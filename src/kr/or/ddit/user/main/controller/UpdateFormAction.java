package kr.or.ddit.user.main.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.soldier.service.ISoldierService;
import kr.or.ddit.soldier.service.SoldierServiceImpl;
import kr.or.ddit.vo.SoldierVO;

public class UpdateFormAction implements IAction{
private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		String sol_no = request.getParameter("sol_num");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("sol_num", sol_no);
		
		ISoldierService service = SoldierServiceImpl.getInstance();
		SoldierVO soldierInfo = service.soldierInfo(params);
		
		String [] sol_num = soldierInfo.getSol_num().split("-");
		String sol_rank = soldierInfo.getSol_rank();
		String sol_name = soldierInfo.getSol_name();
		String [] sol_skillnum = soldierInfo.getSol_skillnum().split("-");
		String [] sol_startday = soldierInfo.getSol_startday().split("-");
		String [] sol_endday = soldierInfo.getSol_endday().split("-");
		String sol_gunnum = soldierInfo.getSol_gunnum();
		String [] sol_bir = soldierInfo.getSol_bir().split("-");
		String sol_add1 = soldierInfo.getSol_add1();
		String sol_add2 = soldierInfo.getSol_add2();
		String [] sol_tel = soldierInfo.getSol_tel().split("-");
		String [] sol_email = soldierInfo.getSol_email().split("@");
		String sol_hobby = soldierInfo.getSol_hobby();
		String sol_ability = soldierInfo.getSol_ability();
		String sol_height = soldierInfo.getSol_height();
		String sol_weight = soldierInfo.getSol_weight();	
		String sol_pass = soldierInfo.getSol_pass();
		String sol_calendar = soldierInfo.getSol_calendar();
		
		request.setAttribute("sol_num1", sol_num[0]);
		request.setAttribute("sol_num2", sol_num[1]);
		request.setAttribute("sol_rank", sol_rank);
		request.setAttribute("sol_name", sol_name);
		request.setAttribute("sol_skillnum1", sol_skillnum[0]);
		request.setAttribute("sol_skillnum2", sol_skillnum[1]);
		request.setAttribute("sol_startday1", sol_startday[0]);
		request.setAttribute("sol_startday2", sol_startday[1]);
		request.setAttribute("sol_startday3", sol_startday[2]);
		request.setAttribute("sol_endday1", sol_endday[0]);
		request.setAttribute("sol_endday2", sol_endday[1]);
		request.setAttribute("sol_endday3", sol_endday[2]);
		request.setAttribute("sol_gunnum", sol_gunnum);
		request.setAttribute("sol_add1", sol_add1);
		request.setAttribute("sol_add2", sol_add2);
		request.setAttribute("sol_hobby", sol_hobby);
		request.setAttribute("sol_ability", sol_ability);
		request.setAttribute("sol_height", sol_height);
		request.setAttribute("sol_weight", sol_weight);
		request.setAttribute("sol_bir1", sol_bir[0]);
		request.setAttribute("sol_bir2", sol_bir[1]);
		request.setAttribute("sol_bir3", sol_bir[2]);
		request.setAttribute("sol_tel1", sol_tel[0]);
		request.setAttribute("sol_tel2", sol_tel[1]);
		request.setAttribute("sol_tel3", sol_tel[2]);
		request.setAttribute("sol_email1", sol_email[0]);
		request.setAttribute("sol_email2", sol_email[1]);			
		request.setAttribute("sol_pass", sol_pass);			
		request.setAttribute("sol_calendar", sol_calendar);			
				
		
		return "/user/join/joinView.tiles";
	}
}
