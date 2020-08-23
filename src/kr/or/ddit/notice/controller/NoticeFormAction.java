package kr.or.ddit.notice.controller;

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
		
		return "/user/notice/noticeForm.tiles";
	}

}
