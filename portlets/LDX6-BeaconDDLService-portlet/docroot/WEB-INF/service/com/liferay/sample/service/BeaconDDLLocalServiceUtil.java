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

package com.liferay.sample.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for BeaconDDL. This utility wraps
 * {@link com.liferay.sample.service.impl.BeaconDDLLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author David Proba
 * @see BeaconDDLLocalService
 * @see com.liferay.sample.service.base.BeaconDDLLocalServiceBaseImpl
 * @see com.liferay.sample.service.impl.BeaconDDLLocalServiceImpl
 * @generated
 */
public class BeaconDDLLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.sample.service.impl.BeaconDDLLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the beacon d d l to the database. Also notifies the appropriate model listeners.
	*
	* @param beaconDDL the beacon d d l
	* @return the beacon d d l that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.BeaconDDL addBeaconDDL(
		com.liferay.sample.model.BeaconDDL beaconDDL)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBeaconDDL(beaconDDL);
	}

	/**
	* Creates a new beacon d d l with the primary key. Does not add the beacon d d l to the database.
	*
	* @param Id the primary key for the new beacon d d l
	* @return the new beacon d d l
	*/
	public static com.liferay.sample.model.BeaconDDL createBeaconDDL(long Id) {
		return getService().createBeaconDDL(Id);
	}

	/**
	* Deletes the beacon d d l with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Id the primary key of the beacon d d l
	* @return the beacon d d l that was removed
	* @throws PortalException if a beacon d d l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.BeaconDDL deleteBeaconDDL(long Id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBeaconDDL(Id);
	}

	/**
	* Deletes the beacon d d l from the database. Also notifies the appropriate model listeners.
	*
	* @param beaconDDL the beacon d d l
	* @return the beacon d d l that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.BeaconDDL deleteBeaconDDL(
		com.liferay.sample.model.BeaconDDL beaconDDL)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBeaconDDL(beaconDDL);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.BeaconDDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.BeaconDDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.sample.model.BeaconDDL fetchBeaconDDL(long Id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBeaconDDL(Id);
	}

	/**
	* Returns the beacon d d l with the primary key.
	*
	* @param Id the primary key of the beacon d d l
	* @return the beacon d d l
	* @throws PortalException if a beacon d d l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.BeaconDDL getBeaconDDL(long Id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBeaconDDL(Id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the beacon d d ls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.BeaconDDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of beacon d d ls
	* @param end the upper bound of the range of beacon d d ls (not inclusive)
	* @return the range of beacon d d ls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.BeaconDDL> getBeaconDDLs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBeaconDDLs(start, end);
	}

	/**
	* Returns the number of beacon d d ls.
	*
	* @return the number of beacon d d ls
	* @throws SystemException if a system exception occurred
	*/
	public static int getBeaconDDLsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBeaconDDLsCount();
	}

	/**
	* Updates the beacon d d l in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param beaconDDL the beacon d d l
	* @return the beacon d d l that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.BeaconDDL updateBeaconDDL(
		com.liferay.sample.model.BeaconDDL beaconDDL)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBeaconDDL(beaconDDL);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static BeaconDDLLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BeaconDDLLocalService.class.getName());

			if (invokableLocalService instanceof BeaconDDLLocalService) {
				_service = (BeaconDDLLocalService)invokableLocalService;
			}
			else {
				_service = new BeaconDDLLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BeaconDDLLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BeaconDDLLocalService service) {
	}

	private static BeaconDDLLocalService _service;
}