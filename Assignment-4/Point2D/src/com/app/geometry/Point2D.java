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
}
