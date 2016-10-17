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

import com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException;
import com.liferay.AdvancedTasks.model.AdvTaskMapping;
import com.liferay.AdvancedTasks.model.impl.AdvTaskMappingImpl;
import com.liferay.AdvancedTasks.model.impl.AdvTaskMappingModelImpl;

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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the adv task mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author David Proba
 * @see AdvTaskMappingPersistence
 * @see AdvTaskMappingUtil
 * @generated
 */
public class AdvTaskMappingPersistenceImpl extends BasePersistenceImpl<AdvTaskMapping>
	implements AdvTaskMappingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AdvTaskMappingUtil} to access the adv task mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AdvTaskMappingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AdvTaskMappingModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskMappingModelImpl.FINDER_CACHE_ENABLED,
			AdvTaskMappingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AdvTaskMappingModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskMappingModelImpl.FINDER_CACHE_ENABLED,
			AdvTaskMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AdvTaskMappingModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MTASKID = new FinderPath(AdvTaskMappingModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskMappingModelImpl.FINDER_CACHE_ENABLED,
			AdvTaskMappingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMTaskId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MTASKID =
		new FinderPath(AdvTaskMappingModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskMappingModelImpl.FINDER_CACHE_ENABLED,
			AdvTaskMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMTaskId",
			new String[] { Long.class.getName() },
			AdvTaskMappingModelImpl.ATMTASKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MTASKID = new FinderPath(AdvTaskMappingModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMTaskId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the adv task mappings where atMTaskId = &#63;.
	 *
	 * @param atMTaskId the at m task ID
	 * @return the matching adv task mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvTaskMapping> findByMTaskId(long atMTaskId)
		throws SystemException {
		return findByMTaskId(atMTaskId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the adv task mappings where atMTaskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param atMTaskId the at m task ID
	 * @param start the lower bound of the range of adv task mappings
	 * @param end the upper bound of the range of adv task mappings (not inclusive)
	 * @return the range of matching adv task mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvTaskMapping> findByMTaskId(long atMTaskId, int start, int end)
		throws SystemException {
		return findByMTaskId(atMTaskId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the adv task mappings where atMTaskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param atMTaskId the at m task ID
	 * @param start the lower bound of the range of adv task mappings
	 * @param end the upper bound of the range of adv task mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching adv task mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvTaskMapping> findByMTaskId(long atMTaskId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MTASKID;
			finderArgs = new Object[] { atMTaskId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MTASKID;
			finderArgs = new Object[] { atMTaskId, start, end, orderByComparator };
		}

		List<AdvTaskMapping> list = (List<AdvTaskMapping>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdvTaskMapping advTaskMapping : list) {
				if ((atMTaskId != advTaskMapping.getAtMTaskId())) {
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

			query.append(_SQL_SELECT_ADVTASKMAPPING_WHERE);

			query.append(_FINDER_COLUMN_MTASKID_ATMTASKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdvTaskMappingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(atMTaskId);

				if (!pagination) {
					list = (List<AdvTaskMapping>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdvTaskMapping>(list);
				}
				else {
					list = (List<AdvTaskMapping>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first adv task mapping in the ordered set where atMTaskId = &#63;.
	 *
	 * @param atMTaskId the at m task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adv task mapping
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a matching adv task mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTaskMapping findByMTaskId_First(long atMTaskId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskMappingException, SystemException {
		AdvTaskMapping advTaskMapping = fetchByMTaskId_First(atMTaskId,
				orderByComparator);

		if (advTaskMapping != null) {
			return advTaskMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("atMTaskId=");
		msg.append(atMTaskId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvTaskMappingException(msg.toString());
	}

	/**
	 * Returns the first adv task mapping in the ordered set where atMTaskId = &#63;.
	 *
	 * @param atMTaskId the at m task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adv task mapping, or <code>null</code> if a matching adv task mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTaskMapping fetchByMTaskId_First(long atMTaskId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdvTaskMapping> list = findByMTaskId(atMTaskId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last adv task mapping in the ordered set where atMTaskId = &#63;.
	 *
	 * @param atMTaskId the at m task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching adv task mapping
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a matching adv task mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTaskMapping findByMTaskId_Last(long atMTaskId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskMappingException, SystemException {
		AdvTaskMapping advTaskMapping = fetchByMTaskId_Last(atMTaskId,
				orderByComparator);

		if (advTaskMapping != null) {
			return advTaskMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("atMTaskId=");
		msg.append(atMTaskId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvTaskMappingException(msg.toString());
	}

	/**
	 * Returns the last adv task mapping in the ordered set where atMTaskId = &#63;.
	 *
	 * @param atMTaskId the at m task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching adv task mapping, or <code>null</code> if a matching adv task mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTaskMapping fetchByMTaskId_Last(long atMTaskId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMTaskId(atMTaskId);

		if (count == 0) {
			return null;
		}

		List<AdvTaskMapping> list = findByMTaskId(atMTaskId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the adv task mappings before and after the current adv task mapping in the ordered set where atMTaskId = &#63;.
	 *
	 * @param atMId the primary key of the current adv task mapping
	 * @param atMTaskId the at m task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next adv task mapping
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a adv task mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTaskMapping[] findByMTaskId_PrevAndNext(long atMId,
		long atMTaskId, OrderByComparator orderByComparator)
		throws NoSuchAdvTaskMappingException, SystemException {
		AdvTaskMapping advTaskMapping = findByPrimaryKey(atMId);

		Session session = null;

		try {
			session = openSession();

			AdvTaskMapping[] array = new AdvTaskMappingImpl[3];

			array[0] = getByMTaskId_PrevAndNext(session, advTaskMapping,
					atMTaskId, orderByComparator, true);

			array[1] = advTaskMapping;

			array[2] = getByMTaskId_PrevAndNext(session, advTaskMapping,
					atMTaskId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdvTaskMapping getByMTaskId_PrevAndNext(Session session,
		AdvTaskMapping advTaskMapping, long atMTaskId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADVTASKMAPPING_WHERE);

		query.append(_FINDER_COLUMN_MTASKID_ATMTASKID_2);

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
			query.append(AdvTaskMappingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(atMTaskId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(advTaskMapping);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdvTaskMapping> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the adv task mappings where atMTaskId = &#63; from the database.
	 *
	 * @param atMTaskId the at m task ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMTaskId(long atMTaskId) throws SystemException {
		for (AdvTaskMapping advTaskMapping : findByMTaskId(atMTaskId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(advTaskMapping);
		}
	}

	/**
	 * Returns the number of adv task mappings where atMTaskId = &#63;.
	 *
	 * @param atMTaskId the at m task ID
	 * @return the number of matching adv task mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMTaskId(long atMTaskId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MTASKID;

		Object[] finderArgs = new Object[] { atMTaskId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADVTASKMAPPING_WHERE);

			query.append(_FINDER_COLUMN_MTASKID_ATMTASKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(atMTaskId);

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

	private static final String _FINDER_COLUMN_MTASKID_ATMTASKID_2 = "advTaskMapping.atMTaskId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPENDENTFROMID =
		new FinderPath(AdvTaskMappingModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskMappingModelImpl.FINDER_CACHE_ENABLED,
			AdvTaskMappingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDependentFromId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPENDENTFROMID =
		new FinderPath(AdvTaskMappingModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskMappingModelImpl.FINDER_CACHE_ENABLED,
			AdvTaskMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDependentFromId",
			new String[] { Long.class.getName() },
			AdvTaskMappingModelImpl.ATMDEPENDENTFROMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPENDENTFROMID = new FinderPath(AdvTaskMappingModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDependentFromId", new String[] { Long.class.getName() });

	/**
	 * Returns all the adv task mappings where atMDependentFromId = &#63;.
	 *
	 * @param atMDependentFromId the at m dependent from ID
	 * @return the matching adv task mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvTaskMapping> findByDependentFromId(long atMDependentFromId)
		throws SystemException {
		return findByDependentFromId(atMDependentFromId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the adv task mappings where atMDependentFromId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param atMDependentFromId the at m dependent from ID
	 * @param start the lower bound of the range of adv task mappings
	 * @param end the upper bound of the range of adv task mappings (not inclusive)
	 * @return the range of matching adv task mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvTaskMapping> findByDependentFromId(long atMDependentFromId,
		int start, int end) throws SystemException {
		return findByDependentFromId(atMDependentFromId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the adv task mappings where atMDependentFromId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param atMDependentFromId the at m dependent from ID
	 * @param start the lower bound of the range of adv task mappings
	 * @param end the upper bound of the range of adv task mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching adv task mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvTaskMapping> findByDependentFromId(long atMDependentFromId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPENDENTFROMID;
			finderArgs = new Object[] { atMDependentFromId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPENDENTFROMID;
			finderArgs = new Object[] {
					atMDependentFromId,
					
					start, end, orderByComparator
				};
		}

		List<AdvTaskMapping> list = (List<AdvTaskMapping>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdvTaskMapping advTaskMapping : list) {
				if ((atMDependentFromId != advTaskMapping.getAtMDependentFromId())) {
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

			query.append(_SQL_SELECT_ADVTASKMAPPING_WHERE);

			query.append(_FINDER_COLUMN_DEPENDENTFROMID_ATMDEPENDENTFROMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdvTaskMappingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(atMDependentFromId);

				if (!pagination) {
					list = (List<AdvTaskMapping>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdvTaskMapping>(list);
				}
				else {
					list = (List<AdvTaskMapping>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first adv task mapping in the ordered set where atMDependentFromId = &#63;.
	 *
	 * @param atMDependentFromId the at m dependent from ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adv task mapping
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a matching adv task mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTaskMapping findByDependentFromId_First(long atMDependentFromId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskMappingException, SystemException {
		AdvTaskMapping advTaskMapping = fetchByDependentFromId_First(atMDependentFromId,
				orderByComparator);

		if (advTaskMapping != null) {
			return advTaskMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("atMDependentFromId=");
		msg.append(atMDependentFromId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvTaskMappingException(msg.toString());
	}

	/**
	 * Returns the first adv task mapping in the ordered set where atMDependentFromId = &#63;.
	 *
	 * @param atMDependentFromId the at m dependent from ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adv task mapping, or <code>null</code> if a matching adv task mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTaskMapping fetchByDependentFromId_First(
		long atMDependentFromId, OrderByComparator orderByComparator)
		throws SystemException {
		List<AdvTaskMapping> list = findByDependentFromId(atMDependentFromId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last adv task mapping in the ordered set where atMDependentFromId = &#63;.
	 *
	 * @param atMDependentFromId the at m dependent from ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching adv task mapping
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a matching adv task mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTaskMapping findByDependentFromId_Last(long atMDependentFromId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTaskMappingException, SystemException {
		AdvTaskMapping advTaskMapping = fetchByDependentFromId_Last(atMDependentFromId,
				orderByComparator);

		if (advTaskMapping != null) {
			return advTaskMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("atMDependentFromId=");
		msg.append(atMDependentFromId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvTaskMappingException(msg.toString());
	}

	/**
	 * Returns the last adv task mapping in the ordered set where atMDependentFromId = &#63;.
	 *
	 * @param atMDependentFromId the at m dependent from ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching adv task mapping, or <code>null</code> if a matching adv task mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTaskMapping fetchByDependentFromId_Last(long atMDependentFromId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDependentFromId(atMDependentFromId);

		if (count == 0) {
			return null;
		}

		List<AdvTaskMapping> list = findByDependentFromId(atMDependentFromId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the adv task mappings before and after the current adv task mapping in the ordered set where atMDependentFromId = &#63;.
	 *
	 * @param atMId the primary key of the current adv task mapping
	 * @param atMDependentFromId the at m dependent from ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next adv task mapping
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a adv task mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTaskMapping[] findByDependentFromId_PrevAndNext(long atMId,
		long atMDependentFromId, OrderByComparator orderByComparator)
		throws NoSuchAdvTaskMappingException, SystemException {
		AdvTaskMapping advTaskMapping = findByPrimaryKey(atMId);

		Session session = null;

		try {
			session = openSession();

			AdvTaskMapping[] array = new AdvTaskMappingImpl[3];

			array[0] = getByDependentFromId_PrevAndNext(session,
					advTaskMapping, atMDependentFromId, orderByComparator, true);

			array[1] = advTaskMapping;

			array[2] = getByDependentFromId_PrevAndNext(session,
					advTaskMapping, atMDependentFromId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdvTaskMapping getByDependentFromId_PrevAndNext(Session session,
		AdvTaskMapping advTaskMapping, long atMDependentFromId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADVTASKMAPPING_WHERE);

		query.append(_FINDER_COLUMN_DEPENDENTFROMID_ATMDEPENDENTFROMID_2);

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
			query.append(AdvTaskMappingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(atMDependentFromId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(advTaskMapping);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdvTaskMapping> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the adv task mappings where atMDependentFromId = &#63; from the database.
	 *
	 * @param atMDependentFromId the at m dependent from ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDependentFromId(long atMDependentFromId)
		throws SystemException {
		for (AdvTaskMapping advTaskMapping : findByDependentFromId(
				atMDependentFromId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(advTaskMapping);
		}
	}

	/**
	 * Returns the number of adv task mappings where atMDependentFromId = &#63;.
	 *
	 * @param atMDependentFromId the at m dependent from ID
	 * @return the number of matching adv task mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDependentFromId(long atMDependentFromId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEPENDENTFROMID;

		Object[] finderArgs = new Object[] { atMDependentFromId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADVTASKMAPPING_WHERE);

			query.append(_FINDER_COLUMN_DEPENDENTFROMID_ATMDEPENDENTFROMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(atMDependentFromId);

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

	private static final String _FINDER_COLUMN_DEPENDENTFROMID_ATMDEPENDENTFROMID_2 =
		"advTaskMapping.atMDependentFromId = ?";

	public AdvTaskMappingPersistenceImpl() {
		setModelClass(AdvTaskMapping.class);
	}

	/**
	 * Caches the adv task mapping in the entity cache if it is enabled.
	 *
	 * @param advTaskMapping the adv task mapping
	 */
	@Override
	public void cacheResult(AdvTaskMapping advTaskMapping) {
		EntityCacheUtil.putResult(AdvTaskMappingModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskMappingImpl.class, advTaskMapping.getPrimaryKey(),
			advTaskMapping);

		advTaskMapping.resetOriginalValues();
	}

	/**
	 * Caches the adv task mappings in the entity cache if it is enabled.
	 *
	 * @param advTaskMappings the adv task mappings
	 */
	@Override
	public void cacheResult(List<AdvTaskMapping> advTaskMappings) {
		for (AdvTaskMapping advTaskMapping : advTaskMappings) {
			if (EntityCacheUtil.getResult(
						AdvTaskMappingModelImpl.ENTITY_CACHE_ENABLED,
						AdvTaskMappingImpl.class, advTaskMapping.getPrimaryKey()) == null) {
				cacheResult(advTaskMapping);
			}
			else {
				advTaskMapping.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all adv task mappings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AdvTaskMappingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AdvTaskMappingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the adv task mapping.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AdvTaskMapping advTaskMapping) {
		EntityCacheUtil.removeResult(AdvTaskMappingModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskMappingImpl.class, advTaskMapping.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AdvTaskMapping> advTaskMappings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AdvTaskMapping advTaskMapping : advTaskMappings) {
			EntityCacheUtil.removeResult(AdvTaskMappingModelImpl.ENTITY_CACHE_ENABLED,
				AdvTaskMappingImpl.class, advTaskMapping.getPrimaryKey());
		}
	}

	/**
	 * Creates a new adv task mapping with the primary key. Does not add the adv task mapping to the database.
	 *
	 * @param atMId the primary key for the new adv task mapping
	 * @return the new adv task mapping
	 */
	@Override
	public AdvTaskMapping create(long atMId) {
		AdvTaskMapping advTaskMapping = new AdvTaskMappingImpl();

		advTaskMapping.setNew(true);
		advTaskMapping.setPrimaryKey(atMId);

		return advTaskMapping;
	}

	/**
	 * Removes the adv task mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param atMId the primary key of the adv task mapping
	 * @return the adv task mapping that was removed
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a adv task mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTaskMapping remove(long atMId)
		throws NoSuchAdvTaskMappingException, SystemException {
		return remove((Serializable)atMId);
	}

	/**
	 * Removes the adv task mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the adv task mapping
	 * @return the adv task mapping that was removed
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a adv task mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTaskMapping remove(Serializable primaryKey)
		throws NoSuchAdvTaskMappingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AdvTaskMapping advTaskMapping = (AdvTaskMapping)session.get(AdvTaskMappingImpl.class,
					primaryKey);

			if (advTaskMapping == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdvTaskMappingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(advTaskMapping);
		}
		catch (NoSuchAdvTaskMappingException nsee) {
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
	protected AdvTaskMapping removeImpl(AdvTaskMapping advTaskMapping)
		throws SystemException {
		advTaskMapping = toUnwrappedModel(advTaskMapping);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(advTaskMapping)) {
				advTaskMapping = (AdvTaskMapping)session.get(AdvTaskMappingImpl.class,
						advTaskMapping.getPrimaryKeyObj());
			}

			if (advTaskMapping != null) {
				session.delete(advTaskMapping);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (advTaskMapping != null) {
			clearCache(advTaskMapping);
		}

		return advTaskMapping;
	}

	@Override
	public AdvTaskMapping updateImpl(
		com.liferay.AdvancedTasks.model.AdvTaskMapping advTaskMapping)
		throws SystemException {
		advTaskMapping = toUnwrappedModel(advTaskMapping);

		boolean isNew = advTaskMapping.isNew();

		AdvTaskMappingModelImpl advTaskMappingModelImpl = (AdvTaskMappingModelImpl)advTaskMapping;

		Session session = null;

		try {
			session = openSession();

			if (advTaskMapping.isNew()) {
				session.save(advTaskMapping);

				advTaskMapping.setNew(false);
			}
			else {
				session.merge(advTaskMapping);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AdvTaskMappingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((advTaskMappingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MTASKID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						advTaskMappingModelImpl.getOriginalAtMTaskId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MTASKID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MTASKID,
					args);

				args = new Object[] { advTaskMappingModelImpl.getAtMTaskId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MTASKID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MTASKID,
					args);
			}

			if ((advTaskMappingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPENDENTFROMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						advTaskMappingModelImpl.getOriginalAtMDependentFromId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPENDENTFROMID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPENDENTFROMID,
					args);

				args = new Object[] {
						advTaskMappingModelImpl.getAtMDependentFromId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPENDENTFROMID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPENDENTFROMID,
					args);
			}
		}

		EntityCacheUtil.putResult(AdvTaskMappingModelImpl.ENTITY_CACHE_ENABLED,
			AdvTaskMappingImpl.class, advTaskMapping.getPrimaryKey(),
			advTaskMapping);

		return advTaskMapping;
	}

	protected AdvTaskMapping toUnwrappedModel(AdvTaskMapping advTaskMapping) {
		if (advTaskMapping instanceof AdvTaskMappingImpl) {
			return advTaskMapping;
		}

		AdvTaskMappingImpl advTaskMappingImpl = new AdvTaskMappingImpl();

		advTaskMappingImpl.setNew(advTaskMapping.isNew());
		advTaskMappingImpl.setPrimaryKey(advTaskMapping.getPrimaryKey());

		advTaskMappingImpl.setAtMId(advTaskMapping.getAtMId());
		advTaskMappingImpl.setAtMTaskId(advTaskMapping.getAtMTaskId());
		advTaskMappingImpl.setAtMDependentFromId(advTaskMapping.getAtMDependentFromId());

		return advTaskMappingImpl;
	}

	/**
	 * Returns the adv task mapping with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the adv task mapping
	 * @return the adv task mapping
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a adv task mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTaskMapping findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAdvTaskMappingException, SystemException {
		AdvTaskMapping advTaskMapping = fetchByPrimaryKey(primaryKey);

		if (advTaskMapping == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAdvTaskMappingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return advTaskMapping;
	}

	/**
	 * Returns the adv task mapping with the primary key or throws a {@link com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException} if it could not be found.
	 *
	 * @param atMId the primary key of the adv task mapping
	 * @return the adv task mapping
	 * @throws com.liferay.AdvancedTasks.NoSuchAdvTaskMappingException if a adv task mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTaskMapping findByPrimaryKey(long atMId)
		throws NoSuchAdvTaskMappingException, SystemException {
		return findByPrimaryKey((Serializable)atMId);
	}

	/**
	 * Returns the adv task mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the adv task mapping
	 * @return the adv task mapping, or <code>null</code> if a adv task mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTaskMapping fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AdvTaskMapping advTaskMapping = (AdvTaskMapping)EntityCacheUtil.getResult(AdvTaskMappingModelImpl.ENTITY_CACHE_ENABLED,
				AdvTaskMappingImpl.class, primaryKey);

		if (advTaskMapping == _nullAdvTaskMapping) {
			return null;
		}

		if (advTaskMapping == null) {
			Session session = null;

			try {
				session = openSession();

				advTaskMapping = (AdvTaskMapping)session.get(AdvTaskMappingImpl.class,
						primaryKey);

				if (advTaskMapping != null) {
					cacheResult(advTaskMapping);
				}
				else {
					EntityCacheUtil.putResult(AdvTaskMappingModelImpl.ENTITY_CACHE_ENABLED,
						AdvTaskMappingImpl.class, primaryKey,
						_nullAdvTaskMapping);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AdvTaskMappingModelImpl.ENTITY_CACHE_ENABLED,
					AdvTaskMappingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return advTaskMapping;
	}

	/**
	 * Returns the adv task mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param atMId the primary key of the adv task mapping
	 * @return the adv task mapping, or <code>null</code> if a adv task mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvTaskMapping fetchByPrimaryKey(long atMId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)atMId);
	}

	/**
	 * Returns all the adv task mappings.
	 *
	 * @return the adv task mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvTaskMapping> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<AdvTaskMapping> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the adv task mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.AdvancedTasks.model.impl.AdvTaskMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of adv task mappings
	 * @param end the upper bound of the range of adv task mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of adv task mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvTaskMapping> findAll(int start, int end,
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

		List<AdvTaskMapping> list = (List<AdvTaskMapping>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADVTASKMAPPING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADVTASKMAPPING;

				if (pagination) {
					sql = sql.concat(AdvTaskMappingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AdvTaskMapping>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdvTaskMapping>(list);
				}
				else {
					list = (List<AdvTaskMapping>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the adv task mappings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AdvTaskMapping advTaskMapping : findAll()) {
			remove(advTaskMapping);
		}
	}

	/**
	 * Returns the number of adv task mappings.
	 *
	 * @return the number of adv task mappings
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

				Query q = session.createQuery(_SQL_COUNT_ADVTASKMAPPING);

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

	/**
	 * Initializes the adv task mapping persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.AdvancedTasks.model.AdvTaskMapping")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AdvTaskMapping>> listenersList = new ArrayList<ModelListener<AdvTaskMapping>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AdvTaskMapping>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AdvTaskMappingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ADVTASKMAPPING = "SELECT advTaskMapping FROM AdvTaskMapping advTaskMapping";
	private static final String _SQL_SELECT_ADVTASKMAPPING_WHERE = "SELECT advTaskMapping FROM AdvTaskMapping advTaskMapping WHERE ";
	private static final String _SQL_COUNT_ADVTASKMAPPING = "SELECT COUNT(advTaskMapping) FROM AdvTaskMapping advTaskMapping";
	private static final String _SQL_COUNT_ADVTASKMAPPING_WHERE = "SELECT COUNT(advTaskMapping) FROM AdvTaskMapping advTaskMapping WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "advTaskMapping.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AdvTaskMapping exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AdvTaskMapping exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AdvTaskMappingPersistenceImpl.class);
	private static AdvTaskMapping _nullAdvTaskMapping = new AdvTaskMappingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AdvTaskMapping> toCacheModel() {
				return _nullAdvTaskMappingCacheModel;
			}
		};

	private static CacheModel<AdvTaskMapping> _nullAdvTaskMappingCacheModel = new CacheModel<AdvTaskMapping>() {
			@Override
			public AdvTaskMapping toEntityModel() {
				return _nullAdvTaskMapping;
			}
		};
}