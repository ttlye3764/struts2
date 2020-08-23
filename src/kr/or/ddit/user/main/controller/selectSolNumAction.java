package kr.or.ddit.user.main.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.org.mozilla.javascript.internal.regexp.SubString;
import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.soldier.service.ISoldierService;
import kr.or.ddit.soldier.service.SoldierServiceImpl;

public class selectSolNumAction implements IAction{
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		ISoldierService service = SoldierServiceImpl.getInstance();
		String [] solNum = service.soldierNum().split("-");
		
		String gunnum = toString().valueOf(Integer.parseInt(solNum[1]) + 1);
		
		Calendar oCalendar = Calendar.getInstance();		
		int year = oCalendar.get(Calendar.YEAR);
        String sYear = String.valueOf(year);
        sYear = sYear.substring(2,4);       
        		
		request.setAttribute("year", sYear);
		request.setAttribute("gunnum", gunnum);
		return "/user/join/joinForm.tiles";
	}

}
