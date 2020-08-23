package kr.or.ddit.qna.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.qna.service.IQnaService;
import kr.or.ddit.qna.service.QnaServiceImpl;

public class QnaReplyFormAction implements IAction{
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
		String qa_title = request.getParameter("qa_title");
		String qa_group = request.getParameter("qa_group");
		String qa_seq = request.getParameter("qa_seq");
		String qa_depth = request.getParameter("qa_depth");
		
		request.setAttribute("rnum", rnum);
		request.setAttribute("qa_group", qa_group);
		request.setAttribute("qa_title", qa_title);
		request.setAttribute("qa_seq", qa_seq);
		request.setAttribute("qa_depth", qa_depth);
		session.setAttribute("contentPage", "qnaBoardReplyForm");
		return "/user/qna/qnaboardReplyForm.tiles";
	
	}
}
