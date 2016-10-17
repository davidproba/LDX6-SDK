package com.liferay.AdvancedTasks.notification;

import com.liferay.AdvancedTasks.model.AdvTask;
import com.liferay.AdvancedTasks.service.AdvTaskLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.compat.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.UserNotificationEvent;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.AssetRendererFactory;

public class AdvTaskUserNotificationHandler extends BaseUserNotificationHandler {
	
	public static final String TASKS = "ProjectTasks_WAR_AdvancedTaskListportlet";
	
	public AdvTaskUserNotificationHandler() {
		setPortletId(TASKS);
	}

	@Override
	protected String getBody(
			UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext)
		throws Exception {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
			userNotificationEvent.getPayload());

		long tasksEntryId = jsonObject.getLong("classPK");

		AdvTask tasksEntry = AdvTaskLocalServiceUtil.fetchAdvTask(tasksEntryId);

		if (tasksEntry == null) {
			UserNotificationEventLocalServiceUtil.deleteUserNotificationEvent(
				userNotificationEvent.getUserNotificationEventId());

			return null;
		}

		String title = serviceContext.translate(
			jsonObject.getString("title"),
			HtmlUtil.escape(
				PortalUtil.getUserName(
					jsonObject.getLong("userId"), StringPool.BLANK)));

		String groupName = "";
		groupName=(String)GroupLocalServiceUtil.getGroup(tasksEntry.getGroupId()).getDescriptiveName();
		return StringUtil.replace(getBodyTemplate(), new String[] {"[$BODY$]", "[$TITLE$]"},
			new String[] {
				HtmlUtil.escape(groupName + " - " + StringUtil.shorten(HtmlUtil.escape(tasksEntry.getAtTitle()))),
				title
			});
	}	

	@Override
	protected String getLink(
			UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext)
		throws Exception {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
			userNotificationEvent.getPayload());

		long tasksEntryId = jsonObject.getLong("classPK");

		AssetRendererFactory assetRendererFactory =
			AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(
				AdvTask.class.getName());

		AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(
			tasksEntryId);

		return assetRenderer.getURLViewInContext(
			serviceContext.getLiferayPortletRequest(),
			serviceContext.getLiferayPortletResponse(), null);
	}
	


}
