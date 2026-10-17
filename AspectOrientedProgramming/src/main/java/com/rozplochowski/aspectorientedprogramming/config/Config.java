package com.rozplochowski.aspectorientedprogramming.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.rozplochowski.aspectorientedprogramming")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Config {
}
