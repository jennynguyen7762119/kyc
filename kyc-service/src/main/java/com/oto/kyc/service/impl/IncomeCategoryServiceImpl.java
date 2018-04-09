/**
 * 
 */
package com.oto.kyc.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.oto.kyc.dao.IncomeCategoryDao;
import com.oto.kyc.model.IncomeCategory;
import com.oto.kyc.service.IncomeCategoryService;
import com.oto.kyc.service.exception.ServiceException;

/**
 * @author otocon
 *
 */
@Service
@Transactional
public class IncomeCategoryServiceImpl extends GenericServiceImpl<IncomeCategory, Integer> implements IncomeCategoryService {

	@Autowired
	private IncomeCategoryDao incomeCategoryDao;
	
	@Override
	public CrudRepository<IncomeCategory, Integer> getDao() {
		// TODO Auto-generated method stub
		return this.incomeCategoryDao;
	}

	@Override
	public IncomeCategory getActivated(Integer id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
