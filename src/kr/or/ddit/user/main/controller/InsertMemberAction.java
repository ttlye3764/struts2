package kr.or.ddit.user.main.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.soldier.service.ISoldierService;
import kr.or.ddit.soldier.service.SoldierServiceImpl;
import kr.or.ddit.vo.SoldierVO;

import org.apache.commons.beanutils.BeanUtils;

public class InsertMemberAction implements IAction {
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		SoldierVO soldierInfo = new SoldierVO();
		try {
			BeanUtils.populate(soldierInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}		
		//군번
		String sol_num = request.getParameter("sol_num1") + "-" + request.getParameter("sol_num2");
		soldierInfo.setSol_num(sol_num);
		
		//주특기번호
		String sol_skillnum = request.getParameter("sol_skillnum1") + "-" + request.getParameter("sol_skillnum2");
		soldierInfo.setSol_skillnum(sol_skillnum);
		
		//계급
		String sol_rank = request.getParameter("sol_rank1");
		soldierInfo.setSol_rank(sol_rank);		
		
		String sol_name = request.getParameter("sol_name");
		soldierInfo.setSol_name(sol_name);
		
		String sol_start = request.getParameter("sol_start1") + "-" + request.getParameter("sol_start2") + "-" + request.getParameter("sol_start3");
		soldierInfo.setSol_startday(sol_start);
		
		String sol_end = request.getParameter("sol_end1") + "-" + request.getParameter("sol_end2") + "-" + request.getParameter("sol_end3");
		soldierInfo.setSol_endday(sol_end);
		
		String sol_bir = request.getParameter("sol_bir1") + "-" + request.getParameter("sol_bir2") + "-" +  request.getParameter("sol_bir3");
		soldierInfo.setSol_bir(sol_bir);
		
		String sol_pass = request.getParameter("sol_pass");
		soldierInfo.setSol_pass(sol_pass);
		
		String sol_tel = request.getParameter("sol_tel1") + "-" + request.getParameter("sol_tel2") + "-" + request.getParameter("sol_tel3");
		soldierInfo.setSol_tel(sol_tel);		
		
		String sol_mail = request.getParameter("sol_mail1") + "@" + request.getParameter("sol_mail2");
		soldierInfo.setSol_email(sol_mail);		
		
		String sol_add1 = request.getParameter("sol_add1");
		soldierInfo.setSol_add1(sol_add1);
		
		String sol_add2 = request.getParameter("sol_add2");
		soldierInfo.setSol_add2(sol_add2);
		
		String sol_height = request.getParameter("sol_height");
		soldierInfo.setSol_height(sol_height);
		
		String sol_weight = request.getParameter("sol_weight");
		soldierInfo.setSol_weight(sol_weight);
		
		String sol_hobby = request.getParameter("sol_hobby");
		soldierInfo.setSol_hobby(sol_hobby);
		
		String sol_ability = request.getParameter("sol_ability");
		soldierInfo.setSol_ability(sol_ability);
		
		String sol_gunnum = request.getParameter("sol_gunnum");
		soldierInfo.setSol_gunnum(sol_gunnum);
		
		String sol_calendar = request.getParameter("sol_calendar");
		soldierInfo.setSol_calendar(sol_calendar);
		
		soldierInfo.setSol_discharge("현역");
		
		ISoldierService service = SoldierServiceImpl.getInstance();
		service.insertSoldier(soldierInfo);		

		return "/user/main.do";
	}

}
