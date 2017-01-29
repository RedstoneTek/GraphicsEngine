package com.tek.api.graphics.objects;

import java.awt.image.BufferedImage;

public class GraphicsImage {
	
	int x;
	int y;
	int width;
	int height;
	BufferedImage image;
	
	public GraphicsImage(int x, int y, int width, int height, BufferedImage image){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
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

	public BufferedImage getImage() {
		return image;
	}
	
}
