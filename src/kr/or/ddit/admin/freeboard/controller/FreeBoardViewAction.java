package kr.or.ddit.admin.freeboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.freeboard.service.FreeBoardServiceImpl;
import kr.or.ddit.freeboard.service.IFreeBoardService;
import kr.or.ddit.freeboardfileitem.service.FreeBoardFileItemServiceImpl;
import kr.or.ddit.freeboardfileitem.service.IFreeBoardFileItemService;
import kr.or.ddit.vo.FreeBoardFileItemVO;
import kr.or.ddit.vo.FreeBoardVO;

public class FreeBoardViewAction implements IAction {
	
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		String bo_no = request.getParameter("bo_no");
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("bo_no", bo_no);
		IFreeBoardFileItemService file_service = FreeBoardFileItemServiceImpl.getInstance();
		FreeBoardFileItemVO file_Info = file_service.freeboardfileItemInfo(params);
		IFreeBoardService service = FreeBoardServiceImpl.getInstace();
		service.updateHitFreeboard(bo_no);

		
		FreeBoardVO freeboardInfo = service.freeboardInfo(params);
		request.setAttribute("freeboardInfo", freeboardInfo);
		request.setAttribute("file_Info", file_Info);
		
		return "/admin/freeboard/freeBoardView.tiles";
	}

}
