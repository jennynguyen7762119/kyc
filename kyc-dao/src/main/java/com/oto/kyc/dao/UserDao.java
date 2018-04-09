package com.oto.kyc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.oto.kyc.model.User;

/**
 * 
 * @author otocon
 *
 */

public interface UserDao extends CrudRepository<User, Integer>, UserDaoCustomMethods {

	@Query("select u from User u")
	List<User> findAllUser();

}
