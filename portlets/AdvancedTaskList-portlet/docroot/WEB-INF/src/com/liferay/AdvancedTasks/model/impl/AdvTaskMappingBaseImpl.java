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

package com.liferay.AdvancedTasks.model.impl;

import com.liferay.AdvancedTasks.model.AdvTaskMapping;
import com.liferay.AdvancedTasks.service.AdvTaskMappingLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the AdvTaskMapping service. Represents a row in the &quot;AdvancedTasks_AdvTaskMapping&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AdvTaskMappingImpl}.
 * </p>
 *
 * @author David Proba
 * @see AdvTaskMappingImpl
 * @see com.liferay.AdvancedTasks.model.AdvTaskMapping
 * @generated
 */
public abstract class AdvTaskMappingBaseImpl extends AdvTaskMappingModelImpl
	implements AdvTaskMapping {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a adv task mapping model instance should use the {@link AdvTaskMapping} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AdvTaskMappingLocalServiceUtil.addAdvTaskMapping(this);
		}
		else {
			AdvTaskMappingLocalServiceUtil.updateAdvTaskMapping(this);
		}
	}
}