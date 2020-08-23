package kr.or.ddit.soldier.freeboard.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.freeboard.service.FreeBoardServiceImpl;
import kr.or.ddit.freeboard.service.IFreeBoardService;
import kr.or.ddit.vo.FreeBoardVO;
import kr.or.ddit.vo.SoldierVO;

public class UpdateFreeBoardAction implements IAction {
	
private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		

		IFreeBoardService service = FreeBoardServiceImpl.getInstace();
		FreeBoardVO freeoboardInfo = new FreeBoardVO();
		try {
			BeanUtils.populate(freeoboardInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        HttpSession session = request.getSession();
        SoldierVO session_id = (SoldierVO) session.getAttribute("LOGIN_SOLDIERINFO");
        
        
		service.updateFreeboard(freeoboardInfo);
		
		
		return "/freeboardList.do";
	}
}
