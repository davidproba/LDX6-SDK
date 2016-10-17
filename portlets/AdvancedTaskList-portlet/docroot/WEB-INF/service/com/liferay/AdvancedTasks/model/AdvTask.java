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

package com.liferay.AdvancedTasks.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the AdvTask service. Represents a row in the &quot;AdvancedTasks_AdvTask&quot; database table, with each column mapped to a property of this class.
 *
 * @author David Proba
 * @see AdvTaskModel
 * @see com.liferay.AdvancedTasks.model.impl.AdvTaskImpl
 * @see com.liferay.AdvancedTasks.model.impl.AdvTaskModelImpl
 * @generated
 */
public interface AdvTask extends AdvTaskModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.AdvancedTasks.model.impl.AdvTaskImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getAssigneeFullName();

	public java.lang.String getPriorityLabel();

	public java.lang.String getReporterFullName();

	public java.lang.String getStatusLabel();
}