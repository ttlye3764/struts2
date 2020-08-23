package kr.or.ddit.admin.qnaboard.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.qna.service.IQnaService;
import kr.or.ddit.qna.service.QnaServiceImpl;
import kr.or.ddit.utiles.FIleUploadRequestWrapper;
import kr.or.ddit.vo.QnaBoardVO;

public class QnaInsertBoardInfoAction implements IAction{
	
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

		
		QnaBoardVO qnaBoardInfo = new QnaBoardVO();

		// BeanUtils.populate(freeboardInfo, request.getParameterMap());
		try {
			BeanUtils.populate(qnaBoardInfo, wrapper.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		IQnaService service = QnaServiceImpl.getInstance();
		
		service.insertQnaBoardInfo(qnaBoardInfo, wrapper.getFileItemValues("files"));
		
		
		return "/admin/qnaboardList.do";
	
	}
	//
}
