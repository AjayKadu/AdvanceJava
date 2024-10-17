package com.sunbeam;

public class BoxImple {
    
	private int length;
	private int breadth;
	private int height;
	
	public BoxImple() {
		
	}

	public BoxImple(int length, int breadth, int height) {
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "BoxImple [length=" + length + ", breadth=" + breadth + ", height=" + height + "]";
	}
	
	public int calVolume() {
		return length * breadth * height;
	}
	
}
