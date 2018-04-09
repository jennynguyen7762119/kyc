/**
 * 
 */
package com.oto.kyc.dao;

import org.springframework.data.repository.CrudRepository;

import com.oto.kyc.model.Expense;

/**
 * @author otocon
 *
 */
public interface ExpenseDao extends CrudRepository<Expense, Integer>, ExpenseDaoCustomMethods {

}
