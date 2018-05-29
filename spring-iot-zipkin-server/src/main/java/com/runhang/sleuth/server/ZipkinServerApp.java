package com.runhang.sleuth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinServerApp {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(ZipkinServerApp.class , args);
    }

}
