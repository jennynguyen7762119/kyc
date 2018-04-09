/**
 * 
 */
package com.oto.kyc.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.oto.kyc.model.base.IdentifiedEntity;
import com.oto.kyc.service.GenericService;
import com.oto.kyc.service.exception.ServiceException;


/**
 * @author thuyntp
 *
 */
public abstract class GenericServiceImpl<T extends IdentifiedEntity<I>, I extends Serializable>
		implements GenericService<T, I> {

	public T get(I id) throws ServiceException {
		T result = null;
		try {
			CrudRepository<T, I> respository = getDao();
			if (respository != null) {
				result = respository.findOne(id);
			}
		} catch (Exception ex) {
			result = null;
		}

		return result;
	}

	public List<T> get(List<I> ids) throws ServiceException {
		List<T> result = new ArrayList<T>();
		try {
			CrudRepository<T, I> respository = getDao();
			if (respository != null) {
				Iterable<T> tmp = respository.findAll(ids);
				if (tmp != null) {
					tmp.forEach(t -> result.add(t));
				}
			}
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage(), ex);
		}

		return result;
	}

	public List<T> getAll() throws ServiceException {
		List<T> result = new LinkedList<T>();
		Iterable<T> iter = getDao().findAll();
		if (iter != null) {
			iter.forEach(t -> {
				result.add(t);
			});
		}
		return result;
	}

	public List<T> getAllActivated() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public T delete(I id) throws ServiceException {
		T result = null;

		try {
			result = this.get(id);

			if (result != null) {
				this.getDao().delete(id);

			}
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage(), ex);
		}

		return result;
	}

	public T delete(T entity) throws ServiceException {
		T result = null;

		result = this.delete(entity.getId());

		return result;
	}

	public T create(T entity) throws ServiceException {
		T result = null;

		try {
			I id = entity.getId();
			if (id != null && this.getDao().exists(id)) {
				throw new ServiceException("Create failure !!! Entity existed: " + id);
			}
			result = this.getDao().save(entity);
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage(), ex);
		}

		return result;
	}

	public T update(T entity) throws ServiceException {
		T result = null;
        try {
            
            I id = entity.getId();
            T current = this.get(id);
            if (current == null) {
                throw new ServiceException("Update failure !!! Entity is not existed: " + id);
            }
         
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
        
        return result;
	}

	public T saveOrUpdate(T entity) throws ServiceException {
		try {
    		I id = entity.getId();
            T current = this.get(id);
            if (current == null) {
                return this.create(entity);
            }
			return this.update(entity);
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage(), ex);
		}
	}

}
