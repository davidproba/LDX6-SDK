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

import com.liferay.AdvancedTasks.model.AdvTask;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the adv task service. This utility wraps {@link AdvTaskPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author David Proba
 * @see AdvTaskPersistence
 * @see AdvTaskPersistenceImpl
 * @generated
 */
public class AdvTaskUtil {
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
	public static void clearCache(AdvTask advTask) {
		getPersistence().clearCache(advTask);
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
	public static List<AdvTask> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AdvTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AdvTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static AdvTask update(AdvTask advTask) throws SystemException {
		return getPersistence().update(advTask);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static AdvTask update(AdvTask advTask, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(advTask, serviceContext);
	}

	/**
	* Returns all the adv tasks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the adv tasks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of adv tasks
	* @param end the upper bound of the range of adv tasks (not inclusive)
	* @return the range of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the adv tasks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of adv tasks
	* @param end the upper bound of the range of adv tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first adv task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first adv task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last adv task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last adv task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the adv tasks before and after the current adv task in the ordered set where uuid = &#63;.
	*
	* @param atId the primary key of the current adv task
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a adv task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask[] findByUuid_PrevAndNext(
		long atId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(atId, uuid, orderByComparator);
	}

	/**
	* Removes all the adv tasks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of adv tasks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the adv task where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.AdvancedTasks.NoSuchAdvTaskException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the adv task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the adv task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the adv task where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the adv task that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of adv tasks where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the adv tasks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the adv tasks where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of adv tasks
	* @param end the upper bound of the range of adv tasks (not inclusive)
	* @return the range of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the adv tasks where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of adv tasks
	* @param end the upper bound of the range of adv tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first adv task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first adv task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last adv task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last adv task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the adv tasks before and after the current adv task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param atId the primary key of the current adv task
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a adv task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask[] findByUuid_C_PrevAndNext(
		long atId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(atId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the adv tasks where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of adv tasks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the adv tasks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the adv tasks where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of adv tasks
	* @param end the upper bound of the range of adv tasks (not inclusive)
	* @return the range of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the adv tasks where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of adv tasks
	* @param end the upper bound of the range of adv tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first adv task in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first adv task in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last adv task in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last adv task in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the adv tasks before and after the current adv task in the ordered set where groupId = &#63;.
	*
	* @param atId the primary key of the current adv task
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a adv task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask[] findByGroupId_PrevAndNext(
		long atId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(atId, groupId, orderByComparator);
	}

	/**
	* Returns all the adv tasks that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching adv tasks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the adv tasks that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of adv tasks
	* @param end the upper bound of the range of adv tasks (not inclusive)
	* @return the range of matching adv tasks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the adv tasks that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of adv tasks
	* @param end the upper bound of the range of adv tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching adv tasks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the adv tasks before and after the current adv task in the ordered set of adv tasks that the user has permission to view where groupId = &#63;.
	*
	* @param atId the primary key of the current adv task
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a adv task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask[] filterFindByGroupId_PrevAndNext(
		long atId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(atId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the adv tasks where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of adv tasks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of adv tasks that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching adv tasks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns all the adv tasks where status = &#63;.
	*
	* @param status the status
	* @return the matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the adv tasks where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of adv tasks
	* @param end the upper bound of the range of adv tasks (not inclusive)
	* @return the range of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the adv tasks where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of adv tasks
	* @param end the upper bound of the range of adv tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first adv task in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first adv task in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last adv task in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last adv task in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the adv tasks before and after the current adv task in the ordered set where status = &#63;.
	*
	* @param atId the primary key of the current adv task
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a adv task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask[] findByStatus_PrevAndNext(
		long atId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus_PrevAndNext(atId, status, orderByComparator);
	}

	/**
	* Removes all the adv tasks where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Returns the number of adv tasks where status = &#63;.
	*
	* @param status the status
	* @return the number of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns all the adv tasks where atParentTaskId = &#63;.
	*
	* @param atParentTaskId the at parent task ID
	* @return the matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByParentTaskId(
		long atParentTaskId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentTaskId(atParentTaskId);
	}

	/**
	* Returns a range of all the adv tasks where atParentTaskId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param atParentTaskId the at parent task ID
	* @param start the lower bound of the range of adv tasks
	* @param end the upper bound of the range of adv tasks (not inclusive)
	* @return the range of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByParentTaskId(
		long atParentTaskId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentTaskId(atParentTaskId, start, end);
	}

	/**
	* Returns an ordered range of all the adv tasks where atParentTaskId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param atParentTaskId the at parent task ID
	* @param start the lower bound of the range of adv tasks
	* @param end the upper bound of the range of adv tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByParentTaskId(
		long atParentTaskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentTaskId(atParentTaskId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first adv task in the ordered set where atParentTaskId = &#63;.
	*
	* @param atParentTaskId the at parent task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask findByParentTaskId_First(
		long atParentTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentTaskId_First(atParentTaskId, orderByComparator);
	}

	/**
	* Returns the first adv task in the ordered set where atParentTaskId = &#63;.
	*
	* @param atParentTaskId the at parent task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask fetchByParentTaskId_First(
		long atParentTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentTaskId_First(atParentTaskId, orderByComparator);
	}

	/**
	* Returns the last adv task in the ordered set where atParentTaskId = &#63;.
	*
	* @param atParentTaskId the at parent task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask findByParentTaskId_Last(
		long atParentTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentTaskId_Last(atParentTaskId, orderByComparator);
	}

	/**
	* Returns the last adv task in the ordered set where atParentTaskId = &#63;.
	*
	* @param atParentTaskId the at parent task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask fetchByParentTaskId_Last(
		long atParentTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentTaskId_Last(atParentTaskId, orderByComparator);
	}

	/**
	* Returns the adv tasks before and after the current adv task in the ordered set where atParentTaskId = &#63;.
	*
	* @param atId the primary key of the current adv task
	* @param atParentTaskId the at parent task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a adv task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask[] findByParentTaskId_PrevAndNext(
		long atId, long atParentTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentTaskId_PrevAndNext(atId, atParentTaskId,
			orderByComparator);
	}

	/**
	* Removes all the adv tasks where atParentTaskId = &#63; from the database.
	*
	* @param atParentTaskId the at parent task ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentTaskId(long atParentTaskId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentTaskId(atParentTaskId);
	}

	/**
	* Returns the number of adv tasks where atParentTaskId = &#63;.
	*
	* @param atParentTaskId the at parent task ID
	* @return the number of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentTaskId(long atParentTaskId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentTaskId(atParentTaskId);
	}

	/**
	* Returns all the adv tasks where atAssignedToUserId = &#63;.
	*
	* @param atAssignedToUserId the at assigned to user ID
	* @return the matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByAssignedToUserId(
		long atAssignedToUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAssignedToUserId(atAssignedToUserId);
	}

	/**
	* Returns a range of all the adv tasks where atAssignedToUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param atAssignedToUserId the at assigned to user ID
	* @param start the lower bound of the range of adv tasks
	* @param end the upper bound of the range of adv tasks (not inclusive)
	* @return the range of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByAssignedToUserId(
		long atAssignedToUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAssignedToUserId(atAssignedToUserId, start, end);
	}

	/**
	* Returns an ordered range of all the adv tasks where atAssignedToUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param atAssignedToUserId the at assigned to user ID
	* @param start the lower bound of the range of adv tasks
	* @param end the upper bound of the range of adv tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByAssignedToUserId(
		long atAssignedToUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAssignedToUserId(atAssignedToUserId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first adv task in the ordered set where atAssignedToUserId = &#63;.
	*
	* @param atAssignedToUserId the at assigned to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask findByAssignedToUserId_First(
		long atAssignedToUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAssignedToUserId_First(atAssignedToUserId,
			orderByComparator);
	}

	/**
	* Returns the first adv task in the ordered set where atAssignedToUserId = &#63;.
	*
	* @param atAssignedToUserId the at assigned to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask fetchByAssignedToUserId_First(
		long atAssignedToUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAssignedToUserId_First(atAssignedToUserId,
			orderByComparator);
	}

	/**
	* Returns the last adv task in the ordered set where atAssignedToUserId = &#63;.
	*
	* @param atAssignedToUserId the at assigned to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask findByAssignedToUserId_Last(
		long atAssignedToUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAssignedToUserId_Last(atAssignedToUserId,
			orderByComparator);
	}

	/**
	* Returns the last adv task in the ordered set where atAssignedToUserId = &#63;.
	*
	* @param atAssignedToUserId the at assigned to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask fetchByAssignedToUserId_Last(
		long atAssignedToUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAssignedToUserId_Last(atAssignedToUserId,
			orderByComparator);
	}

	/**
	* Returns the adv tasks before and after the current adv task in the ordered set where atAssignedToUserId = &#63;.
	*
	* @param atId the primary key of the current adv task
	* @param atAssignedToUserId the at assigned to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a adv task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask[] findByAssignedToUserId_PrevAndNext(
		long atId, long atAssignedToUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAssignedToUserId_PrevAndNext(atId,
			atAssignedToUserId, orderByComparator);
	}

	/**
	* Removes all the adv tasks where atAssignedToUserId = &#63; from the database.
	*
	* @param atAssignedToUserId the at assigned to user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAssignedToUserId(long atAssignedToUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAssignedToUserId(atAssignedToUserId);
	}

	/**
	* Returns the number of adv tasks where atAssignedToUserId = &#63;.
	*
	* @param atAssignedToUserId the at assigned to user ID
	* @return the number of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAssignedToUserId(long atAssignedToUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAssignedToUserId(atAssignedToUserId);
	}

	/**
	* Caches the adv task in the entity cache if it is enabled.
	*
	* @param advTask the adv task
	*/
	public static void cacheResult(
		com.liferay.AdvancedTasks.model.AdvTask advTask) {
		getPersistence().cacheResult(advTask);
	}

	/**
	* Caches the adv tasks in the entity cache if it is enabled.
	*
	* @param advTasks the adv tasks
	*/
	public static void cacheResult(
		java.util.List<com.liferay.AdvancedTasks.model.AdvTask> advTasks) {
		getPersistence().cacheResult(advTasks);
	}

	/**
	* Creates a new adv task with the primary key. Does not add the adv task to the database.
	*
	* @param atId the primary key for the new adv task
	* @return the new adv task
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask create(long atId) {
		return getPersistence().create(atId);
	}

	/**
	* Removes the adv task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param atId the primary key of the adv task
	* @return the adv task that was removed
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a adv task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask remove(long atId)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(atId);
	}

	public static com.liferay.AdvancedTasks.model.AdvTask updateImpl(
		com.liferay.AdvancedTasks.model.AdvTask advTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(advTask);
	}

	/**
	* Returns the adv task with the primary key or throws a {@link com.liferay.AdvancedTasks.NoSuchAdvTaskException} if it could not be found.
	*
	* @param atId the primary key of the adv task
	* @return the adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a adv task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask findByPrimaryKey(
		long atId)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(atId);
	}

	/**
	* Returns the adv task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param atId the primary key of the adv task
	* @return the adv task, or <code>null</code> if a adv task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.AdvancedTasks.model.AdvTask fetchByPrimaryKey(
		long atId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(atId);
	}

	/**
	* Returns all the adv tasks.
	*
	* @return the adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the adv tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of adv tasks
	* @param end the upper bound of the range of adv tasks (not inclusive)
	* @return the range of adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the adv tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of adv tasks
	* @param end the upper bound of the range of adv tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the adv tasks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of adv tasks.
	*
	* @return the number of adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AdvTaskPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AdvTaskPersistence)PortletBeanLocatorUtil.locate(com.liferay.AdvancedTasks.service.ClpSerializer.getServletContextName(),
					AdvTaskPersistence.class.getName());

			ReferenceRegistry.registerReference(AdvTaskUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AdvTaskPersistence persistence) {
	}

	private static AdvTaskPersistence _persistence;
}