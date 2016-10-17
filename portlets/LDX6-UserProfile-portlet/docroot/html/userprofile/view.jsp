<%@ include file="/html/init.jsp" %>


<%

	Group thisgroup = themeDisplay.getScopeGroup();
	User thisuser = UserLocalServiceUtil.getUserById(thisgroup.getClassPK());
%>


<div class="profile-wrapper row-fluid">
	<div class="profile-bgimage span4"></div>
	<div class="profile-container span8">
		<img src="<%= HtmlUtil.escape(thisuser.getPortraitURL(themeDisplay)) %>" class="picture-nonresp" />
		<img src="<%= HtmlUtil.escape(thisuser.getPortraitURL(themeDisplay)) %>" class="picture-resp" />
		<div class="profile-txt">
			<h1><%= thisuser.getFullName() %></h1>
			<h4><%= thisuser.getJobTitle() %></h4>
			<span><%= thisuser.getComments() %></span>
		</div>
	</div>
</div>