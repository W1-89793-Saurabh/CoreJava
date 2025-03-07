// (Credit Limit Calculator)
// Develop a Java application that determines whether any of several
// department-store customers has exceeded the credit limit on a
// charge account.
// For each customer,the following facts are available:
// a) account number
// b) balance at the beginning of the month
// c) total of all items charged by the customer this month
// d) total of all credits applied to the customer’s account this
// month
// e) allowed credit limit.
// The program should input all these facts as integers, calculate
// the new balance (= beginning balance+ charges – credits),
// display the new balance and determine whether the new balance
// exceeds the customer’s credit limit. For those customers whose
// credit limit is exceeded, the program should display
// the message "Credit limit exceeded".

import java.util.Scanner;

public class CreditLimitCalculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int accountNumber, beginningBalance, totalCharged, totalCredits, creditsLimit;

        System.out.print("Enter total number of customer: ");
        int x = sc.nextInt();

        for(int i = 1; i<=x; i++){
            System.out.print("Enter Account Number: ");
            accountNumber = sc.nextInt();
            if(accountNumber>0){
                System.out.print("Enter Balance at the beginning of the month: ");
                beginningBalance = sc.nextInt();
                System.out.print("Enter total of all items charged by the customer: ");
                totalCharged = sc.nextInt();
                System.out.print("Enter total credits applied to the customer's account: ");
                totalCredits = sc.nextInt();
                System.out.print("Enter customer's credit limit: ");
                creditsLimit = sc.nextInt();

                int newBalance = beginningBalance +totalCharged - totalCredits;

                if(newBalance>creditsLimit){
                    System.out.println("Customer's New Balance is: "+newBalance);
                } else{
                    System.out.println("Credit limit exceeded");
                }

            } else{
                System.out.println("Invalid Input...");
            }
        }
        sc.close();



    }
}
