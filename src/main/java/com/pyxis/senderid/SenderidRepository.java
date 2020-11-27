package com.pyxis.senderid;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface SenderidRepository extends JpaRepository<Senderid, Long> {

	Senderid findBySenderid(int id) throws DataAccessException;	
	
	List<Senderid> findByCreadtedby(Integer loginId);
	
	Page<Senderid> findByCreadtedby(Integer loginId, Pageable pageable);
	
	@Query(value="SELECT a.* FROM `senderid_detils` a INNER JOIN `user_senderid_detils` b ON a.`SENDERID` = b.`SENDERID` AND b.`USERID` = ? AND a.status = 2", nativeQuery=true)
	List<Senderid> findByCreatedByApproved(Integer loginId);
	
	@Query(value="delete from   user_senderid_detils where USERID= ?1 and SENDERID=?2", nativeQuery=true)
	void deleteTest(Long userId, Integer senderId);
	
	@Query(value = "insert into user_senderid_detils(USERID, SENDERID ,STATUS) values( ?1, ?2, 2)",  nativeQuery=true)
	void nativeQueryInsert(Long userId, Integer senderId); 
	

}
