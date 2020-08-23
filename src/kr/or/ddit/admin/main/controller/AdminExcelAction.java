package kr.or.ddit.admin.main.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.base.action.controller.IAction;


public class AdminExcelAction implements IAction{
	private boolean redirectFlag = false;
	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,HttpServletResponse response) {
		String mem_idValue = request.getParameter("mem_id");
		String []mem_id = mem_idValue.split(",");
		
		Map<String,String> params = new HashMap<String,String>();	
		IMemberService service = MemberServiceImpl.getInstance();
	
		List<MemberVO> list = new ArrayList<>();
		for(int i=0; i<mem_id.length; i++){
			params.put("mem_id", mem_id[i]);
			list.add((MemberVO) service.adminExcelList(params));
		}
		request.setAttribute("AdminExcelList", list);
				
		
		response.setHeader("Content-Disposition", "attachment;fileName=members.xls");
		response.setHeader("Content-Description", "Generate Excel File");
		response.setContentType("application/vnd.ms-excel");
		// "/admin/document/excel.tiles"
		return "/WEB-INF/views/admin/document/excel.jsp";
	}

}
