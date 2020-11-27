package com.pyxis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pyxis.entities.EsmeInfo;


public interface EsmeInfoRepository extends JpaRepository<EsmeInfo, Integer>{
	
	List<EsmeInfo> findByStatusAndTransmitterGreaterThan(Integer status, Integer transmitter);

}
