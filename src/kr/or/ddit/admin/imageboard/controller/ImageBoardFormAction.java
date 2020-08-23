package kr.or.ddit.admin.imageboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.base.action.controller.IAction;

public class ImageBoardFormAction implements IAction{


	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		return "/admin/imageboard/imageboardForm.tiles";
	
	}
}
