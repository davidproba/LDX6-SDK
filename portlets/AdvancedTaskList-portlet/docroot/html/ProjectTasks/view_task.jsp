<%@ include file="/init.jsp" %>


<%
	AdvTask task = null;
	long taskId = ParamUtil.getLong(request, "taskId");
	if(taskId>0) {
		task = AdvTaskLocalServiceUtil.getAdvTask(taskId);
		PortalUtil.addPortletBreadcrumbEntry(request, task.getAtTitle(), currentURL);
	}
	PortletURL viewURL = renderResponse.createRenderURL();
	viewURL.setParameter("jspPage", "/html/ProjectTasks/view.jsp");
	PortletURL delTaskURL = renderResponse.createActionURL();
	delTaskURL.setParameter(ActionRequest.ACTION_NAME, "deleteTask");
	delTaskURL.setParameter("redirectURL", viewURL.toString());
	
	PortletURL editURL = renderResponse.createRenderURL();
	editURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	editURL.setParameter("jspPage", "/html/ProjectTasks/edit.jsp");
	editURL.setParameter("taskId", Long.toString(taskId));
	editURL.setParameter("redirectURL", viewURL.toString());

	PortletURL newURL = renderResponse.createRenderURL();
	newURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	newURL.setParameter("mvcPath", "/html/ProjectTasks/new.jsp");

	PortletURL finishTaskURL = renderResponse.createActionURL();
	finishTaskURL.setParameter(ActionRequest.ACTION_NAME, "finishTask");
	
	PortletURL reopenTaskURL = renderResponse.createActionURL();
	reopenTaskURL.setParameter(ActionRequest.ACTION_NAME, "reopenTask");

	int taskStatus = task.getAtStatus();
%>

<aui:button-row cssClass="tasks-buttons">
	<aui:script use="aui-base,aui-dialog,liferay-util-window,aui-io-plugin-deprecated">

			var buttonRow = A.one("#p_p_id<portlet:namespace/> .tasks-buttons");
			
			var buttonLabel = "<liferay-ui:message key="<%= TaskConstants.LABEL_ADD_TASK %>" />";
			var button = new A.Button({
				icon: 'icon-plus',
				label: buttonLabel,
				on: { 
					click: function(event) {
						var dialog = Liferay.Util.Window.getWindow({
							dialog: {
								title: 'Details',
								centered: true,
								modal: true,
								width: 750
							}
						}).plug(A.Plugin.IO, {
								autoLoad: true,
								uri: '<%= newURL.toString() %>'
						}).render();
						dialog.titleNode.html("<%= LanguageUtil.get(pageContext, TaskConstants.LABEL_ADD_TASK) %>");
					} 
				}
			}).render(buttonRow);

		<c:if test="<%= taskStatus!=TaskConstants.STATUS_100 %>">
			buttonLabel = "<liferay-ui:message key="<%= TaskConstants.LABEL_EDIT_TASK %>" />";
			button = new A.Button({
				icon: 'icon-edit',
				label: buttonLabel,
				on: { 
					click: function(event) {
						var dialog = Liferay.Util.Window.getWindow({
							dialog: {
								title: 'Details',
								centered: true,
								modal: true,
								width: 750
							}
						}).plug(A.Plugin.IO, {
								autoLoad: true,
								uri: '<%= editURL.toString() %>'
						}).render();
						dialog.titleNode.html("<%= LanguageUtil.get(pageContext, TaskConstants.LABEL_EDIT_TASK) %>");
					} 
				}
			}).render(buttonRow);
		</c:if>	
			buttonLabel = "<liferay-ui:message key="<%= TaskConstants.LABEL_DELETE_TASK %>" />";
			button = new A.Button({
				icon: 'icon-trash',
				label: buttonLabel,
				on: { 
					click: function(event) {
						if(confirm('<%= LanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-this") %>')) {
							submitForm(document.<portlet:namespace />fmDel);
						}
					} 
				}
			}).render(buttonRow);
		<c:if test="<%= taskStatus!=TaskConstants.STATUS_100 %>">
			buttonLabel = "<liferay-ui:message key="<%= TaskConstants.LABEL_FINISH_TASK %>" />";
			button = new A.Button({
				icon: 'icon-flag',
				label: buttonLabel,
				on: { 
					click: function(event) {
						if(confirm('<%= LanguageUtil.get(pageContext, "are-you-sure-you-want-to-finish-this") %>')) {
							submitForm(document.<portlet:namespace />fmFinish);
						}
					} 
				}
			}).render(buttonRow);
		</c:if>
		<c:if test="<%= taskStatus==TaskConstants.STATUS_100 %>">
			buttonLabel = "<liferay-ui:message key="<%= TaskConstants.LABEL_REOPEN_TASK %>" />";
			button = new A.Button({
				icon: 'icon-undo',
				label: buttonLabel,
				on: { 
					click: function(event) {
						if(confirm('<%= LanguageUtil.get(pageContext, "are-you-sure-you-want-to-reopen-this") %>')) {
							submitForm(document.<portlet:namespace />fmReopen);
						}
					} 
				}
			}).render(buttonRow);
		</c:if>
	</aui:script>
