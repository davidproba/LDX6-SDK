<%@ include file="/init.jsp" %>

<%
	List<AdvTask> tasks = AdvTaskLocalServiceUtil.getTasksByGroupId(group.getGroupId());
	
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("jspPage", TaskConstants.PAGE_LIST);
	PortletURL viewURL = renderResponse.createRenderURL();
	viewURL.setParameter("jspPage", TaskConstants.PAGE_LIST);
	int delta = 10;
	
	PortletURL newURL = renderResponse.createRenderURL();
	newURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	newURL.setParameter("mvcPath", "/html/ProjectTasks/new.jsp");

	PortletURL taskdetails = renderResponse.createRenderURL();
	taskdetails.setParameter("jspPage", TaskConstants.PAGE_DETAIL);
	
	String displayStyle = ParamUtil.getString(request, "displayStyle");
	
	
	boolean hasAddPermission = permissionChecker.hasPermission(
			scopeGroupId, "com.liferay.AdvancedTasks.model",
			scopeGroupId, "ADD_TASK");
	boolean hasConfigurePermission = permissionChecker.hasPermission(
			scopeGroupId, "com.liferay.AdvancedTasks.model", scopeGroupId,
			ActionKeys.PERMISSIONS);
%>
<aui:button-row cssClass="tasks-buttons">

		<liferay-security:permissionsURL
			modelResource="com.liferay.AdvancedTasks.model"
			modelResourceDescription="advtasks-top-level-actions"
			windowState="<%= String.valueOf(LiferayWindowState.EXCLUSIVE) %>"
			resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
			var="permissionsURL" />
			
	<aui:script use="aui-button,aui-base,aui-dialog,liferay-util-window,aui-io-plugin-deprecated">
			var buttonRow = A.one("#p_p_id<portlet:namespace/> .tasks-buttons");

			var buttonLabel = "<liferay-ui:message key="<%= TaskConstants.LABEL_ADD_TASK %>" />";
		<c:if test="<%= hasAddPermission %>">
			new A.Button({
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
		</c:if>			

		<c:if test="<%= hasConfigurePermission %>">
			buttonLabel = "<liferay-ui:message key="Permissions" />";
			new A.Button({
				icon: 'icon-gear',
				label: buttonLabel,
				on: { click: function(event) {
						var dialog = Liferay.Util.Window.getWindow({
							dialog: {
								title: '<liferay-ui:message key="Permissions" />',
								centered: true,
								modal: true,
								width: 750
							}
						}).plug(A.Plugin.IO, {
								autoLoad: true,
								uri: '<%= permissionsURL.toString() %>'
						}).render();
						dialog.titleNode.html("<%= LanguageUtil.get(pageContext, "Permissions") %>");
					} 
				}
			}).render(buttonRow);
		</c:if>			

		<c:if test="<%= displayStyle.equals(\"gantt\") %>">
			buttonLabel = "<liferay-ui:message key="list-style" />";
<%
			viewURL.setParameter("displayStyle", "list");
%>		
			new A.Button({
				icon: 'icon-list-ul',
				label: buttonLabel,
				on: { click: function(event) {
						location.href = "<%=viewURL.toString()%>";
					} 
				}
			}).render(buttonRow);
		</c:if>

		<c:if test="<%= !displayStyle.equals(\"gantt\") %>">
			buttonLabel = "<liferay-ui:message key="gantt-style" />";
<%
			viewURL.setParameter("displayStyle", "gantt");
%>		
			if($(window).width()>700) {
			new A.Button({
				icon: 'icon-bar-chart',
				label: buttonLabel,
				on: { click: function(event) {
						location.href = "<%=viewURL.toString()%>";
					} 
				}
			}).render(buttonRow);
			}
		</c:if>
	</aui:script>
</aui:button-row>


<%	
	if(displayStyle.equals("gantt")) {
%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dhtmlxgantt.js">
</script>

<div id="gantt_here" style="width:100%"></div>

<script type="text/javascript">
	$(function() {
		var adv_tasks = {
				"data":[
		<%
		int conheight=68;
			for(AdvTask at:tasks) {
				conheight+=34;
				String disStartDate = "";
				Date tStart = at.getAtStartDate();
				Date tFinal = at.getAtFinalDate();
				SimpleDateFormat sdfmt = new SimpleDateFormat();
				sdfmt.applyPattern("dd.MM.yyyy");
				if(tStart!=null) {
					disStartDate = sdfmt.format(tStart).toString();
				}
				long datediff = tFinal.getTime() - tStart.getTime();
				long diffdays = datediff / (24 * 60 * 60 * 1000); 
				long parentid=at.getAtParentTaskId();
				int stat = at.getAtStatus();
				double status = 0;
				if (stat == TaskConstants.STATUS_20) {
					status=0.2;
				}
				else if (stat == TaskConstants.STATUS_40) {
					status=0.4;
				}
				else if (stat == TaskConstants.STATUS_60) {
					status=0.6;
				}
				else if (stat == TaskConstants.STATUS_80) {
					status=0.8;
				}
				else if (stat == TaskConstants.STATUS_REOPEN) {
					status=0.95;
				}
				else if (stat == TaskConstants.STATUS_100) {
					status=1.0;
				}
				else {
					status=0.0;
				}
				String color = "white";
				int prio = at.getAtPriority();
				color = ProjectTasks.getColor(stat, prio, at.getAtFinalDate());
				if(parentid>0) {
		%>
					{id:<%= at.getAtId() %>, text:"<%= at.getAtTitle() %>", start_date:"<%= disStartDate %>", duration:"<%= diffdays %>", color: "<%= color %>", progress: <%= status %>, parent: <%= parentid %>},
		<%
				} else {
		%>
					{id:<%= at.getAtId() %>, text:"<%= at.getAtTitle() %>", start_date:"<%= disStartDate %>", duration:"<%= diffdays %>", color: "<%= color %>", progress: <%= status %>, open: true},
		<%
				}
			}
		%>
				],
				"links":[
		<%
				List<AdvTaskMapping> mappings = AdvTaskMappingLocalServiceUtil.getAdvTaskMappings(0, AdvTaskMappingLocalServiceUtil.getAdvTaskMappingsCount());
				for(AdvTaskMapping map:mappings) {
		%>
					{id:"<%= map.getAtMId() %>",source:"<%= map.getAtMDependentFromId() %>",target:"<%= map.getAtMTaskId() %>",type:"0"},
		<%
				}
		%>
				]
			};
			gantt.config.columns =  [
		                         {name:"text",       label:"Task name",  tree:true, width:'*' },
		                         {name:"end_date",   label:"End date",   align: "center" }
		                     ];
			gantt.config.readonly = true;
			gantt.init("gantt_here");
			gantt.parse(adv_tasks);	
			$('#gantt_here').css('height', '<%= conheight %>');
			$('.gantt_container').css('height', '<%= conheight %>');
			$('.gantt_grid').css('height', '<%= conheight %>');
			$('.gantt_grid_data').css('height', '<%= conheight - 34 %>');
			$('.gantt_task').css('height', '<%= conheight %>');
			$('.gantt_data_area').css('height', '<%= conheight - 34 %>');
			$(document).on('dblclick', '.gantt_row', function(e) {
				var task_id = $(this).attr('task_id');
				location.href = "<%= taskdetails.toString()%>" + "&_ProjectTasks_WAR_AdvancedTaskListportlet_taskId=" + task_id;
			});
			$(document).on('dblclick', '.gantt_task_line', function(e) {
				var task_id = $(this).attr('task_id');
				location.href = "<%= taskdetails.toString()%>" + "&_ProjectTasks_WAR_AdvancedTaskListportlet_taskId=" + task_id;
			});
	});
	
</script>
<%
	} else {
%>

<div id="tasklegend">
	<div class="helpicon"></div>
	<div id="legend" class="dropdown-menu">
		<div class="progress-wrapper">
			<div class="current" style="background-color:#FFE0B2">
				<div class="progress" style="background-color:#FF9800;width:40%"></div>
			</div>	
			<div class="help"><%= LanguageUtil.get(pageContext, TaskConstants.LABEL_PRIO_HIGH) %></div>
			<div class="current" style="background-color:#FFF9C4">
				<div class="progress" style="background-color:#FFEB3B;width:40%"></div>
			</div>	
			<div class="help"><%= LanguageUtil.get(pageContext, TaskConstants.LABEL_PRIO_NORMAL) %></div>
			<div class="current" style="background-color:#B2DFDB">
				<div class="progress" style="background-color:#009688;width:40%"></div>
			</div>	
			<div class="help"><%= LanguageUtil.get(pageContext, TaskConstants.LABEL_PRIO_LOW) %></div>
			<div class="current" style="background-color:#FFCDD2">
				<div class="progress" style="background-color:#F44336;width:40%"></div>
			</div>	
			<div class="help"><%= LanguageUtil.get(pageContext, TaskConstants.LABEL_OVERDUE) %></div>
			<div class="current" style="background-color:#CFD8DC">
				<div class="progress" style="background-color:#607D8B;width:100%"></div>
			</div>	
			<div class="help"><%= LanguageUtil.get(pageContext, TaskConstants.LABEL_STATUS_100) %></div>
			<div class="current" style="background-color:#E1BEE7">
				<div class="progress" style="background-color:#9C27B0;width:40%"></div>
			</div>	
			<div class="help"><%= LanguageUtil.get(pageContext, TaskConstants.LABEL_STATUS_REOPEN) %></div>
		</div>	
	</div>
</div>



<%
String orderByType = ParamUtil.getString(request, "orderByType");
String reverseOrderByType = "asc";
if (orderByType.equals("asc")) {
	reverseOrderByType = "desc";
}
%>

<liferay-ui:search-container delta="<%= delta %>" emptyResultsMessage="no-tasks-found" iteratorURL="<%= iteratorURL %>" >
	<liferay-ui:search-container-results
		total="<%= tasks.size() %>"
		results="<%= ListUtil.subList(tasks, searchContainer.getStart(),
											searchContainer.getEnd()) %>"/>
	<liferay-ui:search-container-row className="AdvTask" modelVar="task">
		<liferay-ui:search-container-column-text name="Task">
<%
	taskdetails.setParameter("taskId", Long.toString(task.getAtId()));
%>		
			<a href="<%= taskdetails %>"><%= task.getAtTitle() %></a>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="<%= LanguageUtil.get(pageContext, TaskConstants.LABEL_ASSIGNEDTO) %>">
<%
	String assigneduser = "na";			
	long thisuid = task.getAtAssignedToUserId();
	if(thisuid>0) {
		assigneduser = UserLocalServiceUtil.getUser(thisuid).getFullName();	
	}
%>		
			<%= assigneduser %>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="<%= LanguageUtil.get(pageContext, TaskConstants.LABEL_PRIORITY) %>">
<%
	int thisprio = task.getAtPriority();
	String priomessage = ProjectTasks.getPrioLabel(thisprio);
%>		
			<%= LanguageUtil.get(pageContext, priomessage) %>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="<%= LanguageUtil.get(pageContext, TaskConstants.LABEL_STARTDATE) %>">
<%
			String tS = "na";
			Date tStart = task.getAtStartDate();
			SimpleDateFormat sdfmt = new SimpleDateFormat();
			sdfmt.applyPattern("dd.MM.yyyy");
			if(tStart!=null) {
				tS = sdfmt.format(tStart).toString();
			}
%>		
		<%= tS %>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="<%= LanguageUtil.get(pageContext, TaskConstants.LABEL_FINALDATE) %>">
<%
			String tF = "na";
			Date tFinal = task.getAtFinalDate();
			SimpleDateFormat sdfmt = new SimpleDateFormat();
			sdfmt = new SimpleDateFormat();
			sdfmt.applyPattern("dd.MM.yyyy");
			if(tFinal!=null) {
				tF = sdfmt.format(tFinal).toString();
			}
%>
		<%= tF %>		
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text buffer="buffer" name="<%= LanguageUtil.get(pageContext, TaskConstants.LABEL_STATUS) %>">
<%
				int stat = task.getAtStatus();
				String color = ProjectTasks.getColor(stat, task.getAtPriority(), task.getAtFinalDate());
				String bgcolor = ProjectTasks.getBgColor(stat, task.getAtPriority(), task.getAtFinalDate());


				buffer.append("<div class=\"progress-wrapper\">");
				buffer.append("<div class=\"current\" style=\"background-color:");
				buffer.append(bgcolor);
				buffer.append("\"><div class=\"progress\" style=\"background-color:");
				buffer.append(color);
				buffer.append("; width: ");
				
				if (stat == TaskConstants.STATUS_20) {
					buffer.append("20%");
				}
				else if (stat == TaskConstants.STATUS_40) {
					buffer.append("40%");
				}
				else if (stat == TaskConstants.STATUS_60) {
					buffer.append("60%");
				}
				else if (stat == TaskConstants.STATUS_80) {
					buffer.append("80%");
				}
				else if (stat == TaskConstants.STATUS_REOPEN) {
					buffer.append("90%");
				}
				else if (stat == TaskConstants.STATUS_100) {
					buffer.append("100%");
				}
				else {
					buffer.append("0%");
				}

				buffer.append("\">");
				buffer.append("</div>");
				buffer.append("</div>");
				buffer.append("</div>");
%>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />	
</liferay-ui:search-container>
<%
	}
%>
