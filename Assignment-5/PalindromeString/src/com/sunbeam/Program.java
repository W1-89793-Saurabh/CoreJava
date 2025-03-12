//Write a java code to check string is palindrome.

/*
 Firstly do Reverse String then compair it using equals ...
 */
package com.sunbeam;
import java.util.Scanner;
public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String to check Palindrome:");
		String str = sc.nextLine();
		String reversedString = reverse(str);
		if(reversedString.equals(str)) {
			System.out.print(str+ " is a Palindrome.");
		}else {
			System.out.println(str+ " is not a Palindrome.");
		}
	}
	private static String reverse(String str) {
		StringBuilder stringBuilder = new StringBuilder(str);
		return stringBuilder.reverse().toString();
	}
}
