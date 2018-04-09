/**
 * 
 */
package com.oto.kyc.dao;

import org.springframework.data.repository.CrudRepository;

import com.oto.kyc.model.ExpenseCategory;

/**
 * @author otocon
 *
 */
public interface ExpenseCategoryDao extends CrudRepository<ExpenseCategory, Integer>, ExpenseCategoryDaoCustomMethods {

}
