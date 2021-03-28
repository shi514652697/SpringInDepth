package com.negi.spring.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="KYCBranch")
public class KYCReportDto {
	
	@JsonProperty("VerificationDate")
	private String verificationDate;
	
	@JsonProperty("CreationDate")
	private String creationDate;
	
	
	@JsonProperty("BankingPackage")
	private List<PackageDto> packages;


	public String getVerificationDate() {
		return verificationDate;
	}


	public void setVerificationDate(String verificationDate) {
		this.verificationDate = verificationDate;
	}


	public String getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}


	public List<PackageDto> getPackages() {
		return packages;
	}


	public void setPackages(List<PackageDto> packages) {
		this.packages = packages;
	}
	
	

}
