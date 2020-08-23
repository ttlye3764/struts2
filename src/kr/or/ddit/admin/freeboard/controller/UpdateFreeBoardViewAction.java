package kr.or.ddit.admin.freeboard.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.freeboard.service.FreeBoardServiceImpl;
import kr.or.ddit.freeboard.service.IFreeBoardService;
import kr.or.ddit.freeboardfileitem.service.FreeBoardFileItemServiceImpl;
import kr.or.ddit.freeboardfileitem.service.IFreeBoardFileItemService;
import kr.or.ddit.vo.FreeBoardFileItemVO;
import kr.or.ddit.vo.FreeBoardVO;

public class UpdateFreeBoardViewAction implements IAction{
	
private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		IFreeBoardService service = FreeBoardServiceImpl.getInstace();
		FreeBoardVO freeboardInfo = new FreeBoardVO();
		try {
			BeanUtils.populate(freeboardInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		service.updateFreeboard(freeboardInfo);
		
		return "/admin/freeBoardList.do";
	}

}
