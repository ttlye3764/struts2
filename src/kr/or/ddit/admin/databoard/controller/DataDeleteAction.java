package kr.or.ddit.admin.databoard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.databoard.service.DataBoardServiceImpl;
import kr.or.ddit.databoard.service.IDataBoardService;

public class DataDeleteAction implements IAction{
private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String db_no = request.getParameter("db_no");
		
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("db_no",db_no);
		
		IDataBoardService service = DataBoardServiceImpl.getInstance();
		
		service.deleteDataBoard(params);
		
		return "/admin/dataBoardList.do";
	
	}
}
