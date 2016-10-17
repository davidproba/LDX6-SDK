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

package com.liferay.AdvancedTasks.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AdvTaskLocalService}.
 *
 * @author David Proba
 * @see AdvTaskLocalService
 * @generated
 */
public class AdvTaskLocalServiceWrapper implements AdvTaskLocalService,
	ServiceWrapper<AdvTaskLocalService> {
	public AdvTaskLocalServiceWrapper(AdvTaskLocalService advTaskLocalService) {
		_advTaskLocalService = advTaskLocalService;
	}

	/**
	* Adds the adv task to the database. Also notifies the appropriate model listeners.
	*
	* @param advTask the adv task
	* @return the adv task that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.AdvancedTasks.model.AdvTask addAdvTask(
		com.liferay.AdvancedTasks.model.AdvTask advTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.addAdvTask(advTask);
	}

	/**
	* Creates a new adv task with the primary key. Does not add the adv task to the database.
	*
	* @param atId the primary key for the new adv task
	* @return the new adv task
	*/
	@Override
	public com.liferay.AdvancedTasks.model.AdvTask createAdvTask(long atId) {
		return _advTaskLocalService.createAdvTask(atId);
	}

	/**
	* Deletes the adv task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param atId the primary key of the adv task
	* @return the adv task that was removed
	* @throws PortalException if a adv task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.AdvancedTasks.model.AdvTask deleteAdvTask(long atId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.deleteAdvTask(atId);
	}

	/**
	* Deletes the adv task from the database. Also notifies the appropriate model listeners.
	*
	* @param advTask the adv task
	* @return the adv task that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.AdvancedTasks.model.AdvTask deleteAdvTask(
		com.liferay.AdvancedTasks.model.AdvTask advTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.deleteAdvTask(advTask);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _advTaskLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.AdvancedTasks.model.AdvTask fetchAdvTask(long atId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.fetchAdvTask(atId);
	}

	/**
	* Returns the adv task with the matching UUID and company.
	*
	* @param uuid the adv task's UUID
	* @param companyId the primary key of the company
	* @return the matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.AdvancedTasks.model.AdvTask fetchAdvTaskByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.fetchAdvTaskByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the adv task matching the UUID and group.
	*
	* @param uuid the adv task's UUID
	* @param groupId the primary key of the group
	* @return the matching adv task, or <code>null</code> if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.AdvancedTasks.model.AdvTask fetchAdvTaskByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.fetchAdvTaskByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the adv task with the primary key.
	*
	* @param atId the primary key of the adv task
	* @return the adv task
	* @throws PortalException if a adv task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.AdvancedTasks.model.AdvTask getAdvTask(long atId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.getAdvTask(atId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the adv task with the matching UUID and company.
	*
	* @param uuid the adv task's UUID
	* @param companyId the primary key of the company
	* @return the matching adv task
	* @throws PortalException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.AdvancedTasks.model.AdvTask getAdvTaskByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.getAdvTaskByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the adv task matching the UUID and group.
	*
	* @param uuid the adv task's UUID
	* @param groupId the primary key of the group
	* @return the matching adv task
	* @throws PortalException if a matching adv task could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.AdvancedTasks.model.AdvTask getAdvTaskByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.getAdvTaskByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> getAdvTasks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.getAdvTasks(start, end);
	}

	/**
	* Returns the number of adv tasks.
	*
	* @return the number of adv tasks
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAdvTasksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.getAdvTasksCount();
	}

	/**
	* Updates the adv task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param advTask the adv task
	* @return the adv task that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.AdvancedTasks.model.AdvTask updateAdvTask(
		com.liferay.AdvancedTasks.model.AdvTask advTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.updateAdvTask(advTask);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _advTaskLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_advTaskLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _advTaskLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.liferay.AdvancedTasks.model.AdvTask insertTask(
		java.lang.String title, java.lang.String description,
		java.util.Date startDate, java.util.Date finalDate, int priority,
		int status, long modifier, long asignee, long resolver, long parent,
		com.liferay.portal.theme.ThemeDisplay tD,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.insertTask(title, description, startDate,
			finalDate, priority, status, modifier, asignee, resolver, parent,
			tD, serviceContext);
	}

	@Override
	public com.liferay.AdvancedTasks.model.AdvTask updateTask(
		com.liferay.AdvancedTasks.model.AdvTask editedTask,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.updateTask(editedTask, serviceContext);
	}

	@Override
	public com.liferay.AdvancedTasks.model.AdvTask deleteTask(
		com.liferay.AdvancedTasks.model.AdvTask delTask)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.deleteTask(delTask);
	}

	@Override
	public void sendNotificationEvent(
		com.liferay.AdvancedTasks.model.AdvTask task, int oldStatus,
		long oldAssigneeUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_advTaskLocalService.sendNotificationEvent(task, oldStatus,
			oldAssigneeUserId, serviceContext);
	}

	@Override
	public com.liferay.AdvancedTasks.model.AdvTask deleteTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.deleteTask(taskId);
	}

	@Override
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> getTasksByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.getTasksByGroupId(groupId);
	}

	@Override
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> getTasksByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.getTasksByGroupId(groupId, start, end);
	}

	@Override
	public int getTasksCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.getTasksCountByGroupId(groupId);
	}

	@Override
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> getTasksByAssigneeId(
		long assigneeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.getTasksByAssigneeId(assigneeId);
	}

	@Override
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> getTasksByAssigneeId(
		long assigneeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.getTasksByAssigneeId(assigneeId, start, end);
	}

	@Override
	public int getTasksCountByAssigneeId(long assigneeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.getTasksCountByAssigneeId(assigneeId);
	}

	@Override
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> getTasksByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.getTasksByStatus(status);
	}

	@Override
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTask> getChildTasks(
		long taskId) throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskLocalService.getChildTasks(taskId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AdvTaskLocalService getWrappedAdvTaskLocalService() {
		return _advTaskLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAdvTaskLocalService(
		AdvTaskLocalService advTaskLocalService) {
		_advTaskLocalService = advTaskLocalService;
	}

	@Override
	public AdvTaskLocalService getWrappedService() {
		return _advTaskLocalService;
	}

	@Override
	public void setWrappedService(AdvTaskLocalService advTaskLocalService) {
		_advTaskLocalService = advTaskLocalService;
	}

	private AdvTaskLocalService _advTaskLocalService;
}