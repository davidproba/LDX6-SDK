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

package com.liferay.AdvancedTasks.service.base;

import com.liferay.AdvancedTasks.model.AdvTaskMapping;
import com.liferay.AdvancedTasks.service.AdvTaskMappingLocalService;
import com.liferay.AdvancedTasks.service.persistence.AdvTaskMappingPersistence;
import com.liferay.AdvancedTasks.service.persistence.AdvTaskPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the adv task mapping local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.AdvancedTasks.service.impl.AdvTaskMappingLocalServiceImpl}.
 * </p>
 *
 * @author David Proba
 * @see com.liferay.AdvancedTasks.service.impl.AdvTaskMappingLocalServiceImpl
 * @see com.liferay.AdvancedTasks.service.AdvTaskMappingLocalServiceUtil
 * @generated
 */
public abstract class AdvTaskMappingLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements AdvTaskMappingLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.AdvancedTasks.service.AdvTaskMappingLocalServiceUtil} to access the adv task mapping local service.
	 */

	/**
	 * Adds the adv task mapping to the database. Also notifies the appropriate model listeners.
	 *
	 * @param advTaskMapping the adv task mapping
	 * @return the adv task mapping that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AdvTaskMapping addAdvTaskMapping(AdvTaskMapping advTaskMapping)
		throws SystemException {
		advTaskMapping.setNew(true);

		return advTaskMappingPersistence.update(advTaskMapping);
	}

	/**
	 * Creates a new adv task mapping with the primary key. Does not add the adv task mapping to the database.
	 *
	 * @param atMId the primary key for the new adv task mapping
	 * @return the new adv task mapping
	 */
	@Override
	public AdvTaskMapping createAdvTaskMapping(long atMId) {
		return advTaskMappingPersistence.create(atMId);
	}

	/**
	 * Deletes the adv task mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param atMId the primary key of the adv task mapping
	 * @return the adv task mapping that was removed
	 * @throws PortalException if a adv task mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AdvTaskMapping deleteAdvTaskMapping(long atMId)
		throws PortalException, SystemException {
		return advTaskMappingPersistence.remove(atMId);
	}

	/**
	 * Deletes the adv task mapping from the database. Also notifies the appropriate model listeners.
	 *
	 * @param advTaskMapping the adv task mapping
	 * @return the adv task mapping that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AdvTaskMapping deleteAdvTaskMapping(AdvTaskMapping advTaskMapping)
		throws SystemException {
		return advTaskMappingPersistence.remove(advTaskMapping);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(AdvTaskMapping.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return advTaskMappingPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return advTaskMappingPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return advTaskMappingPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return advTaskMappingPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return advTaskMappingPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public AdvTaskMapping fetchAdvTaskMapping(long atMId)
		throws SystemException {
		return advTaskMappingPersistence.fetchByPrimaryKey(atMId);
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
	public AdvTaskMapping getAdvTaskMapping(long atMId)
		throws PortalException, SystemException {
		return advTaskMappingPersistence.findByPrimaryKey(atMId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return advTaskMappingPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<AdvTaskMapping> getAdvTaskMappings(int start, int end)
		throws SystemException {
		return advTaskMappingPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of adv task mappings.
	 *
	 * @return the number of adv task mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getAdvTaskMappingsCount() throws SystemException {
		return advTaskMappingPersistence.countAll();
	}

	/**
	 * Updates the adv task mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param advTaskMapping the adv task mapping
	 * @return the adv task mapping that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AdvTaskMapping updateAdvTaskMapping(AdvTaskMapping advTaskMapping)
		throws SystemException {
		return advTaskMappingPersistence.update(advTaskMapping);
	}

	/**
	 * Returns the adv task local service.
	 *
	 * @return the adv task local service
	 */
	public com.liferay.AdvancedTasks.service.AdvTaskLocalService getAdvTaskLocalService() {
		return advTaskLocalService;
	}

	/**
	 * Sets the adv task local service.
	 *
	 * @param advTaskLocalService the adv task local service
	 */
	public void setAdvTaskLocalService(
		com.liferay.AdvancedTasks.service.AdvTaskLocalService advTaskLocalService) {
		this.advTaskLocalService = advTaskLocalService;
	}

	/**
	 * Returns the adv task persistence.
	 *
	 * @return the adv task persistence
	 */
	public AdvTaskPersistence getAdvTaskPersistence() {
		return advTaskPersistence;
	}

	/**
	 * Sets the adv task persistence.
	 *
	 * @param advTaskPersistence the adv task persistence
	 */
	public void setAdvTaskPersistence(AdvTaskPersistence advTaskPersistence) {
		this.advTaskPersistence = advTaskPersistence;
	}

	/**
	 * Returns the adv task mapping local service.
	 *
	 * @return the adv task mapping local service
	 */
	public com.liferay.AdvancedTasks.service.AdvTaskMappingLocalService getAdvTaskMappingLocalService() {
		return advTaskMappingLocalService;
	}

	/**
	 * Sets the adv task mapping local service.
	 *
	 * @param advTaskMappingLocalService the adv task mapping local service
	 */
	public void setAdvTaskMappingLocalService(
		com.liferay.AdvancedTasks.service.AdvTaskMappingLocalService advTaskMappingLocalService) {
		this.advTaskMappingLocalService = advTaskMappingLocalService;
	}

	/**
	 * Returns the adv task mapping persistence.
	 *
	 * @return the adv task mapping persistence
	 */
	public AdvTaskMappingPersistence getAdvTaskMappingPersistence() {
		return advTaskMappingPersistence;
	}

	/**
	 * Sets the adv task mapping persistence.
	 *
	 * @param advTaskMappingPersistence the adv task mapping persistence
	 */
	public void setAdvTaskMappingPersistence(
		AdvTaskMappingPersistence advTaskMappingPersistence) {
		this.advTaskMappingPersistence = advTaskMappingPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.liferay.AdvancedTasks.model.AdvTaskMapping",
			advTaskMappingLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.AdvancedTasks.model.AdvTaskMapping");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return AdvTaskMapping.class;
	}

	protected String getModelClassName() {
		return AdvTaskMapping.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = advTaskMappingPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.AdvancedTasks.service.AdvTaskLocalService.class)
	protected com.liferay.AdvancedTasks.service.AdvTaskLocalService advTaskLocalService;
	@BeanReference(type = AdvTaskPersistence.class)
	protected AdvTaskPersistence advTaskPersistence;
	@BeanReference(type = com.liferay.AdvancedTasks.service.AdvTaskMappingLocalService.class)
	protected com.liferay.AdvancedTasks.service.AdvTaskMappingLocalService advTaskMappingLocalService;
	@BeanReference(type = AdvTaskMappingPersistence.class)
	protected AdvTaskMappingPersistence advTaskMappingPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private AdvTaskMappingLocalServiceClpInvoker _clpInvoker = new AdvTaskMappingLocalServiceClpInvoker();
}