package kr.or.ddit.admin.qnaboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.qna.service.IQnaService;
import kr.or.ddit.qna.service.QnaServiceImpl;

public class QnaDeleteAction implements IAction{
private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String qa_no = request.getParameter("qa_no");
		
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("qa_no",qa_no);
		
		IQnaService service = QnaServiceImpl.getInstance();
		
		service.deleteQnaBoard(params);
		
		return "/qna/qnaboradList.do";
	
	}
}
