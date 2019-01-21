package com.example.demo.aliasfor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessRole2 {

    @AliasFor("accessType")
    String value() default "visitor";

    @AliasFor("value")
    String accessType() default "admin";

    String module() default "gui";
}
