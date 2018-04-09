/**
 * 
 */
package com.oto.kyc.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.oto.kyc.dao.ExpenseCategoryDao;
import com.oto.kyc.model.ExpenseCategory;
import com.oto.kyc.service.ExpenseCategoryService;
import com.oto.kyc.service.exception.ServiceException;

/**
 * @author otocon
 *
 */
@Service
@Transactional
public class ExpenseCategoryServiceImpl extends GenericServiceImpl<ExpenseCategory, Integer> implements ExpenseCategoryService {

	@Autowired
	private ExpenseCategoryDao expenseCategoryDao;
	
	@Override
	public CrudRepository<ExpenseCategory, Integer> getDao() {
		return this.expenseCategoryDao;
	}

	@Override
	public ExpenseCategory getActivated(Integer id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
