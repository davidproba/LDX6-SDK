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

package com.liferay.ldx6demo.teamsitewall.service.persistence;

import com.liferay.ldx6demo.teamsitewall.model.Wallpost;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the wallpost service. This utility wraps {@link WallpostPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author David Proba
 * @see WallpostPersistence
 * @see WallpostPersistenceImpl
 * @generated
 */
public class WallpostUtil {
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
	public static void clearCache(Wallpost wallpost) {
		getPersistence().clearCache(wallpost);
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
	public static List<Wallpost> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Wallpost> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Wallpost> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Wallpost update(Wallpost wallpost) throws SystemException {
		return getPersistence().update(wallpost);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Wallpost update(Wallpost wallpost,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(wallpost, serviceContext);
	}

	/**
	* Returns all the wallposts where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the wallposts where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ldx6demo.teamsitewall.model.impl.WallpostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of wallposts
	* @param end the upper bound of the range of wallposts (not inclusive)
	* @return the range of matching wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the wallposts where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ldx6demo.teamsitewall.model.impl.WallpostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of wallposts
	* @param end the upper bound of the range of wallposts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first wallpost in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wallpost
	* @throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first wallpost in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wallpost, or <code>null</code> if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last wallpost in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wallpost
	* @throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last wallpost in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wallpost, or <code>null</code> if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the wallposts before and after the current wallpost in the ordered set where uuid = &#63;.
	*
	* @param wallpostId the primary key of the current wallpost
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wallpost
	* @throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException if a wallpost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost[] findByUuid_PrevAndNext(
		long wallpostId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(wallpostId, uuid, orderByComparator);
	}

	/**
	* Removes all the wallposts where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of wallposts where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the wallpost where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching wallpost
	* @throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the wallpost where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching wallpost, or <code>null</code> if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the wallpost where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching wallpost, or <code>null</code> if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the wallpost where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the wallpost that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of wallposts where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the wallposts where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the wallposts where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ldx6demo.teamsitewall.model.impl.WallpostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of wallposts
	* @param end the upper bound of the range of wallposts (not inclusive)
	* @return the range of matching wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the wallposts where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ldx6demo.teamsitewall.model.impl.WallpostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of wallposts
	* @param end the upper bound of the range of wallposts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first wallpost in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wallpost
	* @throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first wallpost in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wallpost, or <code>null</code> if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last wallpost in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wallpost
	* @throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last wallpost in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wallpost, or <code>null</code> if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the wallposts before and after the current wallpost in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param wallpostId the primary key of the current wallpost
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wallpost
	* @throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException if a wallpost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost[] findByUuid_C_PrevAndNext(
		long wallpostId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(wallpostId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the wallposts where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of wallposts where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the wallposts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the wallposts where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ldx6demo.teamsitewall.model.impl.WallpostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of wallposts
	* @param end the upper bound of the range of wallposts (not inclusive)
	* @return the range of matching wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the wallposts where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ldx6demo.teamsitewall.model.impl.WallpostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of wallposts
	* @param end the upper bound of the range of wallposts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first wallpost in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wallpost
	* @throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first wallpost in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wallpost, or <code>null</code> if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last wallpost in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wallpost
	* @throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last wallpost in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wallpost, or <code>null</code> if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the wallposts before and after the current wallpost in the ordered set where groupId = &#63;.
	*
	* @param wallpostId the primary key of the current wallpost
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wallpost
	* @throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException if a wallpost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost[] findByGroupId_PrevAndNext(
		long wallpostId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(wallpostId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the wallposts that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching wallposts that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the wallposts that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ldx6demo.teamsitewall.model.impl.WallpostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of wallposts
	* @param end the upper bound of the range of wallposts (not inclusive)
	* @return the range of matching wallposts that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the wallposts that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ldx6demo.teamsitewall.model.impl.WallpostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of wallposts
	* @param end the upper bound of the range of wallposts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wallposts that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the wallposts before and after the current wallpost in the ordered set of wallposts that the user has permission to view where groupId = &#63;.
	*
	* @param wallpostId the primary key of the current wallpost
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wallpost
	* @throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException if a wallpost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost[] filterFindByGroupId_PrevAndNext(
		long wallpostId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(wallpostId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the wallposts where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of wallposts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of wallposts that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching wallposts that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns all the wallposts where status = &#63;.
	*
	* @param status the status
	* @return the matching wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the wallposts where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ldx6demo.teamsitewall.model.impl.WallpostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of wallposts
	* @param end the upper bound of the range of wallposts (not inclusive)
	* @return the range of matching wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the wallposts where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ldx6demo.teamsitewall.model.impl.WallpostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of wallposts
	* @param end the upper bound of the range of wallposts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first wallpost in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wallpost
	* @throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first wallpost in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wallpost, or <code>null</code> if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last wallpost in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wallpost
	* @throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last wallpost in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wallpost, or <code>null</code> if a matching wallpost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the wallposts before and after the current wallpost in the ordered set where status = &#63;.
	*
	* @param wallpostId the primary key of the current wallpost
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wallpost
	* @throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException if a wallpost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost[] findByStatus_PrevAndNext(
		long wallpostId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus_PrevAndNext(wallpostId, status,
			orderByComparator);
	}

	/**
	* Removes all the wallposts where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Returns the number of wallposts where status = &#63;.
	*
	* @param status the status
	* @return the number of matching wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Caches the wallpost in the entity cache if it is enabled.
	*
	* @param wallpost the wallpost
	*/
	public static void cacheResult(
		com.liferay.ldx6demo.teamsitewall.model.Wallpost wallpost) {
		getPersistence().cacheResult(wallpost);
	}

	/**
	* Caches the wallposts in the entity cache if it is enabled.
	*
	* @param wallposts the wallposts
	*/
	public static void cacheResult(
		java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> wallposts) {
		getPersistence().cacheResult(wallposts);
	}

	/**
	* Creates a new wallpost with the primary key. Does not add the wallpost to the database.
	*
	* @param wallpostId the primary key for the new wallpost
	* @return the new wallpost
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost create(
		long wallpostId) {
		return getPersistence().create(wallpostId);
	}

	/**
	* Removes the wallpost with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wallpostId the primary key of the wallpost
	* @return the wallpost that was removed
	* @throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException if a wallpost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost remove(
		long wallpostId)
		throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(wallpostId);
	}

	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost updateImpl(
		com.liferay.ldx6demo.teamsitewall.model.Wallpost wallpost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(wallpost);
	}

	/**
	* Returns the wallpost with the primary key or throws a {@link com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException} if it could not be found.
	*
	* @param wallpostId the primary key of the wallpost
	* @return the wallpost
	* @throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException if a wallpost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost findByPrimaryKey(
		long wallpostId)
		throws com.liferay.ldx6demo.teamsitewall.NoSuchWallpostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(wallpostId);
	}

	/**
	* Returns the wallpost with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wallpostId the primary key of the wallpost
	* @return the wallpost, or <code>null</code> if a wallpost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ldx6demo.teamsitewall.model.Wallpost fetchByPrimaryKey(
		long wallpostId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(wallpostId);
	}

	/**
	* Returns all the wallposts.
	*
	* @return the wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the wallposts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ldx6demo.teamsitewall.model.impl.WallpostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wallposts
	* @param end the upper bound of the range of wallposts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.ldx6demo.teamsitewall.model.Wallpost> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the wallposts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of wallposts.
	*
	* @return the number of wallposts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WallpostPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WallpostPersistence)PortletBeanLocatorUtil.locate(com.liferay.ldx6demo.teamsitewall.service.ClpSerializer.getServletContextName(),
					WallpostPersistence.class.getName());

			ReferenceRegistry.registerReference(WallpostUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(WallpostPersistence persistence) {
	}

	private static WallpostPersistence _persistence;
}