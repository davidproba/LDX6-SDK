<%@ include file="/init.jsp" %>


<%
	AdvTask task = null;
	long taskId = ParamUtil.getLong(request, "taskId");
	if(taskId>0) {
		task = AdvTaskLocalServiceUtil.getAdvTask(taskId);
	}

	PortletURL viewURL = renderResponse.createRenderURL();
	viewURL.setParameter("jspPage", TaskConstants.PAGE_DETAIL);
	viewURL.setParameter("taskId", String.valueOf(taskId));
	viewURL.setWindowState(LiferayWindowState.NORMAL);

	PortletURL updateTaskURL = renderResponse.createActionURL();
	updateTaskURL.setParameter(ActionRequest.ACTION_NAME, TaskConstants.ACTION_UPDATE_TASK);
	updateTaskURL.setParameter("redirectURL", viewURL.toString());
	
	Calendar defaultValueDate = CalendarFactoryUtil.getCalendar();
%>

<aui:form name='fm' method="POST" action="<%= updateTaskURL.toString() %>">
<aui:layout>
	<aui:column first="true" columnWidth="50">
		<aui:input type="hidden" name="taskId" value="<%= taskId %>"></aui:input>
		<aui:input name="atTitle" value="<%= task.getAtTitle() %>" label="<%= TaskConstants.LABEL_TITLE %>"></aui:input>
		<aui:input name="atDescription" value="<%= task.getAtDescription() %>" label="<%= TaskConstants.LABEL_DESCRIPTION %>" type="textarea" rows="15"></aui:input>
<%
	String taglibAddStartDateOnClick = renderResponse.getNamespace() + "displayStartDate();";
	String taglibAddFinalDateOnClick = renderResponse.getNamespace() + "displayFinalDate();";
%>
		<label><%= LanguageUtil.get(pageContext, TaskConstants.LABEL_STARTDATE) %></label>
<%
	Date sDate = task.getAtStartDate();
	boolean hasSDate = (sDate!=null);
	if(hasSDate) {
		Calendar sCal = CalendarFactoryUtil.getCalendar();
		sCal.setTime(sDate);
%>
		<aui:input name="addStartDate" id="addStartDate" type="hidden" value="true"></aui:input>
		<a class="field-content due-date-toggle" href="#" id="toggleStartDate" onClick="<%= taglibAddStartDateOnClick %>">&laquo;<%= LanguageUtil.get(pageContext, TaskConstants.LABEL_REMOVESTARTDATE) %></a>
		<liferay-ui:input-date cssClass="lfr-start-date" yearValue="<%= sCal.get(Calendar.YEAR) %>" monthValue="<%= sCal.get(Calendar.MONTH) %>"
			dayValue="<%= sCal.get(Calendar.DATE) %>" yearParam="syear" monthParam="smonth" dayParam="sday" />	
<%
	} else {
%>
		<aui:input name="addStartDate" id="addStartDate" type="hidden" value="false"></aui:input>
		<a class="field-content due-date-toggle" href="#" id="toggleStartDate" onClick="<%= taglibAddStartDateOnClick %>">&raquo;<%= LanguageUtil.get(pageContext, TaskConstants.LABEL_ADDSTARTDATE) %></a>
		<liferay-ui:input-date cssClass="hide lfr-start-date" yearValue="<%= defaultValueDate.get(Calendar.YEAR) %>" monthValue="<%= defaultValueDate.get(Calendar.MONTH) %>"
			dayValue="<%= defaultValueDate.get(Calendar.DATE) %>" yearParam="syear" monthParam="smonth" dayParam="sday" />	
<%
	}
%>
		<br/>
		<label><%= LanguageUtil.get(pageContext, TaskConstants.LABEL_FINALDATE) %></label>
