package com.bonanja;

import java.util.Collections;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class BonanjaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		
		log.info("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		log.info("★★★★★  RUN BonanjaApplication    ★★★★★★★★★");
		log.info("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");

		SpringApplication.run(KredbSiteApplication.class, args);
	}
	
	@Override
    	public void onStartup(ServletContext servletContext) throws ServletException {

		super.onStartup(servletContext);

		servletContext
		    .setSessionTrackingModes(Collections.singleton(SessionTrackingMode.COOKIE));  // url호출시  jsessionid 제거

		SessionCookieConfig sessionCookieConfig = servletContext.getSessionCookieConfig();
		sessionCookieConfig.setHttpOnly(true);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BonanjaApplication.class);
	}

}
