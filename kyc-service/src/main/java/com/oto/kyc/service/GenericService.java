/**
 * 
 */
package com.oto.kyc.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.oto.kyc.service.exception.ServiceException;

/**
 * @author thuyntp
 *
 */
public interface GenericService<T,I extends Serializable> {
	
	/**
     * sub-class must implement this method to get exactly {@link CrudRepository} instance for specific DAO.<br/>
     * Sample:<br/>
     * <code>
     * &commat;Service
     * public class UserServiceImpl extends GenericService&lt;User, Long&gt; implements UserService {
     *     &commat;Autowired
     *     private UserDao userDao;
     *     
     *     public CrudRepository&lt;User, Long&gt; getDao() {
     *         return this.userDao;
     *     }
     * }
     * </code>
     * @return {@link CrudRepository} instance.
     */
	CrudRepository<T, I> getDao();
	
	/**
     * Get entity by given entity id.
     * 
     * @param id
     *            {@link Serializable} is @@Id field from Entity
     * @return instance of {@link LockAuditableEntity}
     * @throws ServiceException if any issue cause by persistence.
     */
    T get(I id) throws ServiceException;
    
    /**
     * Get entity by given entity list of ids.
     * 
     * @param ids
     *            List of {@link Serializable} is @@Id field from Entity
     * @return instance of {@link LockAuditableEntity}
     * @throws ServiceException if any issue cause by persistence.
     */
    List<T> get(List<I> ids) throws ServiceException;
    
    /**
     * Get activated entity by given entity id.
     * if only if entity is instance of {@link PersistentLockAuditableEntity}
     * 
     * @param id
     *            {@link Serializable} is @@Id field from Entity
     * @return instance of {@link PersistentLockAuditableEntity}
     * @throws ServiceException if any issue cause by persistence.
     */
    T getActivated(I id) throws ServiceException;
    
    /**
     * Get all entity.
     * @return list of all entity.
     * @throws ServiceException if any issue cause by persistence.
     */
    public List<T> getAll() throws ServiceException;
    
    /**
     * Get all activated entity. If only if entity is instance of {@link PersistentLockAuditableEntity}
     * @return list of all entity {@link PersistentLockAuditableEntity}.
     * @throws ServiceException if any issue cause by persistence.
     */
    public List<T> getAllActivated() throws ServiceException;
    
    /**
     * Delete entity by given entity id.
     * 
     * @param id
     *            {@link Serializable} is @@Id field from Entity
     * @return instance of deleted {@link LockAuditableEntity}, can use for check from higher-layer
     * @throws ServiceException if any issue cause by persistence.
     */
    T delete(I id) throws ServiceException;
    
    /**
     * Delete entity by given entity.
     * Checking entity is modifiable or not. 
     * @param entity {@link LockAuditableEntity} instance
     * @return instance of deleted {@link LockAuditableEntity}, can use for check from higher-layer
     * @throws UnModifiableException if entity has updated by other user.
     * @throws ServiceException if any issue cause by persistence.
     */
    T delete(T entity) throws ServiceException;
    /**
     * Create new entity and save it to persistence.
     * @param entity {@link LockAuditableEntity}.
     * @return {@link LockAuditableEntity} instance (include ID) if success saved.
     * @throws ServiceException if any issue cause by persistence.
     */
    T create(T entity) throws ServiceException;
    
    /**
     * Update a {@link LockAuditableEntity} entity.
     * @param entity {@link LockAuditableEntity}
     * @return {@link LockAuditableEntity} after update.
     * @throws ServiceException ServiceException if any issue cause by persistence.
     */
    public T update(T entity) throws ServiceException;

    /**
     * Delegate save from DAO.
     * @param entity entity need to save
     * @return entity after save
     * @throws ServiceException if saving cause error.
     */
	T saveOrUpdate(T entity) throws ServiceException;
}
