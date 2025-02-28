package com.sunbeam;

import java.util.Scanner;

public class Invoice{
	private String partNumber;
	private String partDiscription;
	private int purchasedItemQuantity;
	private double pricePerItem;
	
	public Invoice() {
		this.partNumber="null";
		this.partDiscription="null";
		this.purchasedItemQuantity=0;
		this.pricePerItem=0.0;
	}
	
	
	public Invoice(String partNumber, String partDiscription, int purchasedItemQuantity, double pricePerItem) {
		this.partNumber = partNumber;
		this.partDiscription = partDiscription;
		this.purchasedItemQuantity = purchasedItemQuantity;
		this.pricePerItem = pricePerItem;
	}
	public String getPartName() {
		return partNumber;
	}
	public void setPartName(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getPartDiscription() {
		return partDiscription;
	}
	public void setPartDiscription(String partDiscription) {
		this.partDiscription = partDiscription;
	}
	public int getPurchasedItemQuantity() {
		return purchasedItemQuantity;
	}
	public void setPurchasedItemQuantity(int purchasedItemQuantity) {
		this.purchasedItemQuantity = purchasedItemQuantity;
	}
	public double getPricePerItem() {
		return pricePerItem;
	}
	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem;

	}
	public void accept() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Part Number: ");
		partNumber = sc.nextLine();
		System.out.print("Part Discription: ");
		partDiscription = sc.nextLine();
		System.out.print("purchased Item Quantity: ");
		purchasedItemQuantity = sc.nextInt();
		System.out.print("Price Per Item : ");
		pricePerItem = sc.nextDouble();		
	}
	
	public double getInvoice() {
		if (pricePerItem >0) {
			if(purchasedItemQuantity>0) {
				return (purchasedItemQuantity*pricePerItem);
			}else if(purchasedItemQuantity<=0) {
				return 0;
			}
		}else {
				return 0.0;
			} return 0.0;
	}
	
	void Display() {
		System.out.println("Invoice: "+getInvoice());
	}
	
}


