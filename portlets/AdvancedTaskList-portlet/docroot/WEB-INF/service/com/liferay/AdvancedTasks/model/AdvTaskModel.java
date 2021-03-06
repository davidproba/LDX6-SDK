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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedGroupedModel;
import com.liferay.portal.model.WorkflowedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the AdvTask service. Represents a row in the &quot;AdvancedTasks_AdvTask&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.AdvancedTasks.model.impl.AdvTaskImpl}.
 * </p>
 *
 * @author David Proba
 * @see AdvTask
 * @see com.liferay.AdvancedTasks.model.impl.AdvTaskImpl
 * @see com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl
 * @generated
 */
public interface AdvTaskModel extends BaseModel<AdvTask>, StagedGroupedModel,
	WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a adv task model instance should use the {@link AdvTask} interface instead.
	 */

	/**
	 * Returns the primary key of this adv task.
	 *
	 * @return the primary key of this adv task
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this adv task.
	 *
	 * @param primaryKey the primary key of this adv task
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this adv task.
	 *
	 * @return the uuid of this adv task
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this adv task.
	 *
	 * @param uuid the uuid of this adv task
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the at ID of this adv task.
	 *
	 * @return the at ID of this adv task
	 */
	public long getAtId();

	/**
	 * Sets the at ID of this adv task.
	 *
	 * @param atId the at ID of this adv task
	 */
	public void setAtId(long atId);

	/**
	 * Returns the group ID of this adv task.
	 *
	 * @return the group ID of this adv task
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this adv task.
	 *
	 * @param groupId the group ID of this adv task
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this adv task.
	 *
	 * @return the company ID of this adv task
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this adv task.
	 *
	 * @param companyId the company ID of this adv task
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this adv task.
	 *
	 * @return the user ID of this adv task
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this adv task.
	 *
	 * @param userId the user ID of this adv task
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this adv task.
	 *
	 * @return the user uuid of this adv task
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this adv task.
	 *
	 * @param userUuid the user uuid of this adv task
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this adv task.
	 *
	 * @return the user name of this adv task
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this adv task.
	 *
	 * @param userName the user name of this adv task
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this adv task.
	 *
	 * @return the create date of this adv task
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this adv task.
	 *
	 * @param createDate the create date of this adv task
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this adv task.
	 *
	 * @return the modified date of this adv task
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this adv task.
	 *
	 * @param modifiedDate the modified date of this adv task
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the at title of this adv task.
	 *
	 * @return the at title of this adv task
	 */
	@AutoEscape
	public String getAtTitle();

	/**
	 * Sets the at title of this adv task.
	 *
	 * @param atTitle the at title of this adv task
	 */
	public void setAtTitle(String atTitle);

	/**
	 * Returns the at description of this adv task.
	 *
	 * @return the at description of this adv task
	 */
	@AutoEscape
	public String getAtDescription();

	/**
	 * Sets the at description of this adv task.
	 *
	 * @param atDescription the at description of this adv task
	 */
	public void setAtDescription(String atDescription);

	/**
	 * Returns the at start date of this adv task.
	 *
	 * @return the at start date of this adv task
	 */
	public Date getAtStartDate();

	/**
	 * Sets the at start date of this adv task.
	 *
	 * @param atStartDate the at start date of this adv task
	 */
	public void setAtStartDate(Date atStartDate);

	/**
	 * Returns the at final date of this adv task.
	 *
	 * @return the at final date of this adv task
	 */
	public Date getAtFinalDate();

	/**
	 * Sets the at final date of this adv task.
	 *
	 * @param atFinalDate the at final date of this adv task
	 */
	public void setAtFinalDate(Date atFinalDate);

	/**
	 * Returns the at priority of this adv task.
	 *
	 * @return the at priority of this adv task
	 */
	public int getAtPriority();

	/**
	 * Sets the at priority of this adv task.
	 *
	 * @param atPriority the at priority of this adv task
	 */
	public void setAtPriority(int atPriority);

	/**
	 * Returns the at status of this adv task.
	 *
	 * @return the at status of this adv task
	 */
	public int getAtStatus();

	/**
	 * Sets the at status of this adv task.
	 *
	 * @param atStatus the at status of this adv task
	 */
	public void setAtStatus(int atStatus);

	/**
	 * Returns the at modifier user ID of this adv task.
	 *
	 * @return the at modifier user ID of this adv task
	 */
	public long getAtModifierUserId();

	/**
	 * Sets the at modifier user ID of this adv task.
	 *
	 * @param atModifierUserId the at modifier user ID of this adv task
	 */
	public void setAtModifierUserId(long atModifierUserId);

	/**
	 * Returns the at modifier user uuid of this adv task.
	 *
	 * @return the at modifier user uuid of this adv task
	 * @throws SystemException if a system exception occurred
	 */
	public String getAtModifierUserUuid() throws SystemException;

	/**
	 * Sets the at modifier user uuid of this adv task.
	 *
	 * @param atModifierUserUuid the at modifier user uuid of this adv task
	 */
	public void setAtModifierUserUuid(String atModifierUserUuid);

	/**
	 * Returns the at assigned to user ID of this adv task.
	 *
	 * @return the at assigned to user ID of this adv task
	 */
	public long getAtAssignedToUserId();

	/**
	 * Sets the at assigned to user ID of this adv task.
	 *
	 * @param atAssignedToUserId the at assigned to user ID of this adv task
	 */
	public void setAtAssignedToUserId(long atAssignedToUserId);

	/**
	 * Returns the at assigned to user uuid of this adv task.
	 *
	 * @return the at assigned to user uuid of this adv task
	 * @throws SystemException if a system exception occurred
	 */
	public String getAtAssignedToUserUuid() throws SystemException;

	/**
	 * Sets the at assigned to user uuid of this adv task.
	 *
	 * @param atAssignedToUserUuid the at assigned to user uuid of this adv task
	 */
	public void setAtAssignedToUserUuid(String atAssignedToUserUuid);

	/**
	 * Returns the at resolver user ID of this adv task.
	 *
	 * @return the at resolver user ID of this adv task
	 */
	public long getAtResolverUserId();

	/**
	 * Sets the at resolver user ID of this adv task.
	 *
	 * @param atResolverUserId the at resolver user ID of this adv task
	 */
	public void setAtResolverUserId(long atResolverUserId);

	/**
	 * Returns the at resolver user uuid of this adv task.
	 *
	 * @return the at resolver user uuid of this adv task
	 * @throws SystemException if a system exception occurred
	 */
	public String getAtResolverUserUuid() throws SystemException;

	/**
	 * Sets the at resolver user uuid of this adv task.
	 *
	 * @param atResolverUserUuid the at resolver user uuid of this adv task
	 */
	public void setAtResolverUserUuid(String atResolverUserUuid);

	/**
	 * Returns the at parent task ID of this adv task.
	 *
	 * @return the at parent task ID of this adv task
	 */
	public long getAtParentTaskId();

	/**
	 * Sets the at parent task ID of this adv task.
	 *
	 * @param atParentTaskId the at parent task ID of this adv task
	 */
	public void setAtParentTaskId(long atParentTaskId);

	/**
	 * Returns the status of this adv task.
	 *
	 * @return the status of this adv task
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this adv task.
	 *
	 * @param status the status of this adv task
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this adv task.
	 *
	 * @return the status by user ID of this adv task
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this adv task.
	 *
	 * @param statusByUserId the status by user ID of this adv task
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this adv task.
	 *
	 * @return the status by user uuid of this adv task
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getStatusByUserUuid() throws SystemException;

	/**
	 * Sets the status by user uuid of this adv task.
	 *
	 * @param statusByUserUuid the status by user uuid of this adv task
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this adv task.
	 *
	 * @return the status by user name of this adv task
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this adv task.
	 *
	 * @param statusByUserName the status by user name of this adv task
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this adv task.
	 *
	 * @return the status date of this adv task
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this adv task.
	 *
	 * @param statusDate the status date of this adv task
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	 */
	@Override
	public boolean getApproved();

	/**
	 * Returns <code>true</code> if this adv task is approved.
	 *
	 * @return <code>true</code> if this adv task is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this adv task is denied.
	 *
	 * @return <code>true</code> if this adv task is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this adv task is a draft.
	 *
	 * @return <code>true</code> if this adv task is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this adv task is expired.
	 *
	 * @return <code>true</code> if this adv task is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this adv task is inactive.
	 *
	 * @return <code>true</code> if this adv task is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this adv task is incomplete.
	 *
	 * @return <code>true</code> if this adv task is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this adv task is pending.
	 *
	 * @return <code>true</code> if this adv task is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this adv task is scheduled.
	 *
	 * @return <code>true</code> if this adv task is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(AdvTask advTask);

	@Override
	public int hashCode();

	@Override
	public CacheModel<AdvTask> toCacheModel();

	@Override
	public AdvTask toEscapedModel();

	@Override
	public AdvTask toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}