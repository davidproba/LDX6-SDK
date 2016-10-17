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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the adv task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author David Proba
 * @see AdvTaskPersistenceImpl
 * @see AdvTaskUtil
 * @generated
 */
public interface AdvTaskPersistence extends BasePersistence<AdvTask> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AdvTaskUtil} to access the adv task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the adv tasks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first adv task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first adv task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last adv task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last adv task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.AdvancedTasks.model.AdvTask[] findByUuid_PrevAndNext(
		long atId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the adv tasks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of adv tasks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the adv task where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.AdvancedTasks.NoSuchAdvTaskException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the adv task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the adv task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the adv task where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the adv task that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of adv tasks where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the adv tasks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.AdvancedTasks.model.AdvTask findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first adv task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.AdvancedTasks.model.AdvTask findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last adv task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.AdvancedTasks.model.AdvTask[] findByUuid_C_PrevAndNext(
		long atId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the adv tasks where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of adv tasks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the adv tasks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first adv task in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first adv task in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last adv task in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last adv task in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.AdvancedTasks.model.AdvTask[] findByGroupId_PrevAndNext(
		long atId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the adv tasks that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching adv tasks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.AdvancedTasks.model.AdvTask[] filterFindByGroupId_PrevAndNext(
		long atId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the adv tasks where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of adv tasks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of adv tasks that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching adv tasks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the adv tasks where status = &#63;.
	*
	* @param status the status
	* @return the matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first adv task in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first adv task in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last adv task in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last adv task in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.AdvancedTasks.model.AdvTask[] findByStatus_PrevAndNext(
		long atId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the adv tasks where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of adv tasks where status = &#63;.
	*
	* @param status the status
	* @return the number of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the adv tasks where atParentTaskId = &#63;.
	*
	* @param atParentTaskId the at parent task ID
	* @return the matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByParentTaskId(
		long atParentTaskId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByParentTaskId(
		long atParentTaskId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByParentTaskId(
		long atParentTaskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first adv task in the ordered set where atParentTaskId = &#63;.
	*
	* @param atParentTaskId the at parent task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask findByParentTaskId_First(
		long atParentTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first adv task in the ordered set where atParentTaskId = &#63;.
	*
	* @param atParentTaskId the at parent task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask fetchByParentTaskId_First(
		long atParentTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last adv task in the ordered set where atParentTaskId = &#63;.
	*
	* @param atParentTaskId the at parent task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask findByParentTaskId_Last(
		long atParentTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last adv task in the ordered set where atParentTaskId = &#63;.
	*
	* @param atParentTaskId the at parent task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask fetchByParentTaskId_Last(
		long atParentTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.AdvancedTasks.model.AdvTask[] findByParentTaskId_PrevAndNext(
		long atId, long atParentTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the adv tasks where atParentTaskId = &#63; from the database.
	*
	* @param atParentTaskId the at parent task ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentTaskId(long atParentTaskId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of adv tasks where atParentTaskId = &#63;.
	*
	* @param atParentTaskId the at parent task ID
	* @return the number of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentTaskId(long atParentTaskId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the adv tasks where atAssignedToUserId = &#63;.
	*
	* @param atAssignedToUserId the at assigned to user ID
	* @return the matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByAssignedToUserId(
		long atAssignedToUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByAssignedToUserId(
		long atAssignedToUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findByAssignedToUserId(
		long atAssignedToUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first adv task in the ordered set where atAssignedToUserId = &#63;.
	*
	* @param atAssignedToUserId the at assigned to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask findByAssignedToUserId_First(
		long atAssignedToUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first adv task in the ordered set where atAssignedToUserId = &#63;.
	*
	* @param atAssignedToUserId the at assigned to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask fetchByAssignedToUserId_First(
		long atAssignedToUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last adv task in the ordered set where atAssignedToUserId = &#63;.
	*
	* @param atAssignedToUserId the at assigned to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask findByAssignedToUserId_Last(
		long atAssignedToUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last adv task in the ordered set where atAssignedToUserId = &#63;.
	*
	* @param atAssignedToUserId the at assigned to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask fetchByAssignedToUserId_Last(
		long atAssignedToUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.AdvancedTasks.model.AdvTask[] findByAssignedToUserId_PrevAndNext(
		long atId, long atAssignedToUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the adv tasks where atAssignedToUserId = &#63; from the database.
	*
	* @param atAssignedToUserId the at assigned to user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAssignedToUserId(long atAssignedToUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of adv tasks where atAssignedToUserId = &#63;.
	*
	* @param atAssignedToUserId the at assigned to user ID
	* @return the number of matching adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByAssignedToUserId(long atAssignedToUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the adv task in the entity cache if it is enabled.
	*
	* @param advTask the adv task
	*/
	public void cacheResult(com.liferay.AdvancedTasks.model.AdvTask advTask);

	/**
	* Caches the adv tasks in the entity cache if it is enabled.
	*
	* @param advTasks the adv tasks
	*/
	public void cacheResult(
		java.util.List<com.liferay.AdvancedTasks.model.AdvTask> advTasks);

	/**
	* Creates a new adv task with the primary key. Does not add the adv task to the database.
	*
	* @param atId the primary key for the new adv task
	* @return the new adv task
	*/
	public com.liferay.AdvancedTasks.model.AdvTask create(long atId);

	/**
	* Removes the adv task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param atId the primary key of the adv task
	* @return the adv task that was removed
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a adv task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask remove(long atId)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.AdvancedTasks.model.AdvTask updateImpl(
		com.liferay.AdvancedTasks.model.AdvTask advTask)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the adv task with the primary key or throws a {@link com.liferay.AdvancedTasks.NoSuchAdvTaskException} if it could not be found.
	*
	* @param atId the primary key of the adv task
	* @return the adv task
	* @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a adv task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask findByPrimaryKey(long atId)
		throws com.liferay.AdvancedTasks.NoSuchAdvTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the adv task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param atId the primary key of the adv task
	* @return the adv task, or <code>null</code> if a adv task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.AdvancedTasks.model.AdvTask fetchByPrimaryKey(long atId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the adv tasks.
	*
	* @return the adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the adv tasks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of adv tasks.
	*
	* @return the number of adv tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}