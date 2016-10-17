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

import com.liferay.AdvancedTasks.model.AdvTask;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AdvTask in entity cache.
 *
 * @author David Proba
 * @see AdvTask
 * @generated
 */
public class AdvTaskCacheModel implements CacheModel<AdvTask>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", atId=");
		sb.append(atId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", atTitle=");
		sb.append(atTitle);
		sb.append(", atDescription=");
		sb.append(atDescription);
		sb.append(", atStartDate=");
		sb.append(atStartDate);
		sb.append(", atFinalDate=");
		sb.append(atFinalDate);
		sb.append(", atPriority=");
		sb.append(atPriority);
		sb.append(", atStatus=");
		sb.append(atStatus);
		sb.append(", atModifierUserId=");
		sb.append(atModifierUserId);
		sb.append(", atAssignedToUserId=");
		sb.append(atAssignedToUserId);
		sb.append(", atResolverUserId=");
		sb.append(atResolverUserId);
		sb.append(", atParentTaskId=");
		sb.append(atParentTaskId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AdvTask toEntityModel() {
		AdvTaskImpl advTaskImpl = new AdvTaskImpl();

		if (uuid == null) {
			advTaskImpl.setUuid(StringPool.BLANK);
		}
		else {
			advTaskImpl.setUuid(uuid);
		}

		advTaskImpl.setAtId(atId);
		advTaskImpl.setGroupId(groupId);
		advTaskImpl.setCompanyId(companyId);
		advTaskImpl.setUserId(userId);

		if (userName == null) {
			advTaskImpl.setUserName(StringPool.BLANK);
		}
		else {
			advTaskImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			advTaskImpl.setCreateDate(null);
		}
		else {
			advTaskImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			advTaskImpl.setModifiedDate(null);
		}
		else {
			advTaskImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (atTitle == null) {
			advTaskImpl.setAtTitle(StringPool.BLANK);
		}
		else {
			advTaskImpl.setAtTitle(atTitle);
		}

		if (atDescription == null) {
			advTaskImpl.setAtDescription(StringPool.BLANK);
		}
		else {
			advTaskImpl.setAtDescription(atDescription);
		}

		if (atStartDate == Long.MIN_VALUE) {
			advTaskImpl.setAtStartDate(null);
		}
		else {
			advTaskImpl.setAtStartDate(new Date(atStartDate));
		}

		if (atFinalDate == Long.MIN_VALUE) {
			advTaskImpl.setAtFinalDate(null);
		}
		else {
			advTaskImpl.setAtFinalDate(new Date(atFinalDate));
		}

		advTaskImpl.setAtPriority(atPriority);
		advTaskImpl.setAtStatus(atStatus);
		advTaskImpl.setAtModifierUserId(atModifierUserId);
		advTaskImpl.setAtAssignedToUserId(atAssignedToUserId);
		advTaskImpl.setAtResolverUserId(atResolverUserId);
		advTaskImpl.setAtParentTaskId(atParentTaskId);
		advTaskImpl.setStatus(status);
		advTaskImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			advTaskImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			advTaskImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			advTaskImpl.setStatusDate(null);
		}
		else {
			advTaskImpl.setStatusDate(new Date(statusDate));
		}

		advTaskImpl.resetOriginalValues();

		return advTaskImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		atId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		atTitle = objectInput.readUTF();
		atDescription = objectInput.readUTF();
		atStartDate = objectInput.readLong();
		atFinalDate = objectInput.readLong();
		atPriority = objectInput.readInt();
		atStatus = objectInput.readInt();
		atModifierUserId = objectInput.readLong();
		atAssignedToUserId = objectInput.readLong();
		atResolverUserId = objectInput.readLong();
		atParentTaskId = objectInput.readLong();
		status = objectInput.readInt();
		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
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

		objectOutput.writeLong(atId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (atTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(atTitle);
		}

		if (atDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(atDescription);
		}

		objectOutput.writeLong(atStartDate);
		objectOutput.writeLong(atFinalDate);
		objectOutput.writeInt(atPriority);
		objectOutput.writeInt(atStatus);
		objectOutput.writeLong(atModifierUserId);
		objectOutput.writeLong(atAssignedToUserId);
		objectOutput.writeLong(atResolverUserId);
		objectOutput.writeLong(atParentTaskId);
		objectOutput.writeInt(status);
		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long atId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String atTitle;
	public String atDescription;
	public long atStartDate;
	public long atFinalDate;
	public int atPriority;
	public int atStatus;
	public long atModifierUserId;
	public long atAssignedToUserId;
	public long atResolverUserId;
	public long atParentTaskId;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
}