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

package com.liferay.AdvancedTasks.model.impl;

import com.liferay.AdvancedTasks.model.AdvTask;
import com.liferay.AdvancedTasks.model.AdvTaskModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the AdvTask service. Represents a row in the &quot;AdvancedTasks_AdvTask&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.AdvancedTasks.model.AdvTaskModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AdvTaskImpl}.
 * </p>
 *
 * @author David Proba
 * @see AdvTaskImpl
 * @see com.liferay.AdvancedTasks.model.AdvTask
 * @see com.liferay.AdvancedTasks.model.AdvTaskModel
 * @generated
 */
public class AdvTaskModelImpl extends BaseModelImpl<AdvTask>
	implements AdvTaskModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a adv task model instance should use the {@link com.liferay.AdvancedTasks.model.AdvTask} interface instead.
	 */
	public static final String TABLE_NAME = "AdvancedTasks_AdvTask";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "atId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "atTitle", Types.VARCHAR },
			{ "atDescription", Types.VARCHAR },
			{ "atStartDate", Types.TIMESTAMP },
			{ "atFinalDate", Types.TIMESTAMP },
			{ "atPriority", Types.INTEGER },
			{ "atStatus", Types.INTEGER },
			{ "atModifierUserId", Types.BIGINT },
			{ "atAssignedToUserId", Types.BIGINT },
			{ "atResolverUserId", Types.BIGINT },
			{ "atParentTaskId", Types.BIGINT },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table AdvancedTasks_AdvTask (uuid_ VARCHAR(75) null,atId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,atTitle VARCHAR(75) null,atDescription VARCHAR(75) null,atStartDate DATE null,atFinalDate DATE null,atPriority INTEGER,atStatus INTEGER,atModifierUserId LONG,atAssignedToUserId LONG,atResolverUserId LONG,atParentTaskId LONG,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table AdvancedTasks_AdvTask";
	public static final String ORDER_BY_JPQL = " ORDER BY advTask.atPriority ASC, advTask.atFinalDate ASC, advTask.modifiedDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY AdvancedTasks_AdvTask.atPriority ASC, AdvancedTasks_AdvTask.atFinalDate ASC, AdvancedTasks_AdvTask.modifiedDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.AdvancedTasks.model.AdvTask"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.AdvancedTasks.model.AdvTask"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.AdvancedTasks.model.AdvTask"),
			true);
	public static long ATASSIGNEDTOUSERID_COLUMN_BITMASK = 1L;
	public static long ATPARENTTASKID_COLUMN_BITMASK = 2L;
	public static long COMPANYID_COLUMN_BITMASK = 4L;
	public static long GROUPID_COLUMN_BITMASK = 8L;
	public static long STATUS_COLUMN_BITMASK = 16L;
	public static long UUID_COLUMN_BITMASK = 32L;
	public static long ATPRIORITY_COLUMN_BITMASK = 64L;
	public static long ATFINALDATE_COLUMN_BITMASK = 128L;
	public static long MODIFIEDDATE_COLUMN_BITMASK = 256L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.AdvancedTasks.model.AdvTask"));

	public AdvTaskModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _atId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAtId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _atId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AdvTask.class;
	}

	@Override
	public String getModelClassName() {
		return AdvTask.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("atId", getAtId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("atTitle", getAtTitle());
		attributes.put("atDescription", getAtDescription());
		attributes.put("atStartDate", getAtStartDate());
		attributes.put("atFinalDate", getAtFinalDate());
		attributes.put("atPriority", getAtPriority());
		attributes.put("atStatus", getAtStatus());
		attributes.put("atModifierUserId", getAtModifierUserId());
		attributes.put("atAssignedToUserId", getAtAssignedToUserId());
		attributes.put("atResolverUserId", getAtResolverUserId());
		attributes.put("atParentTaskId", getAtParentTaskId());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long atId = (Long)attributes.get("atId");

		if (atId != null) {
			setAtId(atId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String atTitle = (String)attributes.get("atTitle");

		if (atTitle != null) {
			setAtTitle(atTitle);
		}

		String atDescription = (String)attributes.get("atDescription");

		if (atDescription != null) {
			setAtDescription(atDescription);
		}

		Date atStartDate = (Date)attributes.get("atStartDate");

		if (atStartDate != null) {
			setAtStartDate(atStartDate);
		}

		Date atFinalDate = (Date)attributes.get("atFinalDate");

		if (atFinalDate != null) {
			setAtFinalDate(atFinalDate);
		}

		Integer atPriority = (Integer)attributes.get("atPriority");

		if (atPriority != null) {
			setAtPriority(atPriority);
		}

		Integer atStatus = (Integer)attributes.get("atStatus");

		if (atStatus != null) {
			setAtStatus(atStatus);
		}

		Long atModifierUserId = (Long)attributes.get("atModifierUserId");

		if (atModifierUserId != null) {
			setAtModifierUserId(atModifierUserId);
		}

		Long atAssignedToUserId = (Long)attributes.get("atAssignedToUserId");

		if (atAssignedToUserId != null) {
			setAtAssignedToUserId(atAssignedToUserId);
		}

		Long atResolverUserId = (Long)attributes.get("atResolverUserId");

		if (atResolverUserId != null) {
			setAtResolverUserId(atResolverUserId);
		}

		Long atParentTaskId = (Long)attributes.get("atParentTaskId");

		if (atParentTaskId != null) {
			setAtParentTaskId(atParentTaskId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getAtId() {
		return _atId;
	}

	@Override
	public void setAtId(long atId) {
		_atId = atId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getAtTitle() {
		if (_atTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _atTitle;
		}
	}

	@Override
	public void setAtTitle(String atTitle) {
		_atTitle = atTitle;
	}

	@Override
	public String getAtDescription() {
		if (_atDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _atDescription;
		}
	}

	@Override
	public void setAtDescription(String atDescription) {
		_atDescription = atDescription;
	}

	@Override
	public Date getAtStartDate() {
		return _atStartDate;
	}

	@Override
	public void setAtStartDate(Date atStartDate) {
		_atStartDate = atStartDate;
	}

	@Override
	public Date getAtFinalDate() {
		return _atFinalDate;
	}

	@Override
	public void setAtFinalDate(Date atFinalDate) {
		_columnBitmask = -1L;

		_atFinalDate = atFinalDate;
	}

	@Override
	public int getAtPriority() {
		return _atPriority;
	}

	@Override
	public void setAtPriority(int atPriority) {
		_columnBitmask = -1L;

		_atPriority = atPriority;
	}

	@Override
	public int getAtStatus() {
		return _atStatus;
	}

	@Override
	public void setAtStatus(int atStatus) {
		_atStatus = atStatus;
	}

	@Override
	public long getAtModifierUserId() {
		return _atModifierUserId;
	}

	@Override
	public void setAtModifierUserId(long atModifierUserId) {
		_atModifierUserId = atModifierUserId;
	}

	@Override
	public String getAtModifierUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getAtModifierUserId(), "uuid",
			_atModifierUserUuid);
	}

	@Override
	public void setAtModifierUserUuid(String atModifierUserUuid) {
		_atModifierUserUuid = atModifierUserUuid;
	}

	@Override
	public long getAtAssignedToUserId() {
		return _atAssignedToUserId;
	}

	@Override
	public void setAtAssignedToUserId(long atAssignedToUserId) {
		_columnBitmask |= ATASSIGNEDTOUSERID_COLUMN_BITMASK;

		if (!_setOriginalAtAssignedToUserId) {
			_setOriginalAtAssignedToUserId = true;

			_originalAtAssignedToUserId = _atAssignedToUserId;
		}

		_atAssignedToUserId = atAssignedToUserId;
	}

	@Override
	public String getAtAssignedToUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getAtAssignedToUserId(), "uuid",
			_atAssignedToUserUuid);
	}

	@Override
	public void setAtAssignedToUserUuid(String atAssignedToUserUuid) {
		_atAssignedToUserUuid = atAssignedToUserUuid;
	}

	public long getOriginalAtAssignedToUserId() {
		return _originalAtAssignedToUserId;
	}

	@Override
	public long getAtResolverUserId() {
		return _atResolverUserId;
	}

	@Override
	public void setAtResolverUserId(long atResolverUserId) {
		_atResolverUserId = atResolverUserId;
	}

	@Override
	public String getAtResolverUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getAtResolverUserId(), "uuid",
			_atResolverUserUuid);
	}

	@Override
	public void setAtResolverUserUuid(String atResolverUserUuid) {
		_atResolverUserUuid = atResolverUserUuid;
	}

	@Override
	public long getAtParentTaskId() {
		return _atParentTaskId;
	}

	@Override
	public void setAtParentTaskId(long atParentTaskId) {
		_columnBitmask |= ATPARENTTASKID_COLUMN_BITMASK;

		if (!_setOriginalAtParentTaskId) {
			_setOriginalAtParentTaskId = true;

			_originalAtParentTaskId = _atParentTaskId;
		}

		_atParentTaskId = atParentTaskId;
	}

	public long getOriginalAtParentTaskId() {
		return _originalAtParentTaskId;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				AdvTask.class.getName()));
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #isApproved}
	 */
	@Override
	public boolean getApproved() {
		return isApproved();
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			AdvTask.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AdvTask toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (AdvTask)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AdvTaskImpl advTaskImpl = new AdvTaskImpl();

		advTaskImpl.setUuid(getUuid());
		advTaskImpl.setAtId(getAtId());
		advTaskImpl.setGroupId(getGroupId());
		advTaskImpl.setCompanyId(getCompanyId());
		advTaskImpl.setUserId(getUserId());
		advTaskImpl.setUserName(getUserName());
		advTaskImpl.setCreateDate(getCreateDate());
		advTaskImpl.setModifiedDate(getModifiedDate());
		advTaskImpl.setAtTitle(getAtTitle());
		advTaskImpl.setAtDescription(getAtDescription());
		advTaskImpl.setAtStartDate(getAtStartDate());
		advTaskImpl.setAtFinalDate(getAtFinalDate());
		advTaskImpl.setAtPriority(getAtPriority());
		advTaskImpl.setAtStatus(getAtStatus());
		advTaskImpl.setAtModifierUserId(getAtModifierUserId());
		advTaskImpl.setAtAssignedToUserId(getAtAssignedToUserId());
		advTaskImpl.setAtResolverUserId(getAtResolverUserId());
		advTaskImpl.setAtParentTaskId(getAtParentTaskId());
		advTaskImpl.setStatus(getStatus());
		advTaskImpl.setStatusByUserId(getStatusByUserId());
		advTaskImpl.setStatusByUserName(getStatusByUserName());
		advTaskImpl.setStatusDate(getStatusDate());

		advTaskImpl.resetOriginalValues();

		return advTaskImpl;
	}

	@Override
	public int compareTo(AdvTask advTask) {
		int value = 0;

		if (getAtPriority() < advTask.getAtPriority()) {
			value = -1;
		}
		else if (getAtPriority() > advTask.getAtPriority()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getAtFinalDate(), advTask.getAtFinalDate());

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getModifiedDate(), advTask.getModifiedDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdvTask)) {
			return false;
		}

		AdvTask advTask = (AdvTask)obj;

		long primaryKey = advTask.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		AdvTaskModelImpl advTaskModelImpl = this;

		advTaskModelImpl._originalUuid = advTaskModelImpl._uuid;

		advTaskModelImpl._originalGroupId = advTaskModelImpl._groupId;

		advTaskModelImpl._setOriginalGroupId = false;

		advTaskModelImpl._originalCompanyId = advTaskModelImpl._companyId;

		advTaskModelImpl._setOriginalCompanyId = false;

		advTaskModelImpl._originalAtAssignedToUserId = advTaskModelImpl._atAssignedToUserId;

		advTaskModelImpl._setOriginalAtAssignedToUserId = false;

		advTaskModelImpl._originalAtParentTaskId = advTaskModelImpl._atParentTaskId;

		advTaskModelImpl._setOriginalAtParentTaskId = false;

		advTaskModelImpl._originalStatus = advTaskModelImpl._status;

		advTaskModelImpl._setOriginalStatus = false;

		advTaskModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AdvTask> toCacheModel() {
		AdvTaskCacheModel advTaskCacheModel = new AdvTaskCacheModel();

		advTaskCacheModel.uuid = getUuid();

		String uuid = advTaskCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			advTaskCacheModel.uuid = null;
		}

		advTaskCacheModel.atId = getAtId();

		advTaskCacheModel.groupId = getGroupId();

		advTaskCacheModel.companyId = getCompanyId();

		advTaskCacheModel.userId = getUserId();

		advTaskCacheModel.userName = getUserName();

		String userName = advTaskCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			advTaskCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			advTaskCacheModel.createDate = createDate.getTime();
		}
		else {
			advTaskCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			advTaskCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			advTaskCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		advTaskCacheModel.atTitle = getAtTitle();

		String atTitle = advTaskCacheModel.atTitle;

		if ((atTitle != null) && (atTitle.length() == 0)) {
			advTaskCacheModel.atTitle = null;
		}

		advTaskCacheModel.atDescription = getAtDescription();

		String atDescription = advTaskCacheModel.atDescription;

		if ((atDescription != null) && (atDescription.length() == 0)) {
			advTaskCacheModel.atDescription = null;
		}

		Date atStartDate = getAtStartDate();

		if (atStartDate != null) {
			advTaskCacheModel.atStartDate = atStartDate.getTime();
		}
		else {
			advTaskCacheModel.atStartDate = Long.MIN_VALUE;
		}

		Date atFinalDate = getAtFinalDate();

		if (atFinalDate != null) {
			advTaskCacheModel.atFinalDate = atFinalDate.getTime();
		}
		else {
			advTaskCacheModel.atFinalDate = Long.MIN_VALUE;
		}

		advTaskCacheModel.atPriority = getAtPriority();

		advTaskCacheModel.atStatus = getAtStatus();

		advTaskCacheModel.atModifierUserId = getAtModifierUserId();

		advTaskCacheModel.atAssignedToUserId = getAtAssignedToUserId();

		advTaskCacheModel.atResolverUserId = getAtResolverUserId();

		advTaskCacheModel.atParentTaskId = getAtParentTaskId();

		advTaskCacheModel.status = getStatus();

		advTaskCacheModel.statusByUserId = getStatusByUserId();

		advTaskCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = advTaskCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			advTaskCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			advTaskCacheModel.statusDate = statusDate.getTime();
		}
		else {
			advTaskCacheModel.statusDate = Long.MIN_VALUE;
		}

		return advTaskCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", atId=");
		sb.append(getAtId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", atTitle=");
		sb.append(getAtTitle());
		sb.append(", atDescription=");
		sb.append(getAtDescription());
		sb.append(", atStartDate=");
		sb.append(getAtStartDate());
		sb.append(", atFinalDate=");
		sb.append(getAtFinalDate());
		sb.append(", atPriority=");
		sb.append(getAtPriority());
		sb.append(", atStatus=");
		sb.append(getAtStatus());
		sb.append(", atModifierUserId=");
		sb.append(getAtModifierUserId());
		sb.append(", atAssignedToUserId=");
		sb.append(getAtAssignedToUserId());
		sb.append(", atResolverUserId=");
		sb.append(getAtResolverUserId());
		sb.append(", atParentTaskId=");
		sb.append(getAtParentTaskId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(70);

		sb.append("<model><model-name>");
		sb.append("com.liferay.AdvancedTasks.model.AdvTask");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>atId</column-name><column-value><![CDATA[");
		sb.append(getAtId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>atTitle</column-name><column-value><![CDATA[");
		sb.append(getAtTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>atDescription</column-name><column-value><![CDATA[");
		sb.append(getAtDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>atStartDate</column-name><column-value><![CDATA[");
		sb.append(getAtStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>atFinalDate</column-name><column-value><![CDATA[");
		sb.append(getAtFinalDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>atPriority</column-name><column-value><![CDATA[");
		sb.append(getAtPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>atStatus</column-name><column-value><![CDATA[");
		sb.append(getAtStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>atModifierUserId</column-name><column-value><![CDATA[");
		sb.append(getAtModifierUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>atAssignedToUserId</column-name><column-value><![CDATA[");
		sb.append(getAtAssignedToUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>atResolverUserId</column-name><column-value><![CDATA[");
		sb.append(getAtResolverUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>atParentTaskId</column-name><column-value><![CDATA[");
		sb.append(getAtParentTaskId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = AdvTask.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			AdvTask.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _atId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _atTitle;
	private String _atDescription;
	private Date _atStartDate;
	private Date _atFinalDate;
	private int _atPriority;
	private int _atStatus;
	private long _atModifierUserId;
	private String _atModifierUserUuid;
	private long _atAssignedToUserId;
	private String _atAssignedToUserUuid;
	private long _originalAtAssignedToUserId;
	private boolean _setOriginalAtAssignedToUserId;
	private long _atResolverUserId;
	private String _atResolverUserUuid;
	private long _atParentTaskId;
	private long _originalAtParentTaskId;
	private boolean _setOriginalAtParentTaskId;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private long _columnBitmask;
	private AdvTask _escapedModel;
}