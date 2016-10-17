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
public class WallpostSoap implements Serializable {
	public static WallpostSoap toSoapModel(Wallpost model) {
		WallpostSoap soapModel = new WallpostSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setWallpostId(model.getWallpostId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setPostMessage(model.getPostMessage());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserName(model.getUserName());

		return soapModel;
	}

	public static WallpostSoap[] toSoapModels(Wallpost[] models) {
		WallpostSoap[] soapModels = new WallpostSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WallpostSoap[][] toSoapModels(Wallpost[][] models) {
		WallpostSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WallpostSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WallpostSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WallpostSoap[] toSoapModels(List<Wallpost> models) {
		List<WallpostSoap> soapModels = new ArrayList<WallpostSoap>(models.size());

		for (Wallpost model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WallpostSoap[soapModels.size()]);
	}

	public WallpostSoap() {
	}

	public long getPrimaryKey() {
		return _wallpostId;
	}

	public void setPrimaryKey(long pk) {
		setWallpostId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getWallpostId() {
		return _wallpostId;
	}

	public void setWallpostId(long wallpostId) {
		_wallpostId = wallpostId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getPostMessage() {
		return _postMessage;
	}

	public void setPostMessage(String postMessage) {
		_postMessage = postMessage;
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

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	private String _uuid;
	private long _wallpostId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _postMessage;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private Date _createDate;
	private Date _modifiedDate;
	private String _userName;
}