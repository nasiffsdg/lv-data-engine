package com.lv.project.application.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.lv.project.application.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


/**
 * 项目处理服务实现
 * @author QiangZai
 * @version 1.0
 * @date 2023/9/27 11:27 PM
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    /**
     * 加载项目到系统中
     * @param file 文件
     * @return 加载内容
     */
    @Override
    public String loadProject(MultipartFile file) {
        jarValidator(file);
        return null;
    }

    private static void jarValidator(MultipartFile file) {

        // 文件类型判断
        if (!StrUtil.equals(FileUtil.extName(file.getOriginalFilename()), FileUtil.JAR_FILE_EXT)){
            throw new RuntimeException("");
        }
    }
}
