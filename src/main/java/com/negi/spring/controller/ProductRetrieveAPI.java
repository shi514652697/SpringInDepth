package com.negi.spring.controller;

import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import com.negi.spring.model.BankingPackageRequestDto;
import com.negi.spring.model.BankingPkgResponse;
import com.negi.spring.model.ErrorResopseDto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



public interface ProductRetrieveAPI 
{
	
	
	@ApiOperation(value="This API is used to retrieve a new banking package number", notes="Get all package from external system",
			response= String.class, tags= {"USRAO"})
	@ApiResponses(value= {
		@ApiResponse(code=200, message="Successfull retrieved banking package number", response=BankingPkgResponse.class)	,
		@ApiResponse(code= 400, message="<table><tr><td>Type</td><td>Code</td><td>Details</td></tr><tr><td>Invalid</td><td>Invalid Request</td><td>Missing or invalid parameters</td></tr><tr><td>Error</td><td>Validator Error</td><td>Validation Error</td></tr></table>", response = String.class),
		@ApiResponse(code= 401, message="<table><tr><td>Type</td><td>Code</td><td>Details</td></tr><tr><td>Error</td><td>UnAuthorize</td><td>Missing or invalid parameters</td></tr><tr><td>Error</td><td>UnAuthorization credential</td><td>Access Denied</td></tr></table>", response = ErrorResopseDto.class)
	})
	@PostMapping(value="retail/products/bankPackageNumber", produces= {"application/json"})
	ResponseEntity<BankingPkgResponse> getCustomerBankPackage(@RequestHeader Map<String, String> headers,
			@RequestHeader(value="countryCode", required= false, defaultValue="US") String countryCode,
			@ApiParam(value="Banking package type details", required= true) @RequestBody @Valid BankingPackageRequestDto bankingPackageRequest);
	
	
	
	
	@ApiOperation(value="This API is used to retrieve a new banking package number", notes="Get all package from external system",
			response= String.class, tags= {"USRAO"})
	@ApiResponses(value= {
		@ApiResponse(code=200, message="Successfull retrieved agent details", response=BankingPkgResponse.class)	,
		@ApiResponse(code= 400, message="<table><tr><td>Type</td><td>Code</td><td>Details</td></tr><tr><td>Invalid</td><td>Invalid Request</td><td>Missing or invalid parameters</td></tr><tr><td>Error</td><td>Validator Error</td><td>Validation Error</td></tr></table>", response = String.class),
		@ApiResponse(code= 401, message="<table><tr><td>Type</td><td>Code</td><td>Details</td></tr><tr><td>Error</td><td>UnAuthorize</td><td>Missing or invalid parameters</td></tr><tr><td>Error</td><td>UnAuthorization credential</td><td>Access Denied</td></tr></table>", response = ErrorResopseDto.class)
	})
	@PostMapping(value="retail/products/agent/{agentId}", produces= {"application/json"})
	ResponseEntity<BankingPkgResponse> getAgentDetails(@RequestHeader Map<String, String> headers,
			@RequestHeader(value="countryCode", required= false, defaultValue="US") String countryCode,
			@ApiParam(value="Banking package type details", required= true) @PathVariable @Size(min= 3, message="agent id should of min 3") String  agentId);
	
	
	
	
	
	
	

}
