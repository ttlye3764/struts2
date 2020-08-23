package kr.or.ddit.soldier.freeboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.freeboard.service.FreeBoardServiceImpl;
import kr.or.ddit.freeboard.service.IFreeBoardService;
import kr.or.ddit.vo.FreeBoardVO;

public class freeboardReplyFormAction implements IAction{
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		String bo_no = request.getParameter("bo_no");
		String rnum = request.getParameter("rnum");
		
		IFreeBoardService service = FreeBoardServiceImpl.getInstace();
		Map<String, String> params = new HashMap<String, String>();
		params.put("bo_no", bo_no);
		params.put("rnum", rnum);
		
		FreeBoardVO freeboardInfo = new FreeBoardVO();
		freeboardInfo = service.freeboardInfo(params);
		request.setAttribute("freeboardInfo", freeboardInfo);
		
		return "/user/freeboard/freeboardReplyForm.tiles";
	}
}
