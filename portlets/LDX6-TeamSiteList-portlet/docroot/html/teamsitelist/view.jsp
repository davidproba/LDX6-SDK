<%@ include file="/html/init.jsp" %>



<%
	int delta = 10;
	Group base = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "LDX Intranet");
	List<Group> groups = GroupLocalServiceUtil.getGroups(themeDisplay.getCompanyId(), base.getGroupId(), true);
	
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("jspPage", "/html/teamsitelist/view.jsp");
	
	
%>

<liferay-ui:search-container delta="<%= delta %>" emptyResultsMessage="no-sites-found" iteratorURL="<%= iteratorURL %>" >
	<liferay-ui:search-container-results
		total="<%= groups.size() %>"
		results="<%= ListUtil.subList(groups, searchContainer.getStart(),
											searchContainer.getEnd()) %>"/>
	<liferay-ui:search-container-row className="Group" modelVar="group">
		<liferay-ui:search-container-column-text cssClass="collogo" name="">
<%
		String logoURL = "";
		LayoutSet ls = LayoutSetLocalServiceUtil.getLayoutSet(group.getGroupId(), false);
		if(ls.isLogo()) {
			long logoId = ls.getLogoId();
			StringBundler sb = new StringBundler(5);
			String imagePath=PortalUtil.getPathImage();
			sb.append(imagePath);
			sb.append("/layout_set_logo?img_id=");
			sb.append(logoId);
			sb.append("&t=");
			sb.append(WebServerServletTokenUtil.getToken(logoId));
			logoURL = sb.toString();			
		} else {
			logoURL = themeDisplay.getCompanyLogo();
		}
%>
			<a href="<%= "/web" + group.getFriendlyURL() %>"><img class="prologo" src="<%= logoURL %>" /></a>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text cssClass="colname" name="">
			<a href="<%= "/web" + group.getFriendlyURL() %>"><%= HtmlUtil.escape(group.getDescriptiveName(locale)) %></a>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text cssClass="coldesc" name=""><%= HtmlUtil.escape(group.getDescription() ) %>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />	
</liferay-ui:search-container>			