package com.liferay.AdvancedTasks.Handler;

public interface TaskConstants {

	static final String ACTION_INSERT_TASK ="insertTask";
	static final String ACTION_UPDATE_TASK ="updateTask";
	static final String ACTION_DELETE_TASK ="deleteTask";
	
	static final String PAGE_LIST = "/html/ProjectTasks/view.jsp";
	static final String PAGE_DETAIL = "/html/ProjectTasks/view_task.jsp";
	
	static final String LABEL_ADD_TASK = "tasks-add-task";
	static final String LABEL_EDIT_TASK = "tasks-edit-task";
	static final String LABEL_DELETE_TASK = "tasks-delete-task";
	static final String LABEL_FINISH_TASK = "tasks-finish-task";
	static final String LABEL_REOPEN_TASK = "tasks-reopen-task";
	
	
	static final String LABEL_TITLE = "tasks-title";
	static final String LABEL_DESCRIPTION = "tasks-description";
	static final String LABEL_STARTDATE = "tasks-startdate";
	static final String LABEL_FINALDATE = "tasks-finaldate";
	static final String LABEL_PRIORITY = "tasks-priority";
	static final String LABEL_STATUS = "tasks-status";
	static final String LABEL_ASSIGNEDTO = "tasks-assignedto";
	static final String LABEL_ASSIGNEDTO2 = "tasks-assignedto2";
	static final String LABEL_PARENTTASK = "tasks-parenttask";
	static final String LABEL_DEPENDANTTASKS = "tasks-dependanttasks";
	static final String LABEL_ADDSTARTDATE = "tasks-addstartdate";
	static final String LABEL_REMOVESTARTDATE = "tasks-removestartdate";
	static final String LABEL_ADDFINALDATE = "tasks-addfinaldate";
	static final String LABEL_REMOVEFINALDATE = "tasks-removefinaldate";
	static final String LABEL_OVERDUE = "tasks-overdue";
	static final String LABEL_DEPENDENCIES = "tasks-dependencies";
	static final String LABEL_PARENTTASKOF = "tasks-parenttaskof";
	static final String LABEL_SUBTASKOF = "tasks-subtaskof";
	static final String LABEL_UPCOMING_TASKS = "upcoming-tasks";
	
	
	static final int STATUS_BEGINN = 0;
	static final int STATUS_20 = 1;
	static final int STATUS_40 = 2;
	static final int STATUS_60 = 3;
	static final int STATUS_80 = 4;
	static final int STATUS_100 = 5;
	static final int STATUS_REOPEN = 6;

	public final int STATUS_ALL = 10;
	public final String STATUS_ALL_LABEL = "all";
	
	static final String LABEL_STATUS_BEGINN = "tasks-status-beginn";
	static final String LABEL_STATUS_20 = "tasks-status-20";
	static final String LABEL_STATUS_40 = "tasks-status-40";
	static final String LABEL_STATUS_60 = "tasks-status-60";
	static final String LABEL_STATUS_80 = "tasks-status-80";
	static final String LABEL_STATUS_100 = "tasks-status-100";
	static final String LABEL_STATUS_REOPEN = "tasks-status-reopen";
	
	static final int PRIO_HIGH = 1;
	static final int PRIO_NORMAL = 2;
	static final int PRIO_LOW = 3;

	static final String LABEL_PRIO_HIGH = "tasks-prio-high";
	static final String LABEL_PRIO_NORMAL = "tasks-prio-normal";
	static final String LABEL_PRIO_LOW = "tasks-prio-low";
	
	static final int TASK_ACTION_OPEN = 1;
	static final int TASK_ACTION_UPDATE = 2;
	static final int TASK_ACTION_FINISH = 3;
	static final int TASK_ACTION_REOPEN = 4;
	
}
