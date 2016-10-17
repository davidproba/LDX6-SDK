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

import com.liferay.AdvancedTasks.NoSuchAdvTaskException;
import com.liferay.AdvancedTasks.model.AdvTask;
import com.liferay.AdvancedTasks.model.impl.AdvTaskImpl;
import com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the adv task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author David Proba
 * @see AdvTaskPersistence
 * @see AdvTaskUtil
 * @generated
 */
public class AdvTaskPersistenceImpl extends BasePersistenceImpl<AdvTask>
	implements AdvTaskPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AdvTaskUtil} to access the adv task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AdvTaskImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, AdvTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, AdvTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, AdvTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, AdvTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			AdvTaskModelImpl.UUID_COLUMN_BITMASK |
			AdvTaskModelImpl.ATPRIORITY_COLUMN_BITMASK |
			AdvTaskModelImpl.ATFINALDATE_COLUMN_BITMASK |
			AdvTaskModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the adv tasks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching adv tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvTask> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AdvTask> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<AdvTask> findByUuid(String uuid, int start, int end,
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

		List<AdvTask> list = (List<AdvTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdvTask advTask : list) {
				if (!Validator.equals(uuid, advTask.getUuid())) {
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

			query.append(_SQL_SELECT_ADVTASK_WHERE);

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
				query.append(AdvTaskModelImpl.ORDER_BY_JPQL);
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
					list = (List<AdvTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdvTask>(list);
				}
				else {
					list = (List<AdvTask>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first adv task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adv task
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = fetchByUuid_First(uuid, orderByComparator);

		if (advTask != null) {
			return advTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvTaskException(msg.toString());
	}

	/**
	 * Returns the first adv task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adv task, or <code>null</code> if a matching adv task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdvTask> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AdvTask findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = fetchByUuid_Last(uuid, orderByComparator);

		if (advTask != null) {
			return advTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvTaskException(msg.toString());
	}

	/**
	 * Returns the last adv task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching adv task, or <code>null</code> if a matching adv task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AdvTask> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AdvTask[] findByUuid_PrevAndNext(long atId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = findByPrimaryKey(atId);

		Session session = null;

		try {
			session = openSession();

			AdvTask[] array = new AdvTaskImpl[3];

			array[0] = getByUuid_PrevAndNext(session, advTask, uuid,
					orderByComparator, true);

			array[1] = advTask;

			array[2] = getByUuid_PrevAndNext(session, advTask, uuid,
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

	protected AdvTask getByUuid_PrevAndNext(Session session, AdvTask advTask,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADVTASK_WHERE);

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
			query.append(AdvTaskModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(advTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdvTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the adv tasks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (AdvTask advTask : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(advTask);
		}
	}

	/**
	 * Returns the number of adv tasks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching adv tasks
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

			query.append(_SQL_COUNT_ADVTASK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "advTask.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "advTask.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(advTask.uuid IS NULL OR advTask.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, AdvTaskImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			AdvTaskModelImpl.UUID_COLUMN_BITMASK |
			AdvTaskModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the adv task where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.AdvancedTasks.NoSuchAdvTaskException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching adv task
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask findByUUID_G(String uuid, long groupId)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = fetchByUUID_G(uuid, groupId);

		if (advTask == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAdvTaskException(msg.toString());
		}

		return advTask;
	}

	/**
	 * Returns the adv task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching adv task, or <code>null</code> if a matching adv task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
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
	@Override
	public AdvTask fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof AdvTask) {
			AdvTask advTask = (AdvTask)result;

			if (!Validator.equals(uuid, advTask.getUuid()) ||
					(groupId != advTask.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ADVTASK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<AdvTask> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					AdvTask advTask = list.get(0);

					result = advTask;

					cacheResult(advTask);

					if ((advTask.getUuid() == null) ||
							!advTask.getUuid().equals(uuid) ||
							(advTask.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, advTask);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (AdvTask)result;
		}
	}

	/**
	 * Removes the adv task where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the adv task that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask removeByUUID_G(String uuid, long groupId)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = findByUUID_G(uuid, groupId);

		return remove(advTask);
	}

	/**
	 * Returns the number of adv tasks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching adv tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ADVTASK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "advTask.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "advTask.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(advTask.uuid IS NULL OR advTask.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "advTask.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, AdvTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, AdvTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			AdvTaskModelImpl.UUID_COLUMN_BITMASK |
			AdvTaskModelImpl.COMPANYID_COLUMN_BITMASK |
			AdvTaskModelImpl.ATPRIORITY_COLUMN_BITMASK |
			AdvTaskModelImpl.ATFINALDATE_COLUMN_BITMASK |
			AdvTaskModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the adv tasks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching adv tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvTask> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<AdvTask> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<AdvTask> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<AdvTask> list = (List<AdvTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdvTask advTask : list) {
				if (!Validator.equals(uuid, advTask.getUuid()) ||
						(companyId != advTask.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ADVTASK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdvTaskModelImpl.ORDER_BY_JPQL);
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

				qPos.add(companyId);

				if (!pagination) {
					list = (List<AdvTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdvTask>(list);
				}
				else {
					list = (List<AdvTask>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first adv task in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adv task
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (advTask != null) {
			return advTask;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvTaskException(msg.toString());
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
	@Override
	public AdvTask fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdvTask> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AdvTask findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (advTask != null) {
			return advTask;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvTaskException(msg.toString());
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
	@Override
	public AdvTask fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AdvTask> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AdvTask[] findByUuid_C_PrevAndNext(long atId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = findByPrimaryKey(atId);

		Session session = null;

		try {
			session = openSession();

			AdvTask[] array = new AdvTaskImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, advTask, uuid,
					companyId, orderByComparator, true);

			array[1] = advTask;

			array[2] = getByUuid_C_PrevAndNext(session, advTask, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdvTask getByUuid_C_PrevAndNext(Session session, AdvTask advTask,
		String uuid, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADVTASK_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(AdvTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(advTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdvTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the adv tasks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (AdvTask advTask : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(advTask);
		}
	}

	/**
	 * Returns the number of adv tasks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching adv tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ADVTASK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "advTask.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "advTask.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(advTask.uuid IS NULL OR advTask.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "advTask.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, AdvTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, AdvTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			AdvTaskModelImpl.GROUPID_COLUMN_BITMASK |
			AdvTaskModelImpl.ATPRIORITY_COLUMN_BITMASK |
			AdvTaskModelImpl.ATFINALDATE_COLUMN_BITMASK |
			AdvTaskModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the adv tasks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching adv tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvTask> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AdvTask> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<AdvTask> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<AdvTask> list = (List<AdvTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdvTask advTask : list) {
				if ((groupId != advTask.getGroupId())) {
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

			query.append(_SQL_SELECT_ADVTASK_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdvTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<AdvTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdvTask>(list);
				}
				else {
					list = (List<AdvTask>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first adv task in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adv task
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = fetchByGroupId_First(groupId, orderByComparator);

		if (advTask != null) {
			return advTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvTaskException(msg.toString());
	}

	/**
	 * Returns the first adv task in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adv task, or <code>null</code> if a matching adv task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdvTask> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AdvTask findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = fetchByGroupId_Last(groupId, orderByComparator);

		if (advTask != null) {
			return advTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvTaskException(msg.toString());
	}

	/**
	 * Returns the last adv task in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching adv task, or <code>null</code> if a matching adv task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<AdvTask> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AdvTask[] findByGroupId_PrevAndNext(long atId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = findByPrimaryKey(atId);

		Session session = null;

		try {
			session = openSession();

			AdvTask[] array = new AdvTaskImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, advTask, groupId,
					orderByComparator, true);

			array[1] = advTask;

			array[2] = getByGroupId_PrevAndNext(session, advTask, groupId,
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

	protected AdvTask getByGroupId_PrevAndNext(Session session,
		AdvTask advTask, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADVTASK_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(AdvTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(advTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdvTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the adv tasks that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching adv tasks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvTask> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<AdvTask> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
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
	@Override
	public List<AdvTask> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ADVTASK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ADVTASK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ADVTASK_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(AdvTaskModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(AdvTaskModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				AdvTask.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, AdvTaskImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, AdvTaskImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<AdvTask>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public AdvTask[] filterFindByGroupId_PrevAndNext(long atId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(atId, groupId, orderByComparator);
		}

		AdvTask advTask = findByPrimaryKey(atId);

		Session session = null;

		try {
			session = openSession();

			AdvTask[] array = new AdvTaskImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, advTask,
					groupId, orderByComparator, true);

			array[1] = advTask;

			array[2] = filterGetByGroupId_PrevAndNext(session, advTask,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdvTask filterGetByGroupId_PrevAndNext(Session session,
		AdvTask advTask, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ADVTASK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ADVTASK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ADVTASK_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(AdvTaskModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(AdvTaskModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				AdvTask.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, AdvTaskImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, AdvTaskImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(advTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdvTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the adv tasks where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (AdvTask advTask : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(advTask);
		}
	}

	/**
	 * Returns the number of adv tasks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching adv tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADVTASK_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	/**
	 * Returns the number of adv tasks that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching adv tasks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_ADVTASK_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				AdvTask.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "advTask.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, AdvTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, AdvTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Integer.class.getName() },
			AdvTaskModelImpl.STATUS_COLUMN_BITMASK |
			AdvTaskModelImpl.ATPRIORITY_COLUMN_BITMASK |
			AdvTaskModelImpl.ATFINALDATE_COLUMN_BITMASK |
			AdvTaskModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the adv tasks where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching adv tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvTask> findByStatus(int status) throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AdvTask> findByStatus(int status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
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
	@Override
	public List<AdvTask> findByStatus(int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<AdvTask> list = (List<AdvTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdvTask advTask : list) {
				if ((status != advTask.getStatus())) {
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

			query.append(_SQL_SELECT_ADVTASK_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdvTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<AdvTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdvTask>(list);
				}
				else {
					list = (List<AdvTask>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first adv task in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adv task
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask findByStatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = fetchByStatus_First(status, orderByComparator);

		if (advTask != null) {
			return advTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvTaskException(msg.toString());
	}

	/**
	 * Returns the first adv task in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adv task, or <code>null</code> if a matching adv task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask fetchByStatus_First(int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdvTask> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AdvTask findByStatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = fetchByStatus_Last(status, orderByComparator);

		if (advTask != null) {
			return advTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvTaskException(msg.toString());
	}

	/**
	 * Returns the last adv task in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching adv task, or <code>null</code> if a matching adv task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask fetchByStatus_Last(int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<AdvTask> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AdvTask[] findByStatus_PrevAndNext(long atId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = findByPrimaryKey(atId);

		Session session = null;

		try {
			session = openSession();

			AdvTask[] array = new AdvTaskImpl[3];

			array[0] = getByStatus_PrevAndNext(session, advTask, status,
					orderByComparator, true);

			array[1] = advTask;

			array[2] = getByStatus_PrevAndNext(session, advTask, status,
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

	protected AdvTask getByStatus_PrevAndNext(Session session, AdvTask advTask,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADVTASK_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(AdvTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(advTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdvTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the adv tasks where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(int status) throws SystemException {
		for (AdvTask advTask : findByStatus(status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(advTask);
		}
	}

	/**
	 * Returns the number of adv tasks where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching adv tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADVTASK_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "advTask.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTTASKID =
		new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, AdvTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentTaskId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTASKID =
		new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, AdvTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentTaskId",
			new String[] { Long.class.getName() },
			AdvTaskModelImpl.ATPARENTTASKID_COLUMN_BITMASK |
			AdvTaskModelImpl.ATPRIORITY_COLUMN_BITMASK |
			AdvTaskModelImpl.ATFINALDATE_COLUMN_BITMASK |
			AdvTaskModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTTASKID = new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentTaskId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the adv tasks where atParentTaskId = &#63;.
	 *
	 * @param atParentTaskId the at parent task ID
	 * @return the matching adv tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvTask> findByParentTaskId(long atParentTaskId)
		throws SystemException {
		return findByParentTaskId(atParentTaskId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<AdvTask> findByParentTaskId(long atParentTaskId, int start,
		int end) throws SystemException {
		return findByParentTaskId(atParentTaskId, start, end, null);
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
	@Override
	public List<AdvTask> findByParentTaskId(long atParentTaskId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTASKID;
			finderArgs = new Object[] { atParentTaskId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTTASKID;
			finderArgs = new Object[] {
					atParentTaskId,
					
					start, end, orderByComparator
				};
		}

		List<AdvTask> list = (List<AdvTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdvTask advTask : list) {
				if ((atParentTaskId != advTask.getAtParentTaskId())) {
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

			query.append(_SQL_SELECT_ADVTASK_WHERE);

			query.append(_FINDER_COLUMN_PARENTTASKID_ATPARENTTASKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdvTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(atParentTaskId);

				if (!pagination) {
					list = (List<AdvTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdvTask>(list);
				}
				else {
					list = (List<AdvTask>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first adv task in the ordered set where atParentTaskId = &#63;.
	 *
	 * @param atParentTaskId the at parent task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adv task
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask findByParentTaskId_First(long atParentTaskId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = fetchByParentTaskId_First(atParentTaskId,
				orderByComparator);

		if (advTask != null) {
			return advTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("atParentTaskId=");
		msg.append(atParentTaskId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvTaskException(msg.toString());
	}

	/**
	 * Returns the first adv task in the ordered set where atParentTaskId = &#63;.
	 *
	 * @param atParentTaskId the at parent task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adv task, or <code>null</code> if a matching adv task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask fetchByParentTaskId_First(long atParentTaskId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdvTask> list = findByParentTaskId(atParentTaskId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AdvTask findByParentTaskId_Last(long atParentTaskId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = fetchByParentTaskId_Last(atParentTaskId,
				orderByComparator);

		if (advTask != null) {
			return advTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("atParentTaskId=");
		msg.append(atParentTaskId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvTaskException(msg.toString());
	}

	/**
	 * Returns the last adv task in the ordered set where atParentTaskId = &#63;.
	 *
	 * @param atParentTaskId the at parent task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching adv task, or <code>null</code> if a matching adv task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask fetchByParentTaskId_Last(long atParentTaskId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByParentTaskId(atParentTaskId);

		if (count == 0) {
			return null;
		}

		List<AdvTask> list = findByParentTaskId(atParentTaskId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AdvTask[] findByParentTaskId_PrevAndNext(long atId,
		long atParentTaskId, OrderByComparator orderByComparator)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = findByPrimaryKey(atId);

		Session session = null;

		try {
			session = openSession();

			AdvTask[] array = new AdvTaskImpl[3];

			array[0] = getByParentTaskId_PrevAndNext(session, advTask,
					atParentTaskId, orderByComparator, true);

			array[1] = advTask;

			array[2] = getByParentTaskId_PrevAndNext(session, advTask,
					atParentTaskId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdvTask getByParentTaskId_PrevAndNext(Session session,
		AdvTask advTask, long atParentTaskId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADVTASK_WHERE);

		query.append(_FINDER_COLUMN_PARENTTASKID_ATPARENTTASKID_2);

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
			query.append(AdvTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(atParentTaskId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(advTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdvTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the adv tasks where atParentTaskId = &#63; from the database.
	 *
	 * @param atParentTaskId the at parent task ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParentTaskId(long atParentTaskId)
		throws SystemException {
		for (AdvTask advTask : findByParentTaskId(atParentTaskId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(advTask);
		}
	}

	/**
	 * Returns the number of adv tasks where atParentTaskId = &#63;.
	 *
	 * @param atParentTaskId the at parent task ID
	 * @return the number of matching adv tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParentTaskId(long atParentTaskId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTTASKID;

		Object[] finderArgs = new Object[] { atParentTaskId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADVTASK_WHERE);

			query.append(_FINDER_COLUMN_PARENTTASKID_ATPARENTTASKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(atParentTaskId);

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

	private static final String _FINDER_COLUMN_PARENTTASKID_ATPARENTTASKID_2 = "advTask.atParentTaskId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ASSIGNEDTOUSERID =
		new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, AdvTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAssignedToUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNEDTOUSERID =
		new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, AdvTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAssignedToUserId", new String[] { Long.class.getName() },
			AdvTaskModelImpl.ATASSIGNEDTOUSERID_COLUMN_BITMASK |
			AdvTaskModelImpl.ATPRIORITY_COLUMN_BITMASK |
			AdvTaskModelImpl.ATFINALDATE_COLUMN_BITMASK |
			AdvTaskModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ASSIGNEDTOUSERID = new FinderPath(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAssignedToUserId", new String[] { Long.class.getName() });

	/**
	 * Returns all the adv tasks where atAssignedToUserId = &#63;.
	 *
	 * @param atAssignedToUserId the at assigned to user ID
	 * @return the matching adv tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvTask> findByAssignedToUserId(long atAssignedToUserId)
		throws SystemException {
		return findByAssignedToUserId(atAssignedToUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<AdvTask> findByAssignedToUserId(long atAssignedToUserId,
		int start, int end) throws SystemException {
		return findByAssignedToUserId(atAssignedToUserId, start, end, null);
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
	@Override
	public List<AdvTask> findByAssignedToUserId(long atAssignedToUserId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNEDTOUSERID;
			finderArgs = new Object[] { atAssignedToUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ASSIGNEDTOUSERID;
			finderArgs = new Object[] {
					atAssignedToUserId,
					
					start, end, orderByComparator
				};
		}

		List<AdvTask> list = (List<AdvTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdvTask advTask : list) {
				if ((atAssignedToUserId != advTask.getAtAssignedToUserId())) {
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

			query.append(_SQL_SELECT_ADVTASK_WHERE);

			query.append(_FINDER_COLUMN_ASSIGNEDTOUSERID_ATASSIGNEDTOUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdvTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(atAssignedToUserId);

				if (!pagination) {
					list = (List<AdvTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdvTask>(list);
				}
				else {
					list = (List<AdvTask>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first adv task in the ordered set where atAssignedToUserId = &#63;.
	 *
	 * @param atAssignedToUserId the at assigned to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adv task
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a matching adv task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask findByAssignedToUserId_First(long atAssignedToUserId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = fetchByAssignedToUserId_First(atAssignedToUserId,
				orderByComparator);

		if (advTask != null) {
			return advTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("atAssignedToUserId=");
		msg.append(atAssignedToUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvTaskException(msg.toString());
	}

	/**
	 * Returns the first adv task in the ordered set where atAssignedToUserId = &#63;.
	 *
	 * @param atAssignedToUserId the at assigned to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adv task, or <code>null</code> if a matching adv task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask fetchByAssignedToUserId_First(long atAssignedToUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdvTask> list = findByAssignedToUserId(atAssignedToUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AdvTask findByAssignedToUserId_Last(long atAssignedToUserId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = fetchByAssignedToUserId_Last(atAssignedToUserId,
				orderByComparator);

		if (advTask != null) {
			return advTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("atAssignedToUserId=");
		msg.append(atAssignedToUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvTaskException(msg.toString());
	}

	/**
	 * Returns the last adv task in the ordered set where atAssignedToUserId = &#63;.
	 *
	 * @param atAssignedToUserId the at assigned to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching adv task, or <code>null</code> if a matching adv task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask fetchByAssignedToUserId_Last(long atAssignedToUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAssignedToUserId(atAssignedToUserId);

		if (count == 0) {
			return null;
		}

		List<AdvTask> list = findByAssignedToUserId(atAssignedToUserId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AdvTask[] findByAssignedToUserId_PrevAndNext(long atId,
		long atAssignedToUserId, OrderByComparator orderByComparator)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = findByPrimaryKey(atId);

		Session session = null;

		try {
			session = openSession();

			AdvTask[] array = new AdvTaskImpl[3];

			array[0] = getByAssignedToUserId_PrevAndNext(session, advTask,
					atAssignedToUserId, orderByComparator, true);

			array[1] = advTask;

			array[2] = getByAssignedToUserId_PrevAndNext(session, advTask,
					atAssignedToUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdvTask getByAssignedToUserId_PrevAndNext(Session session,
		AdvTask advTask, long atAssignedToUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADVTASK_WHERE);

		query.append(_FINDER_COLUMN_ASSIGNEDTOUSERID_ATASSIGNEDTOUSERID_2);

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
			query.append(AdvTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(atAssignedToUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(advTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdvTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the adv tasks where atAssignedToUserId = &#63; from the database.
	 *
	 * @param atAssignedToUserId the at assigned to user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAssignedToUserId(long atAssignedToUserId)
		throws SystemException {
		for (AdvTask advTask : findByAssignedToUserId(atAssignedToUserId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(advTask);
		}
	}

	/**
	 * Returns the number of adv tasks where atAssignedToUserId = &#63;.
	 *
	 * @param atAssignedToUserId the at assigned to user ID
	 * @return the number of matching adv tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAssignedToUserId(long atAssignedToUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ASSIGNEDTOUSERID;

		Object[] finderArgs = new Object[] { atAssignedToUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADVTASK_WHERE);

			query.append(_FINDER_COLUMN_ASSIGNEDTOUSERID_ATASSIGNEDTOUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(atAssignedToUserId);

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

	private static final String _FINDER_COLUMN_ASSIGNEDTOUSERID_ATASSIGNEDTOUSERID_2 =
		"advTask.atAssignedToUserId = ?";

	public AdvTaskPersistenceImpl() {
		setModelClass(AdvTask.class);
	}

	/**
	 * Caches the adv task in the entity cache if it is enabled.
	 *
	 * @param advTask the adv task
	 */
	@Override
	public void cacheResult(AdvTask advTask) {
		EntityCacheUtil.putResult(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskImpl.class, advTask.getPrimaryKey(), advTask);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { advTask.getUuid(), advTask.getGroupId() }, advTask);

		advTask.resetOriginalValues();
	}

	/**
	 * Caches the adv tasks in the entity cache if it is enabled.
	 *
	 * @param advTasks the adv tasks
	 */
	@Override
	public void cacheResult(List<AdvTask> advTasks) {
		for (AdvTask advTask : advTasks) {
			if (EntityCacheUtil.getResult(
						AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
						AdvTaskImpl.class, advTask.getPrimaryKey()) == null) {
				cacheResult(advTask);
			}
			else {
				advTask.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all adv tasks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AdvTaskImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AdvTaskImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the adv task.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AdvTask advTask) {
		EntityCacheUtil.removeResult(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskImpl.class, advTask.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(advTask);
	}

	@Override
	public void clearCache(List<AdvTask> advTasks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AdvTask advTask : advTasks) {
			EntityCacheUtil.removeResult(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
				AdvTaskImpl.class, advTask.getPrimaryKey());

			clearUniqueFindersCache(advTask);
		}
	}

	protected void cacheUniqueFindersCache(AdvTask advTask) {
		if (advTask.isNew()) {
			Object[] args = new Object[] { advTask.getUuid(), advTask.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, advTask);
		}
		else {
			AdvTaskModelImpl advTaskModelImpl = (AdvTaskModelImpl)advTask;

			if ((advTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						advTask.getUuid(), advTask.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					advTask);
			}
		}
	}

	protected void clearUniqueFindersCache(AdvTask advTask) {
		AdvTaskModelImpl advTaskModelImpl = (AdvTaskModelImpl)advTask;

		Object[] args = new Object[] { advTask.getUuid(), advTask.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((advTaskModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					advTaskModelImpl.getOriginalUuid(),
					advTaskModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new adv task with the primary key. Does not add the adv task to the database.
	 *
	 * @param atId the primary key for the new adv task
	 * @return the new adv task
	 */
	@Override
	public AdvTask create(long atId) {
		AdvTask advTask = new AdvTaskImpl();

		advTask.setNew(true);
		advTask.setPrimaryKey(atId);

		String uuid = PortalUUIDUtil.generate();

		advTask.setUuid(uuid);

		return advTask;
	}

	/**
	 * Removes the adv task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param atId the primary key of the adv task
	 * @return the adv task that was removed
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a adv task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask remove(long atId)
		throws NoSuchAdvTaskException, SystemException {
		return remove((Serializable)atId);
	}

	/**
	 * Removes the adv task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the adv task
	 * @return the adv task that was removed
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a adv task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask remove(Serializable primaryKey)
		throws NoSuchAdvTaskException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AdvTask advTask = (AdvTask)session.get(AdvTaskImpl.class, primaryKey);

			if (advTask == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdvTaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(advTask);
		}
		catch (NoSuchAdvTaskException nsee) {
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
	protected AdvTask removeImpl(AdvTask advTask) throws SystemException {
		advTask = toUnwrappedModel(advTask);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(advTask)) {
				advTask = (AdvTask)session.get(AdvTaskImpl.class,
						advTask.getPrimaryKeyObj());
			}

			if (advTask != null) {
				session.delete(advTask);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (advTask != null) {
			clearCache(advTask);
		}

		return advTask;
	}

	@Override
	public AdvTask updateImpl(com.liferay.AdvancedTasks.model.AdvTask advTask)
		throws SystemException {
		advTask = toUnwrappedModel(advTask);

		boolean isNew = advTask.isNew();

		AdvTaskModelImpl advTaskModelImpl = (AdvTaskModelImpl)advTask;

		if (Validator.isNull(advTask.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			advTask.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (advTask.isNew()) {
				session.save(advTask);

				advTask.setNew(false);
			}
			else {
				session.merge(advTask);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AdvTaskModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((advTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { advTaskModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { advTaskModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((advTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						advTaskModelImpl.getOriginalUuid(),
						advTaskModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						advTaskModelImpl.getUuid(),
						advTaskModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((advTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						advTaskModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { advTaskModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((advTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						advTaskModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { advTaskModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((advTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTASKID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						advTaskModelImpl.getOriginalAtParentTaskId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTTASKID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTASKID,
					args);

				args = new Object[] { advTaskModelImpl.getAtParentTaskId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTTASKID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTASKID,
					args);
			}

			if ((advTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNEDTOUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						advTaskModelImpl.getOriginalAtAssignedToUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ASSIGNEDTOUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNEDTOUSERID,
					args);

				args = new Object[] { advTaskModelImpl.getAtAssignedToUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ASSIGNEDTOUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNEDTOUSERID,
					args);
			}
		}

		EntityCacheUtil.putResult(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskImpl.class, advTask.getPrimaryKey(), advTask);

		clearUniqueFindersCache(advTask);
		cacheUniqueFindersCache(advTask);

		return advTask;
	}

	protected AdvTask toUnwrappedModel(AdvTask advTask) {
		if (advTask instanceof AdvTaskImpl) {
			return advTask;
		}

		AdvTaskImpl advTaskImpl = new AdvTaskImpl();

		advTaskImpl.setNew(advTask.isNew());
		advTaskImpl.setPrimaryKey(advTask.getPrimaryKey());

		advTaskImpl.setUuid(advTask.getUuid());
		advTaskImpl.setAtId(advTask.getAtId());
		advTaskImpl.setGroupId(advTask.getGroupId());
		advTaskImpl.setCompanyId(advTask.getCompanyId());
		advTaskImpl.setUserId(advTask.getUserId());
		advTaskImpl.setUserName(advTask.getUserName());
		advTaskImpl.setCreateDate(advTask.getCreateDate());
		advTaskImpl.setModifiedDate(advTask.getModifiedDate());
		advTaskImpl.setAtTitle(advTask.getAtTitle());
		advTaskImpl.setAtDescription(advTask.getAtDescription());
		advTaskImpl.setAtStartDate(advTask.getAtStartDate());
		advTaskImpl.setAtFinalDate(advTask.getAtFinalDate());
		advTaskImpl.setAtPriority(advTask.getAtPriority());
		advTaskImpl.setAtStatus(advTask.getAtStatus());
		advTaskImpl.setAtModifierUserId(advTask.getAtModifierUserId());
		advTaskImpl.setAtAssignedToUserId(advTask.getAtAssignedToUserId());
		advTaskImpl.setAtResolverUserId(advTask.getAtResolverUserId());
		advTaskImpl.setAtParentTaskId(advTask.getAtParentTaskId());
		advTaskImpl.setStatus(advTask.getStatus());
		advTaskImpl.setStatusByUserId(advTask.getStatusByUserId());
		advTaskImpl.setStatusByUserName(advTask.getStatusByUserName());
		advTaskImpl.setStatusDate(advTask.getStatusDate());

		return advTaskImpl;
	}

	/**
	 * Returns the adv task with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the adv task
	 * @return the adv task
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a adv task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAdvTaskException, SystemException {
		AdvTask advTask = fetchByPrimaryKey(primaryKey);

		if (advTask == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAdvTaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return advTask;
	}

	/**
	 * Returns the adv task with the primary key or throws a {@link com.liferay.AdvancedTasks.NoSuchAdvTaskException} if it could not be found.
	 *
	 * @param atId the primary key of the adv task
	 * @return the adv task
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskException if a adv task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask findByPrimaryKey(long atId)
		throws NoSuchAdvTaskException, SystemException {
		return findByPrimaryKey((Serializable)atId);
	}

	/**
	 * Returns the adv task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the adv task
	 * @return the adv task, or <code>null</code> if a adv task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AdvTask advTask = (AdvTask)EntityCacheUtil.getResult(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
				AdvTaskImpl.class, primaryKey);

		if (advTask == _nullAdvTask) {
			return null;
		}

		if (advTask == null) {
			Session session = null;

			try {
				session = openSession();

				advTask = (AdvTask)session.get(AdvTaskImpl.class, primaryKey);

				if (advTask != null) {
					cacheResult(advTask);
				}
				else {
					EntityCacheUtil.putResult(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
						AdvTaskImpl.class, primaryKey, _nullAdvTask);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AdvTaskModelImpl.ENTITY_CACHE_ENABLED,
					AdvTaskImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return advTask;
	}

	/**
	 * Returns the adv task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param atId the primary key of the adv task
	 * @return the adv task, or <code>null</code> if a adv task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTask fetchByPrimaryKey(long atId) throws SystemException {
		return fetchByPrimaryKey((Serializable)atId);
	}

	/**
	 * Returns all the adv tasks.
	 *
	 * @return the adv tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvTask> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<AdvTask> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<AdvTask> findAll(int start, int end,
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

		List<AdvTask> list = (List<AdvTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADVTASK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADVTASK;

				if (pagination) {
					sql = sql.concat(AdvTaskModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AdvTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdvTask>(list);
				}
				else {
					list = (List<AdvTask>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the adv tasks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AdvTask advTask : findAll()) {
			remove(advTask);
		}
	}

	/**
	 * Returns the number of adv tasks.
	 *
	 * @return the number of adv tasks
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

				Query q = session.createQuery(_SQL_COUNT_ADVTASK);

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
	 * Initializes the adv task persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.AdvancedTasks.model.AdvTask")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AdvTask>> listenersList = new ArrayList<ModelListener<AdvTask>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AdvTask>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AdvTaskImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ADVTASK = "SELECT advTask FROM AdvTask advTask";
	private static final String _SQL_SELECT_ADVTASK_WHERE = "SELECT advTask FROM AdvTask advTask WHERE ";
	private static final String _SQL_COUNT_ADVTASK = "SELECT COUNT(advTask) FROM AdvTask advTask";
	private static final String _SQL_COUNT_ADVTASK_WHERE = "SELECT COUNT(advTask) FROM AdvTask advTask WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "advTask.atId";
	private static final String _FILTER_SQL_SELECT_ADVTASK_WHERE = "SELECT DISTINCT {advTask.*} FROM AdvancedTasks_AdvTask advTask WHERE ";
	private static final String _FILTER_SQL_SELECT_ADVTASK_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {AdvancedTasks_AdvTask.*} FROM (SELECT DISTINCT advTask.atId FROM AdvancedTasks_AdvTask advTask WHERE ";
	private static final String _FILTER_SQL_SELECT_ADVTASK_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN AdvancedTasks_AdvTask ON TEMP_TABLE.atId = AdvancedTasks_AdvTask.atId";
	private static final String _FILTER_SQL_COUNT_ADVTASK_WHERE = "SELECT COUNT(DISTINCT advTask.atId) AS COUNT_VALUE FROM AdvancedTasks_AdvTask advTask WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "advTask";
	private static final String _FILTER_ENTITY_TABLE = "AdvancedTasks_AdvTask";
	private static final String _ORDER_BY_ENTITY_ALIAS = "advTask.";
	private static final String _ORDER_BY_ENTITY_TABLE = "AdvancedTasks_AdvTask.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AdvTask exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AdvTask exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AdvTaskPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static AdvTask _nullAdvTask = new AdvTaskImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AdvTask> toCacheModel() {
				return _nullAdvTaskCacheModel;
			}
		};

	private static CacheModel<AdvTask> _nullAdvTaskCacheModel = new CacheModel<AdvTask>() {
			@Override
			public AdvTask toEntityModel() {
				return _nullAdvTask;
			}
		};
}