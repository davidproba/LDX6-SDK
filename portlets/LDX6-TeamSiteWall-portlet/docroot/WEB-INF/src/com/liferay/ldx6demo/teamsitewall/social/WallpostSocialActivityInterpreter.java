package com.liferay.ldx6demo.teamsitewall.social;

import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.social.model.BaseSocialActivityInterpreter;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.model.SocialActivityFeedEntry;
import com.liferay.ldx6demo.teamsitewall.model.Wallpost;
import com.liferay.ldx6demo.teamsitewall.service.WallpostLocalServiceUtil;

public class WallpostSocialActivityInterpreter extends BaseSocialActivityInterpreter {
	@Override
	public String[] getClassNames() {
		return _CLASS_NAMES;
	}

	@Override
	protected SocialActivityFeedEntry doInterpret(
		SocialActivity activity, ServiceContext serviceContext)
		throws Exception {

		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		
		PermissionChecker permissionChecker =
			themeDisplay.getPermissionChecker();

		Wallpost post = WallpostLocalServiceUtil.getWallpost(activity.getClassPK());

		if (!permissionChecker.hasPermission(
			post.getGroupId(), Wallpost.class.getName(), post.getWallpostId(),
			ActionKeys.VIEW)) {
			return null;
		}

		String link = StringPool.BLANK;
		String key = "activity-post-add-post";
		String keyWithGroup = "activity-post-add-post-in";
		String title =
			getTitle(
				activity, key, keyWithGroup, post.getPostMessage(), link, serviceContext);
		String body = StringUtil.shorten(HtmlUtil.escape(post.getPostMessage()));

		return new SocialActivityFeedEntry(link, title, body);
	}

	protected String getTitle(
		SocialActivity activity, String key, String keyWithGroup,
		String content, String link, ServiceContext serviceContext) {

		String userName = getUserName(activity.getUserId(), serviceContext);
		String text =
			HtmlUtil.escape(StringUtil.shorten(
				HtmlUtil.extractText(content), 200));

		if (Validator.isNotNull(link)) {
			text = wrapLink(link, text);
		}

		String groupName = StringPool.BLANK;

		if (activity.getGroupId() != serviceContext.getScopeGroupId()) {
			groupName = getGroupName(activity.getGroupId(), serviceContext);
		}

		String pattern;

		if (Validator.isNotNull(groupName)) {
			pattern = keyWithGroup;
		}
		else {
			pattern = key;
		}

		return serviceContext.translate(pattern, new Object[] {
			userName, text, groupName
		});
	}

	private static final String[] _CLASS_NAMES = new String[] {
		Wallpost.class.getName()
	};
}
