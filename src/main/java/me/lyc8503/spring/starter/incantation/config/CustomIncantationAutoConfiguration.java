package me.lyc8503.spring.starter.incantation.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ConditionalOnWebApplication
@Configuration(proxyBeanMethods = false)
@ComponentScan(basePackages = "me.lyc8503.spring.starter.incantation")
public class CustomIncantationAutoConfiguration {
}
