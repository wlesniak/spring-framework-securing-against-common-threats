package com.pluralsight.security.model;

import java.math.BigDecimal;

public class PositionDto {
	
	private final CryptoCurrencyDto cryptoCurrency;
	private final BigDecimal quantity;
	private final BigDecimal value;
	
	public PositionDto(CryptoCurrencyDto cryptoCurrency, BigDecimal quantity, BigDecimal value) {
		this.cryptoCurrency = cryptoCurrency;
		this.quantity = quantity;
		this.value = value;
	}

	public CryptoCurrencyDto getCryptoCurrency() {
		return cryptoCurrency;
	}
	
	public BigDecimal getQuantity() {
		return quantity;
	}
	
	public BigDecimal getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cryptoCurrency == null) ? 0 : cryptoCurrency.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PositionDto other = (PositionDto) obj;
		if (cryptoCurrency == null) {
			if (other.cryptoCurrency != null)
				return false;
		} else if (!cryptoCurrency.equals(other.cryptoCurrency))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
}
