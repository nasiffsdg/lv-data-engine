package com.lv.common.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 业务线程池配置
 *
 * @author QiangZai
 * @version 1.0
 * @date 2023/10/22 10:53 PM
 */
@EnableAsync
@Configuration
public class ThreadPoolConfig {

    @Bean("commonThreadPool")
    public ThreadPoolExecutor commonThreadPool() {
        return new ThreadPoolExecutor(
                10,
                100,
                1000,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10),
                new ThreadFactory() {
                    private final AtomicInteger threadNumber = new AtomicInteger(1);
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(Thread.currentThread().getThreadGroup(), r,
                                "thread" + threadNumber.getAndIncrement(),
                                0);
                        if (t.isDaemon())
                            t.setDaemon(false);
                        if (t.getPriority() != Thread.NORM_PRIORITY)
                            t.setPriority(Thread.NORM_PRIORITY);
                        return t;
                    }
                },
                new ThreadPoolExecutor.AbortPolicy());
    }
}
