package com.negi.spring.controller;

import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.negi.spring.model.BankingPackageRequestDto;
import com.negi.spring.model.BankingPkgResponse;

public class ProductRetrieveAPIController implements ProductRetrieveAPI {

	@Override
	public ResponseEntity<BankingPkgResponse> getCustomerBankPackage(Map<String, String> headers, String countryCode,
			@Valid BankingPackageRequestDto bankingPackageRequest) {
		
		BankingPkgResponse bankingPkgResponse = new BankingPkgResponse();
		return new ResponseEntity<>(bankingPkgResponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<BankingPkgResponse> getAgentDetails(Map<String, String> headers, String countryCode,
			String agentId) {
		
		BankingPkgResponse bankingPkgResponse = new BankingPkgResponse();
		return new ResponseEntity<>(bankingPkgResponse, HttpStatus.OK);
	}

}
