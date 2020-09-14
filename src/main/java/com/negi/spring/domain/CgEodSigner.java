package com.negi.spring.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.Id;

@Entity
@NamedQuery(name="CG_EOD_SIGNR.findAll", query="SELECT e from CG_EOD_SIGNR s")
public class CgEodSigner  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CG_ROW_ID")
	@SequenceGenerator(name="CG_EOD_SIGNR", sequenceName="CG_EOD_SIGNR_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CG_EOD_SIGNR")
	private BigInteger cgRowId;
	
	private String cin;
	
	@Temporal(TemporalType.DATE)
	private Date createDate;

	@ManyToOne
	@JoinColumn(name="CG_SESSION_ID")
    private CgRaSession cgRaSession;
	
	private String cgPrimeSignrFlag;

	public BigInteger getCgRowId() {
		return cgRowId;
	}

	public void setCgRowId(BigInteger cgRowId) {
		this.cgRowId = cgRowId;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public CgRaSession getCgRaSession() {
		return cgRaSession;
	}

	public void setCgRaSession(CgRaSession cgRaSession) {
		this.cgRaSession = cgRaSession;
	}

	public String getCgPrimeSignrFlag() {
		return cgPrimeSignrFlag;
	}

	public void setCgPrimeSignrFlag(String cgPrimeSignrFlag) {
		this.cgPrimeSignrFlag = cgPrimeSignrFlag;
	}

	
	


}
