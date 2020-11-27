package com.pyxis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pyxis.entities.SmsDraft;
import com.pyxis.entities.UserCreditsDetail;


public interface UserCreditsDetailRepository extends JpaRepository<UserCreditsDetail, Integer>{
	
//	List<SmsDraft> findByStatusAndTransmitterGreaterThan(Integer status, Integer transmitter);
	

}
