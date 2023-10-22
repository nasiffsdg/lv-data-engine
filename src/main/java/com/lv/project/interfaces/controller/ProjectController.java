package com.lv.project.interfaces.controller;

import com.lv.common.domain.ResponseInfo;
import com.lv.project.application.service.ProjectService;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * 项目文件加载处理加载接口
 * @author QiangZai
 * @version 1.0
 * @date 2023/7/30 4:59 PM
 */
@Log4j2
@RestController("mapper/project")
public class ProjectController {

    @Resource
    private ProjectService projectService;

    /**
     * 项目文件上传并解析
     * @return 响应体
     */
    @PostMapping("/projectUpload")
    public ResponseInfo loadProject(@RequestParam("file") MultipartFile file){
        return ResponseInfo.success(projectService.loadProject(file));
    }

}

