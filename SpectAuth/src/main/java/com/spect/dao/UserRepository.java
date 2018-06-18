/**
 * 
 */
package com.spect.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spect.model.SpUserEntity;

@Repository

public interface UserRepository extends CrudRepository<SpUserEntity, Integer> {
	SpUserEntity findByPhMobileOrLoginNameOrEmailId(String mobileNumber, String userName, String email);
}