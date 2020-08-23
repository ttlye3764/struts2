package kr.or.ddit.soldier.freeboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.freeboard.service.FreeBoardServiceImpl;
import kr.or.ddit.freeboard.service.IFreeBoardService;

public class DeleteFreeBoardAction implements IAction {
private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		IFreeBoardService service = FreeBoardServiceImpl.getInstace();
		String bo_no = request.getParameter("bo_no");
		service.deleteFreeBoard(bo_no);
		
		return "/freeboardList.do";
	}
}
