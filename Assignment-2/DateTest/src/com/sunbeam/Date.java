package com.sunbeam;
import java.util.Scanner;
public class Date {
	private int month;
	private int day;
	private int year;
	public Date() {
		// TODO Auto-generated constructor stub
		this.month=0;
		this.day=0;
		this.year=0;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	public void accept() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Month: ");
		month = sc.nextInt();
		System.out.print("Day: ");
		day = sc.nextInt();
		System.out.println("Year: ");
		year = sc.nextInt();
		}
	public void display() {
		System.out.println(" ");
		System.out.println("Date- "+this.month+"/"+this.day+"/"+this.year);	
	}
}
