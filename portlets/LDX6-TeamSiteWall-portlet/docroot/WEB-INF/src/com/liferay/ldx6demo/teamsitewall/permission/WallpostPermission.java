package com.liferay.ldx6demo.teamsitewall.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.ldx6demo.teamsitewall.model.Wallpost;
import com.liferay.ldx6demo.teamsitewall.service.WallpostLocalServiceUtil;

public class WallpostPermission {

	public static void check(PermissionChecker permissionChecker, Wallpost post,
			String actionId) throws PortalException {

		if (!contains(permissionChecker, post, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, long postId,
			String actionId) throws PortalException, SystemException {

		if (!contains(permissionChecker, postId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			Wallpost post, String actionId) {

		if (permissionChecker.hasOwnerPermission(post.getCompanyId(),
				Wallpost.class.getName(), post.getWallpostId(), post.getUserId(),
				actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(post.getGroupId(),
				Wallpost.class.getName(), post.getWallpostId(), actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long postId, String actionId) throws PortalException,
			SystemException {

		Wallpost post = WallpostLocalServiceUtil.getWallpost(postId);

		return contains(permissionChecker, post, actionId);
	}

}