</aui:button-row>

<c:if test="<%= Validator.isNotNull(task) %>">
<div class="task-container">
<div class="task-title"><%= task.getAtTitle() %></div>
<aui:form name='fmDel' method="POST" action="<%= delTaskURL.toString() %>" style="margin:0px !important;">
	<input type="hidden" name="<portlet:namespace />atDelTaskId" value="<%= taskId %>" />
</aui:form>
<aui:form name='fmFinish' method="POST" action="<%= finishTaskURL.toString() %>" style="margin:0px !important;">
	<input type="hidden" name="<portlet:namespace />atFinishTaskId" value="<%= taskId %>" />
</aui:form>
<aui:form name='fmReopen' method="POST" action="<%= reopenTaskURL.toString() %>" style="margin:0px !important;">
	<input type="hidden" name="<portlet:namespace />atReopenTaskId" value="<%= taskId %>" />
</aui:form>
		<div class="task-data-container">
			<div class="task-data assignee">
				<c:choose>
					<c:when test="<%= task.getAtAssignedToUserId() > 0 %>">
<%
						String assigneeDisplayURL = "";
						String taglibAssigneeDisplayURL = LanguageUtil.get(pageContext, "unknown-user");
						User assigneeUser = UserLocalServiceUtil.fetchUser(task.getAtAssignedToUserId());
						if (assigneeUser != null) {
							assigneeDisplayURL = assigneeUser.getDisplayURL(themeDisplay);
							taglibAssigneeDisplayURL = "<a href=\"" + assigneeDisplayURL + "\">" + HtmlUtil.escape(assigneeUser.getFullName()) + "</a>";
						}
%>
						<liferay-ui:message arguments="<%= taglibAssigneeDisplayURL %>" key="<%= TaskConstants.LABEL_ASSIGNEDTO2 %>" />
					</c:when>
					<c:otherwise>
						<liferay-ui:message key="unassigned" />
					</c:otherwise>
				</c:choose>
			</div>

			<div class="task-data reporter">

				<%
				String reporterDisplayURL = "";
				String taglibReporterDisplayURL = LanguageUtil.get(pageContext, "unknown-user");
				User reporterUser = UserLocalServiceUtil.fetchUser(task.getUserId());
				if (reporterUser != null) {
					reporterDisplayURL = reporterUser.getDisplayURL(themeDisplay);
					taglibReporterDisplayURL = "<a href=\"" + reporterDisplayURL + "\">" + HtmlUtil.escape(reporterUser.getFullName()) + "</a>";
				}
				%>
				<liferay-ui:message arguments="<%= taglibReporterDisplayURL %>" key="created-by-x" />
			</div>

			<div class="task-data last modified-date">
