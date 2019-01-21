package com.example.demo.aliasfor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@AccessRole("Admin")
public @interface AdminAccess {
	@AliasFor(annotation=AccessRole.class)
String value() default"service";
}
