package com.liferay.ldx6demo.hook;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.template.StringTemplateResource;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.NavItem;
import com.liferay.portal.theme.ThemeDisplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlobalNavigationServicePreAction extends Action {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response)
			throws ActionException {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		Group base;

		try {
			base = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "LDX Intranet");
			List<Layout> layoutSet = LayoutLocalServiceUtil.getLayouts(base.getGroupId(), false);
			List<Layout> publicNonHiddenLayouts = new ArrayList<Layout>(layoutSet.size());

			for(Layout layout:layoutSet) {
			    if(!layout.isHidden() && layout.getParentLayoutId()==0) {
			    		publicNonHiddenLayouts.add(layout);
			    }
			}

			TemplateResource templateResource = new StringTemplateResource("0", "#Placeholder");
			Template template = TemplateManagerUtil.getTemplate(TemplateConstants.LANG_TYPE_VM, templateResource, false);
			Template ftl_template = TemplateManagerUtil.getTemplate(TemplateConstants.LANG_TYPE_FTL, templateResource, false);

			List<NavItem> navItems = NavItem.fromLayouts(request, publicNonHiddenLayouts, template);
			List<NavItem> ftl_navItems = NavItem.fromLayouts(request, publicNonHiddenLayouts, ftl_template);
			
			Map<String, Object> vmVariables = new HashMap<String, Object>();
			Map<String, Object> ftlVariables = new HashMap<String, Object>();
			
			vmVariables.put("baseNavItems", navItems);
			ftlVariables.put("baseNavItems", ftl_navItems);
			
			request.setAttribute(WebKeys.VM_VARIABLES, vmVariables);
			request.setAttribute("FTL_VARIABLES", ftlVariables);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
