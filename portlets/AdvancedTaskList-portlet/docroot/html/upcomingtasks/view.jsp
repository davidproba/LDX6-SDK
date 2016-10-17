<%@page import="com.liferay.portlet.asset.model.AssetRenderer"%>
<%@page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetRendererFactory"%>
<%@ include file="/init.jsp" %>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.circliful.js">
</script>
<script type="text/javascript">
	$(function() {
		$('#myStat').circliful();
		var thisheight = $('.uptwrapper').outerHeight();
		$('#portlet_101_INSTANCE_gWNhwpT2fJkP').outerHeight(thisheight);
		$('#portlet_101_INSTANCE_cy4KzkQV7vHH').outerHeight(thisheight);
	});
</script>


<div class="uptwrapper">
	<div class="upttitle"><liferay-ui:message key="<%= TaskConstants.LABEL_UPCOMING_TASKS %>" /></div>
	<div class="uptcontent clearfix">
		<div class="uptchart span6">
<%
		List<AdvTask> tasks = AdvTaskLocalServiceUtil.getTasksByGroupId(themeDisplay.getScopeGroupId());
		int notasks = AdvTaskLocalServiceUtil.getTasksCountByGroupId(themeDisplay.getScopeGroupId());
		int allstatus = 0;
		for (AdvTask at : tasks) {
			allstatus += at.getAtStatus();
			if(at.getAtStatus()==TaskConstants.STATUS_REOPEN) {
				allstatus -= 2;
			}
		}
%>			
			<div id="myStat" data-dimension="150" data-text="<%= Math.round((double)allstatus/(5*notasks)*100)  %>%" data-width="10" data-fontsize="1em" data-percent="<%=(double)allstatus/(5*notasks)*100 %>" data-fgcolor="#304f98" data-bgcolor="#304f98" data-fill="#c9d5f4" data-total="100" data-part="<%=(double)allstatus/(5*notasks)*100 %>"></div>		
		</div>
		<div class="upttop5 span6">
<%
		List<AdvTask> top5tasks = AdvTaskLocalServiceUtil.getTasksByGroupId(themeDisplay.getScopeGroupId(), 0, 5);
		for (AdvTask at : top5tasks) {
			AssetRendererFactory arf = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(AdvTask.class.getName());
			AssetRenderer ar = arf.getAssetRenderer(at.getAtId());
			String viewURL = ar.getURLViewInContext(liferayPortletRequest, liferayPortletResponse, currentURL);
%>
		<a href="<%= viewURL %>"><img src="<%= ar.getIconPath(renderRequest) %>" /><%= at.getAtTitle() %></a><br />
<%			
		}
%>		
		</div>
	</div>
</div>