package com.pluralsight.security.model;

import java.util.List;

public class ListTransactionsDto {

	private final String username;
	private final List<TransactionDetailsDto> transactions;
	
	public ListTransactionsDto(String username, List<TransactionDetailsDto> transactions) {
		this.username = username;
		this.transactions = transactions;
	}
	
	public List<TransactionDetailsDto> getTransactions() {
		return transactions;
	}
	
	public String getUsername() {
		return username;
	}
	
}
