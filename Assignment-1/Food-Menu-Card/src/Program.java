import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TotalBill = 0;
		int price[] = {40 , 50 , 20 , 15 , 35 , 90 , 120 , 25 , 25 , 60};
//		String[] Itmes = {"idle", "Dosa", "Samosa", "Kachori", "Dhokla", "Pav-Bhaji" , "Misal-Pav", "Poha", "Upma", "SandWitch"};
		
		System.out.println("MENU CARD");
		System.out.println("1. idle -> ₹40");
		System.out.println("2. Dosa -> ₹50");
		System.out.println("3. Samosa -> ₹20");
		System.out.println("4. Kachori -> ₹15");
		System.out.println("5. Dhokla -> ₹35");
		System.out.println("6. Pav-Bhaji -> ₹90");
		System.out.println("7. Misal-Pav -> ₹120");
		System.out.println("8. Poha -> ₹25");
		System.out.println("9. Upma -> ₹25");
		System.out.println("10. SandWitch -> ₹60");
		

		System.out.print("Enter total number of Items You Want: ");
		int a = sc.nextInt(); // a--->Items
		if(a>=1 && a<=10 ) {
			for(int i=1;i<=a;i++) {
				System.out.print("Please Enter the sr.no. of Item: ");
				int b = sc.nextInt(); // sr. no. of Item
				if (b>=1 && b<=10) {
					System.out.print("Please Entrer the no. of Quantity: ");
					int c = sc.nextInt();
					TotalBill = TotalBill + c*price[b-1];
				} else {
					System.out.println("Invalid Input!!");
				}
			}
			System.out.println("Your Bill Amount is: ₹"+ TotalBill);
		} else {
			System.out.println("Invalid Input!!");
		}
		System.out.println("Thanks For Visiting");
		sc.close();
	}
}
