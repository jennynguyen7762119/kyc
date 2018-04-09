/**
 * 
 */
package com.oto.kyc.dao;

import org.springframework.data.repository.CrudRepository;

import com.oto.kyc.model.Income;

/**
 * @author otocon
 *
 */
public interface IncomeDao extends CrudRepository<Income, Integer>, IncomeDaoCustomMethods {

}
