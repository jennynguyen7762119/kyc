/**
 * 
 */
package com.oto.kyc.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.oto.kyc.dao.ExpenseDao;
import com.oto.kyc.model.Expense;
import com.oto.kyc.service.ExpenseService;
import com.oto.kyc.service.exception.ServiceException;

/**
 * @author otocon
 *
 */
@Service
@Transactional
public class ExpenseServiceImpl extends GenericServiceImpl<Expense, Integer> implements ExpenseService {

	@Autowired
	private ExpenseDao expenseDao;
	
	@Override
	public CrudRepository<Expense, Integer> getDao() {
		return this.expenseDao;
	}

	@Override
	public Expense getActivated(Integer id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
