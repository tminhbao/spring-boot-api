package com.alantr.springboot;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.tomcat.TomcatWebServer;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@ConditionalOnClass(Tomcat.class)
	public TomcatWebServer createServer() {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);
		return new TomcatWebServer(tomcat);
	}

	@ConditionalOnMissingBean(DataSource.class)
	public DataSource createDefaultDataBase() {
		return new H2Database();
	}

}
