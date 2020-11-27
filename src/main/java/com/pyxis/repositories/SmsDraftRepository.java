package com.pyxis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pyxis.entities.SmsDraft;


public interface SmsDraftRepository extends JpaRepository<SmsDraft, Integer>{
	
//	List<SmsDraft> findByStatusAndTransmitterGreaterThan(Integer status, Integer transmitter);
	
	List<SmsDraft> findByDraftUploadedby(Integer uploadedBy);

}
