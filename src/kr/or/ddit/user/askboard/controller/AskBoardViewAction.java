package kr.or.ddit.user.askboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.askboard.service.AskBoardServiceImpl;
import kr.or.ddit.askboard.service.IAskBoardService;
import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.qna.service.IQnaService;
import kr.or.ddit.qna.service.QnaServiceImpl;
import kr.or.ddit.vo.AskBoardVO;
import kr.or.ddit.vo.QnaBoardVO;

public class AskBoardViewAction implements IAction {

private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String ask_no = request.getParameter("ask_no");

		Map<String, String> params = new HashMap<String, String>();
		
		params.put("ask_no", ask_no);
		
		IAskBoardService service = AskBoardServiceImpl.getInstace();
		
		AskBoardVO askBoardInfo = service.askBoardInfo(params);
		
		request.setAttribute("askBoardInfo", askBoardInfo);
		
		return "/user/askboard/askboardView.tiles";
	
	}
}
