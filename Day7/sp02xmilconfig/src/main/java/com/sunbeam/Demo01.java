package com.sunbeam;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo01 {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		BoxImple b1 = (BoxImple) ctx.getBean("b1");
		System.out.println("b1 Volume: " + b1.calVolume());
		
		BoxImple b2 = (BoxImple) ctx.getBean("b2");
		System.out.println("b2 volume: " + b2.calVolume());
		
		ctx.close();

	}

}
