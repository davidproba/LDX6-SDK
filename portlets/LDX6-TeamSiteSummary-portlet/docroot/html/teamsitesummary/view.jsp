<%@ include file="/html/init.jsp" %>


<%
	Group group = themeDisplay.getScopeGroup();
	String currentURL = PortalUtil.getCurrentURL(request);
%>

<div class="summary-container">
		<h2 class="summary-projectname">
			<%= HtmlUtil.escape(group.getDescriptiveName(locale)) %>
		</h2>
		<div class="summary-text">
			<img src="<%= themeDisplay.getCompanyLogo() %>" />
			<div class="summary-texttext"><%= HtmlUtil.escape(group.getDescription() ) %></div>
			<div style="clear:both;"></div>
		</div>

	<c:if test="<%= themeDisplay.isSignedIn() %>">
		<c:choose>
			<c:when test="<%= SocialRequestLocalServiceUtil.hasRequest(user.getUserId(), Group.class.getName(), group.getGroupId(), 1, SocialRequestConstants.STATUS_PENDING) %>">
				<div class="alert alert-info join-site pending">
					<aui:icon image="time" />

					<liferay-ui:message key="membership-requested" />
				</div>
			</c:when>
			<c:when test="<%= UserLocalServiceUtil.hasGroupUser(group.getGroupId(), user.getUserId()) %>">

				<%
				PortletURL leaveGroupURL = renderResponse.createActionURL();

				leaveGroupURL.setParameter(ActionRequest.ACTION_NAME, "leaveGroup");
				leaveGroupURL.setParameter("redirect", currentURL);

				String leaveGroupHREF = "javascript:if (confirm('" + LanguageUtil.get(pageContext, "are-you-sure-you-want-to-leave-this-site") + "')) { submitForm(document.hrefFm, '" + leaveGroupURL + "'); }";
				%>

				<div class="leave-site"><a href="<%= leaveGroupHREF %>"><i class="icon-signout"></i><%= LanguageUtil.get(pageContext, "leave-site") %></a>
				</div>
			</c:when>
			<c:when test="<%= !GroupLocalServiceUtil.hasUserGroup(user.getUserId(), group.getGroupId()) %>">

				<%
				PortletURL joinGroupURL = renderResponse.createActionURL();

				joinGroupURL.setParameter(ActionRequest.ACTION_NAME, "joinGroup");
				joinGroupURL.setParameter("redirect", currentURL);
				%>

				<div class="join-site"><a href="<%= joinGroupURL.toString() %>"><i class="icon-signin"></i><%= LanguageUtil.get(pageContext, "join-site") %></a>
				</div>
			</c:when>
		</c:choose>
	</c:if>
</div>