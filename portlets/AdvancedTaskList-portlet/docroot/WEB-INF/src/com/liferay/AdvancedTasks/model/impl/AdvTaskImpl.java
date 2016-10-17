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

import com.liferay.AdvancedTasks.Handler.TaskConstants;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The extended model implementation for the AdvTask service. Represents a row in the &quot;AdvancedTasks_AdvTask&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.AdvancedTasks.model.AdvTask} interface.
 * </p>
 *
 * @author David Proba
 */
public class AdvTaskImpl extends AdvTaskBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a adv task model instance should use the {@link com.liferay.AdvancedTasks.model.AdvTask} interface instead.
	 */
	public AdvTaskImpl() {
	}
	
	public String getAssigneeFullName() {
		return getUserFullName(getAtAssignedToUserId());
	}

	public String getPriorityLabel() {
		if (getAtPriority() == TaskConstants.PRIO_HIGH) {
			return TaskConstants.LABEL_PRIO_HIGH;
		}
		else if (getAtPriority() == TaskConstants.PRIO_LOW) {
			return TaskConstants.LABEL_PRIO_LOW;
		}
		else if (getAtPriority() == TaskConstants.PRIO_NORMAL) {
			return TaskConstants.LABEL_PRIO_NORMAL;
		}
		else {
			return null;
		}
	}

	public String getReporterFullName() {
		return getUserFullName(getUserId());
	}

	public String getStatusLabel() {
		if (getAtStatus() == TaskConstants.STATUS_BEGINN) {
			return TaskConstants.LABEL_STATUS_BEGINN;
		}
		else if (getAtStatus() == TaskConstants.STATUS_20) {
			return TaskConstants.LABEL_STATUS_20;
		}
		else if (getAtStatus() == TaskConstants.STATUS_40) {
			return TaskConstants.LABEL_STATUS_40;
		}
		else if (getAtStatus() == TaskConstants.STATUS_60) {
			return TaskConstants.LABEL_STATUS_60;
		}
		else if (getAtStatus() == TaskConstants.STATUS_80) {
			return TaskConstants.LABEL_STATUS_80;
		}
		else if (getAtStatus() == TaskConstants.STATUS_100) {
			return TaskConstants.LABEL_STATUS_100;
		}
		else if (getAtStatus() == TaskConstants.STATUS_REOPEN) {
			return TaskConstants.LABEL_STATUS_REOPEN;
		}
		else {
			return null;
		}
	}

	protected String getUserFullName(long userId) {
		String fullName = StringPool.BLANK;

		try {
			User user = UserLocalServiceUtil.getUser(userId);

			fullName = user.getFullName();
		}
		catch (Exception e) {
		}

		return fullName;
	}
	
}