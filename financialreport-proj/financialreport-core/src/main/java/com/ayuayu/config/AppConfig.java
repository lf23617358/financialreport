package com.ayuayu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.ayuayu.service", "com.ayuayu.generator" })
public class AppConfig {

}
