/**
 * 
 */
package com.oto.kyc.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.oto.kyc.dao.UserDaoCustomMethods;

/**
 * @author otocon
 *
 */
@Repository
public class UserDaoImpl implements UserDaoCustomMethods {
	@Autowired
    @Qualifier("entityManager")
    private EntityManager entityManager;

}
