package com.rockymobi.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class NovelAdminApplication {

    public static void main(String[] args) {

        SpringApplication.run(NovelAdminApplication.class, args);
    }

    /**
     * 服务器时区设置
     * 解决服务端时差问题
     */
    @PostConstruct
    void setDefaultTimezone() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}
