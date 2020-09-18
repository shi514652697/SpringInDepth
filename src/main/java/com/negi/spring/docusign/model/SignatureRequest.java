package com.negi.spring.docusign.model;

import com.negi.spring.docusign.api.esign.EnvelopDefinition;

public class SignatureRequest {
	
	private EnvelopDefinition dsRequestBoday;

	public EnvelopDefinition getDsRequestBoday() {
		return dsRequestBoday;
	}

	public void setDsRequestBoday(EnvelopDefinition dsRequestBoday) {
		this.dsRequestBoday = dsRequestBoday;
	}
	

}
