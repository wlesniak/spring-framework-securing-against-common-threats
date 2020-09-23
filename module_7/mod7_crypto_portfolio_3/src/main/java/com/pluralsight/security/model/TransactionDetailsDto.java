package com.pluralsight.security.model;

public class TransactionDetailsDto {

	private final String id;
	private final String symbol;
	private final String type;
	private final String quantity;
	private final String price;
	
	public TransactionDetailsDto(String id, String symbol, String type, String quantity, String price) {
		this.id = id;
		this.symbol = symbol;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPrice() {
		return price;
	}
	
	public String getQuantity() {
		return quantity;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public String getType() {
		return type;
	}
	
}
