package com.example.demo.aliasfor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;

@Configuration
@ComponentScan(basePackages= {"com"})
public class ExampleAliasFor {

	public static void main(String[] args) {
		AnnotationAttributes aa= AnnotatedElementUtils.getMergedAnnotationAttributes(MyObject1.class, AccessRole.class);
		System.out.println(aa);
		
	}

}
