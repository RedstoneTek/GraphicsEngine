package com.tek.api.graphics;

import java.awt.Canvas;

import javax.swing.JFrame;

public class GraphicsDisplay extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	Canvas canvas;

	public GraphicsDisplay(String title, int width, int height) {
		setTitle(title);
		setSize(width,height);
		
		getContentPane().setLayout(null);
		
		canvas = new Canvas();
		canvas.setBounds(0, 0, width, height);
		getContentPane().add(canvas);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setResizable(false);
		setVisible(true);
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
}
