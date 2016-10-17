<%@ include file="/html/init.jsp" %>


<div class="memberswrapper">
<%
	Group group = themeDisplay.getScopeGroup();
	List<User> users = UserLocalServiceUtil.getGroupUsers(group.getGroupId());
	
	for(User u : users) {
%>
	<div class="member">
		<div class="memberimage"><a href="<%= u.getGroup().getFriendlyURL() %>"><img src="<%= u.getPortraitURL(themeDisplay) %>" /></a></div>
		<div class="membertxt">
			<div class="membername"><a href="/web<%= u.getGroup().getFriendlyURL() %>"><%= u.getFullName() %></a></div>
		</div>
	</div>
<%
	}
%>
</div>