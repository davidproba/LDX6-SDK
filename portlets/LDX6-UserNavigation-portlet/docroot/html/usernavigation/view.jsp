<%@ include file="/html/init.jsp" %>

<%
	Group group = GroupLocalServiceUtil.getGroup(themeDisplay.getScopeGroupId());
	List<Layout> loclayouts = LayoutLocalServiceUtil.getLayouts(themeDisplay.getScopeGroupId(), true);
%>
<ul class="proNav">
<%
	String cURL = themeDisplay.getURLCurrent();
	for(Layout l:loclayouts) {
		String tURL = String.format("/user%s%s", group.getFriendlyURL(), l.getFriendlyURL());
		String actcss = "";
		String iconcss = "";
		if(cURL.contains(l.getFriendlyURL())) {
			actcss="active";
		}
		if(l.getFriendlyURL(Locale.ENGLISH).contains("overview")) {
			iconcss = "icon-home";
		}
		if(l.getFriendlyURL(Locale.ENGLISH).contains("tasks")) {
			iconcss = "icon-list";
		}
		if(l.getFriendlyURL(Locale.ENGLISH).contains("documents")) {
			iconcss = "icon-file";
		}
		if(l.getFriendlyURL(Locale.ENGLISH).contains("calendar")) {
			iconcss = "icon-calendar";
		}
%>
	<li class="proNavItem">
		<a class="proNavLink <%= actcss %>" href="<%= tURL %>"><i class="linkicon <%= iconcss %>"></i><span class="linktext"><%= l.getName(themeDisplay.getLocale()) %></span></a>
	</li>
<%
	}
	
%>	
</ul>