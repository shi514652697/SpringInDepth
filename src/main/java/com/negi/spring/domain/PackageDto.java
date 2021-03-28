package com.negi.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PackageDto {
	
	@JsonProperty("ApplicationId")
	private String applicationId;
	
	@JsonProperty("PackageType")
	private String packageType;
	
	
	@JsonProperty("PackageName")
	private String packageName;


	public String getApplicationId() {
		return applicationId;
	}


	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}


	public String getPackageType() {
		return packageType;
	}


	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

    @JsonIgnore
	public String getPackageName() {
		return packageName;
	}


	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	
	

}
