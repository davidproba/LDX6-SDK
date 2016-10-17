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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author David Proba
 * @generated
 */
public class AdvTaskMappingSoap implements Serializable {
	public static AdvTaskMappingSoap toSoapModel(AdvTaskMapping model) {
		AdvTaskMappingSoap soapModel = new AdvTaskMappingSoap();

		soapModel.setAtMId(model.getAtMId());
		soapModel.setAtMTaskId(model.getAtMTaskId());
		soapModel.setAtMDependentFromId(model.getAtMDependentFromId());

		return soapModel;
	}

	public static AdvTaskMappingSoap[] toSoapModels(AdvTaskMapping[] models) {
		AdvTaskMappingSoap[] soapModels = new AdvTaskMappingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AdvTaskMappingSoap[][] toSoapModels(AdvTaskMapping[][] models) {
		AdvTaskMappingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AdvTaskMappingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AdvTaskMappingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AdvTaskMappingSoap[] toSoapModels(List<AdvTaskMapping> models) {
		List<AdvTaskMappingSoap> soapModels = new ArrayList<AdvTaskMappingSoap>(models.size());

		for (AdvTaskMapping model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AdvTaskMappingSoap[soapModels.size()]);
	}

	public AdvTaskMappingSoap() {
	}

	public long getPrimaryKey() {
		return _atMId;
	}

	public void setPrimaryKey(long pk) {
		setAtMId(pk);
	}

	public long getAtMId() {
		return _atMId;
	}

	public void setAtMId(long atMId) {
		_atMId = atMId;
	}

	public long getAtMTaskId() {
		return _atMTaskId;
	}

	public void setAtMTaskId(long atMTaskId) {
		_atMTaskId = atMTaskId;
	}

	public long getAtMDependentFromId() {
		return _atMDependentFromId;
	}

	public void setAtMDependentFromId(long atMDependentFromId) {
		_atMDependentFromId = atMDependentFromId;
	}

	private long _atMId;
	private long _atMTaskId;
	private long _atMDependentFromId;
}