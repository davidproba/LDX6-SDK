package com.liferay.AdvancedTasks.Handler;

import com.liferay.AdvancedTasks.finalDateExceptionException;
import com.liferay.AdvancedTasks.startDateExceptionException;
import com.liferay.AdvancedTasks.model.AdvTask;
import com.liferay.AdvancedTasks.model.AdvTaskMapping;
import com.liferay.AdvancedTasks.service.AdvTaskLocalServiceUtil;
import com.liferay.AdvancedTasks.service.AdvTaskMappingLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageDisplay;
import com.liferay.portlet.messageboards.model.MBTreeWalker;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

public class ProjectTasks extends com.liferay.util.bridges.mvc.MVCPortlet {

	public void insertTask(ActionRequest aReq, ActionResponse aRes) {
		ThemeDisplay tD = (ThemeDisplay)aReq.getAttribute(WebKeys.THEME_DISPLAY);
		String atTitle = ParamUtil.getString(aReq, "atTitle");
		String atDescription = ParamUtil.getString(aReq, "atDescription");
		String redirectURL = ParamUtil.getString(aReq, "redirectURL");
		System.out.println(redirectURL);
		Date atStartDate = null;
		Date atFinalDate = null;
		try {
			atStartDate = PortalUtil.getDate(
					ParamUtil.getInteger(aReq, "smonth"), ParamUtil.getInteger(aReq, "sday"), 
					ParamUtil.getInteger(aReq, "syear"),0,0,tD.getTimeZone(),startDateExceptionException.class);
			atFinalDate = PortalUtil.getDate(
					ParamUtil.getInteger(aReq, "fmonth"), ParamUtil.getInteger(aReq, "fday"), 
					ParamUtil.getInteger(aReq, "fyear"),0,0,tD.getTimeZone(),finalDateExceptionException.class);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int atPriority = ParamUtil.getInteger(aReq, "atPriority");
		long atModifierUserId = tD.getUserId();
		long atAssignedToUserId = ParamUtil.getLong(aReq, "atAssignedToUserId");
		long atParentTaskId = ParamUtil.getLong(aReq, "atParentTaskId");
		String[] atDTs = aReq.getParameterValues("atDT");
		ServiceContext sC = null;
		try {
			sC = ServiceContextFactory.getInstance(aReq);
			AdvTask newTask = AdvTaskLocalServiceUtil.insertTask(atTitle, atDescription, atStartDate, atFinalDate, atPriority, 0, 
					atModifierUserId, atAssignedToUserId, 0, atParentTaskId, tD, sC);
			if(atDTs!=null) {
				for(int i=0; i<atDTs.length; i++) {
					if(atDTs[i].compareTo("false")!=0) {
						AdvTaskMappingLocalServiceUtil.insertTaskMapping(newTask.getAtId(), Long.parseLong(atDTs[i]));
					}
				}
			}
			aRes.sendRedirect(redirectURL);
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateTask(ActionRequest aReq, ActionResponse aRes) {
		ThemeDisplay tD = (ThemeDisplay)aReq.getAttribute(WebKeys.THEME_DISPLAY);
		long atID = ParamUtil.getLong(aReq, "taskId");
		AdvTask updT = null;
		String redirectURL = ParamUtil.getString(aReq, "redirectURL");
		try {
			updT = AdvTaskLocalServiceUtil.getAdvTask(atID);
			updT.setAtTitle(ParamUtil.getString(aReq, "atTitle"));
			updT.setAtDescription(ParamUtil.getString(aReq, "atDescription"));
			Date atStartDate = null;
			atStartDate = PortalUtil.getDate(
					ParamUtil.getInteger(aReq, "smonth"), ParamUtil.getInteger(aReq, "sday"), 
					ParamUtil.getInteger(aReq, "syear"),0,0,tD.getTimeZone(),startDateExceptionException.class);
			updT.setAtStartDate(atStartDate);
			Date atFinalDate = null;
			atFinalDate = PortalUtil.getDate(
					ParamUtil.getInteger(aReq, "fmonth"), ParamUtil.getInteger(aReq, "fday"), 
					ParamUtil.getInteger(aReq, "fyear"),0,0,tD.getTimeZone(),finalDateExceptionException.class);
			updT.setAtFinalDate(atFinalDate);
			updT.setAtPriority(ParamUtil.getInteger(aReq, "atPriority"));
			updT.setAtStatus(ParamUtil.getInteger(aReq, "atStatus"));
			updT.setAtModifierUserId(tD.getUserId());
			updT.setAtAssignedToUserId(ParamUtil.getLong(aReq, "atAssignedToUserId"));
			updT.setAtParentTaskId(ParamUtil.getLong(aReq, "atParentTaskId"));
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					AdvTask.class.getName(), aReq);
			AdvTaskLocalServiceUtil.updateTask(updT, serviceContext);
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String[] atDTs = aReq.getParameterValues("atDT");
		List<String> atDTNews = new ArrayList<String>();
		try {
			List<AdvTaskMapping> actmaps = AdvTaskMappingLocalServiceUtil.getMTasks(atID);
			if(atDTs!=null) {
				for(int i=0; i<atDTs.length; i++) {
					if(atDTs[i].compareTo("false")!=0) {
						atDTNews.add(atDTs[i]);
					}
				}
			}
			if(atDTNews.size()==actmaps.size()) {
				for(int x=0; x<atDTNews.size(); x++) {
					AdvTaskMapping actMap = actmaps.get(x); 
					actMap.setAtMTaskId(atID);
					actMap.setAtMDependentFromId(Long.parseLong(atDTNews.get(x)));
					AdvTaskMappingLocalServiceUtil.updateAdvTaskMapping(actMap);
				}
			}
			if(atDTNews.size()<actmaps.size()) {
				for(int x=0; x<actmaps.size(); x++) {
					AdvTaskMapping actMap = actmaps.get(x); 
					if(x<atDTNews.size()) {
						actMap.setAtMTaskId(atID);
						actMap.setAtMDependentFromId(Long.parseLong(atDTNews.get(x)));
						AdvTaskMappingLocalServiceUtil.updateAdvTaskMapping(actMap);
					} else {
						AdvTaskMappingLocalServiceUtil.deleteAdvTaskMapping(actMap);
					}
				}
			}
			if(atDTNews.size()>actmaps.size()) {
				for(int x=0; x<atDTNews.size(); x++) {
					if(x<actmaps.size()) {
						AdvTaskMapping actMap = actmaps.get(x); 
						actMap.setAtMTaskId(atID);
						actMap.setAtMDependentFromId(Long.parseLong(atDTNews.get(x)));
						AdvTaskMappingLocalServiceUtil.updateAdvTaskMapping(actMap);
					} else {
						AdvTaskMappingLocalServiceUtil.insertTaskMapping(atID, Long.parseLong(atDTNews.get(x)));
					}
				}
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			aRes.sendRedirect(redirectURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteTask(ActionRequest aReq, ActionResponse aRes) {
		ThemeDisplay tD = (ThemeDisplay)aReq.getAttribute(WebKeys.THEME_DISPLAY);
		long delTaskId = ParamUtil.getLong(aReq, "atDelTaskId");
		String redirectURL = ParamUtil.getString(aReq, "redirectURL");
		List<AdvTask> pTasks = null;
		List<AdvTaskMapping> mTaskMappings = null;
		List<AdvTaskMapping> dTaskMappings = null;
		try {
			pTasks = AdvTaskLocalServiceUtil.getChildTasks(delTaskId);
			for(AdvTask pTask:pTasks) {
				pTask.setAtParentTaskId(0);
				AdvTaskLocalServiceUtil.updateAdvTask(pTask);
			}
			mTaskMappings = AdvTaskMappingLocalServiceUtil.getMTasks(delTaskId);
			for(AdvTaskMapping mMapping:mTaskMappings) {
				AdvTaskMappingLocalServiceUtil.deleteAdvTaskMapping(mMapping);
			}
			dTaskMappings = AdvTaskMappingLocalServiceUtil.getDTasks(delTaskId);
			for(AdvTaskMapping dMapping:dTaskMappings) {
				AdvTaskMappingLocalServiceUtil.deleteAdvTaskMapping(dMapping);
			}
			MBMessageDisplay messageDisplay = MBMessageLocalServiceUtil.getDiscussionMessageDisplay(tD.getUserId(), tD.getScopeGroupId(), AdvTask.class.getName(), delTaskId, WorkflowConstants.STATUS_APPROVED);
			MBTreeWalker treeWalker = messageDisplay.getTreeWalker();
			List<MBMessage> messages = treeWalker.getMessages();
			for (int i = 1; i < messages.size(); i++) {
				MBMessage message = (MBMessage)messages.get(i);
				MBMessageLocalServiceUtil.deleteMBMessage(message);
			}
			AdvTaskLocalServiceUtil.deleteTask(delTaskId);
			aRes.sendRedirect(redirectURL);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void finishTask(ActionRequest aReq, ActionResponse aRes) {
		ThemeDisplay tD = (ThemeDisplay)aReq.getAttribute(
				WebKeys.THEME_DISPLAY);
		long finId = ParamUtil.getLong(aReq, "atFinishTaskId");
		AdvTask finTask;
		try {
			finTask = AdvTaskLocalServiceUtil.getAdvTask(finId);
			finTask.setAtStatus(TaskConstants.STATUS_100);
			finTask.setAtModifierUserId(tD.getUserId());
			finTask.setAtResolverUserId(tD.getUserId());
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					AdvTask.class.getName(), aReq);
			AdvTaskLocalServiceUtil.updateTask(finTask, serviceContext);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void reopenTask(ActionRequest aReq, ActionResponse aRes) {
		ThemeDisplay tD = (ThemeDisplay)aReq.getAttribute(
				WebKeys.THEME_DISPLAY);
		long reopenId = ParamUtil.getLong(aReq, "atReopenTaskId");
		AdvTask reopenTask;
		try {
			reopenTask = AdvTaskLocalServiceUtil.getAdvTask(reopenId);
			reopenTask.setAtStatus(TaskConstants.STATUS_REOPEN);
			reopenTask.setAtModifierUserId(tD.getUserId());
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					AdvTask.class.getName(), aReq);
			AdvTaskLocalServiceUtil.updateTask(reopenTask, serviceContext);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateMessage(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		long groupId = PortalUtil.getScopeGroupId(actionRequest);
		String className = ParamUtil.getString(actionRequest, "className");
		long classPK = ParamUtil.getLong(actionRequest, "classPK");
		long messageId = ParamUtil.getLong(actionRequest, "messageId");
		long threadId = ParamUtil.getLong(actionRequest, "threadId");
		long parentMessageId = ParamUtil.getLong(
			actionRequest, "parentMessageId");
		String subject = ParamUtil.getString(actionRequest, "subject");
		String body = ParamUtil.getString(actionRequest, "body");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			MBMessage.class.getName(), actionRequest);

		if (cmd.equals(Constants.DELETE)) {
			MBMessageServiceUtil.deleteDiscussionMessage(
				groupId, className, classPK, className, classPK,
				themeDisplay.getUserId(), messageId);
		}
		else if (messageId <= 0) {
			MBMessageServiceUtil.addDiscussionMessage(
				groupId, className, classPK, className, classPK,
				themeDisplay.getUserId(), threadId, parentMessageId, subject,
				body, serviceContext);
		}
		else {
			MBMessageServiceUtil.updateDiscussionMessage(
				className, classPK, className, classPK,
				themeDisplay.getUserId(), messageId, subject, body,
				serviceContext);
		}
	}
	
	public static String getStatusLabel(int status) {
		if (status == TaskConstants.STATUS_BEGINN) {
			return TaskConstants.LABEL_STATUS_BEGINN;
		}
		else if (status == TaskConstants.STATUS_20) {
			return TaskConstants.LABEL_STATUS_20;
		}
		else if (status == TaskConstants.STATUS_40) {
			return TaskConstants.LABEL_STATUS_40;
		}
		else if (status == TaskConstants.STATUS_60) {
			return TaskConstants.LABEL_STATUS_60;
		}
		else if (status == TaskConstants.STATUS_80) {
			return TaskConstants.LABEL_STATUS_80;
		}
		else if (status == TaskConstants.STATUS_100) {
			return TaskConstants.LABEL_STATUS_100;
		}
		else if (status == TaskConstants.STATUS_REOPEN) {
			return TaskConstants.LABEL_STATUS_REOPEN;
		}
		else {
			return null;
		}
	}
	
	public static String getPrioLabel(int prio) {
		if (prio == TaskConstants.PRIO_HIGH) {
			return TaskConstants.LABEL_PRIO_HIGH;
		}
		else if (prio == TaskConstants.PRIO_NORMAL) {
			return TaskConstants.LABEL_PRIO_NORMAL;
		}
		else if (prio == TaskConstants.PRIO_LOW) {
			return TaskConstants.LABEL_PRIO_LOW;
		}
		else {
			return null;
		}
	}
	
	public static String getBgColor(int status, int prio, Date fdate) {
		String color = "#555";
		if(status==TaskConstants.STATUS_100) {
			color="#CFD8DC";		
		} else if(status==TaskConstants.STATUS_REOPEN) {
			color="#E1BEE7";		
		} else {
			if(prio==1) {
				color="#FFE0B2";		
			}
			if(prio==2) {
				color="#FFF9C4";		
			}
			if(prio==3) {
				color="#B2DFDB";		
			}
			if(DateUtil.compareTo(new Date(), fdate, true) >= 0) {
				color="#FFCDD2";		
			}
		}
		return color;
	}
	
	public static String getColor(int status, int prio, Date fdate) {
		String color = "#555";
		if(status==TaskConstants.STATUS_100) {
			color="#607D8B";		
		} else if(status==TaskConstants.STATUS_REOPEN) {
			color="#9C27B0";		
		} else {
			if(prio==1) {
				color="#FF9800";		
			}
			if(prio==2) {
				color="#FFEB3B";		
			}
			if(prio==3) {
				color="#009688";		
			}
			if(DateUtil.compareTo(new Date(), fdate, true) >= 0) {
				color="#F44336";		
			}
		}
		return color;
	}
}
