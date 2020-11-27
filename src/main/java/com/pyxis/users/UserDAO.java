/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.users;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author suresh
 */
public interface UserDAO extends JpaRepository<Users, Long>{
	
	

	Users findByUsername(String username);
	
	Users findByLoginid(String loginId);
	
	Page<Users> findByUsercreatedbyUserid(Long createdBy, Pageable pageable);
	
	Page<Users> findByUsertypeIn(List<Integer> usertypes, Pageable pageable);
	
	
	@Query(value = "SELECT AES_DECRYPT(PASSWORD, '20091129') password FROM user_details where userid = ?1", nativeQuery = true)
	byte[] getPassword(Long userId);
	
	@Modifying
	@Query(value = "update user_details set password = AES_ENCRYPT(?1, '20091129') where userid = ?2", nativeQuery = true)
	void updatePassword(String password, Long id);
	
	
	@Query(value = "select sum(SMSCOUNT) from user_credits_details where USERID = ?1", nativeQuery = true)
	Long getUserSmsCount(Long userId);
	
	@Query(value = "select sum(CREDITS) from user_credits_used_details where USERID = ?1", nativeQuery = true)
	Long getUserUsedCredits(Long userId);
//    public void addRecord(Users s);
//
////    public void updateRecord(int id);
//
//    public void deleteRecord(int id);
//
//    public Users getById(int id);
//
//    public Users getByName(String id);
//
//    public String getPassword(Integer id);
//
//    List<Users> listRecords(Integer page, Integer size);
//
//    Long getUsersCount();
//
//	void updateRecord(Users id);

	Page<Users> findByUsertypeAndUsercreatedbyUserid(int i, Long id, Pageable pageable);

}
