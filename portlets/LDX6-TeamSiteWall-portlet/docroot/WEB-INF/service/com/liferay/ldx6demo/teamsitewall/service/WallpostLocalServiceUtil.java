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

package com.liferay.ldx6demo.teamsitewall.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Wallpost. This utility wraps
 * {@link com.liferay.ldx6demo.teamsitewall.service.impl.WallpostLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author David Proba
 * @see WallpostLocalService
 * @see com.liferay.ldx6demo.teamsitewall.service.base.WallpostLocalServiceBaseImpl
 * @see com.liferay.ldx6demo.teamsitewall.service.impl.WallpostLocalServiceImpl
 * @generated
 */
public class WallpostLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.ldx6demo.teamsitewall.service.impl.WallpostLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the wallpost to the database. Also notifies the appropriate model listeners.
	*
	* @param wallpost the wallpost
	* @return the wallpost that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost addWallpost(
		com.liferay.ldx6demo.teamsitewall.model.Wallpost wallpost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addWallpost(wallpost);
	}

	/**
	* Creates a new wallpost with the primary key. Does not add the wallpost to the database.
	*
	* @param wallpostId the primary key for the new wallpost
	* @return the new wallpost
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost createWallpost(
		long wallpostId) {
		return getService().createWallpost(wallpostId);
	}

	/**
	* Deletes the wallpost with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wallpostId the primary key of the wallpost
	* @return the wallpost that was removed
	* @throws PortalException if a wallpost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost deleteWallpost(
		long wallpostId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWallpost(wallpostId);
	}

	/**
	* Deletes the wallpost from the database. Also notifies the appropriate model listeners.
	*
	* @param wallpost the wallpost
	* @return the wallpost that was removed
	* @throws PortalException
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost deleteWallpost(
		com.liferay.ldx6demo.teamsitewall.model.Wallpost wallpost)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWallpost(wallpost);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ldx6demo.teamsitewall.model.impl.WallpostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ldx6demo.teamsitewall.model.impl.WallpostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost fetchWallpost(
		long wallpostId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchWallpost(wallpostId);
	}

	/**
	* Returns the wallpost with the matching UUID and company.
	*
	* @param uuid the wallpost's UUID
	* @param companyId the primary key of the company
	* @return the matching wallpost, or <code>null</code> if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost fetchWallpostByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchWallpostByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the wallpost matching the UUID and group.
	*
	* @param uuid the wallpost's UUID
	* @param groupId the primary key of the group
	* @return the matching wallpost, or <code>null</code> if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost fetchWallpostByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchWallpostByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the wallpost with the primary key.
	*
	* @param wallpostId the primary key of the wallpost
	* @return the wallpost
	* @throws PortalException if a wallpost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost getWallpost(
		long wallpostId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWallpost(wallpostId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the wallpost with the matching UUID and company.
	*
	* @param uuid the wallpost's UUID
	* @param companyId the primary key of the company
	* @return the matching wallpost
	* @throws PortalException if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost getWallpostByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWallpostByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the wallpost matching the UUID and group.
	*
	* @param uuid the wallpost's UUID
	* @param groupId the primary key of the group
	* @return the matching wallpost
	* @throws PortalException if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost getWallpostByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWallpostByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the wallposts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ldx6demo.teamsitewall.model.impl.WallpostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wallposts
	* @param end the upper bound of the range of wallposts (not inclusive)
	* @return the range of wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> getWallposts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWallposts(start, end);
	}

	/**
	* Returns the number of wallposts.
	*
	* @return the number of wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static int getWallpostsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWallpostsCount();
	}

	/**
	* Updates the wallpost in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wallpost the wallpost
	* @return the wallpost that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost updateWallpost(
		com.liferay.ldx6demo.teamsitewall.model.Wallpost wallpost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWallpost(wallpost);
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

	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost addWallpost(
		java.lang.String message,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addWallpost(message, serviceContext);
	}

	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost updateWallpost(
		com.liferay.ldx6demo.teamsitewall.model.Wallpost editedWallpost,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWallpost(editedWallpost, serviceContext);
	}

	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> getWallpostsByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWallpostsByGroupId(groupId);
	}

	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> getWallpostsByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWallpostsByGroupId(groupId, start, end);
	}

	public static int getWallpostsCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWallpostsCountByGroupId(groupId);
	}

	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> getWallpostsByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWallpostsByStatus(status);
	}

	public static void clearService() {
		_service = null;
	}

	public static WallpostLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					WallpostLocalService.class.getName());

			if (invokableLocalService instanceof WallpostLocalService) {
				_service = (WallpostLocalService)invokableLocalService;
			}
			else {
				_service = new WallpostLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(WallpostLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(WallpostLocalService service) {
	}

	private static WallpostLocalService _service;
}