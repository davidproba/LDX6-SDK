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

package com.liferay.ldx6demo.teamsitewall.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Wallpost}.
 * </p>
 *
 * @author David Proba
 * @see Wallpost
 * @generated
 */
public class WallpostWrapper implements Wallpost, ModelWrapper<Wallpost> {
	public WallpostWrapper(Wallpost wallpost) {
		_wallpost = wallpost;
	}

	@Override
	public Class<?> getModelClass() {
		return Wallpost.class;
	}

	@Override
	public String getModelClassName() {
		return Wallpost.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("wallpostId", getWallpostId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("postMessage", getPostMessage());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userName", getUserName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long wallpostId = (Long)attributes.get("wallpostId");

		if (wallpostId != null) {
			setWallpostId(wallpostId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String postMessage = (String)attributes.get("postMessage");

		if (postMessage != null) {
			setPostMessage(postMessage);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}
	}

	/**
	* Returns the primary key of this wallpost.
	*
	* @return the primary key of this wallpost
	*/
	@Override
	public long getPrimaryKey() {
		return _wallpost.getPrimaryKey();
	}

	/**
	* Sets the primary key of this wallpost.
	*
	* @param primaryKey the primary key of this wallpost
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_wallpost.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this wallpost.
	*
	* @return the uuid of this wallpost
	*/
	@Override
	public java.lang.String getUuid() {
		return _wallpost.getUuid();
	}

	/**
	* Sets the uuid of this wallpost.
	*
	* @param uuid the uuid of this wallpost
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_wallpost.setUuid(uuid);
	}

	/**
	* Returns the wallpost ID of this wallpost.
	*
	* @return the wallpost ID of this wallpost
	*/
	@Override
	public long getWallpostId() {
		return _wallpost.getWallpostId();
	}

	/**
	* Sets the wallpost ID of this wallpost.
	*
	* @param wallpostId the wallpost ID of this wallpost
	*/
	@Override
	public void setWallpostId(long wallpostId) {
		_wallpost.setWallpostId(wallpostId);
	}

	/**
	* Returns the company ID of this wallpost.
	*
	* @return the company ID of this wallpost
	*/
	@Override
	public long getCompanyId() {
		return _wallpost.getCompanyId();
	}

	/**
	* Sets the company ID of this wallpost.
	*
	* @param companyId the company ID of this wallpost
	*/
	@Override
	public void setCompanyId(long companyId) {
		_wallpost.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this wallpost.
	*
	* @return the group ID of this wallpost
	*/
	@Override
	public long getGroupId() {
		return _wallpost.getGroupId();
	}

	/**
	* Sets the group ID of this wallpost.
	*
	* @param groupId the group ID of this wallpost
	*/
	@Override
	public void setGroupId(long groupId) {
		_wallpost.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this wallpost.
	*
	* @return the user ID of this wallpost
	*/
	@Override
	public long getUserId() {
		return _wallpost.getUserId();
	}

	/**
	* Sets the user ID of this wallpost.
	*
	* @param userId the user ID of this wallpost
	*/
	@Override
	public void setUserId(long userId) {
		_wallpost.setUserId(userId);
	}

	/**
	* Returns the user uuid of this wallpost.
	*
	* @return the user uuid of this wallpost
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wallpost.getUserUuid();
	}

	/**
	* Sets the user uuid of this wallpost.
	*
	* @param userUuid the user uuid of this wallpost
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_wallpost.setUserUuid(userUuid);
	}

	/**
	* Returns the post message of this wallpost.
	*
	* @return the post message of this wallpost
	*/
	@Override
	public java.lang.String getPostMessage() {
		return _wallpost.getPostMessage();
	}

	/**
	* Sets the post message of this wallpost.
	*
	* @param postMessage the post message of this wallpost
	*/
	@Override
	public void setPostMessage(java.lang.String postMessage) {
		_wallpost.setPostMessage(postMessage);
	}

	/**
	* Returns the status of this wallpost.
	*
	* @return the status of this wallpost
	*/
	@Override
	public int getStatus() {
		return _wallpost.getStatus();
	}

	/**
	* Sets the status of this wallpost.
	*
	* @param status the status of this wallpost
	*/
	@Override
	public void setStatus(int status) {
		_wallpost.setStatus(status);
	}

	/**
	* Returns the status by user ID of this wallpost.
	*
	* @return the status by user ID of this wallpost
	*/
	@Override
	public long getStatusByUserId() {
		return _wallpost.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this wallpost.
	*
	* @param statusByUserId the status by user ID of this wallpost
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_wallpost.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this wallpost.
	*
	* @return the status by user uuid of this wallpost
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wallpost.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this wallpost.
	*
	* @param statusByUserUuid the status by user uuid of this wallpost
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_wallpost.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this wallpost.
	*
	* @return the status by user name of this wallpost
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _wallpost.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this wallpost.
	*
	* @param statusByUserName the status by user name of this wallpost
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_wallpost.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this wallpost.
	*
	* @return the status date of this wallpost
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _wallpost.getStatusDate();
	}

	/**
	* Sets the status date of this wallpost.
	*
	* @param statusDate the status date of this wallpost
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_wallpost.setStatusDate(statusDate);
	}

	/**
	* Returns the create date of this wallpost.
	*
	* @return the create date of this wallpost
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _wallpost.getCreateDate();
	}

	/**
	* Sets the create date of this wallpost.
	*
	* @param createDate the create date of this wallpost
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_wallpost.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this wallpost.
	*
	* @return the modified date of this wallpost
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _wallpost.getModifiedDate();
	}

	/**
	* Sets the modified date of this wallpost.
	*
	* @param modifiedDate the modified date of this wallpost
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_wallpost.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user name of this wallpost.
	*
	* @return the user name of this wallpost
	*/
	@Override
	public java.lang.String getUserName() {
		return _wallpost.getUserName();
	}

	/**
	* Sets the user name of this wallpost.
	*
	* @param userName the user name of this wallpost
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_wallpost.setUserName(userName);
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _wallpost.getApproved();
	}

	/**
	* Returns <code>true</code> if this wallpost is approved.
	*
	* @return <code>true</code> if this wallpost is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _wallpost.isApproved();
	}

	/**
	* Returns <code>true</code> if this wallpost is denied.
	*
	* @return <code>true</code> if this wallpost is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _wallpost.isDenied();
	}

	/**
	* Returns <code>true</code> if this wallpost is a draft.
	*
	* @return <code>true</code> if this wallpost is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _wallpost.isDraft();
	}

	/**
	* Returns <code>true</code> if this wallpost is expired.
	*
	* @return <code>true</code> if this wallpost is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _wallpost.isExpired();
	}

	/**
	* Returns <code>true</code> if this wallpost is inactive.
	*
	* @return <code>true</code> if this wallpost is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _wallpost.isInactive();
	}

	/**
	* Returns <code>true</code> if this wallpost is incomplete.
	*
	* @return <code>true</code> if this wallpost is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _wallpost.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this wallpost is pending.
	*
	* @return <code>true</code> if this wallpost is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _wallpost.isPending();
	}

	/**
	* Returns <code>true</code> if this wallpost is scheduled.
	*
	* @return <code>true</code> if this wallpost is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _wallpost.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _wallpost.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_wallpost.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _wallpost.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wallpost.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _wallpost.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _wallpost.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_wallpost.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _wallpost.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_wallpost.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_wallpost.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_wallpost.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WallpostWrapper((Wallpost)_wallpost.clone());
	}

	@Override
	public int compareTo(
		com.liferay.ldx6demo.teamsitewall.model.Wallpost wallpost) {
		return _wallpost.compareTo(wallpost);
	}

	@Override
	public int hashCode() {
		return _wallpost.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.ldx6demo.teamsitewall.model.Wallpost> toCacheModel() {
		return _wallpost.toCacheModel();
	}

	@Override
	public com.liferay.ldx6demo.teamsitewall.model.Wallpost toEscapedModel() {
		return new WallpostWrapper(_wallpost.toEscapedModel());
	}

	@Override
	public com.liferay.ldx6demo.teamsitewall.model.Wallpost toUnescapedModel() {
		return new WallpostWrapper(_wallpost.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _wallpost.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wallpost.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_wallpost.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WallpostWrapper)) {
			return false;
		}

		WallpostWrapper wallpostWrapper = (WallpostWrapper)obj;

		if (Validator.equals(_wallpost, wallpostWrapper._wallpost)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _wallpost.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Wallpost getWrappedWallpost() {
		return _wallpost;
	}

	@Override
	public Wallpost getWrappedModel() {
		return _wallpost;
	}

	@Override
	public void resetOriginalValues() {
		_wallpost.resetOriginalValues();
	}

	private Wallpost _wallpost;
}