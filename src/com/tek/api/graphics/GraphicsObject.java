package com.tek.api.graphics;

public class GraphicsObject {
	
	int x;
	int y;
	int width;
	int height;
	Shape shape;
	
	public static enum Shape{
		TRIANGLE,
		RECTANGLE,
		PENTAGON,
		HEXAGON,
		OVAL;
	}
	
	public GraphicsObject(int x, int y, int width, int height, Shape shape){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.shape = shape;
	}
	
	public Shape getShape(){
		return shape;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
