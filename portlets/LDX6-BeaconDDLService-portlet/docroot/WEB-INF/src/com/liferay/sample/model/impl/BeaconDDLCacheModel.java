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

package com.liferay.sample.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.sample.model.BeaconDDL;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BeaconDDL in entity cache.
 *
 * @author David Proba
 * @see BeaconDDL
 * @generated
 */
public class BeaconDDLCacheModel implements CacheModel<BeaconDDL>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", Id=");
		sb.append(Id);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BeaconDDL toEntityModel() {
		BeaconDDLImpl beaconDDLImpl = new BeaconDDLImpl();

		if (uuid == null) {
			beaconDDLImpl.setUuid(StringPool.BLANK);
		}
		else {
			beaconDDLImpl.setUuid(uuid);
		}

		beaconDDLImpl.setId(Id);

		beaconDDLImpl.resetOriginalValues();

		return beaconDDLImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		Id = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(Id);
	}

	public String uuid;
	public long Id;
}