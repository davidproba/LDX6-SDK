package com.liferay.ldx6.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordServiceUtil;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.dynamicdatamapping.util.DDMUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalFolder;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class DDLTest
 */
public class DDLTest extends MVCPortlet {
 
	public void addDDL(ActionRequest aReq, ActionResponse aRes) {
		/**
		 * init
		 */
		ThemeDisplay themeDisplay = (ThemeDisplay)aReq.getAttribute(WebKeys.THEME_DISPLAY);
		String redirectURL = ParamUtil.getString(aReq, "redirectURL");
		long groupId = 0L;
		long folderId = 0L;
		ServiceContext serviceContext = null;
		try {
			groupId = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "LXM").getGroupId();
			serviceContext = ServiceContextFactory.getInstance(aReq);
			List<JournalFolder> folders = JournalFolderLocalServiceUtil.getFolders(GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "LXM").getGroupId());
			for(JournalFolder jf:folders) {
				if(jf.getName().contains(String.valueOf(themeDisplay.getScopeGroupId()))) {
					folderId=jf.getFolderId();
				}
			}
			List<Layout> layouts = LayoutLocalServiceUtil.getLayouts(groupId, false);
			for(Layout l:layouts) {
				System.out.println("Layout: "+l.getUuid()+l.getName());
			}
//			JournalArticle artTeam = JournalArticleLocalServiceUtil.getArticle(themeDisplay.getScopeGroupId(), "88569");
//			Calendar cal = Calendar.getInstance();
//			cal.setTime(artTeam.getDisplayDate());
			JournalArticle article;
			List<DDLRecordSet> recordSets = DDLRecordSetLocalServiceUtil.getRecordSets(GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "LXM").getGroupId());
			for(DDLRecordSet ddlRS:recordSets) {
				System.out.println("DDLR Schleife");
				if(ddlRS.getName().contains("TeamSite Mapping")) {
					System.out.println("Within TeamSite Mapping");
					for(DDLRecord lookupRecord:ddlRS.getRecords()) {
						System.out.println("DDLR Schleife Inner");
						if(lookupRecord.getField("Site_ID")!=null
								&&lookupRecord.getFieldValue("Site_ID").toString().contains(String.valueOf(themeDisplay.getScopeGroupId()))) {
							for(Layout l:layouts) {
								if(l.getName().contains(lookupRecord.getFieldValue("Article_Type").toString()))
									System.out.println("JAWOLL::: Layout: "+l.getUuid()+l.getName());
							}
						}
					}	
				}
/*				if(ddlRS.getName().contains("Shoe Articles")) {
					for(DDLRecord lookupRecord:ddlRS.getRecords()) {
						if(lookupRecord.getField("TeamContentID")!=null
								&&lookupRecord.getFieldValue("TeamContentID").toString().contains("88569")) {
							article = JournalArticleLocalServiceUtil.getArticle(groupId, 
									lookupRecord.getFieldValue("ContentID").toString());
							article.setContent(artTeam.getContent());
							article.setVersion(artTeam.getVersion());
							article.setDisplayDate(artTeam.getDisplayDate());
							article.setTitleMap(artTeam.getTitleMap());
							article.setModifiedDate(artTeam.getModifiedDate());
							article.setDescriptionMap(artTeam.getDescriptionMap());
							article.persist();
						} else {
							article = JournalArticleLocalServiceUtil.addArticle(themeDisplay.getUserId(),
									groupId, folderId, artTeam.getClassNameId(), artTeam.getClassPK(), "", true, 1.0, 
									artTeam.getTitleMap(), artTeam.getDescriptionMap(), artTeam.getContent(), artTeam.getType(), 
									artTeam.getStructureId(), artTeam.getTemplateId(), "827c2fcf-73a0-403b-8c8e-402146a99705", 
									cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 
									cal.get(Calendar.YEAR), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), 
									0, 0, 0, 0, 0, true, 0, 0, 0, 0, 0, true, 
									artTeam.isIndexable(), artTeam.getSmallImage(), artTeam.getSmallImageURL(), 
									null, new HashMap<String, byte[]>() , artTeam.getUrlTitle(), serviceContext);
							DDMStructure ddmStructure = ddlRS.getDDMStructure();
							Fields fields = DDMUtil.getFields(ddmStructure.getStructureId(), serviceContext);
							Field field = new Field(ddmStructure.getStructureId(), "ContentID", article.getArticleId());
							field.setDefaultLocale(LocaleUtil.getDefault());
							fields.put(field);
							field = new Field(ddmStructure.getStructureId(), "FolderID", article.getFolderId());
							field.setDefaultLocale(themeDisplay.getSiteDefaultLocale());
							fields.put(field);
							field = new Field(ddmStructure.getStructureId(), "FriendlyLink", "/web/lxm/-/" + article.getUrlTitle());
							field.setDefaultLocale(themeDisplay.getSiteDefaultLocale());
							fields.put(field);
							field = new Field(ddmStructure.getStructureId(), "TeamSiteID", themeDisplay.getScopeGroupId());
							field.setDefaultLocale(themeDisplay.getSiteDefaultLocale());
							fields.put(field);
							field = new Field(ddmStructure.getStructureId(), "TeamContentID", "88569");
							field.setDefaultLocale(themeDisplay.getSiteDefaultLocale());
							fields.put(field);
							DDLRecordServiceUtil.addRecord(groupId, ddlRS.getRecordSetId(), 0, fields, serviceContext);
						}
					}
				}*/
			} 
			aRes.sendRedirect(redirectURL);
		} catch (IOException | PortalException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
