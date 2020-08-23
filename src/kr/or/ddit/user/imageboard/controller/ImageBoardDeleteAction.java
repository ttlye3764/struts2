package kr.or.ddit.user.imageboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.imageboard.service.IImageBoardService;
import kr.or.ddit.imageboard.service.ImageBoardServiceImpl;
import kr.or.ddit.qna.service.IQnaService;
import kr.or.ddit.qna.service.QnaServiceImpl;

public class ImageBoardDeleteAction implements IAction{

	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String img_no = request.getParameter("img_no");
		
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("img_no",img_no);
		
		IImageBoardService service = ImageBoardServiceImpl.getInstance();
		
		service.deleteImageBoard(params);
		
		session.setAttribute("contentPage", "imageBoardList");
		
		return "/user/imageboardList.do";
	
	}
}