<%
	Date fDate = task.getAtFinalDate();
	boolean hasFDate = (fDate!=null);
	if(hasFDate) {
		Calendar fCal = CalendarFactoryUtil.getCalendar();
		fCal.setTime(fDate);
%>
		<aui:input name="addFinalDate" id="addFinalDate" type="hidden" value="true"></aui:input>
		<a class="field-content due-date-toggle" href="#" id="toggleFinalDate" onClick="<%= taglibAddFinalDateOnClick %>">&raquo;<%= LanguageUtil.get(pageContext, TaskConstants.LABEL_REMOVEFINALDATE) %></a>
		<liferay-ui:input-date cssClass="lfr-final-date" yearValue="<%= fCal.get(Calendar.YEAR) %>" monthValue="<%= fCal.get(Calendar.MONTH) %>"
			dayValue="<%= fCal.get(Calendar.DATE) %>" yearParam="fyear" monthParam="fmonth" dayParam="fday" />	
<%
	} else {
%>
		<aui:input name="addFinalDate" id="addFinalDate" type="hidden" value="false"></aui:input>
		<a class="field-content due-date-toggle" href="#" id="toggleFinalDate" onClick="<%= taglibAddFinalDateOnClick %>">&raquo;<%= LanguageUtil.get(pageContext, TaskConstants.LABEL_ADDFINALDATE) %></a>
		<liferay-ui:input-date cssClass="hide lfr-final-date" yearValue="<%= defaultValueDate.get(Calendar.YEAR) %>" monthValue="<%= defaultValueDate.get(Calendar.MONTH) %>"
			dayValue="<%= defaultValueDate.get(Calendar.DATE) %>" yearParam="fyear" monthParam="fmonth" dayParam="fday" />	
<%
	}
%>
		<br /><br />
	</aui:column>
	<aui:column>
		<aui:select name="atStatus" label="<%= TaskConstants.LABEL_STATUS %>">
			<aui:option label="<%= TaskConstants.LABEL_STATUS_BEGINN %>" value="<%= TaskConstants.STATUS_BEGINN %>" selected="<%= task.getAtStatus()==TaskConstants.STATUS_BEGINN %>" />
			<aui:option label="<%= TaskConstants.LABEL_STATUS_20 %>" value="<%= TaskConstants.STATUS_20 %>" selected="<%= task.getAtStatus()==TaskConstants.STATUS_20 %>" />
			<aui:option label="<%= TaskConstants.LABEL_STATUS_40 %>" value="<%= TaskConstants.STATUS_40 %>" selected="<%= task.getAtStatus()==TaskConstants.STATUS_40 %>" />
			<aui:option label="<%= TaskConstants.LABEL_STATUS_60 %>" value="<%= TaskConstants.STATUS_60 %>" selected="<%= task.getAtStatus()==TaskConstants.STATUS_60 %>" />
			<aui:option label="<%= TaskConstants.LABEL_STATUS_80 %>" value="<%= TaskConstants.STATUS_80 %>" selected="<%= task.getAtStatus()==TaskConstants.STATUS_80 %>" />
			<aui:option label="<%= TaskConstants.LABEL_STATUS_100 %>" value="<%= TaskConstants.STATUS_100 %>" selected="<%= task.getAtStatus()==TaskConstants.STATUS_100 %>" />
			<aui:option label="<%= TaskConstants.LABEL_STATUS_REOPEN %>" value="<%= TaskConstants.STATUS_REOPEN %>" selected="<%= task.getAtStatus()==TaskConstants.STATUS_REOPEN %>" />
		</aui:select>
		<aui:select name="atPriority" label="<%= TaskConstants.LABEL_PRIORITY %>">
			<aui:option label="<%= TaskConstants.LABEL_PRIO_HIGH %>" value="<%= TaskConstants.PRIO_HIGH %>" selected="<%= task.getAtPriority()==TaskConstants.PRIO_HIGH %>" />
			<aui:option label="<%= TaskConstants.LABEL_PRIO_NORMAL %>" value="<%= TaskConstants.PRIO_NORMAL %>" selected="<%= task.getAtPriority()==TaskConstants.PRIO_NORMAL %>" />
			<aui:option label="<%= TaskConstants.LABEL_PRIO_LOW %>" value="<%= TaskConstants.PRIO_LOW %>" selected="<%= task.getAtPriority()==TaskConstants.PRIO_LOW %>" />
		</aui:select>
		<aui:select label="<%= TaskConstants.LABEL_ASSIGNEDTO %>" name="atAssignedToUserId">
			<aui:option label="unassigned" value="0" selected="<%= task.getAtAssignedToUserId()==0 %>" />
			<optgroup label="<liferay-ui:message key="members" />">
<%
	List<User> users = null;
	users = UserLocalServiceUtil.getGroupUsers(group.getGroupId());
	for (User curUser : users) {
		long curUserId = curUser.getUserId();
%>
				<aui:option label="<%= HtmlUtil.escape(curUser.getFullName()) %>" value="<%= curUserId %>" selected="<%= task.getAtAssignedToUserId()==curUserId %>" />
<%
	}
%>
			</optgroup>
		</aui:select>
