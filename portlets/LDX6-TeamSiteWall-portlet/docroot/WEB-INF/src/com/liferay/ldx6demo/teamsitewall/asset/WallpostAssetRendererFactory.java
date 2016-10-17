package com.liferay.ldx6demo.teamsitewall.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.liferay.ldx6demo.teamsitewall.model.Wallpost;
import com.liferay.ldx6demo.teamsitewall.service.WallpostLocalServiceUtil;

public class WallpostAssetRendererFactory extends BaseAssetRendererFactory {
@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {
		Wallpost post = WallpostLocalServiceUtil.getWallpost(classPK);
		return new WallpostAssetRenderer(post);
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
	
	public static final String CLASS_NAME = Wallpost.class.getName();
	public static final String TYPE = "wallpost";
	    
}
