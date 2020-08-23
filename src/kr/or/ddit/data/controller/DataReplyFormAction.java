package kr.or.ddit.data.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.base.action.controller.IAction;

public class DataReplyFormAction implements IAction{
private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String rnum = request.getParameter("rnum");
		String db_title = request.getParameter("db_title");
		String db_group = request.getParameter("db_group");
		String db_seq = request.getParameter("db_seq");
		String db_depth = request.getParameter("db_depth");
		
		request.setAttribute("rnum", rnum);
		request.setAttribute("db_group", db_group);
		request.setAttribute("db_title", db_title);
		request.setAttribute("db_seq", db_seq);
		request.setAttribute("db_depth", db_depth);
		
		return "/user/data/databoardReplyForm.tiles";
	
	}
}
