package kr.or.ddit.notice.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;

public class NoticeDeleteAction implements IAction{
private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String nt_no = request.getParameter("nt_no");
		
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("nt_no",nt_no);
		
		INoticeService service = NoticeServiceImpl.getInstance();
		
		service.deleteNoticeboard(params);
		
		return "/user/notice/noticeList.tiles";
	
	}
}
