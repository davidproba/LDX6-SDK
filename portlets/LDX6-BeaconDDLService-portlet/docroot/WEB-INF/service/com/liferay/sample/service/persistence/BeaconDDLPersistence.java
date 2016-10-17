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

package com.liferay.sample.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.sample.model.BeaconDDL;

/**
 * The persistence interface for the beacon d d l service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author David Proba
 * @see BeaconDDLPersistenceImpl
 * @see BeaconDDLUtil
 * @generated
 */
public interface BeaconDDLPersistence extends BasePersistence<BeaconDDL> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BeaconDDLUtil} to access the beacon d d l persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the beacon d d ls where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching beacon d d ls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.BeaconDDL> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the beacon d d ls where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.BeaconDDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of beacon d d ls
	* @param end the upper bound of the range of beacon d d ls (not inclusive)
	* @return the range of matching beacon d d ls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.BeaconDDL> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the beacon d d ls where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.BeaconDDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of beacon d d ls
	* @param end the upper bound of the range of beacon d d ls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching beacon d d ls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.BeaconDDL> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first beacon d d l in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching beacon d d l
	* @throws com.liferay.sample.NoSuchBeaconDDLException if a matching beacon d d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.BeaconDDL findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchBeaconDDLException;

	/**
	* Returns the first beacon d d l in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching beacon d d l, or <code>null</code> if a matching beacon d d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.BeaconDDL fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last beacon d d l in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching beacon d d l
	* @throws com.liferay.sample.NoSuchBeaconDDLException if a matching beacon d d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.BeaconDDL findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchBeaconDDLException;

	/**
	* Returns the last beacon d d l in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching beacon d d l, or <code>null</code> if a matching beacon d d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.BeaconDDL fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the beacon d d ls before and after the current beacon d d l in the ordered set where uuid = &#63;.
	*
	* @param Id the primary key of the current beacon d d l
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next beacon d d l
	* @throws com.liferay.sample.NoSuchBeaconDDLException if a beacon d d l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.BeaconDDL[] findByUuid_PrevAndNext(
		long Id, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchBeaconDDLException;

	/**
	* Removes all the beacon d d ls where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of beacon d d ls where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching beacon d d ls
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the beacon d d l in the entity cache if it is enabled.
	*
	* @param beaconDDL the beacon d d l
	*/
	public void cacheResult(com.liferay.sample.model.BeaconDDL beaconDDL);

	/**
	* Caches the beacon d d ls in the entity cache if it is enabled.
	*
	* @param beaconDDLs the beacon d d ls
	*/
	public void cacheResult(
		java.util.List<com.liferay.sample.model.BeaconDDL> beaconDDLs);

	/**
	* Creates a new beacon d d l with the primary key. Does not add the beacon d d l to the database.
	*
	* @param Id the primary key for the new beacon d d l
	* @return the new beacon d d l
	*/
	public com.liferay.sample.model.BeaconDDL create(long Id);

	/**
	* Removes the beacon d d l with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Id the primary key of the beacon d d l
	* @return the beacon d d l that was removed
	* @throws com.liferay.sample.NoSuchBeaconDDLException if a beacon d d l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.BeaconDDL remove(long Id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchBeaconDDLException;

	public com.liferay.sample.model.BeaconDDL updateImpl(
		com.liferay.sample.model.BeaconDDL beaconDDL)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the beacon d d l with the primary key or throws a {@link com.liferay.sample.NoSuchBeaconDDLException} if it could not be found.
	*
	* @param Id the primary key of the beacon d d l
	* @return the beacon d d l
	* @throws com.liferay.sample.NoSuchBeaconDDLException if a beacon d d l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.BeaconDDL findByPrimaryKey(long Id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchBeaconDDLException;

	/**
	* Returns the beacon d d l with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param Id the primary key of the beacon d d l
	* @return the beacon d d l, or <code>null</code> if a beacon d d l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.BeaconDDL fetchByPrimaryKey(long Id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the beacon d d ls.
	*
	* @return the beacon d d ls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.BeaconDDL> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.sample.model.BeaconDDL> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the beacon d d ls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.BeaconDDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of beacon d d ls
	* @param end the upper bound of the range of beacon d d ls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of beacon d d ls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.BeaconDDL> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the beacon d d ls from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of beacon d d ls.
	*
	* @return the number of beacon d d ls
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}