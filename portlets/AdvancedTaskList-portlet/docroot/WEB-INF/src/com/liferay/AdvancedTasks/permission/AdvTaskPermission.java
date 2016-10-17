package com.liferay.AdvancedTasks.permission;

import com.liferay.AdvancedTasks.model.AdvTask;
import com.liferay.AdvancedTasks.service.AdvTaskLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class AdvTaskPermission {

	public static void check(PermissionChecker permissionChecker, AdvTask task,
			String actionId) throws PortalException {

		if (!contains(permissionChecker, task, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, long taskId,
			String actionId) throws PortalException, SystemException {

		if (!contains(permissionChecker, taskId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			AdvTask task, String actionId) {

		if (permissionChecker.hasOwnerPermission(task.getCompanyId(),
				AdvTask.class.getName(), task.getAtId(), task.getUserId(),
				actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(task.getGroupId(),
				AdvTask.class.getName(), task.getAtId(), actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long taskId, String actionId) throws PortalException,
			SystemException {

		AdvTask task = AdvTaskLocalServiceUtil.getAdvTask(taskId);

		return contains(permissionChecker, task, actionId);
	}

}