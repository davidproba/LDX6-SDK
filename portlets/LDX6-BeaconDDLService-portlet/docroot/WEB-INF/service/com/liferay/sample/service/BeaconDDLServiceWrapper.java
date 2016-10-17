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

package com.liferay.sample.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BeaconDDLService}.
 *
 * @author David Proba
 * @see BeaconDDLService
 * @generated
 */
public class BeaconDDLServiceWrapper implements BeaconDDLService,
	ServiceWrapper<BeaconDDLService> {
	public BeaconDDLServiceWrapper(BeaconDDLService beaconDDLService) {
		_beaconDDLService = beaconDDLService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _beaconDDLService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_beaconDDLService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _beaconDDLService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String getActiveBeaconUUID(java.lang.String companyId) {
		return _beaconDDLService.getActiveBeaconUUID(companyId);
	}

	@Override
	public java.lang.String getActiveBeaconMajor(java.lang.String companyId) {
		return _beaconDDLService.getActiveBeaconMajor(companyId);
	}

	@Override
	public java.lang.String getActiveBeaconMinor(java.lang.String companyId) {
		return _beaconDDLService.getActiveBeaconMinor(companyId);
	}

	@Override
	public java.lang.String getActiveBeaconHeader(java.lang.String companyId) {
		return _beaconDDLService.getActiveBeaconHeader(companyId);
	}

	@Override
	public java.lang.String getActiveBeaconBody(java.lang.String companyId) {
		return _beaconDDLService.getActiveBeaconBody(companyId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BeaconDDLService getWrappedBeaconDDLService() {
		return _beaconDDLService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBeaconDDLService(BeaconDDLService beaconDDLService) {
		_beaconDDLService = beaconDDLService;
	}

	@Override
	public BeaconDDLService getWrappedService() {
		return _beaconDDLService;
	}

	@Override
	public void setWrappedService(BeaconDDLService beaconDDLService) {
		_beaconDDLService = beaconDDLService;
	}

	private BeaconDDLService _beaconDDLService;
}