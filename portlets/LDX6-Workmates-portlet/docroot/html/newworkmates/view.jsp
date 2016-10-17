<%@ include file="/html/init.jsp" %>


<div class="mateswrapper">
	<div class="matestitle">
<% 
	Date mDate = new Date(System.currentTimeMillis());
	int iMon = mDate.getMonth() +1;
	int iYear = mDate.getYear();
	String  aMonth = new SimpleDateFormat("MMMM", themeDisplay.getLocale()).format(mDate);
%>
		<i class="icon-group"></i><br /><br/><liferay-ui:message arguments="<%= aMonth %>" key="new-workmates-in" />
	</div>
	
<%
	List<User> users = UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount());
	List<User> mUsers = new ArrayList<User>();
	for(User u:users) {
		// Needs to be checked
		Date hDate = (Date)u.getExpandoBridge().getAttribute("Hired");
		int hMon = hDate.getMonth() +1;
		int hYear = hDate.getYear();
		if(hMon==iMon && hYear==iYear) {
			mUsers.add(u);
		}
	}
	for(User mu:mUsers) {
%>
	<div class="mate clearfix">
		<div class="mate-portrait"><a href="<%= mu.getDisplayURL(themeDisplay, false) %>"><img src="<%= HtmlUtil.escape(mu.getPortraitURL(themeDisplay)) %>" /></a>
		</div>
		<div class="mate-txt">
			<div class="mate-name"><a href="<%= mu.getDisplayURL(themeDisplay, false) %>"><%= mu.getFullName() %></a></div>
			<div class="mate-comment"><%= mu.getComments() %></div>
		</div>
	</div>
<%
	}
%>
</div>
