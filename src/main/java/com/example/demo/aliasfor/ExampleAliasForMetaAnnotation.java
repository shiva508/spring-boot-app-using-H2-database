package com.example.demo.aliasfor;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;

@Configuration
public class ExampleAliasForMetaAnnotation {
	public static void main(String[] args) {
        AnnotationAttributes aa = AnnotatedElementUtils
                .getMergedAnnotationAttributes(MyObject2.class, AdminAccess.class);
        System.out.println("attributes of AdminAccess used on MyObject2 " + aa);

        aa = AnnotatedElementUtils
                .getMergedAnnotationAttributes(MyObject2.class, AccessRole.class);
        System.out.println("attributes of AccessRole used on MyObject2 " + aa);
    }
}
