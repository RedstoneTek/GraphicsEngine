package com.tek.api.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.tek.api.graphics.objects.GraphicsPolygon;
import com.tek.api.graphics.objects.GraphicsPolygon.Shape;
import com.tek.api.graphics.objects.GraphicsString;

public class GraphicsEngine {
	
	ArrayList<GraphicsPolygon> renderobj = new ArrayList<GraphicsPolygon>();
	ArrayList<GraphicsString> renderstr = new ArrayList<GraphicsString>();
	
	Canvas canvas;
	
	public GraphicsEngine(Canvas canvas){
		this.canvas = canvas;
	}
	
	public void setBackground(Color color){
		canvas.setBackground(color);
	}
	
	public void clearCanvas(){
		renderobj.clear();
	}
	
	public void draw(int x, int y, int width, int height, Shape shape){
		renderobj.add(new GraphicsPolygon(x,y,width,height,shape));
	}
	
	public void drawString(int x, int y, String string){
		renderstr.add(new GraphicsString(x,y,string));
	}
	
	public void render(){
		Graphics g = canvas.getGraphics();
		
		for(GraphicsPolygon polygon : renderobj){
			switch(polygon.getShape()){
			    case OVAL:
			    	g.drawOval(polygon.getX(), polygon.getY(), polygon.getWidth(), polygon.getHeight());
				    break;
			    case LINE:
			    	g.drawLine(polygon.getX(), polygon.getY(), polygon.getX() + polygon.getWidth(), polygon.getY() + polygon.getHeight());
			    	break;
			    case TRIANGLE:
			    	int xpoints[] = {polygon.getX() + polygon.getWidth() / 2, polygon.getX(), polygon.getX() + polygon.getWidth()};
			    	int ypoints[] = {polygon.getY(), polygon.getY() + polygon.getHeight(), polygon.getHeight() + polygon.getY()};
			    	int npoints = 3;
			    	g.drawPolygon(xpoints, ypoints, npoints);
			    	break;
			    case RECTANGLE:
			    	g.drawRect(polygon.getX(), polygon.getY(), polygon.getWidth(), polygon.getHeight());
			    	break;
			    case PENTAGON:
			    	int x1points[] = {polygon.getX() + polygon.getWidth() / 2, polygon.getX(), polygon.getX() + polygon.getWidth() / 6, polygon.getX() + polygon.getWidth() - polygon.getWidth() / 6, polygon.getX() + polygon.getWidth()};
			    	int y1points[] = {polygon.getY(), polygon.getY() + polygon.getHeight() / 3, polygon.getHeight() + polygon.getY(), polygon.getHeight() + polygon.getY(), polygon.getY() + polygon.getHeight() / 3};
			    	int n1points = 5;
			    	g.drawPolygon(x1points, y1points, n1points);
			    	break;
			    case HEXAGON:
			    	int x2points[] = {polygon.getX() + polygon.getWidth() / 4, polygon.getX(), polygon.getX() + polygon.getWidth() / 4, polygon.getX() + polygon.getWidth() - polygon.getWidth() / 4, polygon.getX() + polygon.getWidth(), polygon.getX() + polygon.getWidth() - polygon.getWidth() / 4};
			    	int y2points[] = {polygon.getY(), polygon.getY() + polygon.getHeight() / 2, polygon.getY() + polygon.getHeight(), polygon.getY() + polygon.getHeight(), polygon.getY() + polygon.getHeight() / 2, polygon.getY()};
			    	int n2points = 6;
			    	g.drawPolygon(x2points, y2points, n2points);
			    	break;
			}
		}
		
		for(GraphicsString string : renderstr){
			g.drawString(string.getString(), string.getX(), string.getY());
		}
	}
}
