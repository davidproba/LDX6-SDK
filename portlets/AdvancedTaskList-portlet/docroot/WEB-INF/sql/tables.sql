create table AdvancedTasks_AdvTask (
	uuid_ VARCHAR(75) null,
	atId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	atTitle VARCHAR(75) null,
	atDescription VARCHAR(75) null,
	atStartDate DATE null,
	atFinalDate DATE null,
	atPriority INTEGER,
	atStatus INTEGER,
	atModifierUserId LONG,
	atAssignedToUserId LONG,
	atResolverUserId LONG,
	atParentTaskId LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table AdvancedTasks_AdvTaskMapping (
	atMId LONG not null primary key,
	atMTaskId LONG,
	atMDependentFromId LONG
);