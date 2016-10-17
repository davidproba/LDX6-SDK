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

import com.liferay.AdvancedTasks.model.AdvTaskMapping;
import com.liferay.AdvancedTasks.model.impl.AdvTaskMappingImpl;
import com.liferay.AdvancedTasks.service.AdvTaskMappingLocalServiceUtil;
import com.liferay.AdvancedTasks.service.base.AdvTaskMappingLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the adv task mapping local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.AdvancedTasks.service.AdvTaskMappingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author David Proba
 * @see com.liferay.AdvancedTasks.service.base.AdvTaskMappingLocalServiceBaseImpl
 * @see com.liferay.AdvancedTasks.service.AdvTaskMappingLocalServiceUtil
 */
public class AdvTaskMappingLocalServiceImpl
	extends AdvTaskMappingLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.AdvancedTasks.service.AdvTaskMappingLocalServiceUtil} to access the adv task mapping local service.
	 */
	public List<AdvTaskMapping> getMTasks(long taskId) throws SystemException {
		return advTaskMappingPersistence.findByMTaskId(taskId);
	}
	
	public List<AdvTaskMapping> getDTasks(long taskId) throws SystemException {
		return advTaskMappingPersistence.findByDependentFromId(taskId);
	}
	
	public AdvTaskMapping insertTaskMapping(long taskId, long dependentId) {
		AdvTaskMapping taskM = new AdvTaskMappingImpl(); 
		long taskMId = 01;
		try {
			taskMId = CounterLocalServiceUtil.increment();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		taskM.setAtMId(taskMId);
		taskM.setAtMTaskId(taskId);
		taskM.setAtMDependentFromId(dependentId);
		
		
		try {
			taskM = AdvTaskMappingLocalServiceUtil.addAdvTaskMapping(taskM);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return taskM;
	}
}