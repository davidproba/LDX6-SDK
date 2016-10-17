/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.AdvancedTasks.service.impl;

import com.liferay.AdvancedTasks.Handler.ProjectTasks;
import com.liferay.AdvancedTasks.Handler.TaskConstants;
import com.liferay.AdvancedTasks.model.AdvTask;
import com.liferay.AdvancedTasks.service.base.AdvTaskLocalServiceBaseImpl;
import com.liferay.AdvancedTasks.social.AdvTaskActivityKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.notifications.NotificationEvent;
import com.liferay.portal.kernel.notifications.NotificationEventFactoryUtil;
import com.liferay.portal.kernel.notifications.UserNotificationManagerUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.UserNotificationDeliveryConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * The implementation of the adv task local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.AdvancedTasks.service.AdvTaskLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author David Proba
 * @see com.liferay.AdvancedTasks.service.base.AdvTaskLocalServiceBaseImpl
 * @see com.liferay.AdvancedTasks.service.AdvTaskLocalServiceUtil
 */
public class AdvTaskLocalServiceImpl extends AdvTaskLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.AdvancedTasks.service.AdvTaskLocalServiceUtil} to access the adv task local service.
	 */
	
	public AdvTask insertTask(String title, String description, Date startDate, Date finalDate,
			int priority, int status, long modifier, long asignee, long resolver, long parent, 
			ThemeDisplay tD, ServiceContext serviceContext) throws SystemException, PortalException {

		long taskId = counterLocalService.increment(AdvTask.class.getName());
		long userId = serviceContext.getUserId();
		
		AdvTask task = advTaskPersistence.create(taskId);
		
		task.setAtId(taskId);
		
		task.setGroupId(tD.getScopeGroupId());
		
		task.setCreateDate(new Date());
		task.setModifiedDate(new Date());
		task.setCompanyId(tD.getCompanyId());
		task.setUserId(tD.getUserId());
		task.setUserName(tD.getUser().getFullName());
		
		task.setAtTitle(title);
		task.setAtDescription(description);
		task.setAtStartDate(startDate);
		task.setAtFinalDate(finalDate);
		task.setAtPriority(priority);
		task.setAtStatus(status);
		task.setAtModifierUserId(modifier);
		task.setAtAssignedToUserId(asignee);
		task.setAtResolverUserId(resolver);
		task.setAtParentTaskId(parent);
		task.setUuid(PortalUUIDUtil.generate());
		
		advTaskPersistence.update(task);
		
		resourceLocalService.addResources(task.getCompanyId(),
				task.getGroupId(), userId, AdvTask.class.getName(), taskId, false,
				true, true);
		
		socialActivityLocalService.addActivity(userId, task.getGroupId(), 
				AdvTask.class.getName(), taskId, 
				AdvTaskActivityKeys.ADD_TASK, StringPool.BLANK, 0);
		assetEntryLocalService.updateEntry(
				userId, task.getGroupId(), AdvTask.class.getName(),
				taskId, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames());
		
		sendNotificationEvent(
				task, TaskConstants.STATUS_ALL, asignee,
				serviceContext);
		Indexer indexer = IndexerRegistryUtil.getIndexer(AdvTask.class);
		indexer.reindex(task);
		
		
		return task;
	}
	
	public AdvTask updateTask(AdvTask editedTask, ServiceContext serviceContext) throws SystemException, PortalException {
		AdvTask task = super.getAdvTask(editedTask.getAtId());
		sendNotificationEvent(editedTask, task.getAtStatus(), task.getAtAssignedToUserId(), serviceContext);

		task = super.updateAdvTask(editedTask);
		
		long userId = serviceContext.getUserId();

		socialActivityLocalService.addActivity(userId, task.getGroupId(), 
				AdvTask.class.getName(), editedTask.getAtId(), 
				AdvTaskActivityKeys.UPDATE_TASK, StringPool.BLANK, 0);
		
		assetEntryLocalService.updateEntry(
				userId, task.getGroupId(), AdvTask.class.getName(),
				task.getAtId(), serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames());
		
		return task;
	}

	
	public AdvTask deleteTask(AdvTask delTask)
			throws SystemException, PortalException {

		resourceLocalService.deleteResource(delTask.getCompanyId(),
				AdvTask.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				delTask.getPrimaryKey());
		
		socialActivityLocalService.deleteActivities(AdvTask.class.getName(), delTask.getAtId());
		assetEntryLocalService.deleteEntry(AdvTask.class.getName(),
				delTask.getAtId());
		Indexer indexer = IndexerRegistryUtil.getIndexer(AdvTask.class);
		indexer.delete(delTask);
		return super.deleteAdvTask(delTask);
	}

	
	public void sendNotificationEvent(
			AdvTask task, int oldStatus, long oldAssigneeUserId,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		HashSet<Long> receiverUserIds = new HashSet<Long>(3);

		receiverUserIds.add(oldAssigneeUserId);
		receiverUserIds.add(task.getUserId());
		receiverUserIds.add(task.getAtAssignedToUserId());

		receiverUserIds.remove(serviceContext.getUserId());

		JSONObject notificationEventJSONObject =
			JSONFactoryUtil.createJSONObject();

		notificationEventJSONObject.put(
			"classPK", task.getAtId());
		notificationEventJSONObject.put("userId", serviceContext.getUserId());

		for (long receiverUserId : receiverUserIds) {
			if ((receiverUserId == 0) ||
				!UserNotificationManagerUtil.isDeliver(
					receiverUserId, "ProjectTasks_WAR_AdvancedTaskListportlet", 0,
					TaskConstants.STATUS_ALL,
					UserNotificationDeliveryConstants.TYPE_WEBSITE)) {

				continue;
			}

			String title = StringPool.BLANK;

			if (oldStatus == TaskConstants.STATUS_ALL) {
				title = "x-assigned-you-a-task";
			}
			else if (task.getAtAssignedToUserId() != oldAssigneeUserId) {
				if (receiverUserId == oldAssigneeUserId) {
					title = "x-reassigned-your-task";
				}
				else {
					title = "x-assigned-you-a-task";
				}
			}
			else if (task.getAtStatus() != oldStatus) {
				if ((task.getAtStatus() !=
						TaskConstants.STATUS_BEGINN) &&
					(task.getAtStatus() !=
						TaskConstants.STATUS_REOPEN) &&
					(task.getAtStatus() !=
						TaskConstants.STATUS_100)) {

					return;
				}

				String statusLabel = ProjectTasks.getStatusLabel(
					task.getAtStatus());

				title = "x-" + statusLabel + "-the-task";
			}
			else {
				title = "x-modified-the-task";
			}

			notificationEventJSONObject.put("title", title);

			NotificationEvent notificationEvent =
				NotificationEventFactoryUtil.createNotificationEvent(
					System.currentTimeMillis(), "ProjectTasks_WAR_AdvancedTaskListportlet",
					notificationEventJSONObject);

			notificationEvent.setDeliveryRequired(0);

			UserNotificationEventLocalServiceUtil.addUserNotificationEvent(
				receiverUserId, notificationEvent);
		}
		
		
/*		String title = StringPool.BLANK;
		JSONObject notificationEventJSONObject =
				JSONFactoryUtil.createJSONObject();

		notificationEventJSONObject.put(
				"classPK", task.getAtId());
		notificationEventJSONObject.put("userId", serviceContext.getUserId());

		// new Assignee
		title = "x-assigned-you-a-task";
		notificationEventJSONObject.put("title", title);

		NotificationEvent notificationEvent =
			NotificationEventFactoryUtil.createNotificationEvent(
				System.currentTimeMillis(), "ProjectTasks_WAR_AdvancedTaskListportlet",
				notificationEventJSONObject);

		notificationEvent.setDeliveryRequired(0);

		UserNotificationEventLocalServiceUtil.addUserNotificationEvent(
			task.getAtAssignedToUserId(), notificationEvent);
		
		
		// old Assignee
		if(oldAssigneeUserId>0) {
			title = "x-reassigned-your-task";
			notificationEventJSONObject.put("title", title);

			notificationEvent =
				NotificationEventFactoryUtil.createNotificationEvent(
					System.currentTimeMillis(), "ProjectTasks_WAR_AdvancedTaskListportlet",
					notificationEventJSONObject);

			notificationEvent.setDeliveryRequired(0);

			UserNotificationEventLocalServiceUtil.addUserNotificationEvent(
				task.getAtAssignedToUserId(), notificationEvent);
		} */
	}

	    
	public AdvTask deleteTask(long taskId) throws PortalException, SystemException {
		AdvTask task = advTaskLocalService.getAdvTask(taskId);
		return deleteAdvTask(task);
	}
	
	public List<AdvTask> getTasksByGroupId(long groupId) throws SystemException {

		return advTaskPersistence.filterFindByGroupId(groupId);
	}

	public List<AdvTask> getTasksByGroupId(long groupId, int start, int end) throws SystemException {
		
		return advTaskPersistence.filterFindByGroupId(groupId, start, end);
	}

	public int getTasksCountByGroupId(long groupId) throws SystemException {

		return advTaskPersistence.filterCountByGroupId(groupId);
	}
	
	public List<AdvTask> getTasksByAssigneeId(long assigneeId) throws SystemException {

		return advTaskPersistence.findByAssignedToUserId(assigneeId);
	}

	public List<AdvTask> getTasksByAssigneeId(long assigneeId, int start, int end) throws SystemException {
		
		return advTaskPersistence.findByAssignedToUserId(assigneeId, start, end);
	}

	public int getTasksCountByAssigneeId(long assigneeId) throws SystemException {

		return advTaskPersistence.countByAssignedToUserId(assigneeId);
	}
	
	public List<AdvTask> getTasksByStatus(int status) throws SystemException {
		
		return advTaskPersistence.findByStatus(status);
	}
	
	public List<AdvTask> getChildTasks(long taskId) throws SystemException {
		return advTaskPersistence.findByParentTaskId(taskId);
	}
}