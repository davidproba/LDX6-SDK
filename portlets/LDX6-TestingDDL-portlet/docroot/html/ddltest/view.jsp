<%@page import="com.liferay.portal.service.ServiceContextFactory"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>
<%@page import="com.liferay.portlet.dynamicdatalists.util.DDLUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portlet.dynamicdatamapping.storage.Field"%>
<%@page import="com.liferay.portlet.dynamicdatamapping.storage.Fields"%>
<%@page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalServiceUtil"%>
<%@page import="com.liferay.portlet.dynamicdatalists.model.DDLRecord"%>
<%@page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>


<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

This group: <%= themeDisplay.getScopeGroupName() %><br/>
This group ID: <%= themeDisplay.getScopeGroupId() %><br/>
Parent group: <%= GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "LXM").getName() %><br/>
Parent group ID: <%= GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "LXM").getGroupId() %><br/>

<%
ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
List<DDLRecordSet> recordSets = DDLRecordSetLocalServiceUtil.getRecordSets(GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "LXM").getGroupId());
for(DDLRecordSet ddlRS:recordSets) {
%>	
	<%= ddlRS.getName() %><br/>
<%	
	if(ddlRS.getName().contains("Beacons")) {
		List<DDLRecord> records = DDLRecordLocalServiceUtil.getRecords(ddlRS.getRecordSetId());
		for(DDLRecord record:records) {
		%>	
			<%= record.getPrimaryKey() %><br/>
		<%	
			Fields fields = record.getFields();
			for(Field f:fields) {
				if(f.getName().contains("Act")) {
					f.setValue("yes");
				}
			%>	
				<%= f.getName() %><br/>
				<%= f.getValue() %><br/>
			<%	
			}
			DDLRecordLocalServiceUtil.updateRecord(themeDisplay.getUserId(), record.getRecordId(), true, record.getDisplayIndex(), fields, true, serviceContext);
//			DDLUtil.updateRecord(record.getRecordId(), record.getRecordSetId(), true, serviceContext);
		}
	}
}



PortletURL viewURL = renderResponse.createRenderURL();
PortletURL updateURL = renderResponse.createActionURL();
updateURL.setParameter(ActionRequest.ACTION_NAME, "addDDL");
updateURL.setParameter("redirectURL", viewURL.toString());

%>

<aui:form name='fm' method="POST" action="<%= updateURL.toString() %>">
		<aui:button type="submit" value="Save" />
</aui:form>


