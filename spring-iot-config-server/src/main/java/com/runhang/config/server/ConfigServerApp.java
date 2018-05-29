package com.runhang.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApp {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(ConfigServerApp.class , args);
    }

}
