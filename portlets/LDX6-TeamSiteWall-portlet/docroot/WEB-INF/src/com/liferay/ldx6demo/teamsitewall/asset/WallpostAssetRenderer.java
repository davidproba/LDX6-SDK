package com.liferay.ldx6demo.teamsitewall.asset;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.liferay.ldx6demo.teamsitewall.model.Wallpost;
import com.liferay.ldx6demo.teamsitewall.permission.WallpostPermission;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class WallpostAssetRenderer extends BaseAssetRenderer {

	private Wallpost _post;

	public WallpostAssetRenderer (Wallpost post) {
		_post = post;
	}
	
	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) {
		
		return WallpostPermission.contains(permissionChecker, _post,
				ActionKeys.UPDATE);
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) {
		
		return WallpostPermission.contains(permissionChecker, _post,
				ActionKeys.VIEW);
	}

	@Override
	public String getClassName() {
		return Wallpost.class.getName();
	}

	@Override
	public long getClassPK() {
		return _post.getPrimaryKey();
	}

	@Override
	public long getGroupId() {
		return _post.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return com.liferay.portal.kernel.util.HtmlUtil.escape(_post.getPostMessage());
	}

	@Override
	public String getTitle(Locale locale) {
		return StringUtil.shorten(_post.getPostMessage(), 50);
	}

	@Override
	public long getUserId() {
		return _post.getUserId();
	}

	@Override
	public String getUserName() {
		return _post.getUserName();
	}

	@Override
	public String getUuid() {
		return _post.getUuid();
	}
	
	@Override
    protected String getIconPath(ThemeDisplay themeDisplay) { 
        return themeDisplay.getURLPortal() + "/LDX6-TeamSiteWall-portlet/icon.png"; 
    }	

	@Override
	public String render(RenderRequest request, RenderResponse response, String template)
    throws Exception {
		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			request.setAttribute("WALLPOST ENTRY", _post);
			return "/html/wallpost/" + template + ".jsp";
		}	else {
			return null;
		}
	}
}
