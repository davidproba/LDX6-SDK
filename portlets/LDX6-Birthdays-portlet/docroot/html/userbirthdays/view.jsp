<%@ include file="/html/init.jsp" %>


<div class="mateswrapper">
<div class="matestitle">
	<i class="icon-gift"></i><br /><br/><liferay-ui:message key="birthdays-this-week" />
</div>
<%

DateFormat dateFormatDate = DateFormats.getDate(locale, timeZone);
Date date = new Date();
Calendar c = Calendar.getInstance();
c.setTime(date);

int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
c.add(Calendar.DAY_OF_MONTH, -dayOfWeek);
Date weekStart = c.getTime();
int wsDay = weekStart.getDate();
int wsMon = weekStart.getMonth() +1;
c.add(Calendar.DAY_OF_MONTH, 6); 
Date weekEnd = c.getTime();
int weDay = weekEnd.getDate();
int weMon = weekEnd.getMonth()+1;
List<User> users = UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount());
List<User> mUsers = new ArrayList<User>();
for(User u:users) {
	Date bDay = u.getBirthday();
	int bdDay = bDay.getDate();
	int bdMon = bDay.getMonth()+1;
	if((wsMon==weMon&&(bdMon==wsMon&&bdDay>=wsDay&&bdDay<=weDay))
		|| (wsMon!=weMon&&((bdMon==wsMon&&bdDay>=wsDay)||(bdMon==weMon&&bdDay<=weDay)))) {
		mUsers.add(u);
	}
}

for(User mu:mUsers) {
	Calendar eoWeek = Calendar.getInstance();
	Calendar bDate = Calendar.getInstance();
	
	eoWeek.setTime(weekEnd);
	bDate.setTime(mu.getBirthday());
%>
<div class="mate mateb clearfix">
	<div class="mate-portrait"><a href="<%= mu.getDisplayURL(themeDisplay, false) %>"><img src="<%= HtmlUtil.escape(mu.getPortraitURL(themeDisplay)) %>" /></a>
	</div>
	<div class="mate-txt">
		<div class="mate-name"><a href="<%= mu.getDisplayURL(themeDisplay, false) %>"><%= mu.getFullName() %></a></div>
		<div class="mate-comment"><i class="icon-calendar"></i><%= dateFormatDate.format(mu.getBirthday()) %><i class="icon-beer"></i><%= eoWeek.get(Calendar.YEAR) - bDate.get(Calendar.YEAR) %></div>
	</div>
</div>
<%
}
%>
</div>
