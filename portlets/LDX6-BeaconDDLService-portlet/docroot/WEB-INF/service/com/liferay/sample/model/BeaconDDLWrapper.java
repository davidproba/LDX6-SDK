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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BeaconDDL}.
 * </p>
 *
 * @author David Proba
 * @see BeaconDDL
 * @generated
 */
public class BeaconDDLWrapper implements BeaconDDL, ModelWrapper<BeaconDDL> {
	public BeaconDDLWrapper(BeaconDDL beaconDDL) {
		_beaconDDL = beaconDDL;
	}

	@Override
	public Class<?> getModelClass() {
		return BeaconDDL.class;
	}

	@Override
	public String getModelClassName() {
		return BeaconDDL.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("Id", getId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long Id = (Long)attributes.get("Id");

		if (Id != null) {
			setId(Id);
		}
	}

	/**
	* Returns the primary key of this beacon d d l.
	*
	* @return the primary key of this beacon d d l
	*/
	@Override
	public long getPrimaryKey() {
		return _beaconDDL.getPrimaryKey();
	}

	/**
	* Sets the primary key of this beacon d d l.
	*
	* @param primaryKey the primary key of this beacon d d l
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_beaconDDL.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this beacon d d l.
	*
	* @return the uuid of this beacon d d l
	*/
	@Override
	public java.lang.String getUuid() {
		return _beaconDDL.getUuid();
	}

	/**
	* Sets the uuid of this beacon d d l.
	*
	* @param uuid the uuid of this beacon d d l
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_beaconDDL.setUuid(uuid);
	}

	/**
	* Returns the ID of this beacon d d l.
	*
	* @return the ID of this beacon d d l
	*/
	@Override
	public long getId() {
		return _beaconDDL.getId();
	}

	/**
	* Sets the ID of this beacon d d l.
	*
	* @param Id the ID of this beacon d d l
	*/
	@Override
	public void setId(long Id) {
		_beaconDDL.setId(Id);
	}

	@Override
	public boolean isNew() {
		return _beaconDDL.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_beaconDDL.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _beaconDDL.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_beaconDDL.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _beaconDDL.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _beaconDDL.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_beaconDDL.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _beaconDDL.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_beaconDDL.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_beaconDDL.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_beaconDDL.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BeaconDDLWrapper((BeaconDDL)_beaconDDL.clone());
	}

	@Override
	public int compareTo(com.liferay.sample.model.BeaconDDL beaconDDL) {
		return _beaconDDL.compareTo(beaconDDL);
	}

	@Override
	public int hashCode() {
		return _beaconDDL.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.sample.model.BeaconDDL> toCacheModel() {
		return _beaconDDL.toCacheModel();
	}

	@Override
	public com.liferay.sample.model.BeaconDDL toEscapedModel() {
		return new BeaconDDLWrapper(_beaconDDL.toEscapedModel());
	}

	@Override
	public com.liferay.sample.model.BeaconDDL toUnescapedModel() {
		return new BeaconDDLWrapper(_beaconDDL.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _beaconDDL.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _beaconDDL.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_beaconDDL.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BeaconDDLWrapper)) {
			return false;
		}

		BeaconDDLWrapper beaconDDLWrapper = (BeaconDDLWrapper)obj;

		if (Validator.equals(_beaconDDL, beaconDDLWrapper._beaconDDL)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BeaconDDL getWrappedBeaconDDL() {
		return _beaconDDL;
	}

	@Override
	public BeaconDDL getWrappedModel() {
		return _beaconDDL;
	}

	@Override
	public void resetOriginalValues() {
		_beaconDDL.resetOriginalValues();
	}

	private BeaconDDL _beaconDDL;
}