<%
	List<AdvTask> tasks = null;
	tasks = AdvTaskLocalServiceUtil.getTasksByGroupId(group.getGroupId());
	if(tasks.size()>1) {
%>
		<aui:select label="<%= TaskConstants.LABEL_PARENTTASK %>" name="atParentTaskId">
			<aui:option label="unassigned" value="0" selected="<%= task.getAtParentTaskId()==0 %>" />
<%
	for (AdvTask curtask:tasks) {
		long curTaskId = curtask.getAtId();
		if(curTaskId!=taskId) {
%>
			<aui:option label="<%= HtmlUtil.escape(curtask.getAtTitle()) %>" value="<%= curTaskId %>" selected="<%= task.getAtParentTaskId()==curTaskId %>" />
<%
		}
	}
%>
		</aui:select>
		<label class="control-label"><%= LanguageUtil.get(pageContext, TaskConstants.LABEL_DEPENDANTTASKS) %></label>
<%
	List<AdvTaskMapping> mappings = AdvTaskMappingLocalServiceUtil.getMTasks(task.getAtId());
	for (AdvTask curtask:tasks) {
		long curTaskId = curtask.getAtId();
		boolean ismapped = false;
		for(AdvTaskMapping ezM:mappings) {
			if(ezM.getAtMDependentFromId()==curTaskId) {
				ismapped=true;
			}
		}
		if(curTaskId!=taskId) {
		if(ismapped) {
%>
		<input type="hidden" value="<%= curTaskId %>" id="<portlet:namespace/>atDT" name="<portlet:namespace/>atDT" />
		<input type="checkbox" class="field" id="<portlet:namespace/>atDTCheckbox" name="<portlet:namespace/>atDTCheckbox" 
			onclick="Liferay.Util.updateCheckboxValue(this);" value="<%= curTaskId %>" checked
			style="margin-top:0px !important; margin-right:8px !important;" /><%= HtmlUtil.escape(curtask.getAtTitle()) %><br/>
<%			
		} else {
%>
		<input type="hidden" value="false" id="<portlet:namespace/>atDT" name="<portlet:namespace/>atDT" />
		<input type="checkbox" class="field" id="<portlet:namespace/>atDTCheckbox" name="<portlet:namespace/>atDTCheckbox" 
			onclick="Liferay.Util.updateCheckboxValue(this);" value="<%= curTaskId %>"
			style="margin-top:0px !important; margin-right:8px !important;" /><%= HtmlUtil.escape(curtask.getAtTitle()) %><br/>
<%
		}
		}
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
	Liferay.provide(
		window,
		'<portlet:namespace />displayStartDate',
		function() {
			var A = AUI();
			var checkbox = A.one('#<portlet:namespace />addStartDate');
			if (checkbox) {
				var checkboxValue = checkbox.get('value');
				var dueDateToggle = A.one('#toggleStartDate');
				if (checkboxValue == 'true') {
					checkbox.set('value', false);
					dueDateToggle.html('&raquo;<%= LanguageUtil.get(pageContext, TaskConstants.LABEL_ADDSTARTDATE) %>');
				}
				else {
					checkbox.set('value', true);
					dueDateToggle.html('&laquo;<%= LanguageUtil.get(pageContext, TaskConstants.LABEL_REMOVESTARTDATE) %>');
				}
			} 
			var inputDate = A.one('#<portlet:namespace />fm .lfr-start-date');
			if (inputDate) {
				inputDate.toggleClass('hide');
			}
		},
		['aui-base']
	);
	Liferay.provide(
		window,
		'<portlet:namespace />displayFinalDate',
		function() {
			var A = AUI();
			var checkbox = A.one('#<portlet:namespace />addFinalDate');
			if (checkbox) {
				var checkboxValue = checkbox.get('value');
				var dueDateToggle = A.one('#toggleFinalDate');
				if (checkboxValue == 'true') {
					checkbox.set('value', false);
					dueDateToggle.html('&raquo;<%= LanguageUtil.get(pageContext, TaskConstants.LABEL_ADDFINALDATE) %>');
				}
				else {
					checkbox.set('value', true);
					dueDateToggle.html('&laquo;<%= LanguageUtil.get(pageContext, TaskConstants.LABEL_REMOVEFINALDATE) %>');
				}
			} 
			var inputDate = A.one('#<portlet:namespace />fm .lfr-final-date');
			if (inputDate) {
				inputDate.toggleClass('hide');
			}
		},
		['aui-base']
	);
</aui:script>

