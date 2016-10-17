/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.so.activities.hook.social;

import com.liferay.AdvancedTasks.model.AdvTask;
import com.liferay.AdvancedTasks.service.AdvTaskLocalServiceUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.model.SocialActivitySet;
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil;
import com.liferay.portlet.social.service.SocialActivitySetLocalServiceUtil;
import com.liferay.so.activities.util.SocialActivityKeyConstants;

import java.util.List;


/**
 * @author Matthew Kong
 */
public class AdvTasksActivityInterpreter extends SOSocialActivityInterpreter {

	public String[] getClassNames() {
		return _CLASS_NAMES;
	}

	@Override
	protected long getActivitySetId(long activityId) {
		try {
			SocialActivitySet activitySet = null;

			SocialActivity activity =
				SocialActivityLocalServiceUtil.getActivity(activityId);

			if (activity.getType() ==
					SocialActivityKeyConstants.TASKS_UPDATE_ENTRY) {

				activitySet =
					SocialActivitySetLocalServiceUtil.getClassActivitySet(
						activity.getUserId(), activity.getClassNameId(),
						activity.getClassPK(), activity.getType());
			}

			if ((activitySet != null) && !isExpired(activitySet, false)) {
				return activitySet.getActivitySetId();
			}
		}
		catch (Exception e) {
		}

		return 0;
	}

	@Override
	protected String getBody(
			SocialActivity activity, ServiceContext serviceContext)
		throws Exception {

		return getBody(
			activity.getClassName(), activity.getClassPK(), serviceContext);
	}

	@Override
	protected String getBody(
			SocialActivitySet activitySet, ServiceContext serviceContext)
		throws Exception {

		if (activitySet.getType() ==
				SocialActivityKeyConstants.TASKS_UPDATE_ENTRY) {

			return getBody(
				activitySet.getClassName(), activitySet.getClassPK(),
				serviceContext);
		}

		StringBundler sb = new StringBundler();

		sb.append("<div class=\"grouped-activity-body-container\">");
		sb.append("<div class=\"grouped-activity-body\">");

		List<SocialActivity> activities = getViewableActivities(
			activitySet, serviceContext);

		for (SocialActivity activity : activities) {
			sb.append("<div class=\"activity-subentry tasks\">");
			sb.append(
				getBody(
					activity.getClassName(), activity.getClassPK(),
					serviceContext));
			sb.append("</div>");
		}

		sb.append("</div></div>");

		return sb.toString();
	}

	protected String getBody(
			String className, long classPK, ServiceContext serviceContext)
		throws Exception {
		
		
		int sblength = 15;
		AdvTask tasksEntry = AdvTaskLocalServiceUtil.getAdvTask(
				classPK);
		String assigneeUserLink = "";
		
		if (tasksEntry.getAtAssignedToUserId() > 0) {
			sblength +=4;
			String assigneeDisplayURL = null;
			User assigneeUser = UserLocalServiceUtil.fetchUser(
				tasksEntry.getAtAssignedToUserId());
			if (assigneeUser != null) {
				assigneeDisplayURL = assigneeUser.getDisplayURL(
					serviceContext.getThemeDisplay());
			}
			assigneeUserLink = wrapLink(
				assigneeDisplayURL, tasksEntry.getAssigneeFullName());
		}

		StringBundler sb = new StringBundler(sblength);

		sb.append("<div class=\"activity-body-container\"><div class=\"activity-body\"><div class=\"title\">");
		sb.append(getPageTitle(className, classPK, serviceContext));
		sb.append("</div><div class=\"tasks-entry-content\"><div class=\"tasks-entry-deadline\"><strong>");
		sb.append(serviceContext.translate("tasks-finaldate"));
		sb.append(": </strong>");
		sb.append(tasksEntry.getAtFinalDate());
		sb.append("</div><div class=\"tasks-entry-status\"><strong>");
		sb.append(serviceContext.translate("tasks-status"));
		sb.append(": </strong>");
		sb.append(serviceContext.translate(tasksEntry.getStatusLabel()));
		sb.append("</div><div class=\"tasks-entry-prio\"><strong>");
		sb.append(serviceContext.translate("tasks-priority"));
		sb.append(": </strong>");
		sb.append(serviceContext.translate(tasksEntry.getPriorityLabel()));
		if (tasksEntry.getAtAssignedToUserId() > 0) {
			sb.append("</div><div class=\"tasks-entry-assigned\"><strong>");
			sb.append(serviceContext.translate("tasks-assignedto"));
			sb.append(": </strong>");
			sb.append(assigneeUserLink);
		}
		sb.append("</div></div></div></div>");
		


		return sb.toString();
	}

	@Override
	protected Object[] getTitleArguments(
			String groupName, SocialActivity activity, String link,
			String title, ServiceContext serviceContext)
		throws Exception {

		if ((activity.getReceiverUserId() <= 0) ||
			(activity.getUserId() == activity.getReceiverUserId())) {

			return null;
		}

		String receiverUserName = getUserName(
			activity.getReceiverUserId(), serviceContext);

		return new Object[] {receiverUserName};
	}

	@Override
	protected String getTitlePattern(
		String groupName, SocialActivity activity) {

		String titlePattern = null;

		if (activity.getType() == SocialActivityKeyConstants.TASKS_ADD_ENTRY) {
			titlePattern = "created-a-new-task";
		}
		else if (activity.getType() ==
					SocialActivityKeyConstants.TASKS_REOPEN_ENTRY) {

			titlePattern = "reopened-a-task";
		}
		else if (activity.getType() ==
					SocialActivityKeyConstants.TASKS_RESOLVE_ENTRY) {

			titlePattern = "resolved-a-task";
		}
		else if (activity.getType() ==
					SocialActivityKeyConstants.TASKS_UPDATE_ENTRY) {

			titlePattern = "updated-a-task";
		}
		else {
			return StringPool.BLANK;
		}

		if ((activity.getReceiverUserId() > 0) &&
			(activity.getUserId() != activity.getReceiverUserId())) {

			titlePattern = titlePattern.concat("-for");
		}

		return titlePattern;
	}
	
	@Override
	protected String getTitlePattern(
		String groupName, SocialActivitySet activitySet) {

		if (activitySet.getType() ==
				SocialActivityKeyConstants.TASKS_ADD_ENTRY) {

			return "created-x-new-tasks";
		}
		else if (activitySet.getType() ==
					SocialActivityKeyConstants.TASKS_REOPEN_ENTRY) {

			return "reopened-x-tasks";
		}
		else if (activitySet.getType() ==
					SocialActivityKeyConstants.TASKS_RESOLVE_ENTRY) {

			return "resolved-x-tasks";
		}
		else if (activitySet.getType() ==
					SocialActivityKeyConstants.TASKS_UPDATE_ENTRY) {

			return "made-x-updates-to-a-task";
		}

		return StringPool.BLANK;
	}

	private static final String[] _CLASS_NAMES = {AdvTask.class.getName()};

}