<%@ include file="/init.jsp" %>


<%
	PortletURL viewURL = renderResponse.createRenderURL();
	viewURL.setParameter("jspPage", "/html/ProjectTasks/view.jsp");
	viewURL.setWindowState(LiferayWindowState.NORMAL);

	PortletURL newTaskURL = renderResponse.createActionURL();
	newTaskURL.setParameter(ActionRequest.ACTION_NAME, TaskConstants.ACTION_INSERT_TASK);
	newTaskURL.setParameter("redirectURL", viewURL.toString());
	
	Calendar defaultValueDate = CalendarFactoryUtil.getCalendar();
%>

<aui:form name='fm' method="POST" action="<%= newTaskURL.toString() %>">
<aui:layout>
	<aui:column first="true" columnWidth="50">

		<aui:input name="atTitle" label="<%= TaskConstants.LABEL_TITLE %>">
			<aui:validator name="required"></aui:validator>
		</aui:input>

		<aui:input name="atDescription" label="<%= TaskConstants.LABEL_DESCRIPTION %>" type="textarea" rows="15"></aui:input>

		<label><%= LanguageUtil.get(pageContext, TaskConstants.LABEL_STARTDATE) %></label>
		<liferay-ui:input-date cssClass="lfr-start-date" yearValue="<%= defaultValueDate.get(Calendar.YEAR) %>" monthValue="<%= defaultValueDate.get(Calendar.MONTH) %>"
			dayValue="<%= defaultValueDate.get(Calendar.DATE) %>" yearParam="syear" monthParam="smonth" dayParam="sday" />	
		<br/>
		
		<label><%= LanguageUtil.get(pageContext, TaskConstants.LABEL_FINALDATE) %></label>
		<liferay-ui:input-date cssClass="lfr-final-date" yearValue="<%= defaultValueDate.get(Calendar.YEAR) %>" monthValue="<%= defaultValueDate.get(Calendar.MONTH) %>"
			dayValue="<%= defaultValueDate.get(Calendar.DATE) %>" yearParam="fyear" monthParam="fmonth" dayParam="fday" />	
		<br /><br />

	</aui:column>
	<aui:column>

		<aui:select name="atPriority" label="<%= TaskConstants.LABEL_PRIORITY %>">
			<aui:option label="<%= TaskConstants.LABEL_PRIO_HIGH %>" value="<%= TaskConstants.PRIO_HIGH %>" />
			<aui:option label="<%= TaskConstants.LABEL_PRIO_NORMAL %>" value="<%= TaskConstants.PRIO_NORMAL %>" selected="true" />
			<aui:option label="<%= TaskConstants.LABEL_PRIO_LOW %>" value="<%= TaskConstants.PRIO_LOW %>" />
		</aui:select>

		<aui:select label="<%= TaskConstants.LABEL_ASSIGNEDTO %>" name="atAssignedToUserId">
			<aui:option label="unassigned" value="0" />
			<optgroup label="<liferay-ui:message key="members" />">
<%
	List<User> users = null;
	users = UserLocalServiceUtil.getGroupUsers(group.getGroupId());
	for (User curUser : users) {
		long curUserId = curUser.getUserId();
%>
				<aui:option label="<%= HtmlUtil.escape(curUser.getFullName()) %>" value="<%= curUserId %>" />
<%
	}
%>
			</optgroup>
		</aui:select>
		
<%
	List<AdvTask> tasks = null;
	tasks = AdvTaskLocalServiceUtil.getTasksByGroupId(group.getGroupId());
	if(tasks.size()>0) {
%>
		<aui:select label="<%= LanguageUtil.get(pageContext, TaskConstants.LABEL_PARENTTASK) %>" name="atParentTaskId">
			<aui:option label="unassigned" value="0" />
<%
	for (AdvTask curtask:tasks) {
		long curTaskId = curtask.getAtId();
%>
			<aui:option label="<%= HtmlUtil.escape(curtask.getAtTitle()) %>" value="<%= curTaskId %>" />
<%
	}
%>
		</aui:select>
		
		<label class="control-label"><%= LanguageUtil.get(pageContext, TaskConstants.LABEL_DEPENDANTTASKS) %></label>
<%
	for (AdvTask curtask:tasks) {
		long curTaskId = curtask.getAtId();
%>
		<input type="hidden" value="false" id="<portlet:namespace/>atDT" name="<portlet:namespace/>atDT" />
		<input type="checkbox" class="field" id="<portlet:namespace/>atDTCheckbox" name="<portlet:namespace/>atDTCheckbox" 
			onclick="Liferay.Util.updateCheckboxValue(this);" value="<%= curTaskId %>"
			style="margin-top:0px !important; margin-right:8px !important;" /><%= HtmlUtil.escape(curtask.getAtTitle()) %><br/>
<%
	}
	}
%>
	</aui:column>
	<aui:button-row>
		<aui:button type="submit" value="Save" />
		<aui:button type="cancel" value="Cancel" />
	</aui:button-row>
</aui:layout>
</aui:form>

<aui:script>
	Liferay.Util.focusFormField(document.<portlet:namespace/>fm.<portlet:namespace/>ezTitle);
</aui:script>

