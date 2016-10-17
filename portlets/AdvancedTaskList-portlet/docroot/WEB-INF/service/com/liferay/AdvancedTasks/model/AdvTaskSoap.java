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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author David Proba
 * @generated
 */
public class AdvTaskSoap implements Serializable {
	public static AdvTaskSoap toSoapModel(AdvTask model) {
		AdvTaskSoap soapModel = new AdvTaskSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAtId(model.getAtId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAtTitle(model.getAtTitle());
		soapModel.setAtDescription(model.getAtDescription());
		soapModel.setAtStartDate(model.getAtStartDate());
		soapModel.setAtFinalDate(model.getAtFinalDate());
		soapModel.setAtPriority(model.getAtPriority());
		soapModel.setAtStatus(model.getAtStatus());
		soapModel.setAtModifierUserId(model.getAtModifierUserId());
		soapModel.setAtAssignedToUserId(model.getAtAssignedToUserId());
		soapModel.setAtResolverUserId(model.getAtResolverUserId());
		soapModel.setAtParentTaskId(model.getAtParentTaskId());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static AdvTaskSoap[] toSoapModels(AdvTask[] models) {
		AdvTaskSoap[] soapModels = new AdvTaskSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AdvTaskSoap[][] toSoapModels(AdvTask[][] models) {
		AdvTaskSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AdvTaskSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AdvTaskSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AdvTaskSoap[] toSoapModels(List<AdvTask> models) {
		List<AdvTaskSoap> soapModels = new ArrayList<AdvTaskSoap>(models.size());

		for (AdvTask model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AdvTaskSoap[soapModels.size()]);
	}

	public AdvTaskSoap() {
	}

	public long getPrimaryKey() {
		return _atId;
	}

	public void setPrimaryKey(long pk) {
		setAtId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAtId() {
		return _atId;
	}

	public void setAtId(long atId) {
		_atId = atId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getAtTitle() {
		return _atTitle;
	}

	public void setAtTitle(String atTitle) {
		_atTitle = atTitle;
	}

	public String getAtDescription() {
		return _atDescription;
	}

	public void setAtDescription(String atDescription) {
		_atDescription = atDescription;
	}

	public Date getAtStartDate() {
		return _atStartDate;
	}

	public void setAtStartDate(Date atStartDate) {
		_atStartDate = atStartDate;
	}

	public Date getAtFinalDate() {
		return _atFinalDate;
	}

	public void setAtFinalDate(Date atFinalDate) {
		_atFinalDate = atFinalDate;
	}

	public int getAtPriority() {
		return _atPriority;
	}

	public void setAtPriority(int atPriority) {
		_atPriority = atPriority;
	}

	public int getAtStatus() {
		return _atStatus;
	}

	public void setAtStatus(int atStatus) {
		_atStatus = atStatus;
	}

	public long getAtModifierUserId() {
		return _atModifierUserId;
	}

	public void setAtModifierUserId(long atModifierUserId) {
		_atModifierUserId = atModifierUserId;
	}

	public long getAtAssignedToUserId() {
		return _atAssignedToUserId;
	}

	public void setAtAssignedToUserId(long atAssignedToUserId) {
		_atAssignedToUserId = atAssignedToUserId;
	}

	public long getAtResolverUserId() {
		return _atResolverUserId;
	}

	public void setAtResolverUserId(long atResolverUserId) {
		_atResolverUserId = atResolverUserId;
	}

	public long getAtParentTaskId() {
		return _atParentTaskId;
	}

	public void setAtParentTaskId(long atParentTaskId) {
		_atParentTaskId = atParentTaskId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	private String _uuid;
	private long _atId;
	private long _groupId;
	private long _companyId;
	private long _userId;
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
	private long _atAssignedToUserId;
	private long _atResolverUserId;
	private long _atParentTaskId;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
}