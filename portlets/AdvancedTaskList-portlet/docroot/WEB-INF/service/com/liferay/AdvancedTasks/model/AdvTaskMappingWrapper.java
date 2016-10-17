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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AdvTaskMapping}.
 * </p>
 *
 * @author David Proba
 * @see AdvTaskMapping
 * @generated
 */
public class AdvTaskMappingWrapper implements AdvTaskMapping,
	ModelWrapper<AdvTaskMapping> {
	public AdvTaskMappingWrapper(AdvTaskMapping advTaskMapping) {
		_advTaskMapping = advTaskMapping;
	}

	@Override
	public Class<?> getModelClass() {
		return AdvTaskMapping.class;
	}

	@Override
	public String getModelClassName() {
		return AdvTaskMapping.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("atMId", getAtMId());
		attributes.put("atMTaskId", getAtMTaskId());
		attributes.put("atMDependentFromId", getAtMDependentFromId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long atMId = (Long)attributes.get("atMId");

		if (atMId != null) {
			setAtMId(atMId);
		}

		Long atMTaskId = (Long)attributes.get("atMTaskId");

		if (atMTaskId != null) {
			setAtMTaskId(atMTaskId);
		}

		Long atMDependentFromId = (Long)attributes.get("atMDependentFromId");

		if (atMDependentFromId != null) {
			setAtMDependentFromId(atMDependentFromId);
		}
	}

	/**
	* Returns the primary key of this adv task mapping.
	*
	* @return the primary key of this adv task mapping
	*/
	@Override
	public long getPrimaryKey() {
		return _advTaskMapping.getPrimaryKey();
	}

	/**
	* Sets the primary key of this adv task mapping.
	*
	* @param primaryKey the primary key of this adv task mapping
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_advTaskMapping.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the at m ID of this adv task mapping.
	*
	* @return the at m ID of this adv task mapping
	*/
	@Override
	public long getAtMId() {
		return _advTaskMapping.getAtMId();
	}

	/**
	* Sets the at m ID of this adv task mapping.
	*
	* @param atMId the at m ID of this adv task mapping
	*/
	@Override
	public void setAtMId(long atMId) {
		_advTaskMapping.setAtMId(atMId);
	}

	/**
	* Returns the at m task ID of this adv task mapping.
	*
	* @return the at m task ID of this adv task mapping
	*/
	@Override
	public long getAtMTaskId() {
		return _advTaskMapping.getAtMTaskId();
	}

	/**
	* Sets the at m task ID of this adv task mapping.
	*
	* @param atMTaskId the at m task ID of this adv task mapping
	*/
	@Override
	public void setAtMTaskId(long atMTaskId) {
		_advTaskMapping.setAtMTaskId(atMTaskId);
	}

	/**
	* Returns the at m dependent from ID of this adv task mapping.
	*
	* @return the at m dependent from ID of this adv task mapping
	*/
	@Override
	public long getAtMDependentFromId() {
		return _advTaskMapping.getAtMDependentFromId();
	}

	/**
	* Sets the at m dependent from ID of this adv task mapping.
	*
	* @param atMDependentFromId the at m dependent from ID of this adv task mapping
	*/
	@Override
	public void setAtMDependentFromId(long atMDependentFromId) {
		_advTaskMapping.setAtMDependentFromId(atMDependentFromId);
	}

	@Override
	public boolean isNew() {
		return _advTaskMapping.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_advTaskMapping.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _advTaskMapping.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_advTaskMapping.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _advTaskMapping.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _advTaskMapping.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_advTaskMapping.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _advTaskMapping.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_advTaskMapping.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_advTaskMapping.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_advTaskMapping.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AdvTaskMappingWrapper((AdvTaskMapping)_advTaskMapping.clone());
	}

	@Override
	public int compareTo(
		com.liferay.AdvancedTasks.model.AdvTaskMapping advTaskMapping) {
		return _advTaskMapping.compareTo(advTaskMapping);
	}

	@Override
	public int hashCode() {
		return _advTaskMapping.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.AdvancedTasks.model.AdvTaskMapping> toCacheModel() {
		return _advTaskMapping.toCacheModel();
	}

	@Override
	public com.liferay.AdvancedTasks.model.AdvTaskMapping toEscapedModel() {
		return new AdvTaskMappingWrapper(_advTaskMapping.toEscapedModel());
	}

	@Override
	public com.liferay.AdvancedTasks.model.AdvTaskMapping toUnescapedModel() {
		return new AdvTaskMappingWrapper(_advTaskMapping.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _advTaskMapping.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _advTaskMapping.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_advTaskMapping.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdvTaskMappingWrapper)) {
			return false;
		}

		AdvTaskMappingWrapper advTaskMappingWrapper = (AdvTaskMappingWrapper)obj;

		if (Validator.equals(_advTaskMapping,
					advTaskMappingWrapper._advTaskMapping)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AdvTaskMapping getWrappedAdvTaskMapping() {
		return _advTaskMapping;
	}

	@Override
	public AdvTaskMapping getWrappedModel() {
		return _advTaskMapping;
	}

	@Override
	public void resetOriginalValues() {
		_advTaskMapping.resetOriginalValues();
	}

	private AdvTaskMapping _advTaskMapping;
}