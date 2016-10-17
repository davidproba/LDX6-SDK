<%@ include file="/init.jsp" %>

<%
Group group = themeDisplay.getScopeGroup();
Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
%>

<form action='<portlet:actionURL name="updateMessage" />' method="post" name="<portlet:namespace />fm200">
<input name="<portlet:namespace />mvcPath" type="hidden" value="/view.jsp" />
<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(currentURL) %>" />
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="" />
<input name="<portlet:namespace />className" type="hidden" value="<%= Group.class.getName() %>" />
<input name="<portlet:namespace />classPK" type="hidden" value="<%= group.getGroupId() %>" />
<input name="<portlet:namespace />messageId" type="hidden" value="" />

<div class="comment-wrapper">
		<div class="comment-div">
			<textarea placeholder="Write a comment..." class="comment-text" name="<portlet:namespace />body" onkeypress="<portlet:namespace />doEnter(event)" onKeyUp="document.getElementById('<portlet:namespace />postButton').disabled = (this.value == '');"></textarea>
		</div>
		<input class="btn btn-primary" disabled id="<portlet:namespace />postButton" type="button" value="<liferay-ui:message key="post" />" onClick="<portlet:namespace />postReply();" />
</div>

</form>

<aui:script>
	function <portlet:namespace />postReply() {
		document.<portlet:namespace />fm200.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.ADD %>";

		<portlet:namespace />submitCommentForm();
	}

	function <portlet:namespace />doEnter(event) {
		if(event.keyCode==13) {
			event.preventDefault();

			document.<portlet:namespace />fm200.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.ADD %>";
			var form = AUI().one(document.<portlet:namespace />fm200);
			form.submit();
		}
	}

	function <portlet:namespace />submitCommentForm() {
		var form = AUI().one(document.<portlet:namespace />fm200);
		form.submit();
	}
</aui:script>