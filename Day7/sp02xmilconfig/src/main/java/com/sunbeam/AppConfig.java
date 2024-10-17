package com.sunbeam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
     
	@Bean
	public BoxImple b1() {
		
		BoxImple b = new BoxImple();
		b.setLength(4);
		b.setBreadth(5);
		b.setHeight(2);
		
		return b;
	}
	
	@Bean
	public BoxImple b2() {
		
		BoxImple b = new BoxImple(10, 8, 6);
		return b;
	}
}
