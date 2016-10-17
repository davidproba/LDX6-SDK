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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the adv task mapping service. This utility wraps {@link AdvTaskMappingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author David Proba
 * @see AdvTaskMappingPersistence
 * @see AdvTaskMappingPersistenceImpl
 * @generated
 */
public class AdvTaskMappingUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(AdvTaskMapping advTaskMapping) {
		getPersistence().clearCache(advTaskMapping);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AdvTaskMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AdvTaskMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AdvTaskMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static AdvTaskMapping update(AdvTaskMapping advTaskMapping)
		throws SystemException {
		return getPersistence().update(advTaskMapping);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static AdvTaskMapping update(AdvTaskMapping advTaskMapping,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(advTaskMapping, serviceContext);
	}

	/**
	* Returns all the adv task mappings where atMTaskId = &#63;.
	*
	* @param atMTaskId the at m task ID
	* @return the matching adv task mappings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> findByMTaskId(
		long atMTaskId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMTaskId(atMTaskId);
	}

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
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> findByMTaskId(
		long atMTaskId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMTaskId(atMTaskId, start, end);
	}

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
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> findByMTaskId(
		long atMTaskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMTaskId(atMTaskId, start, end, orderByComparator);
	}

	/**
	* Returns the first adv task mapping in the ordered set where atMTaskId = &#63;.
	*
	* @param atMTaskId the at m task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task mapping
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a matching adv task mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTaskMapping findByMTaskId_First(
		long atMTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMTaskId_First(atMTaskId, orderByComparator);
	}

	/**
	* Returns the first adv task mapping in the ordered set where atMTaskId = &#63;.
	*
	* @param atMTaskId the at m task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task mapping, or <code>null</code> if a matching adv task mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTaskMapping fetchByMTaskId_First(
		long atMTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMTaskId_First(atMTaskId, orderByComparator);
	}

	/**
	* Returns the last adv task mapping in the ordered set where atMTaskId = &#63;.
	*
	* @param atMTaskId the at m task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task mapping
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a matching adv task mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTaskMapping findByMTaskId_Last(
		long atMTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMTaskId_Last(atMTaskId, orderByComparator);
	}

	/**
	* Returns the last adv task mapping in the ordered set where atMTaskId = &#63;.
	*
	* @param atMTaskId the at m task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task mapping, or <code>null</code> if a matching adv task mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTaskMapping fetchByMTaskId_Last(
		long atMTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMTaskId_Last(atMTaskId, orderByComparator);
	}

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
	public static com.liferay.AdvancedTasks.model.AdvTaskMapping[] findByMTaskId_PrevAndNext(
		long atMId, long atMTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMTaskId_PrevAndNext(atMId, atMTaskId,
			orderByComparator);
	}

	/**
	* Removes all the adv task mappings where atMTaskId = &#63; from the database.
	*
	* @param atMTaskId the at m task ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMTaskId(long atMTaskId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMTaskId(atMTaskId);
	}

	/**
	* Returns the number of adv task mappings where atMTaskId = &#63;.
	*
	* @param atMTaskId the at m task ID
	* @return the number of matching adv task mappings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMTaskId(long atMTaskId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMTaskId(atMTaskId);
	}

	/**
	* Returns all the adv task mappings where atMDependentFromId = &#63;.
	*
	* @param atMDependentFromId the at m dependent from ID
	* @return the matching adv task mappings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> findByDependentFromId(
		long atMDependentFromId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDependentFromId(atMDependentFromId);
	}

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
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> findByDependentFromId(
		long atMDependentFromId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDependentFromId(atMDependentFromId, start, end);
	}

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
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> findByDependentFromId(
		long atMDependentFromId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDependentFromId(atMDependentFromId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first adv task mapping in the ordered set where atMDependentFromId = &#63;.
	*
	* @param atMDependentFromId the at m dependent from ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task mapping
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a matching adv task mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTaskMapping findByDependentFromId_First(
		long atMDependentFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDependentFromId_First(atMDependentFromId,
			orderByComparator);
	}

	/**
	* Returns the first adv task mapping in the ordered set where atMDependentFromId = &#63;.
	*
	* @param atMDependentFromId the at m dependent from ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task mapping, or <code>null</code> if a matching adv task mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTaskMapping fetchByDependentFromId_First(
		long atMDependentFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDependentFromId_First(atMDependentFromId,
			orderByComparator);
	}

	/**
	* Returns the last adv task mapping in the ordered set where atMDependentFromId = &#63;.
	*
	* @param atMDependentFromId the at m dependent from ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task mapping
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a matching adv task mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTaskMapping findByDependentFromId_Last(
		long atMDependentFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDependentFromId_Last(atMDependentFromId,
			orderByComparator);
	}

	/**
	* Returns the last adv task mapping in the ordered set where atMDependentFromId = &#63;.
	*
	* @param atMDependentFromId the at m dependent from ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task mapping, or <code>null</code> if a matching adv task mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTaskMapping fetchByDependentFromId_Last(
		long atMDependentFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDependentFromId_Last(atMDependentFromId,
			orderByComparator);
	}

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
	public static com.liferay.AdvancedTasks.model.AdvTaskMapping[] findByDependentFromId_PrevAndNext(
		long atMId, long atMDependentFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDependentFromId_PrevAndNext(atMId,
			atMDependentFromId, orderByComparator);
	}

	/**
	* Removes all the adv task mappings where atMDependentFromId = &#63; from the database.
	*
	* @param atMDependentFromId the at m dependent from ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDependentFromId(long atMDependentFromId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDependentFromId(atMDependentFromId);
	}

	/**
	* Returns the number of adv task mappings where atMDependentFromId = &#63;.
	*
	* @param atMDependentFromId the at m dependent from ID
	* @return the number of matching adv task mappings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDependentFromId(long atMDependentFromId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDependentFromId(atMDependentFromId);
	}

	/**
	* Caches the adv task mapping in the entity cache if it is enabled.
	*
	* @param advTaskMapping the adv task mapping
	*/
	public static void cacheResult(
		com.liferay.AdvancedTasks.model.AdvTaskMapping advTaskMapping) {
		getPersistence().cacheResult(advTaskMapping);
	}

	/**
	* Caches the adv task mappings in the entity cache if it is enabled.
	*
	* @param advTaskMappings the adv task mappings
	*/
	public static void cacheResult(
		java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> advTaskMappings) {
		getPersistence().cacheResult(advTaskMappings);
	}

	/**
	* Creates a new adv task mapping with the primary key. Does not add the adv task mapping to the database.
	*
	* @param atMId the primary key for the new adv task mapping
	* @return the new adv task mapping
	*/
	public static com.liferay.AdvancedTasks.model.AdvTaskMapping create(
		long atMId) {
		return getPersistence().create(atMId);
	}

	/**
	* Removes the adv task mapping with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param atMId the primary key of the adv task mapping
	* @return the adv task mapping that was removed
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a adv task mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTaskMapping remove(
		long atMId)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(atMId);
	}

	public static com.liferay.AdvancedTasks.model.AdvTaskMapping updateImpl(
		com.liferay.AdvancedTasks.model.AdvTaskMapping advTaskMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(advTaskMapping);
	}

	/**
	* Returns the adv task mapping with the primary key or throws a {@link com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException} if it could not be found.
	*
	* @param atMId the primary key of the adv task mapping
	* @return the adv task mapping
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a adv task mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTaskMapping findByPrimaryKey(
		long atMId)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(atMId);
	}

	/**
	* Returns the adv task mapping with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param atMId the primary key of the adv task mapping
	* @return the adv task mapping, or <code>null</code> if a adv task mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTaskMapping fetchByPrimaryKey(
		long atMId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(atMId);
	}

	/**
	* Returns all the adv task mappings.
	*
	* @return the adv task mappings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the adv task mappings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of adv task mappings.
	*
	* @return the number of adv task mappings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AdvTaskMappingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AdvTaskMappingPersistence)PortletBeanLocatorUtil.locate(com.liferay.AdvancedTasks.service.ClpSerializer.getServletContextName(),
					AdvTaskMappingPersistence.class.getName());

			ReferenceRegistry.registerReference(AdvTaskMappingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AdvTaskMappingPersistence persistence) {
	}

	private static AdvTaskMappingPersistence _persistence;
}