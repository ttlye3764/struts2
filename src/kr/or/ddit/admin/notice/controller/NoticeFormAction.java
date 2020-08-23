package kr.or.ddit.admin.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.base.action.controller.IAction;

public class NoticeFormAction implements IAction{
	
	private boolean redirectFlag = false;

	@Override
	public boolean isRedirect() {		
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		return "/admin/notice/noticeForm.tiles";
	}

}
