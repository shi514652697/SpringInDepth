package com.negi.spring.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.negi.spring.domain.CgEodSigner;

public interface CgEodSignerRepositor extends JpaRepository<CgEodSigner, BigInteger> {
	
	List<CgEodSigner> findByCgRaSession_CgSessionIdIn(List<String> sessionIdList);
	
	CgEodSigner findByCgRaSession_CgSessionIdAndCgPrimeSignrFlag(String sessionId, String primaryFlag);

}
