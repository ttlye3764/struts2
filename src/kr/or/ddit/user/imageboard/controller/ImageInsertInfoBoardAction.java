package kr.or.ddit.user.imageboard.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.imageboard.service.IImageBoardService;
import kr.or.ddit.imageboard.service.ImageBoardServiceImpl;
import kr.or.ddit.utiles.FIleUploadRequestWrapper;
import kr.or.ddit.vo.ImageBoardVO;
import org.apache.commons.beanutils.BeanUtils;

public class ImageInsertInfoBoardAction implements IAction{

	
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

		FIleUploadRequestWrapper wrapper = new FIleUploadRequestWrapper(request);

		
		ImageBoardVO imageBoardInfo = new ImageBoardVO();

		// BeanUtils.populate(freeboardInfo, request.getParameterMap());
		try {
			BeanUtils.populate(imageBoardInfo, wrapper.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		IImageBoardService service = ImageBoardServiceImpl.getInstance();
		
		service.insertImageBoardInfo(imageBoardInfo, wrapper.getFileItemValues("files"));
		
		session.setAttribute("contentPage", "imageBoardList");
		return "/user/imageboardList.do";
	}
}