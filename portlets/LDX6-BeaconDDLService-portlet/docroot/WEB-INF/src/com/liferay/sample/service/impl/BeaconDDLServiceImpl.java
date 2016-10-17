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

package com.liferay.sample.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.sample.service.base.BeaconDDLServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the beacon d d l remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.sample.service.BeaconDDLService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author David Proba
 * @see com.liferay.sample.service.base.BeaconDDLServiceBaseImpl
 * @see com.liferay.sample.service.BeaconDDLServiceUtil
 */
public class BeaconDDLServiceImpl extends BeaconDDLServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.sample.service.BeaconDDLServiceUtil} to access the beacon d d l remote service.
	 */
	@AccessControlled(guestAccessEnabled = true)
	public String getActiveBeaconUUID(String companyId) {
		DDLRecord record = getActiveBeaconRecord(companyId);
		try {
			return (String)record.getFields().get("UUID").getValue();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@AccessControlled(guestAccessEnabled = true)
	public String getActiveBeaconMajor(String companyId) {
		DDLRecord record = getActiveBeaconRecord(companyId);
		try {
			return (String)record.getFields().get("Major").getValue();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@AccessControlled(guestAccessEnabled = true)
	public String getActiveBeaconMinor(String companyId) {
		DDLRecord record = getActiveBeaconRecord(companyId);
		try {
			return (String)record.getFields().get("Minor").getValue();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public String getActiveBeaconHeader(String companyId) {
		DDLRecord record = getActiveBeaconRecord(companyId);
		try {
			return (String)record.getFields().get("Header").getValue();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@AccessControlled(guestAccessEnabled = true)
	public String getActiveBeaconBody(String companyId) {
		DDLRecord record = getActiveBeaconRecord(companyId);
		try {
			return (String)record.getFields().get("Body").getValue();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private DDLRecord getActiveBeaconRecord(String cId) {
		long companyId = Long.valueOf(cId);
		List<DDLRecordSet> recordSets;
		try {
			recordSets = DDLRecordSetLocalServiceUtil.getRecordSets(GroupLocalServiceUtil.getGroup(companyId, "LXM").getGroupId());
			for(DDLRecordSet ddlRS:recordSets) {
				if(ddlRS.getName().contains("Beacons")) {
					List<DDLRecord> records = DDLRecordLocalServiceUtil.getRecords(ddlRS.getRecordSetId());
					for(DDLRecord record:records) {
						if(record.getFields().get("Act").getValue().equals("true")) {
							return record;
						}
					}
				}
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}