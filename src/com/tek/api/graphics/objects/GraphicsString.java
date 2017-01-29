package com.tek.api.graphics.objects;

public class GraphicsString {
	
	int x;
	int y;
	String string;
	
	public GraphicsString(int x, int y, String string){
		this.x = x;
		this.y = y;
		this.string = string;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getString() {
		return string;
	}
	
}
