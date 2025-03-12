// write a java program to count number of words in a String.
//Hint: You can use , trim() , length() and split() methods
package com.sunbeam;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String: ");
		String str = sc.nextLine();
		System.out.print("Total number of words in String are: "+str.trim().split(" ").length);
		
		sc.close();
		
//		((str.trim()).split(" ")).length
		
//		String str1 = str.trim();
//		String[] str2 = str1.split(" ");
//		System.out.println("Total number of words in String are: "+ str2.length);
		
		
		

	}

//	private static String split() {
//		list[] l = new Array
//		
//	}

}
