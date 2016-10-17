<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@page import="com.liferay.portal.kernel.util.DateFormats"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.model.Group"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />