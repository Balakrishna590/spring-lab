package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@SpringBootApplication
public class SpringBootThymeleaf1Application {
	@Autowired
	ApplicationContext ctx;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootThymeleaf1Application.class, args);
	}

	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setApplicationContext(ctx);
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".html");
		return resolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver());
		return engine;
	}
	
	@Bean
	  public ViewResolver viewResolver(){
	      ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	      viewResolver.setTemplateEngine(templateEngine());
	      return viewResolver;
	  }
}
