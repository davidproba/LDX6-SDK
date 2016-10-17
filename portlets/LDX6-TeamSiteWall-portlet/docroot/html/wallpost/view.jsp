<%@ include file="/html/init.jsp" %>


<%
	boolean hasPermissions = themeDisplay.getPermissionChecker()
			.hasPermission(group.getGroupId(), "com.liferay.ldx6demo.teamsitewall.model",
					group.getGroupId(), "ADD_POST");

	PortletURL addWallpostURL = renderResponse.createActionURL();
	addWallpostURL.setParameter(ActionRequest.ACTION_NAME, "addWallpost");
	addWallpostURL.setParameter("redirectURL", HtmlUtil.escape(currentURL));

%>


<c:if test='<%= hasPermissions %>'>

<form action="<%= addWallpostURL.toString() %>" method="post" name="<portlet:namespace />fm200">

<div class="wp-comment-wrapper">
		<div class="comment-div">
			<textarea placeholder="Write a comment..." class="comment-text comment-text-stand" name="<portlet:namespace />post" onkeypress="<portlet:namespace />doEnter(event)" onKeyUp="document.getElementById('<portlet:namespace />postButton').disabled = (this.value == '');"></textarea>
		</div>
		<input class="btn btn-primary" disabled id="<portlet:namespace />postButton" type="button" value="<liferay-ui:message key="post" />" onClick="<portlet:namespace />submitCommentForm();" />
</div>

</form>

</c:if>
<aui:script>
	function <portlet:namespace />submitCommentForm() {
		var form = AUI().one(document.<portlet:namespace />fm200);
		form.submit();
	}
</aui:script>