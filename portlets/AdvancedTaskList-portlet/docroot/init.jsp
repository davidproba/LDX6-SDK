<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.text.Format"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%>

<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.model.Group" %>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portlet.messageboards.model.MBMessage"%>
<%@page import="com.liferay.portlet.messageboards.model.MBTreeWalker"%>
<%@page import="com.liferay.portlet.messageboards.model.MBThread"%>
<%@page import="com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil"%>
<%@page import="com.liferay.portlet.messageboards.model.MBMessageDisplay"%>
<%@page import="com.liferay.portlet.messageboards.util.comparator.MessageCreateDateComparator"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>

<%@page import="com.liferay.AdvancedTasks.Handler.ProjectTasks"%>
<%@page import="com.liferay.AdvancedTasks.Handler.TaskConstants"%>
<%@page import="com.liferay.AdvancedTasks.service.AdvTaskLocalServiceUtil"%>
<%@page import="com.liferay.AdvancedTasks.model.AdvTask"%>

<%@page import="com.liferay.AdvancedTasks.service.AdvTaskMappingLocalServiceUtil"%>
<%@page import="com.liferay.AdvancedTasks.model.AdvTaskMapping"%>



<portlet:defineObjects />
<liferay-theme:defineObjects />

<%

String currentURL = PortalUtil.getCurrentURL(request);
Group group = themeDisplay.getScopeGroup();
Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
%>