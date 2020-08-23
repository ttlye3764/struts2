package kr.or.ddit.admin.askboard.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.askboard.service.AskBoardServiceImpl;
import kr.or.ddit.askboard.service.IAskBoardService;
import kr.or.ddit.base.action.controller.IAction;

import kr.or.ddit.vo.AskBoardVO;


import org.apache.commons.beanutils.BeanUtils;

public class InsertAskBoardAction implements IAction{
	
private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		AskBoardVO askBoardInfo = new AskBoardVO();

		// BeanUtils.populate(freeboardInfo, request.getParameterMap());
		try {
			BeanUtils.populate(askBoardInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		IAskBoardService service = AskBoardServiceImpl.getInstace();
		
		service.insertAskBoardInfo(askBoardInfo);
		
		return "/admin/askBoardList.do";
	
	}
}
