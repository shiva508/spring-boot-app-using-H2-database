package com.example.demo.aliasfor;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;

@Configuration
public class ExampleAliasForDifferentDefaults {
	  public static void main(String[] args) {
	        AnnotationAttributes aa = AnnotatedElementUtils
	                .getMergedAnnotationAttributes(MyObject3.class, AccessRole2.class);
	        System.out.println("Attributes of AccessRole3 used on MyObject3: " + aa);
	    }
}