<%
String tMod = "na";
Date tModified = task.getModifiedDate();
SimpleDateFormat sdfmt = new SimpleDateFormat();
sdfmt.applyPattern("dd.MM.yyyy, HH:mm");
if(tModified!=null) {
	tMod = sdfmt.format(tModified).toString();
}

%>			
			
				<liferay-ui:message arguments="<%= tMod %>" key="modified-on-x" />
			</div>
		</div>

		<table class="task-data-table lfr-table">
<%
	int prio = task.getAtPriority();
	String priolabel = ProjectTasks.getPrioLabel(prio);
	int stat = task.getAtStatus();
	String statlabel = ProjectTasks.getStatusLabel(stat);
	String bgcolor = ProjectTasks.getColor(stat, prio, task.getAtFinalDate());
%>
<tr><td class="bgtd" style="background-color:<%= bgcolor %>"></td>
<td class="tdtable"><table>
		<c:if test="<%= task.getAtStartDate() != null %>">
<%
String tS = "na";
Date tStart = task.getAtStartDate();
sdfmt = new SimpleDateFormat();
sdfmt.applyPattern("dd.MM.yyyy");
if(tStart!=null) {
	tS = sdfmt.format(tStart).toString();
}
%>

			<tr>
				<td class="lfr-label">
					<liferay-ui:message key="<%= TaskConstants.LABEL_STARTDATE %>" />:
				</td>
				<td>
					<div class="task-data due-date">
						<%= tS %>
					</div>
				</td>
			</tr>
		</c:if>
		<c:if test="<%= task.getAtFinalDate() != null %>">
<%
String tF = "na";
Date tFinal = task.getAtFinalDate();
sdfmt = new SimpleDateFormat();
sdfmt.applyPattern("dd.MM.yyyy");
if(tFinal!=null) {
	tF = sdfmt.format(tFinal).toString();
}
%>
			<tr>
				<td class="lfr-label">
					<liferay-ui:message key="<%= TaskConstants.LABEL_FINALDATE %>" />:
				</td>
				<td>
					<div class="task-data due-date">
						<%= tF %>
					</div>
				</td>
			</tr>
		</c:if>
			<tr>
				<td class="lfr-label">
					<liferay-ui:message key="<%= TaskConstants.LABEL_PRIORITY %>" />:
				</td>
				<td>
					<liferay-ui:message key="<%= priolabel %>" />
				</td>
			</tr>
			<tr>
				<td class="lfr-label">
					<liferay-ui:message key="<%= TaskConstants.LABEL_STATUS %>" />:
				</td>
				<td>
					<liferay-ui:message key="<%= statlabel  %>" />
				</td>
			</tr>
<c:if test="<%= ((DateUtil.compareTo(new Date(), task.getAtFinalDate(), true) >= 0)&&(task.getAtStatus()!=TaskConstants.STATUS_100)) %>">
	<tr>
		<td colspan="2" style="color:red;font-weight:bold;"><liferay-ui:message key="<%= TaskConstants.LABEL_OVERDUE %>" />
		</td>
	</tr>
</c:if>
		</table>
</td></tr>
<c:if test="<%= !task.getAtDescription().equals(StringPool.BLANK) %>">
<tr><td colspan="2" style="text-align:justify;padding:16px 0px">
	<liferay-ui:message key="<%= task.getAtDescription() %>" />
</td></tr>
</c:if>				
</table>
	
