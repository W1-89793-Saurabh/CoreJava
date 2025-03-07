package tester;

import java.util.Scanner;

import com.app.geometry.Point2D;

public class TestPoint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter x1 co-ords: ");
		int x1 = sc.nextInt(); 
		System.out.print("Enter y1 co-ords: ");
		int y1 = sc.nextInt();
		System.out.print("Enter x2 co-ords: ");
		int x2 = sc.nextInt();
		System.out.print("Enter y2 co-ords: ");
		int y2 = sc.nextInt();
		
		Point2D p1 = new Point2D(x1,y1);
		Point2D p2 = new Point2D(x2,y2);
		
		System.out.println("Point P1: "+p1.getDetails());
		System.out.println("Point P2: "+p2.getDetails());
		
		
		if ((x1==x2) && (y1==y2)) {
			System.out.println("Same Point...");
		} else {
			double d = p1.calculateDistance(p2);
			System.out.println("Distance between two points is: "+ d);
		}
		
sc.close();
	}
	

}
