package com.liferay.AdvancedTasks.asset;

import com.liferay.AdvancedTasks.model.AdvTask;
import com.liferay.AdvancedTasks.service.AdvTaskLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class AdvTaskAssetRendererFactory extends BaseAssetRendererFactory {
@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {
		AdvTask task = AdvTaskLocalServiceUtil.getAdvTask(classPK);
		return new AdvTaskAssetRenderer(task);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public boolean isLinkable() {
		return true;
	}
	
	@Override
	public boolean isCategorizable() {
		return true;
	}
	
	public static final String CLASS_NAME = AdvTask.class.getName();
	public static final String TYPE = "advtask";
	    
}
