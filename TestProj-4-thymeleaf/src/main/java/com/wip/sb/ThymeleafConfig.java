package com.wip.sb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
public class ThymeleafConfig {

	@Bean
	public SpringResourceTemplateResolver templateResolver1() {
		SpringResourceTemplateResolver srtr = new SpringResourceTemplateResolver();
		srtr.setCacheable(false);
		srtr.setPrefix("classpath:/newDir/");
		srtr.setSuffix(".html");
		//setOrder required to mention the order of the view engines, when
		//srtr.setOrder(1);
		srtr.setCheckExistence(true);
		return srtr;
	}
	
	@Bean
	public SpringResourceTemplateResolver templateResolver2() {
		SpringResourceTemplateResolver srtr = new SpringResourceTemplateResolver();
		srtr.setCacheable(false);
		srtr.setPrefix("classpath:/newDir2/");
		srtr.setSuffix(".html");
		// required if view files are in multiple locations
		srtr.setCheckExistence(true);
		return srtr;
	}
	
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine te = new SpringTemplateEngine();
		te.addTemplateResolver(templateResolver1());
		te.addTemplateResolver(templateResolver2());
		return te;
	}
	
	@Bean
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver tvr = new ThymeleafViewResolver();
		tvr.setTemplateEngine(templateEngine());
		tvr.setOrder(1);
		return tvr;
	}
}
