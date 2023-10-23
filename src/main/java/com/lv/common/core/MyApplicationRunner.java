package com.lv.common.core;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.client.config.listener.impl.PropertiesListener;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Spring容器启动时需要加载的配置
 * @author QiangZai
 * @version 1.0
 * @date 2023/10/22 11:05 PM
 */
@Log4j2
@Configuration
public class MyApplicationRunner implements ApplicationRunner {

    @Resource
    private NacosConfigManager nacosConfigManager;
    @Resource
    private NacosConfigProperties nacosConfigProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("[SpringRunner启动]--开始加载容器自定义配置");
        nacosConfigManager.getConfigService().addListener("data-server.yml", nacosConfigProperties.getGroup(),
                new PropertiesListener() {
                    @Override
                    public void innerReceive(Properties properties) {
                        System.out.println("[Spring配置修改回调]--Spring配置被修改！");

                        properties.forEach((p, q)->{
                            System.out.println(p);
                        });
//
//                        ThreadPoolProperties poolProperties = new ThreadPoolProperties();
//                        poolProperties.setCorePoolSize(Integer.parseInt(properties.getProperty("corePoolSize")));
//                        poolProperties.setMaxPoolSize(Integer.parseInt(properties.getProperty("maxPoolSize")));
//                        poolProperties.setKeepAliveSeconds(Integer.parseInt(properties.getProperty("keepAliveSeconds")));
//                        poolProperties.setQueueCapacity(Integer.parseInt(properties.getProperty("queueCapacity")));
//                        System.out.println("开始重新调整线程池...");
//                        threadPoolConfig.restThreadPool(poolProperties);
//                        System.out.println("调整之后线程池的参数：");
//                        threadPoolConfig.printParam();
                    }
                });
    }


}
