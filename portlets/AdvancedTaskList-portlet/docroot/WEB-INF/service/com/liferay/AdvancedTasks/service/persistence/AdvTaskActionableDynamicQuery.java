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

package com.liferay.AdvancedTasks.service.persistence;

import com.liferay.AdvancedTasks.model.AdvTask;
import com.liferay.AdvancedTasks.service.AdvTaskLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author David Proba
 * @generated
 */
public abstract class AdvTaskActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public AdvTaskActionableDynamicQuery() throws SystemException {
		setBaseLocalService(AdvTaskLocalServiceUtil.getService());
		setClass(AdvTask.class);

		setClassLoader(com.liferay.AdvancedTasks.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("atId");
	}
}