/**
 * 
 */
package com.oto.kyc.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.oto.kyc.dao.IncomeDao;
import com.oto.kyc.model.Income;
import com.oto.kyc.service.IncomeService;
import com.oto.kyc.service.exception.ServiceException;

/**
 * @author otocon
 *
 */
@Service
@Transactional
public class IncomeServiceImpl extends GenericServiceImpl<Income, Integer> implements IncomeService {

	@Autowired
	private IncomeDao incomeDao;
	@Override
	public CrudRepository<Income, Integer> getDao() {
		return this.incomeDao;
	}

	@Override
	public Income getActivated(Integer id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
