package com.pluralsight.security.model;


public class AddTransactionToPortfolioDto {

	private String cryptoSymbol;
	private String quantity;
	private String price;
	private String transactionType;
	private String username;
	
	public AddTransactionToPortfolioDto() {
	}
	
	public AddTransactionToPortfolioDto(String cryptoSymbol, String quantity, String price) {
		this.cryptoSymbol = cryptoSymbol;
		this.quantity = quantity;
		this.price = price;
	}

	public String getCryptoSymbol() {
		return cryptoSymbol;
	}

	public void setCryptoSymbol(String cryptoSymbol) {
		this.cryptoSymbol = cryptoSymbol;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
