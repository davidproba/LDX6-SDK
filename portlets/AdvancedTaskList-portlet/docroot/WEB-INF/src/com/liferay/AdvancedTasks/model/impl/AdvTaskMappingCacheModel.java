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

package com.liferay.AdvancedTasks.model.impl;

import com.liferay.AdvancedTasks.model.AdvTaskMapping;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AdvTaskMapping in entity cache.
 *
 * @author David Proba
 * @see AdvTaskMapping
 * @generated
 */
public class AdvTaskMappingCacheModel implements CacheModel<AdvTaskMapping>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{atMId=");
		sb.append(atMId);
		sb.append(", atMTaskId=");
		sb.append(atMTaskId);
		sb.append(", atMDependentFromId=");
		sb.append(atMDependentFromId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AdvTaskMapping toEntityModel() {
		AdvTaskMappingImpl advTaskMappingImpl = new AdvTaskMappingImpl();

		advTaskMappingImpl.setAtMId(atMId);
		advTaskMappingImpl.setAtMTaskId(atMTaskId);
		advTaskMappingImpl.setAtMDependentFromId(atMDependentFromId);

		advTaskMappingImpl.resetOriginalValues();

		return advTaskMappingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		atMId = objectInput.readLong();
		atMTaskId = objectInput.readLong();
		atMDependentFromId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(atMId);
		objectOutput.writeLong(atMTaskId);
		objectOutput.writeLong(atMDependentFromId);
	}

	public long atMId;
	public long atMTaskId;
	public long atMDependentFromId;
}