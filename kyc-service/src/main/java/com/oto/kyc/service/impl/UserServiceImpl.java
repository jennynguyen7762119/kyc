/**
 * 
 */
package com.oto.kyc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.oto.kyc.dao.UserDao;
import com.oto.kyc.model.User;
import com.oto.kyc.service.UserService;
import com.oto.kyc.service.exception.ServiceException;

/**
 * @author otocon
 *
 */
@Service
@Transactional
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2420872279915303276L;
	
	@Autowired
	private UserDao userDao;

	
	public List<User> getAllUser() {
		List<User> result = null;
		try {
			result = this.userDao.findAllUser();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}


	@Override
	public CrudRepository<User, Integer> getDao() {
		// TODO Auto-generated method stub
		return this.userDao;
	}


	@Override
	public User getActivated(Integer id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
