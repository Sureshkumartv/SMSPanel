package com.pyxis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pyxis.entities.ImageUpload;


public interface ImageUploadRepository extends JpaRepository<ImageUpload, Integer>{
	

}