<%
	PortletURL nextdetails = renderResponse.createRenderURL();
	nextdetails.setParameter("jspPage", TaskConstants.PAGE_DETAIL);

	boolean hasdependencies = false;
	
	List<AdvTask> checklist = AdvTaskLocalServiceUtil.getTasksByGroupId(group.getGroupId());
	List<AdvTask> parents = new ArrayList<AdvTask>();
	List<AdvTask> children = new ArrayList<AdvTask>();
	for(AdvTask at:checklist) {
		if(at.getAtParentTaskId()==task.getAtId()) {
			children.add(at);
			hasdependencies = true;
		}
		if(task.getAtParentTaskId()==at.getAtId()) {
			parents.add(at);			
			hasdependencies = true;
		}
	}
	List<AdvTask> dependents = new ArrayList<AdvTask>();
	List<AdvTaskMapping> tmpMappings = AdvTaskMappingLocalServiceUtil.getMTasks(task.getAtId());
	for(AdvTaskMapping tmpMap:tmpMappings) {
		dependents.add(AdvTaskLocalServiceUtil.getAdvTask(tmpMap.getAtMDependentFromId()));
		hasdependencies = true;
	}
%>	
<div>
<%
	if(parents.size()>0) {
%>
	<div style="float:left;padding-right:32px;">
		<div style="margin-bottom:8px;"><b><%= LanguageUtil.get(pageContext, TaskConstants.LABEL_SUBTASKOF) %></b></div>
<% 
		for(AdvTask pt:parents) {
			nextdetails.setParameter("taskId", Long.toString(pt.getAtId()));
%>		
		<div style="margin-right:5px;float:left;width:5px;background-color:<%= ProjectTasks.getColor(pt.getAtStatus(), pt.getAtPriority(), pt.getAtFinalDate()) %>">&nbsp;
		</div>
		<div style="float:left">
			<a href="<%= nextdetails.toString() %>"><%= pt.getAtTitle() %></a>
		</div>
		<div style="float:left;padding-left:10px;"><%= LanguageUtil.get(pageContext, ProjectTasks.getStatusLabel(pt.getAtStatus()))  %></div>
		<div style="clear:both"></div>
<% 
		}
%>		
	</div>
<% 	
	}
	if(children.size()>0) {
%>
	<div style="float:left;padding-right:32px;">
		<div style="margin-bottom:8px;"><b><%= LanguageUtil.get(pageContext, TaskConstants.LABEL_PARENTTASKOF) %></b></div>
<% 
		for(AdvTask ct:children) {
			nextdetails.setParameter("taskId", Long.toString(ct.getAtId()));
%>		
		<div style="margin-right:5px;float:left;width:5px;background-color:<%= ProjectTasks.getColor(ct.getAtStatus(), ct.getAtPriority(), ct.getAtFinalDate()) %>">&nbsp;
		</div>
		<div style="float:left">
			<a href="<%= nextdetails.toString() %>"><%= ct.getAtTitle() %></a>
		</div>
		<div style="float:left;padding-left:10px;"><%= LanguageUtil.get(pageContext, ProjectTasks.getStatusLabel(ct.getAtStatus()))  %></div>
		<div style="clear:both"></div>
<% 
		}
%>		
	</div>
<% 	
	}
	if(dependents.size()>0) {
%>
	<div style="float:left;padding-right:32px;">
		<div style="margin-bottom:8px;"><b><%= LanguageUtil.get(pageContext, TaskConstants.LABEL_DEPENDANTTASKS) %></b></div>
<% 
		for(AdvTask dt:dependents) {
			nextdetails.setParameter("taskId", Long.toString(dt.getAtId()));
%>		
		<div style="margin-right:5px;float:left;width:5px;background-color:<%= ProjectTasks.getColor(dt.getAtStatus(), dt.getAtPriority(), dt.getAtFinalDate()) %>">&nbsp;
		</div>
		<div style="float:left">
			<a href="<%= nextdetails.toString() %>"><%= dt.getAtTitle() %></a>
		</div>
		<div style="float:left;padding-left:10px;"><%= LanguageUtil.get(pageContext, ProjectTasks.getStatusLabel(dt.getAtStatus()))  %></div>
		<div style="clear:both"></div>
<% 
		}
%>		
	</div>
<% 	
	}
%>
	<div style="clear:both"></div>
</div>
		<%@ include file="/html/ProjectTasks/view_comments.jspf" %>
</div>		
</c:if>

