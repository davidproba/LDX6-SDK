<%@ include file="/html/init.jsp" %>

<%

	Group thisgroup = themeDisplay.getScopeGroup();
	User thisuser = UserLocalServiceUtil.getUserById(thisgroup.getClassPK());
	
	DateFormat dateFormatDate = DateFormats.getDate(locale, timeZone);
	
%>

<div class="udetailswrapper">
	<div class="udetailscontainer">
		<div class="udetailslabel">
			<%= LanguageUtil.get(pageContext, "email") %>
		</div>
		<div class="udetailsvalue">
			<a href="mailto:<%= thisuser.getEmailAddress() %>"><%= thisuser.getEmailAddress() %></a>
		</div>
	</div>
	<div class="udetailscontainer">
		<div class="udetailslabel">
			<%= LanguageUtil.get(pageContext, "birthday") %>
		</div>
		<div class="udetailsvalue">
			<%= dateFormatDate.format(thisuser.getBirthday()) %>
		</div>
	</div>
	<div class="udetailscontainer">
		<div class="udetailslabel">
			<%= LanguageUtil.get(pageContext, "organizations") %>
		</div>
		<div class="udetailsvalue">
			<% 
				List<Organization> uorgs = thisuser.getOrganizations();
				for(Organization org : uorgs) {
					%>
							<%= org.getName() %><br/>
					<%
				}
			%>
		</div>
	</div>
	<div class="udetailscontainer">
		<div class="udetailslabel">
			<%= LanguageUtil.get(pageContext, "sites") %>
		</div>
		<div class="udetailsvalue">
			<% 
				List<Group> usites = thisuser.getSiteGroups();
				for(Group grp : usites) {
					if(grp.isRegularSite()) {
					%>
							<%= grp.getName() %><br/>
					<%
					}
				}
			%>
		</div>
	</div>
	<div class="udetailscontainer">
		<div class="udetailslabel">
			<%= LanguageUtil.get(pageContext, "ask-me-about") %>
		</div>
		<div class="udetailsvalue">
			<%= thisuser.getExpandoBridge().getAttribute("ask-me-about") %>
		</div>
	</div>
	<div class="udetailscontainer">
		<div class="udetailslabel">
			<%= LanguageUtil.get(pageContext, "my-hobbies") %>
		</div>
		<div class="udetailsvalue">
			<%= thisuser.getExpandoBridge().getAttribute("my-hobbies") %>
		</div>
	</div>
</div>