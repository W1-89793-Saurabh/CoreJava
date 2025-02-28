package com.sunbeam;
import java.util.Scanner;
public class InvoiceTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Invoice t1 = new Invoice("A123", "XYZ", 1, 2.20);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st Product Details");
		Invoice t1 = new Invoice();
		t1.accept();
		t1.Display();
		System.out.println(" ");
		
		System.out.println("Enter 2nd Product Details");
		Invoice t2 = new Invoice();
		t2.accept();
		t2.Display();
		System.out.println(" ");
		
		System.out.println("Enter 3rd Product Details");
		Invoice t3 = new Invoice();
		t3.accept();
		t3.Display();
		System.out.println(" ");
		
		System.out.println("Enter 4th Product Details");
		Invoice t4 = new Invoice();
		t4.accept();
		t4.Display();
		System.out.println(" ");
	}
}