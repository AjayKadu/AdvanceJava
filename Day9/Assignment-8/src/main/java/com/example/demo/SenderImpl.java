package com.example.demo;

public class SenderImpl implements Sender{

	@Override
	public void send(double value) {
		
		System.out.println("Send: "+ value);
		
	}

}
