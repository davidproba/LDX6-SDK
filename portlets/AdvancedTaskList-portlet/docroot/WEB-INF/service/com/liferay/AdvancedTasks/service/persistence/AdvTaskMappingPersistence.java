/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.AdvancedTasks.service.persistence;

import com.liferay.AdvancedTasks.model.AdvTaskMapping;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the adv task mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author David Proba
 * @see AdvTaskMappingPersistenceImpl
 * @see AdvTaskMappingUtil
 * @generated
 */
public interface AdvTaskMappingPersistence extends BasePersistence<AdvTaskMapping> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AdvTaskMappingUtil} to access the adv task mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the adv task mappings where atMTaskId = &#63;.
	*
	* @param atMTaskId the at m task ID
	* @return the matching adv task mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> findByMTaskId(
		long atMTaskId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the adv task mappings where atMTaskId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param atMTaskId the at m task ID
	* @param start the lower bound of the range of adv task mappings
	* @param end the upper bound of the range of adv task mappings (not inclusive)
	* @return the range of matching adv task mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> findByMTaskId(
		long atMTaskId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the adv task mappings where atMTaskId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param atMTaskId the at m task ID
	* @param start the lower bound of the range of adv task mappings
	* @param end the upper bound of the range of adv task mappings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching adv task mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> findByMTaskId(
		long atMTaskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first adv task mapping in the ordered set where atMTaskId = &#63;.
	*
	* @param atMTaskId the at m task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task mapping
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a matching adv task mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTaskMapping findByMTaskId_First(
		long atMTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first adv task mapping in the ordered set where atMTaskId = &#63;.
	*
	* @param atMTaskId the at m task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task mapping, or <code>null</code> if a matching adv task mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTaskMapping fetchByMTaskId_First(
		long atMTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last adv task mapping in the ordered set where atMTaskId = &#63;.
	*
	* @param atMTaskId the at m task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task mapping
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a matching adv task mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTaskMapping findByMTaskId_Last(
		long atMTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last adv task mapping in the ordered set where atMTaskId = &#63;.
	*
	* @param atMTaskId the at m task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task mapping, or <code>null</code> if a matching adv task mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTaskMapping fetchByMTaskId_Last(
		long atMTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the adv task mappings before and after the current adv task mapping in the ordered set where atMTaskId = &#63;.
	*
	* @param atMId the primary key of the current adv task mapping
	* @param atMTaskId the at m task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next adv task mapping
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a adv task mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTaskMapping[] findByMTaskId_PrevAndNext(
		long atMId, long atMTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the adv task mappings where atMTaskId = &#63; from the database.
	*
	* @param atMTaskId the at m task ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMTaskId(long atMTaskId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of adv task mappings where atMTaskId = &#63;.
	*
	* @param atMTaskId the at m task ID
	* @return the number of matching adv task mappings
	* @throws SystemException if a system exception occurred
	*/
	public int countByMTaskId(long atMTaskId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the adv task mappings where atMDependentFromId = &#63;.
	*
	* @param atMDependentFromId the at m dependent from ID
	* @return the matching adv task mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> findByDependentFromId(
		long atMDependentFromId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the adv task mappings where atMDependentFromId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param atMDependentFromId the at m dependent from ID
	* @param start the lower bound of the range of adv task mappings
	* @param end the upper bound of the range of adv task mappings (not inclusive)
	* @return the range of matching adv task mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> findByDependentFromId(
		long atMDependentFromId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the adv task mappings where atMDependentFromId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param atMDependentFromId the at m dependent from ID
	* @param start the lower bound of the range of adv task mappings
	* @param end the upper bound of the range of adv task mappings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching adv task mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> findByDependentFromId(
		long atMDependentFromId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first adv task mapping in the ordered set where atMDependentFromId = &#63;.
	*
	* @param atMDependentFromId the at m dependent from ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task mapping
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a matching adv task mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTaskMapping findByDependentFromId_First(
		long atMDependentFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first adv task mapping in the ordered set where atMDependentFromId = &#63;.
	*
	* @param atMDependentFromId the at m dependent from ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task mapping, or <code>null</code> if a matching adv task mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTaskMapping fetchByDependentFromId_First(
		long atMDependentFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last adv task mapping in the ordered set where atMDependentFromId = &#63;.
	*
	* @param atMDependentFromId the at m dependent from ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task mapping
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a matching adv task mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTaskMapping findByDependentFromId_Last(
		long atMDependentFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last adv task mapping in the ordered set where atMDependentFromId = &#63;.
	*
	* @param atMDependentFromId the at m dependent from ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task mapping, or <code>null</code> if a matching adv task mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTaskMapping fetchByDependentFromId_Last(
		long atMDependentFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the adv task mappings before and after the current adv task mapping in the ordered set where atMDependentFromId = &#63;.
	*
	* @param atMId the primary key of the current adv task mapping
	* @param atMDependentFromId the at m dependent from ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next adv task mapping
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a adv task mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTaskMapping[] findByDependentFromId_PrevAndNext(
		long atMId, long atMDependentFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the adv task mappings where atMDependentFromId = &#63; from the database.
	*
	* @param atMDependentFromId the at m dependent from ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDependentFromId(long atMDependentFromId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of adv task mappings where atMDependentFromId = &#63;.
	*
	* @param atMDependentFromId the at m dependent from ID
	* @return the number of matching adv task mappings
	* @throws SystemException if a system exception occurred
	*/
	public int countByDependentFromId(long atMDependentFromId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the adv task mapping in the entity cache if it is enabled.
	*
	* @param advTaskMapping the adv task mapping
	*/
	public void cacheResult(
		com.liferay.AdvancedTasks.model.AdvTaskMapping advTaskMapping);

	/**
	* Caches the adv task mappings in the entity cache if it is enabled.
	*
	* @param advTaskMappings the adv task mappings
	*/
	public void cacheResult(
		java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> advTaskMappings);

	/**
	* Creates a new adv task mapping with the primary key. Does not add the adv task mapping to the database.
	*
	* @param atMId the primary key for the new adv task mapping
	* @return the new adv task mapping
	*/
	public com.liferay.AdvancedTasks.model.AdvTaskMapping create(long atMId);

	/**
	* Removes the adv task mapping with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param atMId the primary key of the adv task mapping
	* @return the adv task mapping that was removed
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a adv task mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTaskMapping remove(long atMId)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.AdvancedTasks.model.AdvTaskMapping updateImpl(
		com.liferay.AdvancedTasks.model.AdvTaskMapping advTaskMapping)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the adv task mapping with the primary key or throws a {@link com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException} if it could not be found.
	*
	* @param atMId the primary key of the adv task mapping
	* @return the adv task mapping
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a adv task mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTaskMapping findByPrimaryKey(
		long atMId)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the adv task mapping with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param atMId the primary key of the adv task mapping
	* @return the adv task mapping, or <code>null</code> if a adv task mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTaskMapping fetchByPrimaryKey(
		long atMId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the adv task mappings.
	*
	* @return the adv task mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the adv task mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of adv task mappings
	* @param end the upper bound of the range of adv task mappings (not inclusive)
	* @return the range of adv task mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the adv task mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of adv task mappings
	* @param end the upper bound of the range of adv task mappings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of adv task mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the adv task mappings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of adv task mappings.
	*
	* @return the number of adv task mappings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}