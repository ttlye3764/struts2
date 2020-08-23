package kr.or.ddit.notice.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.utiles.FIleUploadRequestWrapper;
import kr.or.ddit.vo.NoticeBoardVO;
import kr.or.ddit.vo.SoldierVO;

public class NoticeInsertAction implements IAction{
	
	private boolean redirectFlag = false;

	@Override
	public boolean isRedirect() {
		
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		SoldierVO vo = (SoldierVO) session.getAttribute("LOGIN_SOLDIERINFO");
		
		FIleUploadRequestWrapper wrapper = new FIleUploadRequestWrapper(request);
		
		NoticeBoardVO noticeInfo = new NoticeBoardVO();
		
		
		noticeInfo.setNt_writer(vo.getSol_num());
		
		try {
			BeanUtils.populate(noticeInfo, wrapper.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {		
			e.printStackTrace();
		}
		
		
		INoticeService service = NoticeServiceImpl.getInstance();		
		service.insertNoticeboardInfo(noticeInfo, wrapper.getFileItemValues("files"));
		
		return "/user/notice/noticeList.tiles";
	}

}
