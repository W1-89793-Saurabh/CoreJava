package tester;
import java.util.Scanner;

import com.app.geometry.Point2D;

public class TestPointArray1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please Enter total number of 2D Points: ");
		int p = sc.nextInt();
		
		Point2D[] points=new Point2D[p];
		
		for(int i = 1; i <= p ; i++) {
			System.out.print("Enter x  co-cords of point "+i +" : ");
			int x = sc.nextInt();
			System.out.print("Enter y  co-cords of point "+i +" : ");
			int y = sc.nextInt();
			
			points[i-1] = new Point2D(x,y);
		}

		while (true){
			System.out.println("\nMenu: ");
			System.out.println("1. Display details of a specific point");
			System.out.println("2. Display x, y coordinates of all points");
			System.out.println("3. Display distance between two points");
			System.out.println("4. calculate the midpoint b/n two points");
			System.out.println("5. calculate the slope b/n two points");
			System.out.println("6. Determine the quadrant of a point");
			System.out.println("7. Exit");
			System.out.println("Enter your choie: ");
			int choice = sc.nextInt();

			switch (choice){
				case 1:
					System.out.println("Enter the point's index: ");
					int index = sc.nextInt();
					if(index >= 0 && index<p ){
						System.out.println("Point details: "+points[index].getDetails());
					}else{
						System.out.println("Invalid input");
					}
					break;

				case 2:
					System.out.println("Coordinates of all points: ");
					for(Point2D point : points){
						System.out.println(point.getDetails());
					}
					break;

				case 3:
					System.out.println("Enter first point's index: ");
					int x1 = sc.nextInt();
					System.out.println("Enter last point's index: ");
					int x2 = sc.nextInt();

					if(x1>=0 && x1<p && x2>=0 && x2<p){
						if(!points[x1].isEqual(points[x2])){
							System.out.println("Distance b/n Given two points: "+ points[x1].calculateDistance(points[x2]));
						}else{
							System.out.println("Same point");
						}
					}else{
						System.out.println("Invalid inputs");
					}
					break;

				case 4:
					System.out.println("Enter first point's index: ");
					x1 = sc.nextInt();
					System.out.println("Enter last point's index: ");
					x2 = sc.nextInt();

					if(x1>=0 && x1<p && x2>=0 && x2<p){
						Point2D midpoint = points[x1].calculateMidPoint(points[x2]);
						System.out.println("Midpoint: "+midpoint.getDetails());

					}
					else{
							System.out.println("Invalid Input");
					}
					break;
				case 5:
					System.out.println("Enter first point's index: ");
					x1 = sc.nextInt();
					System.out.println("Enter last point's index: ");
					x2 = sc.nextInt();
					if(x1>=0 && x1<p && x2>=0 && x2<p){
						try{
							double slope = points[x1].calculateSlope(points[x2]);
							System.out.println("Slope b/n two points: "+slope);
						}catch (ArithmeticException e){
							System.out.println("Slope is infinite");
						}
					}else{
						System.out.println("Invalid Input");
					}
					break;
				case 6:
					System.out.println("Enter the point's index: ");
					index = sc.nextInt();
					if(index >= 0 && index<p ){
						System.out.println("Quadrant of the point: "+points[index].getQuadrant());
					}else{
						System.out.println("Invalid input");
					}
					break;
				case 7:
					System.out.println("Exiting...");
					System.exit(0);
					return;
				default:
					System.out.println("Invalid choice");
			}
		}
	}
}

