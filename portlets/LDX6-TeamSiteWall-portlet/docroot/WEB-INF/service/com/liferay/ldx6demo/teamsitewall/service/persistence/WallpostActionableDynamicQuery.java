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

package com.liferay.ldx6demo.teamsitewall.service.persistence;

import com.liferay.ldx6demo.teamsitewall.model.Wallpost;
import com.liferay.ldx6demo.teamsitewall.service.WallpostLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author David Proba
 * @generated
 */
public abstract class WallpostActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public WallpostActionableDynamicQuery() throws SystemException {
		setBaseLocalService(WallpostLocalServiceUtil.getService());
		setClass(Wallpost.class);

		setClassLoader(com.liferay.ldx6demo.teamsitewall.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("wallpostId");
	}
}