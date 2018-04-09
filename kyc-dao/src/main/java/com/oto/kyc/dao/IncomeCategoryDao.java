/**
 * 
 */
package com.oto.kyc.dao;

import org.springframework.data.repository.CrudRepository;

import com.oto.kyc.model.IncomeCategory;

/**
 * @author otocon
 *
 */
public interface IncomeCategoryDao extends CrudRepository<IncomeCategory, Integer>, IncomeCategoryDaoCustomMethods {

}
