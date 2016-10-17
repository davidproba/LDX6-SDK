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

package com.liferay.ldx6demo.teamsitewall.model.impl;

import com.liferay.ldx6demo.teamsitewall.model.Wallpost;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Wallpost in entity cache.
 *
 * @author David Proba
 * @see Wallpost
 * @generated
 */
public class WallpostCacheModel implements CacheModel<Wallpost>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", wallpostId=");
		sb.append(wallpostId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", postMessage=");
		sb.append(postMessage);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userName=");
		sb.append(userName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Wallpost toEntityModel() {
		WallpostImpl wallpostImpl = new WallpostImpl();

		if (uuid == null) {
			wallpostImpl.setUuid(StringPool.BLANK);
		}
		else {
			wallpostImpl.setUuid(uuid);
		}

		wallpostImpl.setWallpostId(wallpostId);
		wallpostImpl.setCompanyId(companyId);
		wallpostImpl.setGroupId(groupId);
		wallpostImpl.setUserId(userId);

		if (postMessage == null) {
			wallpostImpl.setPostMessage(StringPool.BLANK);
		}
		else {
			wallpostImpl.setPostMessage(postMessage);
		}

		wallpostImpl.setStatus(status);
		wallpostImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			wallpostImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			wallpostImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			wallpostImpl.setStatusDate(null);
		}
		else {
			wallpostImpl.setStatusDate(new Date(statusDate));
		}

		if (createDate == Long.MIN_VALUE) {
			wallpostImpl.setCreateDate(null);
		}
		else {
			wallpostImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wallpostImpl.setModifiedDate(null);
		}
		else {
			wallpostImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (userName == null) {
			wallpostImpl.setUserName(StringPool.BLANK);
		}
		else {
			wallpostImpl.setUserName(userName);
		}

		wallpostImpl.resetOriginalValues();

		return wallpostImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		wallpostId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		postMessage = objectInput.readUTF();
		status = objectInput.readInt();
		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userName = objectInput.readUTF();
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

		objectOutput.writeLong(wallpostId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (postMessage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postMessage);
		}

		objectOutput.writeInt(status);
		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}
	}

	public String uuid;
	public long wallpostId;
	public long companyId;
	public long groupId;
	public long userId;
	public String postMessage;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long createDate;
	public long modifiedDate;
	public String userName;
}