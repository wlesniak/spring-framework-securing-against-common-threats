package com.pluralsight.security.model;

import java.util.List;
import java.util.Map;

public class PortfolioPositionsDto {

	private final String firstName;
	private final String lastname;
	private final List<PositionDto> positions;
	private final Map<String, String> cryptoCurrencies;
	
	public PortfolioPositionsDto(String firstName, String lastname, List<PositionDto> positions,
			Map<String, String> cryptoCurrencies) {
		this.firstName = firstName;
		this.lastname = lastname;
		this.positions = positions;
		this.cryptoCurrencies = cryptoCurrencies;
	}
	
	public PositionDto getPositionForCrypto(CryptoCurrencyDto crypto) {
		PositionDto position = null;
		for(PositionDto pos : positions) {
			if(pos.getCryptoCurrency().equals(crypto)) {
				position = pos;
				break;
			}
		}
		return position;
	}
	
	public Map<String, String> getCryptoCurrencies() {
		return cryptoCurrencies;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public List<PositionDto> getPositions() {
		return positions;
	}
	
}
