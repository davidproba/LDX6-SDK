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

package com.liferay.sample.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.sample.service.http.BeaconDDLServiceSoap}.
 *
 * @author David Proba
 * @see com.liferay.sample.service.http.BeaconDDLServiceSoap
 * @generated
 */
public class BeaconDDLSoap implements Serializable {
	public static BeaconDDLSoap toSoapModel(BeaconDDL model) {
		BeaconDDLSoap soapModel = new BeaconDDLSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());

		return soapModel;
	}

	public static BeaconDDLSoap[] toSoapModels(BeaconDDL[] models) {
		BeaconDDLSoap[] soapModels = new BeaconDDLSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BeaconDDLSoap[][] toSoapModels(BeaconDDL[][] models) {
		BeaconDDLSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BeaconDDLSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BeaconDDLSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BeaconDDLSoap[] toSoapModels(List<BeaconDDL> models) {
		List<BeaconDDLSoap> soapModels = new ArrayList<BeaconDDLSoap>(models.size());

		for (BeaconDDL model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BeaconDDLSoap[soapModels.size()]);
	}

	public BeaconDDLSoap() {
	}

	public long getPrimaryKey() {
		return _Id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _Id;
	}

	public void setId(long Id) {
		_Id = Id;
	}

	private String _uuid;
	private long _Id;
}