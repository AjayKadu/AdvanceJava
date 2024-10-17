package com.sunbeam;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01 {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		BoxImple b1 = (BoxImple) ctx.getBean("b1");
		
	     System.out.println("b1 volume: " + b1.calVolume());

	      BoxImple b2 = (BoxImple) ctx.getBean("b2");
	      System.out.println("b2 volume: " + b2.calVolume());
	}

}
