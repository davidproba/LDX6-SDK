package com.liferay.AdvancedTasks.asset;

import com.liferay.AdvancedTasks.model.AdvTask;
import com.liferay.AdvancedTasks.permission.AdvTaskPermission;
import com.liferay.AdvancedTasks.util.PortletKeys;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class AdvTaskAssetRenderer extends BaseAssetRenderer {

	private AdvTask _task;

	public AdvTaskAssetRenderer (AdvTask task) {
		_task = task;
	}
	
	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) {
		
		return AdvTaskPermission.contains(permissionChecker, _task,
				ActionKeys.UPDATE);
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) {
		
		return AdvTaskPermission.contains(permissionChecker, _task,
				ActionKeys.VIEW);
	}

	@Override
	public String getClassName() {
		return AdvTask.class.getName();
	}

	@Override
	public long getClassPK() {
		return _task.getPrimaryKey();
	}

	@Override
	public long getGroupId() {
		return _task.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return com.liferay.portal.kernel.util.HtmlUtil.escape(_task.getAtDescription());
	}

	@Override
	public String getTitle(Locale locale) {
		return StringUtil.shorten(_task.getAtTitle(), 50);
	}

	@Override
	public long getUserId() {
		return _task.getUserId();
	}

	@Override
	public String getUserName() {
		return _task.getUserName();
	}

	@Override
	public String getUuid() {
		return _task.getUuid();
	}
	
	@Override
    protected String getIconPath(ThemeDisplay themeDisplay) { 
        return themeDisplay.getURLPortal() + "/AdvancedTaskList-portlet/icon.png"; 
    }	

	@Override
	public String getURLViewInContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		String noSuchEntryRedirect) {

		try {
			long plid = PortalUtil.getPlidFromPortletId(_task.getGroupId(), PortletKeys.ADVTASKS);
			PortletURL portletURL = PortletURLFactoryUtil.create(liferayPortletRequest, PortletKeys.ADVTASKS, plid, PortletRequest.RENDER_PHASE);
			portletURL.setParameter("mvcPath", "/html/ProjectTasks/view_task.jsp");
			portletURL.setParameter("taskId", Long.toString(_task.getAtId())); 
			
			return portletURL.toString();
		}
		catch (Exception e) {
		}

		return null;
	}
	
	
	@Override
	public String render(RenderRequest request, RenderResponse response, String template)
    throws Exception {
		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			request.setAttribute("TASK ENTRY", _task);
			return "/html/ProjectTasks/" + template + ".jsp";
		}	else {
			return null;
		}
	}
}
