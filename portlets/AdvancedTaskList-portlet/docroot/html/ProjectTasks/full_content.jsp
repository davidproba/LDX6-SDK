<%@include file="/init.jsp"%>

<%
AdvTask task = (AdvTask)request.getAttribute("TASK ENTRY");
%>

<%= task.getAtDescription() %>
