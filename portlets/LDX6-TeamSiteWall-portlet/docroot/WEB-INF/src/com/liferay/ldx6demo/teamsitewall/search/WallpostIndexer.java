package com.liferay.ldx6demo.teamsitewall.search;

import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.ldx6demo.teamsitewall.model.Wallpost;
import com.liferay.ldx6demo.teamsitewall.permission.WallpostPermission;
import com.liferay.ldx6demo.teamsitewall.service.WallpostLocalServiceUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

public class WallpostIndexer extends BaseIndexer {
	
	public WallpostIndexer() {
		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker,
			String entryClassName, long entryClassPK, String actionId)
			throws Exception {

		return WallpostPermission.contains(permissionChecker,
				entryClassPK, ActionKeys.VIEW);
	}

	@Override
	protected void doDelete(Object obj) throws Exception {

		Wallpost post = (Wallpost)obj;
		Document document = new DocumentImpl();

		document.addUID(PORTLET_ID, post.getPrimaryKey());

		String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
		SearchEngineUtil.deleteDocument(searchEngineId,
				post.getCompanyId(), document.get(Field.UID));
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {

		Wallpost post = (Wallpost) obj;
		long groupId = getSiteGroupId(post.getGroupId());
		long scopeGroupId = post.getGroupId();
		String description = post.getPostMessage();

		Document document = getBaseModelDocument(PORTLET_ID, post);

		document.addKeyword(Field.GROUP_ID, groupId);
		document.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);
		document.addText(Field.DESCRIPTION, description);

		return document;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {

		Wallpost post = (Wallpost) obj;
		
		if (post.isApproved()){ 
			String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
			SearchEngineUtil.updateDocument(searchEngineId,
				post.getCompanyId(), getDocument(post));
		}
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {

		Wallpost post = WallpostLocalServiceUtil
				.getWallpost(classPK);

		doReindex(post);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);

		doReindexAll(companyId);
	}

	private void doReindexAll(long companyId) throws Exception {

		int count = WallpostLocalServiceUtil.getWallpostsCount();

		int pages = count / Indexer.DEFAULT_INTERVAL;

		for (int i = 0; i <= pages; i++) {
			int start = (i * Indexer.DEFAULT_INTERVAL);
			int end = start + Indexer.DEFAULT_INTERVAL;

			reindexWallposts(companyId, start, end);
		}
	}

	protected void reindexWallposts(long companyId, int start, int end)
			throws Exception {

		List<Wallpost> posts = WallpostLocalServiceUtil
				.getWallpostsByStatus(WorkflowConstants.STATUS_APPROVED);

		if (posts.isEmpty()) {
			return;
		}

		Collection<Document> documents = new ArrayList<Document>();

		for (Wallpost post : posts) {
			Document document = getDocument(post);

			documents.add(document);
		}

		String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
		SearchEngineUtil.updateDocuments(searchEngineId, companyId, documents);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {

		return PORTLET_ID;
	}

	public Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletURL portletURL) {

		String title = document.get(Field.TITLE);

		String content = snippet;

		if (Validator.isNull(snippet)) {
			content = document.get(Field.DESCRIPTION);

			if (Validator.isNull(content)) {
				content = StringUtil.shorten(document.get(Field.CONTENT), 200);
			}
		}

		String postId = document.get(Field.ENTRY_CLASS_PK);

		portletURL.setParameter("mvcPath", "/html/wallpost/full_content.jsp");
		portletURL.setParameter("postId", postId);

		return new Summary(title, content, portletURL);
	}

	@Override
	public String getPortletId() {
		
		return PORTLET_ID;
	}

	public String[] getClassNames() {

		return CLASS_NAMES;
	}

	public static final String[] CLASS_NAMES = { Wallpost.class.getName() };

	public static final String PORTLET_ID = "wallpost-portlet";

}