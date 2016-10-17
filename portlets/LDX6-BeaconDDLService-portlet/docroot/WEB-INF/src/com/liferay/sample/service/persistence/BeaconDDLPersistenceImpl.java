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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.sample.NoSuchBeaconDDLException;
import com.liferay.sample.model.BeaconDDL;
import com.liferay.sample.model.impl.BeaconDDLImpl;
import com.liferay.sample.model.impl.BeaconDDLModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the beacon d d l service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author David Proba
 * @see BeaconDDLPersistence
 * @see BeaconDDLUtil
 * @generated
 */
public class BeaconDDLPersistenceImpl extends BasePersistenceImpl<BeaconDDL>
	implements BeaconDDLPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BeaconDDLUtil} to access the beacon d d l persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BeaconDDLImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BeaconDDLModelImpl.ENTITY_CACHE_ENABLED,
			BeaconDDLModelImpl.FINDER_CACHE_ENABLED, BeaconDDLImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BeaconDDLModelImpl.ENTITY_CACHE_ENABLED,
			BeaconDDLModelImpl.FINDER_CACHE_ENABLED, BeaconDDLImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BeaconDDLModelImpl.ENTITY_CACHE_ENABLED,
			BeaconDDLModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(BeaconDDLModelImpl.ENTITY_CACHE_ENABLED,
			BeaconDDLModelImpl.FINDER_CACHE_ENABLED, BeaconDDLImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(BeaconDDLModelImpl.ENTITY_CACHE_ENABLED,
			BeaconDDLModelImpl.FINDER_CACHE_ENABLED, BeaconDDLImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			BeaconDDLModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(BeaconDDLModelImpl.ENTITY_CACHE_ENABLED,
			BeaconDDLModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the beacon d d ls where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching beacon d d ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BeaconDDL> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<BeaconDDL> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<BeaconDDL> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<BeaconDDL> list = (List<BeaconDDL>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BeaconDDL beaconDDL : list) {
				if (!Validator.equals(uuid, beaconDDL.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BEACONDDL_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BeaconDDLModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<BeaconDDL>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BeaconDDL>(list);
				}
				else {
					list = (List<BeaconDDL>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first beacon d d l in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching beacon d d l
	 * @throws com.liferay.sample.NoSuchBeaconDDLException if a matching beacon d d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BeaconDDL findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchBeaconDDLException, SystemException {
		BeaconDDL beaconDDL = fetchByUuid_First(uuid, orderByComparator);

		if (beaconDDL != null) {
			return beaconDDL;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBeaconDDLException(msg.toString());
	}

	/**
	 * Returns the first beacon d d l in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching beacon d d l, or <code>null</code> if a matching beacon d d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BeaconDDL fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<BeaconDDL> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last beacon d d l in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching beacon d d l
	 * @throws com.liferay.sample.NoSuchBeaconDDLException if a matching beacon d d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BeaconDDL findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchBeaconDDLException, SystemException {
		BeaconDDL beaconDDL = fetchByUuid_Last(uuid, orderByComparator);

		if (beaconDDL != null) {
			return beaconDDL;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBeaconDDLException(msg.toString());
	}

	/**
	 * Returns the last beacon d d l in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching beacon d d l, or <code>null</code> if a matching beacon d d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BeaconDDL fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<BeaconDDL> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public BeaconDDL[] findByUuid_PrevAndNext(long Id, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchBeaconDDLException, SystemException {
		BeaconDDL beaconDDL = findByPrimaryKey(Id);

		Session session = null;

		try {
			session = openSession();

			BeaconDDL[] array = new BeaconDDLImpl[3];

			array[0] = getByUuid_PrevAndNext(session, beaconDDL, uuid,
					orderByComparator, true);

			array[1] = beaconDDL;

			array[2] = getByUuid_PrevAndNext(session, beaconDDL, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BeaconDDL getByUuid_PrevAndNext(Session session,
		BeaconDDL beaconDDL, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BEACONDDL_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BeaconDDLModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(beaconDDL);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BeaconDDL> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the beacon d d ls where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (BeaconDDL beaconDDL : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(beaconDDL);
		}
	}

	/**
	 * Returns the number of beacon d d ls where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching beacon d d ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BEACONDDL_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "beaconDDL.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "beaconDDL.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(beaconDDL.uuid IS NULL OR beaconDDL.uuid = '')";

	public BeaconDDLPersistenceImpl() {
		setModelClass(BeaconDDL.class);
	}

	/**
	 * Caches the beacon d d l in the entity cache if it is enabled.
	 *
	 * @param beaconDDL the beacon d d l
	 */
	@Override
	public void cacheResult(BeaconDDL beaconDDL) {
		EntityCacheUtil.putResult(BeaconDDLModelImpl.ENTITY_CACHE_ENABLED,
			BeaconDDLImpl.class, beaconDDL.getPrimaryKey(), beaconDDL);

		beaconDDL.resetOriginalValues();
	}

	/**
	 * Caches the beacon d d ls in the entity cache if it is enabled.
	 *
	 * @param beaconDDLs the beacon d d ls
	 */
	@Override
	public void cacheResult(List<BeaconDDL> beaconDDLs) {
		for (BeaconDDL beaconDDL : beaconDDLs) {
			if (EntityCacheUtil.getResult(
						BeaconDDLModelImpl.ENTITY_CACHE_ENABLED,
						BeaconDDLImpl.class, beaconDDL.getPrimaryKey()) == null) {
				cacheResult(beaconDDL);
			}
			else {
				beaconDDL.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all beacon d d ls.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BeaconDDLImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BeaconDDLImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the beacon d d l.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BeaconDDL beaconDDL) {
		EntityCacheUtil.removeResult(BeaconDDLModelImpl.ENTITY_CACHE_ENABLED,
			BeaconDDLImpl.class, beaconDDL.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BeaconDDL> beaconDDLs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BeaconDDL beaconDDL : beaconDDLs) {
			EntityCacheUtil.removeResult(BeaconDDLModelImpl.ENTITY_CACHE_ENABLED,
				BeaconDDLImpl.class, beaconDDL.getPrimaryKey());
		}
	}

	/**
	 * Creates a new beacon d d l with the primary key. Does not add the beacon d d l to the database.
	 *
	 * @param Id the primary key for the new beacon d d l
	 * @return the new beacon d d l
	 */
	@Override
	public BeaconDDL create(long Id) {
		BeaconDDL beaconDDL = new BeaconDDLImpl();

		beaconDDL.setNew(true);
		beaconDDL.setPrimaryKey(Id);

		String uuid = PortalUUIDUtil.generate();

		beaconDDL.setUuid(uuid);

		return beaconDDL;
	}

	/**
	 * Removes the beacon d d l with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the beacon d d l
	 * @return the beacon d d l that was removed
	 * @throws com.liferay.sample.NoSuchBeaconDDLException if a beacon d d l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BeaconDDL remove(long Id)
		throws NoSuchBeaconDDLException, SystemException {
		return remove((Serializable)Id);
	}

	/**
	 * Removes the beacon d d l with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the beacon d d l
	 * @return the beacon d d l that was removed
	 * @throws com.liferay.sample.NoSuchBeaconDDLException if a beacon d d l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BeaconDDL remove(Serializable primaryKey)
		throws NoSuchBeaconDDLException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BeaconDDL beaconDDL = (BeaconDDL)session.get(BeaconDDLImpl.class,
					primaryKey);

			if (beaconDDL == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBeaconDDLException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(beaconDDL);
		}
		catch (NoSuchBeaconDDLException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected BeaconDDL removeImpl(BeaconDDL beaconDDL)
		throws SystemException {
		beaconDDL = toUnwrappedModel(beaconDDL);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(beaconDDL)) {
				beaconDDL = (BeaconDDL)session.get(BeaconDDLImpl.class,
						beaconDDL.getPrimaryKeyObj());
			}

			if (beaconDDL != null) {
				session.delete(beaconDDL);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (beaconDDL != null) {
			clearCache(beaconDDL);
		}

		return beaconDDL;
	}

	@Override
	public BeaconDDL updateImpl(com.liferay.sample.model.BeaconDDL beaconDDL)
		throws SystemException {
		beaconDDL = toUnwrappedModel(beaconDDL);

		boolean isNew = beaconDDL.isNew();

		BeaconDDLModelImpl beaconDDLModelImpl = (BeaconDDLModelImpl)beaconDDL;

		if (Validator.isNull(beaconDDL.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			beaconDDL.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (beaconDDL.isNew()) {
				session.save(beaconDDL);

				beaconDDL.setNew(false);
			}
			else {
				session.merge(beaconDDL);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BeaconDDLModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((beaconDDLModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						beaconDDLModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { beaconDDLModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		EntityCacheUtil.putResult(BeaconDDLModelImpl.ENTITY_CACHE_ENABLED,
			BeaconDDLImpl.class, beaconDDL.getPrimaryKey(), beaconDDL);

		return beaconDDL;
	}

	protected BeaconDDL toUnwrappedModel(BeaconDDL beaconDDL) {
		if (beaconDDL instanceof BeaconDDLImpl) {
			return beaconDDL;
		}

		BeaconDDLImpl beaconDDLImpl = new BeaconDDLImpl();

		beaconDDLImpl.setNew(beaconDDL.isNew());
		beaconDDLImpl.setPrimaryKey(beaconDDL.getPrimaryKey());

		beaconDDLImpl.setUuid(beaconDDL.getUuid());
		beaconDDLImpl.setId(beaconDDL.getId());

		return beaconDDLImpl;
	}

	/**
	 * Returns the beacon d d l with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the beacon d d l
	 * @return the beacon d d l
	 * @throws com.liferay.sample.NoSuchBeaconDDLException if a beacon d d l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BeaconDDL findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBeaconDDLException, SystemException {
		BeaconDDL beaconDDL = fetchByPrimaryKey(primaryKey);

		if (beaconDDL == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBeaconDDLException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return beaconDDL;
	}

	/**
	 * Returns the beacon d d l with the primary key or throws a {@link com.liferay.sample.NoSuchBeaconDDLException} if it could not be found.
	 *
	 * @param Id the primary key of the beacon d d l
	 * @return the beacon d d l
	 * @throws com.liferay.sample.NoSuchBeaconDDLException if a beacon d d l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BeaconDDL findByPrimaryKey(long Id)
		throws NoSuchBeaconDDLException, SystemException {
		return findByPrimaryKey((Serializable)Id);
	}

	/**
	 * Returns the beacon d d l with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the beacon d d l
	 * @return the beacon d d l, or <code>null</code> if a beacon d d l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BeaconDDL fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BeaconDDL beaconDDL = (BeaconDDL)EntityCacheUtil.getResult(BeaconDDLModelImpl.ENTITY_CACHE_ENABLED,
				BeaconDDLImpl.class, primaryKey);

		if (beaconDDL == _nullBeaconDDL) {
			return null;
		}

		if (beaconDDL == null) {
			Session session = null;

			try {
				session = openSession();

				beaconDDL = (BeaconDDL)session.get(BeaconDDLImpl.class,
						primaryKey);

				if (beaconDDL != null) {
					cacheResult(beaconDDL);
				}
				else {
					EntityCacheUtil.putResult(BeaconDDLModelImpl.ENTITY_CACHE_ENABLED,
						BeaconDDLImpl.class, primaryKey, _nullBeaconDDL);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BeaconDDLModelImpl.ENTITY_CACHE_ENABLED,
					BeaconDDLImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return beaconDDL;
	}

	/**
	 * Returns the beacon d d l with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the beacon d d l
	 * @return the beacon d d l, or <code>null</code> if a beacon d d l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BeaconDDL fetchByPrimaryKey(long Id) throws SystemException {
		return fetchByPrimaryKey((Serializable)Id);
	}

	/**
	 * Returns all the beacon d d ls.
	 *
	 * @return the beacon d d ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BeaconDDL> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<BeaconDDL> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<BeaconDDL> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<BeaconDDL> list = (List<BeaconDDL>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BEACONDDL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BEACONDDL;

				if (pagination) {
					sql = sql.concat(BeaconDDLModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BeaconDDL>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BeaconDDL>(list);
				}
				else {
					list = (List<BeaconDDL>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the beacon d d ls from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BeaconDDL beaconDDL : findAll()) {
			remove(beaconDDL);
		}
	}

	/**
	 * Returns the number of beacon d d ls.
	 *
	 * @return the number of beacon d d ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BEACONDDL);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the beacon d d l persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.sample.model.BeaconDDL")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BeaconDDL>> listenersList = new ArrayList<ModelListener<BeaconDDL>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BeaconDDL>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(BeaconDDLImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BEACONDDL = "SELECT beaconDDL FROM BeaconDDL beaconDDL";
	private static final String _SQL_SELECT_BEACONDDL_WHERE = "SELECT beaconDDL FROM BeaconDDL beaconDDL WHERE ";
	private static final String _SQL_COUNT_BEACONDDL = "SELECT COUNT(beaconDDL) FROM BeaconDDL beaconDDL";
	private static final String _SQL_COUNT_BEACONDDL_WHERE = "SELECT COUNT(beaconDDL) FROM BeaconDDL beaconDDL WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "beaconDDL.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BeaconDDL exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BeaconDDL exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BeaconDDLPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static BeaconDDL _nullBeaconDDL = new BeaconDDLImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BeaconDDL> toCacheModel() {
				return _nullBeaconDDLCacheModel;
			}
		};

	private static CacheModel<BeaconDDL> _nullBeaconDDLCacheModel = new CacheModel<BeaconDDL>() {
			@Override
			public BeaconDDL toEntityModel() {
				return _nullBeaconDDL;
			}
		};
}