package com.pluralsight.security.model;


public class AddTransactionToPortfolioDto {

	private String cryptoSymbol;
	private String quantity;
	private String price;
	private String type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
