package com.wkclz.sql2api.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@AutoConfiguration
@ComponentScan({"com.wkclz.sql2api.manager"})
public class Sql2ApiEngineManagerAotuConfig {
    public static void main(String[] args) {
        SpringApplication.run(Sql2ApiEngineManagerAotuConfig.class, args);
    }
}
