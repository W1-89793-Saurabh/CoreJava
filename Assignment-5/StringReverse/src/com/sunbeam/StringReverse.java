//Q1) Write a java program to reverse a String
package com.sunbeam;

import java.util.Scanner;

public class StringReverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String Input: ");
		String str = sc.nextLine();
		
		String reversed = reverse(str);
		
		System.out.println("Reversed String: "+ reversed);
		
	}

	public static String reverse(String str) {
		StringBuilder stringBuilder = new StringBuilder(str);
		return stringBuilder.reverse().toString();
	}
	
	

}
