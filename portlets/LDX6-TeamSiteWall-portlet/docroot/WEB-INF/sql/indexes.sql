create index IX_B7AF349 on LDXTeamSiteWall_Wallpost (groupId);
create index IX_835EF067 on LDXTeamSiteWall_Wallpost (status);
create index IX_2E16C413 on LDXTeamSiteWall_Wallpost (uuid_);
create index IX_BA700635 on LDXTeamSiteWall_Wallpost (uuid_, companyId);
create unique index IX_493E95F7 on LDXTeamSiteWall_Wallpost (uuid_, groupId);