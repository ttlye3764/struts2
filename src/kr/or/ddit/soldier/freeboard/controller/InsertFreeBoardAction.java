package kr.or.ddit.soldier.freeboard.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.freeboard.service.FreeBoardServiceImpl;
import kr.or.ddit.freeboard.service.IFreeBoardService;
import kr.or.ddit.freeboardfileitem.service.IFreeBoardFileItemService;
import kr.or.ddit.utiles.FIleUploadRequestWrapper;
import kr.or.ddit.utiles.RolePaginationUtil;
import kr.or.ddit.vo.FreeBoardVO;
import kr.or.ddit.vo.SoldierVO;

public class InsertFreeBoardAction implements IAction{
	// 프레임웍 : 포워딩 default.
		private boolean redirectFlag = false;
		
		@Override
		public boolean isRedirect() {
			return redirectFlag;
		}

		@Override
		public String process(HttpServletRequest request,
				HttpServletResponse response) {
			try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			HttpSession session = request.getSession();
			SoldierVO vo = (SoldierVO) session.getAttribute("LOGIN_SOLDIERINFO");
			
			IFreeBoardService service = FreeBoardServiceImpl.getInstace();
			FreeBoardVO freeboardInfo = new FreeBoardVO();
			freeboardInfo.setBo_writer(vo.getSol_num());
			
			FIleUploadRequestWrapper wrapper = new FIleUploadRequestWrapper(request);
			
			try {
				BeanUtils.populate(freeboardInfo, wrapper.getParameterMap());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			String content = freeboardInfo.getBo_content();
			content = content.replace("<p>", "");
			content = content.replace("</p>", "");
			freeboardInfo.setBo_content(content);
			service.insertFreeboardInfo(freeboardInfo, wrapper.getFileItemValues("files"));
			
			
			return "/freeboardList.do";
		}
}
