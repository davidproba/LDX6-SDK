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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.model.SocialActivitySet;
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil;
import com.liferay.portlet.social.service.SocialActivitySetLocalServiceUtil;
import com.liferay.so.activities.util.SocialActivityKeyConstants;
import com.liferay.ldx6demo.teamsitewall.model.Wallpost;
import com.liferay.ldx6demo.teamsitewall.service.WallpostLocalServiceUtil;

import java.util.List;

/**
 * @author Evan Thibodeau
 * @author Matthew Kong
 */
public class WallpostActivityInterpreter extends SOSocialActivityInterpreter {

	public String[] getClassNames() {
		return _CLASS_NAMES;
	}

	public void updateActivitySet(long activityId)
		throws PortalException, SystemException {

		SocialActivity activity =
			SocialActivityLocalServiceUtil.fetchSocialActivity(activityId);

		if ((activity == null) || (activity.getActivitySetId() > 0)) {
			return;
		}

		long activitySetId = getActivitySetId(activityId);

		if (activitySetId > 0) {
			SocialActivitySetLocalServiceUtil.incrementActivityCount(
				activitySetId, activityId);
		}
		else {
			SocialActivitySet activitySet =
				SocialActivitySetLocalServiceUtil.addActivitySet(activityId);

			if ((activity.getType() ==
					SocialActivityKeyConstants.MB_ADD_MESSAGE) &&
				(activity.getReceiverUserId() > 0)) {

				activitySet.setType(
					SocialActivityKeyConstants.MB_REPLY_MESSAGE);

				SocialActivitySetLocalServiceUtil.updateSocialActivitySet(
					activitySet);
			}
		}
	}

	@Override
	protected long getActivitySetId(long activityId) {
		try {
			SocialActivity activity =
				SocialActivityLocalServiceUtil.getActivity(activityId);

			int activityType = activity.getType();

			if ((activity.getType() ==
					SocialActivityKeyConstants.MB_ADD_MESSAGE) &&
				(activity.getReceiverUserId() > 0)) {

				activityType = SocialActivityKeyConstants.MB_REPLY_MESSAGE;
			}

			SocialActivitySet activitySet = null;

			boolean comment = false;

			if (activityType == SocialActivityKeyConstants.MB_REPLY_MESSAGE) {
				activitySet =
					SocialActivitySetLocalServiceUtil.getClassActivitySet(
						activity.getClassNameId(), activity.getClassPK(),
						activity.getType());

				comment = true;
			}

			if ((activitySet != null) && !isExpired(activitySet, comment)) {
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
				SocialActivityKeyConstants.MB_REPLY_MESSAGE) {

			return getBody(
				activitySet.getClassName(), activitySet.getClassPK(),
				serviceContext);
		}

		return super.getBody(activitySet, serviceContext);
	}

	protected String getBody(
			String className, long classPK, ServiceContext serviceContext)
		throws Exception {

		StringBundler sb = new StringBundler(5);

/*		sb.append("<div class=\"activity-body\"><div class=\"title\">");
		sb.append(getPageTitle(className, classPK, serviceContext));
		sb.append("</div><div class=\"wallpost-page-content\">");
		sb.append("</div></div>");
*/
		return sb.toString();
	}

	@Override
	protected Object[] getTitleArguments(
			String groupName, SocialActivity activity, String link,
			String title, ServiceContext serviceContext)
		throws Exception {

		return null;
	}

	@Override
	protected Object[] getTitleArguments(
			String groupName, SocialActivitySet activitySet, String link,
			String title, ServiceContext serviceContext)
		throws Exception {

		if (activitySet.getType() ==
				SocialActivityKeyConstants.MB_REPLY_MESSAGE) {

			List<SocialActivity> activities =
				SocialActivityLocalServiceUtil.getActivitySetActivities(
					activitySet.getActivitySetId(), 0, 1);

			SocialActivity activity = activities.get(0);

			return getTitleArguments(
				groupName, activity, link, title, serviceContext);
		}

		return super.getTitleArguments(
			groupName, activitySet, link, title, serviceContext);
	}

	@Override
	protected String getTitlePattern(String groupName, SocialActivity activity)
		throws Exception {

		String titlePattern = StringPool.BLANK;
		
		Wallpost post = WallpostLocalServiceUtil.getWallpost(activity.getClassPK());
		titlePattern = post.getPostMessage();

		return titlePattern;
	}

	@Override
	protected String getTitlePattern(
			String groupName, SocialActivitySet activitySet)
		throws Exception {

		String titlePattern = StringPool.BLANK;
		
		Wallpost post = WallpostLocalServiceUtil.getWallpost(activitySet.getClassPK());
		titlePattern = post.getPostMessage();

		return titlePattern;
	}

	private static final String[] _CLASS_NAMES = {Wallpost.class.getName()};

}