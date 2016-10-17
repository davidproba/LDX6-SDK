create table LDXTeamSiteWall_Wallpost (
	uuid_ VARCHAR(75) null,
	wallpostId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	postMessage VARCHAR(75) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	createDate DATE null,
	modifiedDate DATE null,
	userName VARCHAR(75) null
);