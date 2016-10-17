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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AdvTask}.
 * </p>
 *
 * @author David Proba
 * @see AdvTask
 * @generated
 */
public class AdvTaskWrapper implements AdvTask, ModelWrapper<AdvTask> {
	public AdvTaskWrapper(AdvTask advTask) {
		_advTask = advTask;
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

	/**
	* Returns the primary key of this adv task.
	*
	* @return the primary key of this adv task
	*/
	@Override
	public long getPrimaryKey() {
		return _advTask.getPrimaryKey();
	}

	/**
	* Sets the primary key of this adv task.
	*
	* @param primaryKey the primary key of this adv task
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_advTask.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this adv task.
	*
	* @return the uuid of this adv task
	*/
	@Override
	public java.lang.String getUuid() {
		return _advTask.getUuid();
	}

	/**
	* Sets the uuid of this adv task.
	*
	* @param uuid the uuid of this adv task
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_advTask.setUuid(uuid);
	}

	/**
	* Returns the at ID of this adv task.
	*
	* @return the at ID of this adv task
	*/
	@Override
	public long getAtId() {
		return _advTask.getAtId();
	}

	/**
	* Sets the at ID of this adv task.
	*
	* @param atId the at ID of this adv task
	*/
	@Override
	public void setAtId(long atId) {
		_advTask.setAtId(atId);
	}

	/**
	* Returns the group ID of this adv task.
	*
	* @return the group ID of this adv task
	*/
	@Override
	public long getGroupId() {
		return _advTask.getGroupId();
	}

	/**
	* Sets the group ID of this adv task.
	*
	* @param groupId the group ID of this adv task
	*/
	@Override
	public void setGroupId(long groupId) {
		_advTask.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this adv task.
	*
	* @return the company ID of this adv task
	*/
	@Override
	public long getCompanyId() {
		return _advTask.getCompanyId();
	}

	/**
	* Sets the company ID of this adv task.
	*
	* @param companyId the company ID of this adv task
	*/
	@Override
	public void setCompanyId(long companyId) {
		_advTask.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this adv task.
	*
	* @return the user ID of this adv task
	*/
	@Override
	public long getUserId() {
		return _advTask.getUserId();
	}

	/**
	* Sets the user ID of this adv task.
	*
	* @param userId the user ID of this adv task
	*/
	@Override
	public void setUserId(long userId) {
		_advTask.setUserId(userId);
	}

	/**
	* Returns the user uuid of this adv task.
	*
	* @return the user uuid of this adv task
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTask.getUserUuid();
	}

	/**
	* Sets the user uuid of this adv task.
	*
	* @param userUuid the user uuid of this adv task
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_advTask.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this adv task.
	*
	* @return the user name of this adv task
	*/
	@Override
	public java.lang.String getUserName() {
		return _advTask.getUserName();
	}

	/**
	* Sets the user name of this adv task.
	*
	* @param userName the user name of this adv task
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_advTask.setUserName(userName);
	}

	/**
	* Returns the create date of this adv task.
	*
	* @return the create date of this adv task
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _advTask.getCreateDate();
	}

	/**
	* Sets the create date of this adv task.
	*
	* @param createDate the create date of this adv task
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_advTask.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this adv task.
	*
	* @return the modified date of this adv task
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _advTask.getModifiedDate();
	}

	/**
	* Sets the modified date of this adv task.
	*
	* @param modifiedDate the modified date of this adv task
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_advTask.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the at title of this adv task.
	*
	* @return the at title of this adv task
	*/
	@Override
	public java.lang.String getAtTitle() {
		return _advTask.getAtTitle();
	}

	/**
	* Sets the at title of this adv task.
	*
	* @param atTitle the at title of this adv task
	*/
	@Override
	public void setAtTitle(java.lang.String atTitle) {
		_advTask.setAtTitle(atTitle);
	}

	/**
	* Returns the at description of this adv task.
	*
	* @return the at description of this adv task
	*/
	@Override
	public java.lang.String getAtDescription() {
		return _advTask.getAtDescription();
	}

	/**
	* Sets the at description of this adv task.
	*
	* @param atDescription the at description of this adv task
	*/
	@Override
	public void setAtDescription(java.lang.String atDescription) {
		_advTask.setAtDescription(atDescription);
	}

	/**
	* Returns the at start date of this adv task.
	*
	* @return the at start date of this adv task
	*/
	@Override
	public java.util.Date getAtStartDate() {
		return _advTask.getAtStartDate();
	}

	/**
	* Sets the at start date of this adv task.
	*
	* @param atStartDate the at start date of this adv task
	*/
	@Override
	public void setAtStartDate(java.util.Date atStartDate) {
		_advTask.setAtStartDate(atStartDate);
	}

	/**
	* Returns the at final date of this adv task.
	*
	* @return the at final date of this adv task
	*/
	@Override
	public java.util.Date getAtFinalDate() {
		return _advTask.getAtFinalDate();
	}

	/**
	* Sets the at final date of this adv task.
	*
	* @param atFinalDate the at final date of this adv task
	*/
	@Override
	public void setAtFinalDate(java.util.Date atFinalDate) {
		_advTask.setAtFinalDate(atFinalDate);
	}

	/**
	* Returns the at priority of this adv task.
	*
	* @return the at priority of this adv task
	*/
	@Override
	public int getAtPriority() {
		return _advTask.getAtPriority();
	}

	/**
	* Sets the at priority of this adv task.
	*
	* @param atPriority the at priority of this adv task
	*/
	@Override
	public void setAtPriority(int atPriority) {
		_advTask.setAtPriority(atPriority);
	}

	/**
	* Returns the at status of this adv task.
	*
	* @return the at status of this adv task
	*/
	@Override
	public int getAtStatus() {
		return _advTask.getAtStatus();
	}

	/**
	* Sets the at status of this adv task.
	*
	* @param atStatus the at status of this adv task
	*/
	@Override
	public void setAtStatus(int atStatus) {
		_advTask.setAtStatus(atStatus);
	}

	/**
	* Returns the at modifier user ID of this adv task.
	*
	* @return the at modifier user ID of this adv task
	*/
	@Override
	public long getAtModifierUserId() {
		return _advTask.getAtModifierUserId();
	}

	/**
	* Sets the at modifier user ID of this adv task.
	*
	* @param atModifierUserId the at modifier user ID of this adv task
	*/
	@Override
	public void setAtModifierUserId(long atModifierUserId) {
		_advTask.setAtModifierUserId(atModifierUserId);
	}

	/**
	* Returns the at modifier user uuid of this adv task.
	*
	* @return the at modifier user uuid of this adv task
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getAtModifierUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTask.getAtModifierUserUuid();
	}

	/**
	* Sets the at modifier user uuid of this adv task.
	*
	* @param atModifierUserUuid the at modifier user uuid of this adv task
	*/
	@Override
	public void setAtModifierUserUuid(java.lang.String atModifierUserUuid) {
		_advTask.setAtModifierUserUuid(atModifierUserUuid);
	}

	/**
	* Returns the at assigned to user ID of this adv task.
	*
	* @return the at assigned to user ID of this adv task
	*/
	@Override
	public long getAtAssignedToUserId() {
		return _advTask.getAtAssignedToUserId();
	}

	/**
	* Sets the at assigned to user ID of this adv task.
	*
	* @param atAssignedToUserId the at assigned to user ID of this adv task
	*/
	@Override
	public void setAtAssignedToUserId(long atAssignedToUserId) {
		_advTask.setAtAssignedToUserId(atAssignedToUserId);
	}

	/**
	* Returns the at assigned to user uuid of this adv task.
	*
	* @return the at assigned to user uuid of this adv task
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getAtAssignedToUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTask.getAtAssignedToUserUuid();
	}

	/**
	* Sets the at assigned to user uuid of this adv task.
	*
	* @param atAssignedToUserUuid the at assigned to user uuid of this adv task
	*/
	@Override
	public void setAtAssignedToUserUuid(java.lang.String atAssignedToUserUuid) {
		_advTask.setAtAssignedToUserUuid(atAssignedToUserUuid);
	}

	/**
	* Returns the at resolver user ID of this adv task.
	*
	* @return the at resolver user ID of this adv task
	*/
	@Override
	public long getAtResolverUserId() {
		return _advTask.getAtResolverUserId();
	}

	/**
	* Sets the at resolver user ID of this adv task.
	*
	* @param atResolverUserId the at resolver user ID of this adv task
	*/
	@Override
	public void setAtResolverUserId(long atResolverUserId) {
		_advTask.setAtResolverUserId(atResolverUserId);
	}

	/**
	* Returns the at resolver user uuid of this adv task.
	*
	* @return the at resolver user uuid of this adv task
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getAtResolverUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTask.getAtResolverUserUuid();
	}

	/**
	* Sets the at resolver user uuid of this adv task.
	*
	* @param atResolverUserUuid the at resolver user uuid of this adv task
	*/
	@Override
	public void setAtResolverUserUuid(java.lang.String atResolverUserUuid) {
		_advTask.setAtResolverUserUuid(atResolverUserUuid);
	}

	/**
	* Returns the at parent task ID of this adv task.
	*
	* @return the at parent task ID of this adv task
	*/
	@Override
	public long getAtParentTaskId() {
		return _advTask.getAtParentTaskId();
	}

	/**
	* Sets the at parent task ID of this adv task.
	*
	* @param atParentTaskId the at parent task ID of this adv task
	*/
	@Override
	public void setAtParentTaskId(long atParentTaskId) {
		_advTask.setAtParentTaskId(atParentTaskId);
	}

	/**
	* Returns the status of this adv task.
	*
	* @return the status of this adv task
	*/
	@Override
	public int getStatus() {
		return _advTask.getStatus();
	}

	/**
	* Sets the status of this adv task.
	*
	* @param status the status of this adv task
	*/
	@Override
	public void setStatus(int status) {
		_advTask.setStatus(status);
	}

	/**
	* Returns the status by user ID of this adv task.
	*
	* @return the status by user ID of this adv task
	*/
	@Override
	public long getStatusByUserId() {
		return _advTask.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this adv task.
	*
	* @param statusByUserId the status by user ID of this adv task
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_advTask.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this adv task.
	*
	* @return the status by user uuid of this adv task
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advTask.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this adv task.
	*
	* @param statusByUserUuid the status by user uuid of this adv task
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_advTask.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this adv task.
	*
	* @return the status by user name of this adv task
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _advTask.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this adv task.
	*
	* @param statusByUserName the status by user name of this adv task
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_advTask.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this adv task.
	*
	* @return the status date of this adv task
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _advTask.getStatusDate();
	}

	/**
	* Sets the status date of this adv task.
	*
	* @param statusDate the status date of this adv task
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_advTask.setStatusDate(statusDate);
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _advTask.getApproved();
	}

	/**
	* Returns <code>true</code> if this adv task is approved.
	*
	* @return <code>true</code> if this adv task is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _advTask.isApproved();
	}

	/**
	* Returns <code>true</code> if this adv task is denied.
	*
	* @return <code>true</code> if this adv task is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _advTask.isDenied();
	}

	/**
	* Returns <code>true</code> if this adv task is a draft.
	*
	* @return <code>true</code> if this adv task is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _advTask.isDraft();
	}

	/**
	* Returns <code>true</code> if this adv task is expired.
	*
	* @return <code>true</code> if this adv task is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _advTask.isExpired();
	}

	/**
	* Returns <code>true</code> if this adv task is inactive.
	*
	* @return <code>true</code> if this adv task is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _advTask.isInactive();
	}

	/**
	* Returns <code>true</code> if this adv task is incomplete.
	*
	* @return <code>true</code> if this adv task is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _advTask.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this adv task is pending.
	*
	* @return <code>true</code> if this adv task is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _advTask.isPending();
	}

	/**
	* Returns <code>true</code> if this adv task is scheduled.
	*
	* @return <code>true</code> if this adv task is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _advTask.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _advTask.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_advTask.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _advTask.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_advTask.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _advTask.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _advTask.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_advTask.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _advTask.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_advTask.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_advTask.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_advTask.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AdvTaskWrapper((AdvTask)_advTask.clone());
	}

	@Override
	public int compareTo(com.liferay.AdvancedTasks.model.AdvTask advTask) {
		return _advTask.compareTo(advTask);
	}

	@Override
	public int hashCode() {
		return _advTask.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.AdvancedTasks.model.AdvTask> toCacheModel() {
		return _advTask.toCacheModel();
	}

	@Override
	public com.liferay.AdvancedTasks.model.AdvTask toEscapedModel() {
		return new AdvTaskWrapper(_advTask.toEscapedModel());
	}

	@Override
	public com.liferay.AdvancedTasks.model.AdvTask toUnescapedModel() {
		return new AdvTaskWrapper(_advTask.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _advTask.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _advTask.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_advTask.persist();
	}

	@Override
	public java.lang.String getAssigneeFullName() {
		return _advTask.getAssigneeFullName();
	}

	@Override
	public java.lang.String getPriorityLabel() {
		return _advTask.getPriorityLabel();
	}

	@Override
	public java.lang.String getReporterFullName() {
		return _advTask.getReporterFullName();
	}

	@Override
	public java.lang.String getStatusLabel() {
		return _advTask.getStatusLabel();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdvTaskWrapper)) {
			return false;
		}

		AdvTaskWrapper advTaskWrapper = (AdvTaskWrapper)obj;

		if (Validator.equals(_advTask, advTaskWrapper._advTask)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _advTask.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AdvTask getWrappedAdvTask() {
		return _advTask;
	}

	@Override
	public AdvTask getWrappedModel() {
		return _advTask;
	}

	@Override
	public void resetOriginalValues() {
		_advTask.resetOriginalValues();
	}

	private AdvTask _advTask;
}