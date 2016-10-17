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

import com.liferay.AdvancedTasks.service.AdvTaskMappingLocalServiceUtil;
import com.liferay.AdvancedTasks.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author David Proba
 */
public class AdvTaskMappingClp extends BaseModelImpl<AdvTaskMapping>
	implements AdvTaskMapping {
	public AdvTaskMappingClp() {
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
	public long getPrimaryKey() {
		return _atMId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAtMId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _atMId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getAtMId() {
		return _atMId;
	}

	@Override
	public void setAtMId(long atMId) {
		_atMId = atMId;

		if (_advTaskMappingRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setAtMId", long.class);

				method.invoke(_advTaskMappingRemoteModel, atMId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAtMTaskId() {
		return _atMTaskId;
	}

	@Override
	public void setAtMTaskId(long atMTaskId) {
		_atMTaskId = atMTaskId;

		if (_advTaskMappingRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setAtMTaskId", long.class);

				method.invoke(_advTaskMappingRemoteModel, atMTaskId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAtMDependentFromId() {
		return _atMDependentFromId;
	}

	@Override
	public void setAtMDependentFromId(long atMDependentFromId) {
		_atMDependentFromId = atMDependentFromId;

		if (_advTaskMappingRemoteModel != null) {
			try {
				Class<?> clazz = _advTaskMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setAtMDependentFromId",
						long.class);

				method.invoke(_advTaskMappingRemoteModel, atMDependentFromId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAdvTaskMappingRemoteModel() {
		return _advTaskMappingRemoteModel;
	}

	public void setAdvTaskMappingRemoteModel(
		BaseModel<?> advTaskMappingRemoteModel) {
		_advTaskMappingRemoteModel = advTaskMappingRemoteModel;
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

		Class<?> remoteModelClass = _advTaskMappingRemoteModel.getClass();

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

		Object returnValue = method.invoke(_advTaskMappingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AdvTaskMappingLocalServiceUtil.addAdvTaskMapping(this);
		}
		else {
			AdvTaskMappingLocalServiceUtil.updateAdvTaskMapping(this);
		}
	}

	@Override
	public AdvTaskMapping toEscapedModel() {
		return (AdvTaskMapping)ProxyUtil.newProxyInstance(AdvTaskMapping.class.getClassLoader(),
			new Class[] { AdvTaskMapping.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AdvTaskMappingClp clone = new AdvTaskMappingClp();

		clone.setAtMId(getAtMId());
		clone.setAtMTaskId(getAtMTaskId());
		clone.setAtMDependentFromId(getAtMDependentFromId());

		return clone;
	}

	@Override
	public int compareTo(AdvTaskMapping advTaskMapping) {
		long primaryKey = advTaskMapping.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdvTaskMappingClp)) {
			return false;
		}

		AdvTaskMappingClp advTaskMapping = (AdvTaskMappingClp)obj;

		long primaryKey = advTaskMapping.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{atMId=");
		sb.append(getAtMId());
		sb.append(", atMTaskId=");
		sb.append(getAtMTaskId());
		sb.append(", atMDependentFromId=");
		sb.append(getAtMDependentFromId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.liferay.AdvancedTasks.model.AdvTaskMapping");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>atMId</column-name><column-value><![CDATA[");
		sb.append(getAtMId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>atMTaskId</column-name><column-value><![CDATA[");
		sb.append(getAtMTaskId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>atMDependentFromId</column-name><column-value><![CDATA[");
		sb.append(getAtMDependentFromId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _atMId;
	private long _atMTaskId;
	private long _atMDependentFromId;
	private BaseModel<?> _advTaskMappingRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.AdvancedTasks.service.ClpSerializer.class;
}