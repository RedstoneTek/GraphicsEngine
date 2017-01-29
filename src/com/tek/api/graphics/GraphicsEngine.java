package com.tek.api.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.tek.api.graphics.GraphicsObject.Shape;

public class GraphicsEngine {
	
	ArrayList<GraphicsObject> renderlist = new ArrayList<GraphicsObject>();
	
	Canvas canvas;
	
	public GraphicsEngine(Canvas canvas){
		this.canvas = canvas;
	}
	
	public void setBackground(Color color){
		canvas.setBackground(color);
	}
	
	public void clearCanvas(){
		renderlist.clear();
	}
	
	public void draw(int x, int y, int width, int height, Shape shape){
		renderlist.add(new GraphicsObject(x,y,width,height,shape));
	}
	
	public void render(){
		Graphics g = canvas.getGraphics();
		
		for(GraphicsObject obj : renderlist){
			switch(obj.getShape()){
			    case OVAL:
			    	g.drawOval(obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight());
				    break;
			    case TRIANGLE:
			    	int xpoints[] = {obj.getX() + obj.getWidth() / 2, obj.getX(), obj.getX() + obj.getWidth()};
			    	int ypoints[] = {obj.getY(), obj.getY() + obj.getHeight(), obj.getHeight() + obj.getY()};
			    	int npoints = 3;
			    	g.drawPolygon(xpoints, ypoints, npoints);
			    	break;
			    case RECTANGLE:
			    	g.drawRect(obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight());
			    	break;
			    case PENTAGON:
			    	int x1points[] = {obj.getX() + obj.getWidth() / 2, obj.getX(), obj.getX() + obj.getWidth() / 6, obj.getX() + obj.getWidth() - obj.getWidth() / 6, obj.getX() + obj.getWidth()};
			    	int y1points[] = {obj.getY(), obj.getY() + obj.getHeight() / 3, obj.getHeight() + obj.getY(), obj.getHeight() + obj.getY(), obj.getY() + obj.getHeight() / 3};
			    	int n1points = 5;
			    	g.drawPolygon(x1points, y1points, n1points);
			    	break;
			    case HEXAGON:
			    	int x2points[] = {obj.getX() + obj.getWidth() / 4, obj.getX(), obj.getX() + obj.getWidth() / 4, obj.getX() + obj.getWidth() - obj.getWidth() / 4, obj.getX() + obj.getWidth(), obj.getX() + obj.getWidth() - obj.getWidth() / 4};
			    	int y2points[] = {obj.getY(), obj.getY() + obj.getHeight() / 2, obj.getY() + obj.getHeight(), obj.getY() + obj.getHeight(), obj.getY() + obj.getHeight() / 2, obj.getY()};
			    	int n2points = 6;
			    	g.drawPolygon(x2points, y2points, n2points);
			    	break;
			}
		}
	}
}
