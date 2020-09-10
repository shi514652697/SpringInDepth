package com.negi.spring.model;

import javax.validation.constraints.NotNull;

public class BankingPackageRequestDto {
	
	@NotNull(message="hoseholdNumber can not be null")
	private String houseHoldNumber;
	
	private String valuePropositinCode;

	public String getHouseHoldNumber() {
		return houseHoldNumber;
	}

	public void setHouseHoldNumber(String houseHoldNumber) {
		this.houseHoldNumber = houseHoldNumber;
	}

	public String getValuePropositinCode() {
		return valuePropositinCode;
	}

	public void setValuePropositinCode(String valuePropositinCode) {
		this.valuePropositinCode = valuePropositinCode;
	}
	
	

}
