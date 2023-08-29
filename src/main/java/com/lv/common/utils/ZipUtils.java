package com.lv.common.utils;

import lombok.extern.log4j.Log4j2;
import net.sf.sevenzipjbinding.ExtractOperationResult;
import net.sf.sevenzipjbinding.IInArchive;
import net.sf.sevenzipjbinding.SevenZip;
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream;
import net.sf.sevenzipjbinding.simple.ISimpleInArchive;
import net.sf.sevenzipjbinding.simple.ISimpleInArchiveItem;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 文件压缩和解压缩工具类
 *
 * @author QiangZai
 * @version 1.0
 * @date 2023/7/30 6:54 PM
 */
@Log4j2
public class ZipUtils {

    /**
     * rar解压缩
     * @param rarFile rar文件的全路径
     */
    public static String unRarZip7Z(String rarFile) throws Exception {
        if (rarFile.toLowerCase().endsWith(".zip")) {
            return unZip(rarFile);
        } else if (rarFile.toLowerCase().endsWith(".rar")) {
            return unRar(rarFile);
        } else if (rarFile.toLowerCase().endsWith(".7z")) {
            return un7z(rarFile);
        }
        return null;
    }


    /**
     * rar解压缩
     * @param rarFile rar文件的全路径
     */
    private static String unRar(String rarFile) {

        RandomAccessFile randomAccessFile = null;
        IInArchive inArchive = null;
        String outPath = new File(rarFile).getParent();

        try {
            // 第一个参数是需要解压的压缩包路径，第二个参数参考JdkAPI文档的RandomAccessFile
            randomAccessFile = new RandomAccessFile(rarFile, "r");
            inArchive = SevenZip.openInArchive(null, new RandomAccessFileInStream(randomAccessFile));

            ISimpleInArchive simpleInArchive = inArchive.getSimpleInterface();
            for (final ISimpleInArchiveItem item : simpleInArchive.getArchiveItems()) {
                final int[] hash = new int[]{0};
                if (!item.isFolder()) {
                    ExtractOperationResult result;
                    final long[] sizeArray = new long[1];

                    File outFile = new File(outPath + File.separator + item.getPath());
                    File parent = outFile.getParentFile();
                    if ((!parent.exists()) && (!parent.mkdirs())) {
                        continue;
                    }
                    result = item.extractSlow(data -> {
                        try {
                            IOUtils.write(data, new FileOutputStream(outFile, true));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        hash[0] ^= Arrays.hashCode(data);
                        sizeArray[0] += data.length;
                        return data.length;
                    });

                    if (result == ExtractOperationResult.OK) {
                        log.info("解压rar成功...." + String.format("%9X | %10s | %s", hash[0], sizeArray[0], item.getPath()));
                    } else {
                        log.error("解压rar成功：密码错误或者其他错误...." + result);
                    }
                }
            }
        } catch (Exception e) {
            log.error("unRar error" + e.getMessage());
        } finally {
            try {
                assert inArchive != null;
                inArchive.close();
                randomAccessFile.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return outPath;
    }

    /**
     * zip解压缩 解压后源文件名存在相同的目录
     * @param zipFilePath   zip文件的全路径
     */
    private static String unZip(String zipFilePath) throws Exception {

        File zipFile = new File(zipFilePath);
        String fileName = zipFile.getName();
        if (StringUtils.isNotEmpty(fileName)) {
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
        }
        String unzipFilePath = zipFile.getParent() + File.separator + fileName;

        //判断保存路径是否存在，不存在则创建
        File unzipFileDir = new File(unzipFilePath);
        if (!unzipFileDir.exists() || !unzipFileDir.isDirectory()) {
            unzipFileDir.mkdirs();
        }

        //开始解压
        ZipEntry entry;
        String entryFilePath, entryDirPath = "";
        File entryFile, entryDir;
        int index, count, bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        ZipFile zip = new ZipFile(zipFile);
        try {
            Enumeration<? extends ZipEntry> entries = zip.entries();
            while (entries.hasMoreElements()) {
                entry = entries.nextElement();
                entryFilePath = unzipFilePath + File.separator + entry.getName();
                entryFilePath = entryFilePath.replace("/", File.separator);
                index = entryFilePath.lastIndexOf(File.separator);
                if (index != -1) {
                    entryDirPath = entryFilePath.substring(0, index);
                }
                entryDir = new File(entryDirPath);
                if (!entryDir.exists() || !entryDir.isDirectory()) {
                    entryDir.mkdirs();
                }
                entryFile = new File(entryFilePath);
                //判断当前文件父类路径是否存在，不存在则创建
                if (!entryFile.getParentFile().exists() || !entryFile.getParentFile().isDirectory()) {
                    entryFile.getParentFile().mkdirs();
                }
                //不是文件说明是文件夹创建即可，无需写入
                if (entryFile.isDirectory()) {
                    continue;
                }
                bos = new BufferedOutputStream(new FileOutputStream(entryFile));
                bis = new BufferedInputStream(zip.getInputStream(entry));
                while ((count = bis.read(buffer, 0, bufferSize)) != -1) {
                    bos.write(buffer, 0, count);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert bos != null;
            bos.flush();
            bos.close();
            assert bis != null;
            bis.close();
            zip.close();
        }
        return unzipFilePath;
    }


    /**
     * 7z解压缩
     *
     * @param z7zFilePath 7z文件的全路径
     */
    private static String un7z(String z7zFilePath) {

        SevenZFile zIn = null;
        String outPath = null;
        try {
            File file = new File(z7zFilePath);
            outPath = file.getParent();
            zIn = new SevenZFile(file);
            SevenZArchiveEntry entry;
            File newFile;
            while ((entry = zIn.getNextEntry()) != null) {
                //不是文件夹就进行解压
                if (!entry.isDirectory()) {
                    newFile = new File(outPath, entry.getName());
                    if (!newFile.exists()) {
                        //创建此文件的上层目录
                        new File(newFile.getParent()).mkdirs();
                    }
                    OutputStream out = new FileOutputStream(newFile);
                    BufferedOutputStream bos = new BufferedOutputStream(out);
                    int len;
                    byte[] buf = new byte[(int) entry.getSize()];
                    while ((len = zIn.read(buf)) != -1) {
                        bos.write(buf, 0, len);
                    }
                    bos.flush();
                    bos.close();
                    out.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (zIn != null) {
                    zIn.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return outPath;
    }
}
