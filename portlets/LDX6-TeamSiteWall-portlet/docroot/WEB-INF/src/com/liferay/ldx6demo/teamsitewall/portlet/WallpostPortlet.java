package com.liferay.ldx6demo.teamsitewall.portlet;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.ldx6demo.teamsitewall.model.Wallpost;
import com.liferay.ldx6demo.teamsitewall.service.WallpostLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class WallpostPortlet
 */
public class WallpostPortlet extends MVCPortlet {
	
	public void addWallpost(ActionRequest request, ActionResponse response)
			throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();

		if (themeDisplay.getPermissionChecker()
				.hasPermission(groupId, "com.liferay.ldx6demo.teamsitewall.model",
						groupId, "ADD_POST")) {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Wallpost.class.getName(), request);
			WallpostLocalServiceUtil.addWallpost(ParamUtil.getString(request, "post"), serviceContext);

			sendRedirect(request, response);
			
		}
		
	}

}
