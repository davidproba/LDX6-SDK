create index IX_48185C1 on AdvancedTasks_AdvTask (atAssignedToUserId);
create index IX_49891D3C on AdvancedTasks_AdvTask (atParentTaskId);
create index IX_D87AA29F on AdvancedTasks_AdvTask (groupId);
create index IX_1EA0FE51 on AdvancedTasks_AdvTask (status);
create index IX_E8C650E9 on AdvancedTasks_AdvTask (uuid_);
create index IX_6151379F on AdvancedTasks_AdvTask (uuid_, companyId);
create unique index IX_82B119E1 on AdvancedTasks_AdvTask (uuid_, groupId);

create index IX_50BA5B8D on AdvancedTasks_AdvTaskMapping (atMDependentFromId);
create index IX_D8AC33BB on AdvancedTasks_AdvTaskMapping (atMTaskId);