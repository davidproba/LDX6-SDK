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
 * Provides a wrapper for {@link AdvTaskMappingLocalService}.
 *
 * @author David Proba
 * @see AdvTaskMappingLocalService
 * @generated
 */
public class AdvTaskMappingLocalServiceWrapper
	implements AdvTaskMappingLocalService,
		ServiceWrapper<AdvTaskMappingLocalService> {
	public AdvTaskMappingLocalServiceWrapper(
		AdvTaskMappingLocalService advTaskMappingLocalService) {
		_advTaskMappingLocalService = advTaskMappingLocalService;
	}

	/**
	* Adds the adv task mapping to the database. Also notifies the appropriate model listeners.
	*
	* @param advTaskMapping the adv task mapping
	* @return the adv task mapping that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.AdvancedTasks.model.AdvTaskMapping addAdvTaskMapping(
		com.liferay.AdvancedTasks.model.AdvTaskMapping advTaskMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskMappingLocalService.addAdvTaskMapping(advTaskMapping);
	}

	/**
	* Creates a new adv task mapping with the primary key. Does not add the adv task mapping to the database.
	*
	* @param atMId the primary key for the new adv task mapping
	* @return the new adv task mapping
	*/
	@Override
	public com.liferay.AdvancedTasks.model.AdvTaskMapping createAdvTaskMapping(
		long atMId) {
		return _advTaskMappingLocalService.createAdvTaskMapping(atMId);
	}

	/**
	* Deletes the adv task mapping with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param atMId the primary key of the adv task mapping
	* @return the adv task mapping that was removed
	* @throws PortalException if a adv task mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.AdvancedTasks.model.AdvTaskMapping deleteAdvTaskMapping(
		long atMId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advTaskMappingLocalService.deleteAdvTaskMapping(atMId);
	}

	/**
	* Deletes the adv task mapping from the database. Also notifies the appropriate model listeners.
	*
	* @param advTaskMapping the adv task mapping
	* @return the adv task mapping that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.AdvancedTasks.model.AdvTaskMapping deleteAdvTaskMapping(
		com.liferay.AdvancedTasks.model.AdvTaskMapping advTaskMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskMappingLocalService.deleteAdvTaskMapping(advTaskMapping);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _advTaskMappingLocalService.dynamicQuery();
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
		return _advTaskMappingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _advTaskMappingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _advTaskMappingLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _advTaskMappingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _advTaskMappingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.AdvancedTasks.model.AdvTaskMapping fetchAdvTaskMapping(
		long atMId) throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskMappingLocalService.fetchAdvTaskMapping(atMId);
	}

	/**
	* Returns the adv task mapping with the primary key.
	*
	* @param atMId the primary key of the adv task mapping
	* @return the adv task mapping
	* @throws PortalException if a adv task mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.AdvancedTasks.model.AdvTaskMapping getAdvTaskMapping(
		long atMId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advTaskMappingLocalService.getAdvTaskMapping(atMId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advTaskMappingLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> getAdvTaskMappings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskMappingLocalService.getAdvTaskMappings(start, end);
	}

	/**
	* Returns the number of adv task mappings.
	*
	* @return the number of adv task mappings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAdvTaskMappingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskMappingLocalService.getAdvTaskMappingsCount();
	}

	/**
	* Updates the adv task mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param advTaskMapping the adv task mapping
	* @return the adv task mapping that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.AdvancedTasks.model.AdvTaskMapping updateAdvTaskMapping(
		com.liferay.AdvancedTasks.model.AdvTaskMapping advTaskMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskMappingLocalService.updateAdvTaskMapping(advTaskMapping);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _advTaskMappingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_advTaskMappingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _advTaskMappingLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> getMTasks(
		long taskId) throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskMappingLocalService.getMTasks(taskId);
	}

	@Override
	public java.util.List<com.liferay.AdvancedTasks.model.AdvTaskMapping> getDTasks(
		long taskId) throws com.liferay.portal.kernel.exception.SystemException {
		return _advTaskMappingLocalService.getDTasks(taskId);
	}

	@Override
	public com.liferay.AdvancedTasks.model.AdvTaskMapping insertTaskMapping(
		long taskId, long dependentId) {
		return _advTaskMappingLocalService.insertTaskMapping(taskId, dependentId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AdvTaskMappingLocalService getWrappedAdvTaskMappingLocalService() {
		return _advTaskMappingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAdvTaskMappingLocalService(
		AdvTaskMappingLocalService advTaskMappingLocalService) {
		_advTaskMappingLocalService = advTaskMappingLocalService;
	}

	@Override
	public AdvTaskMappingLocalService getWrappedService() {
		return _advTaskMappingLocalService;
	}

	@Override
	public void setWrappedService(
		AdvTaskMappingLocalService advTaskMappingLocalService) {
		_advTaskMappingLocalService = advTaskMappingLocalService;
	}

	private AdvTaskMappingLocalService _advTaskMappingLocalService;
}