package kr.or.ddit.admin.databoard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.databoard.service.DataBoardServiceImpl;
import kr.or.ddit.databoard.service.IDataBoardService;
import kr.or.ddit.vo.DataBoardVO;

public class DataBoardViewAction implements IAction{
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
		
		params.put("db_no", db_no);
		
		IDataBoardService service = DataBoardServiceImpl.getInstance();
		
		DataBoardVO dataBoardInfo = service.dataInfo(params);
		
		
		
		request.setAttribute("dataBoardInfo", dataBoardInfo);
		
			return "/admin/data/dataBoardView.tiles";
				
	
	}
}
