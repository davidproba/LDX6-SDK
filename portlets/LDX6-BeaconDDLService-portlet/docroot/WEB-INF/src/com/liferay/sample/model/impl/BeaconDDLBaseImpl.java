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

package com.liferay.sample.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.liferay.sample.model.BeaconDDL;
import com.liferay.sample.service.BeaconDDLLocalServiceUtil;

/**
 * The extended model base implementation for the BeaconDDL service. Represents a row in the &quot;BeaconDDL_BeaconDDL&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BeaconDDLImpl}.
 * </p>
 *
 * @author David Proba
 * @see BeaconDDLImpl
 * @see com.liferay.sample.model.BeaconDDL
 * @generated
 */
public abstract class BeaconDDLBaseImpl extends BeaconDDLModelImpl
	implements BeaconDDL {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a beacon d d l model instance should use the {@link BeaconDDL} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BeaconDDLLocalServiceUtil.addBeaconDDL(this);
		}
		else {
			BeaconDDLLocalServiceUtil.updateBeaconDDL(this);
		}
	}
}