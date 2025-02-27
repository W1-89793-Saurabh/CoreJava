import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please Enter First Value: ");
		
		if(sc.hasNextDouble()) {
			double a = sc.nextDouble();
			System.out.print("Please Enter Second Value: ");
			if(sc.hasNextDouble()) {
				double b = sc.nextDouble();
				System.out.println("Average of Given Values is: "+(a+b)/2);
			}else {
				System.out.println("Invalid Input!! Given Value is not Double.. ");
			}
		}else {
			System.out.println("Invalid Input!! Given Value is not Double.. ");
		}
		sc.close();
	}
}
