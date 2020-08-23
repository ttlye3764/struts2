package kr.or.ddit.user.imageboard.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.imageboard.service.IImageBoardService;
import kr.or.ddit.imageboard.service.ImageBoardServiceImpl;
import kr.or.ddit.qna.service.IQnaService;
import kr.or.ddit.qna.service.QnaServiceImpl;
import kr.or.ddit.vo.ImageBoardVO;
import kr.or.ddit.vo.QnaBoardVO;

import org.apache.commons.beanutils.BeanUtils;

public class ImageBoardUpdateAction implements IAction{

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

		
		ImageBoardVO imageBoardInfo = new ImageBoardVO();

	try {
		BeanUtils.populate(imageBoardInfo, request.getParameterMap());
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	IImageBoardService service = ImageBoardServiceImpl.getInstance();
	
	service.updateImageBoard(imageBoardInfo);;
	session.setAttribute("contentPage", "imageBoardList");
	return "/user/imageboardList.do";
	
	}

}
