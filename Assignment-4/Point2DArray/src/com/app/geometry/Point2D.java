package com.app.geometry;

public class Point2D {
	private double x;
	private double y;
	
	public Point2D() {
		
	}
	
	public Point2D(double x, double y) {
//		super();
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	public String getDetails() {
		return "("+x+","+y+")";
	}
	
	public boolean isEqual(Point2D other) {
		return x==y;
	}
	
	public double calculateDistance(Point2D other) {
		double dx = other.x - this.x;
		double dy = other.y - this.y;
		return Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
	}

	public Point2D calculateMidPoint(Point2D other) {
		double midX = (this.x + other.x)/2;
		double midY = (this.y + other.y)/2;
		return new Point2D(midX, midY);
	}

	public double calculateSlope(Point2D other) {
		if (other.x == this.x) {
			throw new ArithmeticException("Slope is undefined for vertical line");
		}
		double dx = other.x - this.x;
		double dy = other.y - this.y;
		return dy/dx;
	}

	public String getQuadrant(){
		if(x>0 && y>0)
			return "Quadrant 1";
		else if(x<0 && y>0)
			return "Quadrant 2";
		else if(x<0 && y<0)
			return "Quadrant 3";
		else if(x>0 && y<0)
			return "Quadrant 4";
		else
			return "Origin";
	}
}
