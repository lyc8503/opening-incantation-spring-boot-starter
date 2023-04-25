package io.github.lyc8503.spring.starter.incantation.annotation;

import io.github.lyc8503.spring.starter.incantation.config.CustomIncantationAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Import(CustomIncantationAutoConfiguration.class)
public @interface OpeningIncantation {

}
