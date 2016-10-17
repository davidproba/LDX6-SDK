package com.liferay.AdvancedTasks.search;

import com.liferay.AdvancedTasks.model.AdvTask;
import com.liferay.AdvancedTasks.permission.AdvTaskPermission;
import com.liferay.AdvancedTasks.service.AdvTaskLocalServiceUtil;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

public class AdvTaskIndexer extends BaseIndexer {
	
	public AdvTaskIndexer() {
		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker,
			String entryClassName, long entryClassPK, String actionId)
			throws Exception {

		return AdvTaskPermission.contains(permissionChecker,
				entryClassPK, ActionKeys.VIEW);
	}

	@Override
	protected void doDelete(Object obj) throws Exception {

		AdvTask task = (AdvTask)obj;
		Document document = new DocumentImpl();

		document.addUID(PORTLET_ID, task.getPrimaryKey());

		String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
		SearchEngineUtil.deleteDocument(searchEngineId,
				task.getCompanyId(), document.get(Field.UID));
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {

		AdvTask task = (AdvTask) obj;
		long groupId = getSiteGroupId(task.getGroupId());
		long scopeGroupId = task.getGroupId();
		String description = task.getAtDescription();

		Document document = getBaseModelDocument(PORTLET_ID, task);

		document.addKeyword(Field.GROUP_ID, groupId);
		document.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);
		document.addText(Field.DESCRIPTION, description);

		return document;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {

		AdvTask task = (AdvTask) obj;
		
		if (task.isApproved()){ 
			String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
			SearchEngineUtil.updateDocument(searchEngineId,
				task.getCompanyId(), getDocument(task));
		}
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {

		AdvTask task = AdvTaskLocalServiceUtil.getAdvTask(classPK);

		doReindex(task);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);

		doReindexAll(companyId);
	}

	private void doReindexAll(long companyId) throws Exception {

		int count = AdvTaskLocalServiceUtil.getAdvTasksCount();

		int pages = count / Indexer.DEFAULT_INTERVAL;

		for (int i = 0; i <= pages; i++) {
			int start = (i * Indexer.DEFAULT_INTERVAL);
			int end = start + Indexer.DEFAULT_INTERVAL;

			reindexTasks(companyId, start, end);
		}
	}

	protected void reindexTasks(long companyId, int start, int end)
			throws Exception {

		List<AdvTask> tasks = AdvTaskLocalServiceUtil
				.getTasksByStatus(WorkflowConstants.STATUS_APPROVED);

		if (tasks.isEmpty()) {
			return;
		}

		Collection<Document> documents = new ArrayList<Document>();

		for (AdvTask task : tasks) {
			Document document = getDocument(task);

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

		String taskId = document.get(Field.ENTRY_CLASS_PK);

		portletURL.setParameter("mvcPath", "/html/ProjectTasks/view_task.jsp");
		portletURL.setParameter("taskId", taskId);

		return new Summary(title, content, portletURL);
	}

	@Override
	public String getPortletId() {
		
		return PORTLET_ID;
	}

	public String[] getClassNames() {

		return CLASS_NAMES;
	}

	public static final String[] CLASS_NAMES = { AdvTask.class.getName() };

	public static final String PORTLET_ID = "AdvancedTaskList-portlet";

}