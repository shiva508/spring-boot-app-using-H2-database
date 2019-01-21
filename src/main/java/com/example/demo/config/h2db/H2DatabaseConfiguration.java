package com.example.demo.config.h2db;

import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Configuration;
// to show H2 database on browser 
@Configuration
public class H2DatabaseConfiguration {
@SuppressWarnings("rawtypes")
ServletRegistrationBean h2databaseConfiguration() {
	@SuppressWarnings("unchecked")
	ServletRegistrationBean h2DBconfig=new ServletRegistrationBean(new WebdavServlet());
	h2DBconfig.addUrlMappings("/h2-console");
	return h2DBconfig;
	}
}
