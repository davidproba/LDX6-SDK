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

package com.liferay.ldx6demo.teamsitewall.service.impl;

import com.liferay.ldx6demo.teamsitewall.service.base.WallpostLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.ldx6demo.teamsitewall.model.Wallpost;
import com.liferay.ldx6demo.teamsitewall.social.WallpostActivityKeys;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the wallpost local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.ldx6demo.teamsitewall.service.WallpostLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author David Proba
 * @see com.liferay.ldx6demo.teamsitewall.service.base.WallpostLocalServiceBaseImpl
 * @see com.liferay.ldx6demo.teamsitewall.service.WallpostLocalServiceUtil
 */
public class WallpostLocalServiceImpl extends WallpostLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.ldx6demo.teamsitewall.service.WallpostLocalServiceUtil} to access the wallpost local service.
	 */
	public Wallpost addWallpost(String message, ServiceContext serviceContext) throws SystemException, PortalException {
		
		long wallpostId = counterLocalService.increment(Wallpost.class.getName());
		long userId = serviceContext.getUserId();
		
		Wallpost post = wallpostPersistence.create(wallpostId);
		post.setPostMessage(message);
		post.setCompanyId(serviceContext.getCompanyId());
		post.setUuid(PortalUUIDUtil.generate());
		post.setGroupId(serviceContext.getScopeGroupId());
		post.setUserId(userId);
		post.setUserName(userLocalService.getUser(userId).getFullName());
		post.setCreateDate(new Date());
		post.setModifiedDate(new Date());
		
		wallpostPersistence.update(post);
		
		resourceLocalService.addResources(post.getCompanyId(),
				post.getGroupId(), userId, Wallpost.class.getName(), wallpostId, false,
				true, true);
		
		socialActivityLocalService.addActivity(userId, post.getGroupId(), 
				Wallpost.class.getName(), wallpostId, 
				WallpostActivityKeys.ADD_POST, StringPool.BLANK, 0);
		assetEntryLocalService.updateEntry(
				userId, post.getGroupId(), Wallpost.class.getName(),
				wallpostId, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames());		
		Indexer indexer = IndexerRegistryUtil.getIndexer(Wallpost.class);
		indexer.reindex(post);
		
		
		return post;
	}
	
	public Wallpost updateWallpost(Wallpost editedWallpost, ServiceContext serviceContext) throws SystemException, PortalException {
		Wallpost post = super.updateWallpost(editedWallpost);
		
		long userId = serviceContext.getUserId();
		
		assetEntryLocalService.updateEntry(
				userId, post.getGroupId(), Wallpost.class.getName(),
				post.getWallpostId(), serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames());
		
		return post;
	}

	
	public Wallpost deleteWallpost(Wallpost delPost)
			throws SystemException, PortalException {

		resourceLocalService.deleteResource(delPost.getCompanyId(),
				Wallpost.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				delPost.getPrimaryKey());
		
		socialActivityLocalService.deleteActivities(Wallpost.class.getName(), delPost.getWallpostId());
		assetEntryLocalService.deleteEntry(Wallpost.class.getName(),
				delPost.getWallpostId());
		Indexer indexer = IndexerRegistryUtil.getIndexer(Wallpost.class);
		indexer.delete(delPost);
		return super.deleteWallpost(delPost);

	}
	    
	public Wallpost deleteWallpost(long postId) throws PortalException, SystemException {
		Wallpost post = wallpostLocalService.getWallpost(postId);
		return deleteWallpost(post);
	}
	

	public List<Wallpost> getWallpostsByGroupId(long groupId) throws SystemException {

		return wallpostPersistence.filterFindByGroupId(groupId);
	}

	public List<Wallpost> getWallpostsByGroupId(long groupId, int start, int end) throws SystemException {

		return wallpostPersistence.filterFindByGroupId(groupId, start, end);
	}

	public int getWallpostsCountByGroupId(long groupId) throws SystemException {

		return wallpostPersistence.filterCountByGroupId(groupId);
	}
	
	
	
	public List<Wallpost>getWallpostsByStatus(int status) throws SystemException {
		
		return wallpostPersistence.findByStatus(status);
	}

}