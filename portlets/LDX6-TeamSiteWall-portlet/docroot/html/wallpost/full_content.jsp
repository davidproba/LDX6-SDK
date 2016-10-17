<%@page import="com.liferay.ldx6demo.teamsitewall.model.Wallpost"%>
<%@include file="/html/init.jsp"%>

<%
Wallpost post = (Wallpost)request.getAttribute("WALLPOST ENTRY");
%>

<%= post.getPostMessage() %>
