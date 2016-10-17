<%@page import="com.liferay.portlet.asset.model.AssetRenderer"%>
<%@page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetRendererFactory"%>
<%@ include file="/init.jsp" %>


<%
List<AdvTask> tasks = AdvTaskLocalServiceUtil.getTasksByAssigneeId(themeDisplay.getUserId());

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("jspPage", "/html/personaltasks/view.jsp");
int delta = 10;

%>




<liferay-ui:search-container delta="<%= delta %>" emptyResultsMessage="no-tasks-found" iteratorURL="<%= iteratorURL %>" >
	<liferay-ui:search-container-results
		total="<%= tasks.size() %>"
		results="<%= ListUtil.subList(tasks, searchContainer.getStart(),
											searchContainer.getEnd()) %>"/>
	<liferay-ui:search-container-row className="AdvTask" modelVar="task">
		<liferay-ui:search-container-column-text name="Task">
<%
			AssetRendererFactory arf = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(AdvTask.class.getName());
			AssetRenderer ar = arf.getAssetRenderer(task.getAtId());
			String viewURL = ar.getURLViewInContext(liferayPortletRequest, liferayPortletResponse, currentURL);
%>		
			<a href="<%= viewURL %>"><%= task.getAtTitle() %></a>
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
