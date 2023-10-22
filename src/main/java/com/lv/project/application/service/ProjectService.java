package com.lv.project.application.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 项目文件处理应用
 * @author QiangZai
 * @version 1.0
 * @date 2023/9/27 11:26 PM
 */
public interface ProjectService {

    /**
     * 加载项目jar包到系统中
     * @param file
     * @return
     */
    String loadProject(MultipartFile file);
}
