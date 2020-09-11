package com.negi.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.negi.spring.domain.CgRaSession;

@Repository
public interface CgRaSessionRepositry extends JpaRepository<CgRaSession, String> {
	
	@Modifying
	@Query(nativeQuery= true, value="update CG_RA_SESSION s set s.CG_BRANCH=:branchId where s.CG_RA_SESSION_ID=:sessionId")
	int updateCgRASession(@Param("sessionId") String sessionId, @Param("branchId") String branchId);
	
	@Query(nativeQuery= true, value= "select * from CG_RA_SESSION where CG_RA_SESSION_ID= ?1 and  CG_BRANCH=?2")
	List<CgRaSession> getCgRaSessions(String sessionId, String branchId);
	
	@Modifying
	@Transactional(isolation= Isolation.READ_COMMITTED)
	@Query(nativeQuery=true, value="delete from CG_RA_SESSION")
	void deleteData();
	
	CgRaSession findByCgSessionIdAndBranchText(String cgsessionId, String branchText);

}
