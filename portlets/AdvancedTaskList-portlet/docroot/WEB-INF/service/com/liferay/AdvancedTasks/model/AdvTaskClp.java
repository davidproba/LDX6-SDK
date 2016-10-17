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

package com.liferay.AdvancedTasks.model;

import com.liferay.AdvancedTasks.service.AdvTaskLocalServiceUtil;
import com.liferay.AdvancedTasks.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author David Proba
 */
public class AdvTaskClp extends BaseModelImpl<AdvTask> implements AdvTask {
	public AdvTaskClp() {
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
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_advTaskRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAtId() {
		return _atId;
	}

	@Override
	public void setAtId(long atId) {
		_atId = atId;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setAtId", long.class);

				method.invoke(_advTaskRemoteModel, atId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_advTaskRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_advTaskRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_advTaskRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
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
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_advTaskRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_advTaskRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_advTaskRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAtTitle() {
		return _atTitle;
	}

	@Override
	public void setAtTitle(String atTitle) {
		_atTitle = atTitle;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setAtTitle", String.class);

				method.invoke(_advTaskRemoteModel, atTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAtDescription() {
		return _atDescription;
	}

	@Override
	public void setAtDescription(String atDescription) {
		_atDescription = atDescription;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setAtDescription", String.class);

				method.invoke(_advTaskRemoteModel, atDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getAtStartDate() {
		return _atStartDate;
	}

	@Override
	public void setAtStartDate(Date atStartDate) {
		_atStartDate = atStartDate;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setAtStartDate", Date.class);

				method.invoke(_advTaskRemoteModel, atStartDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getAtFinalDate() {
		return _atFinalDate;
	}

	@Override
	public void setAtFinalDate(Date atFinalDate) {
		_atFinalDate = atFinalDate;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setAtFinalDate", Date.class);

				method.invoke(_advTaskRemoteModel, atFinalDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAtPriority() {
		return _atPriority;
	}

	@Override
	public void setAtPriority(int atPriority) {
		_atPriority = atPriority;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setAtPriority", int.class);

				method.invoke(_advTaskRemoteModel, atPriority);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAtStatus() {
		return _atStatus;
	}

	@Override
	public void setAtStatus(int atStatus) {
		_atStatus = atStatus;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setAtStatus", int.class);

				method.invoke(_advTaskRemoteModel, atStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAtModifierUserId() {
		return _atModifierUserId;
	}

	@Override
	public void setAtModifierUserId(long atModifierUserId) {
		_atModifierUserId = atModifierUserId;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setAtModifierUserId",
						long.class);

				method.invoke(_advTaskRemoteModel, atModifierUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
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
		_atAssignedToUserId = atAssignedToUserId;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setAtAssignedToUserId",
						long.class);

				method.invoke(_advTaskRemoteModel, atAssignedToUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
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

	@Override
	public long getAtResolverUserId() {
		return _atResolverUserId;
	}

	@Override
	public void setAtResolverUserId(long atResolverUserId) {
		_atResolverUserId = atResolverUserId;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setAtResolverUserId",
						long.class);

				method.invoke(_advTaskRemoteModel, atResolverUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
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
		_atParentTaskId = atParentTaskId;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setAtParentTaskId", long.class);

				method.invoke(_advTaskRemoteModel, atParentTaskId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_advTaskRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_advTaskRemoteModel, statusByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
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
		return _statusByUserName;
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_advTaskRemoteModel, statusByUserName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;

		if (_advTaskRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDate", Date.class);

				method.invoke(_advTaskRemoteModel, statusDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getReporterFullName() {
		try {
			String methodName = "getReporterFullName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getPriorityLabel() {
		try {
			String methodName = "getPriorityLabel";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getStatusLabel() {
		try {
			String methodName = "getStatusLabel";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getAssigneeFullName() {
		try {
			String methodName = "getAssigneeFullName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
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

	public BaseModel<?> getAdvTaskRemoteModel() {
		return _advTaskRemoteModel;
	}

	public void setAdvTaskRemoteModel(BaseModel<?> advTaskRemoteModel) {
		_advTaskRemoteModel = advTaskRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _advTaskRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_advTaskRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AdvTaskLocalServiceUtil.addAdvTask(this);
		}
		else {
			AdvTaskLocalServiceUtil.updateAdvTask(this);
		}
	}

	@Override
	public AdvTask toEscapedModel() {
		return (AdvTask)ProxyUtil.newProxyInstance(AdvTask.class.getClassLoader(),
			new Class[] { AdvTask.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AdvTaskClp clone = new AdvTaskClp();

		clone.setUuid(getUuid());
		clone.setAtId(getAtId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setAtTitle(getAtTitle());
		clone.setAtDescription(getAtDescription());
		clone.setAtStartDate(getAtStartDate());
		clone.setAtFinalDate(getAtFinalDate());
		clone.setAtPriority(getAtPriority());
		clone.setAtStatus(getAtStatus());
		clone.setAtModifierUserId(getAtModifierUserId());
		clone.setAtAssignedToUserId(getAtAssignedToUserId());
		clone.setAtResolverUserId(getAtResolverUserId());
		clone.setAtParentTaskId(getAtParentTaskId());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusByUserName(getStatusByUserName());
		clone.setStatusDate(getStatusDate());

		return clone;
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

		if (!(obj instanceof AdvTaskClp)) {
			return false;
		}

		AdvTaskClp advTask = (AdvTaskClp)obj;

		long primaryKey = advTask.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
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

	private String _uuid;
	private long _atId;
	private long _groupId;
	private long _companyId;
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
	private long _atResolverUserId;
	private String _atResolverUserUuid;
	private long _atParentTaskId;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private BaseModel<?> _advTaskRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.AdvancedTasks.service.ClpSerializer.class;
}