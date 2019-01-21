package com.example.demo.aliasfor;

import org.hibernate.annotations.AccessType;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;

@AccessRole("a")
@ComponentScan(basePackages= {"com"})
public class MyObject1 {

}
