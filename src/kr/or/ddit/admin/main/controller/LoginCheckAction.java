package kr.or.ddit.admin.main.controller;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.listener.SessionManager;
import kr.or.ddit.soldier.service.ISoldierService;
import kr.or.ddit.soldier.service.SoldierServiceImpl;
import kr.or.ddit.utiles.CryptoGenerator;
import kr.or.ddit.vo.SoldierVO;

public class LoginCheckAction implements IAction{
	// 프레임웍 : 포워딩 default.
		private boolean redirectFlag = false;
		
		@Override
		public boolean isRedirect() {
			return redirectFlag;
		}

		@Override
		public String process(HttpServletRequest request,
				HttpServletResponse response) {
			
			HttpSession session = request.getSession();
			
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String sol_num = request.getParameter("sol_num");
			String sol_pass = request.getParameter("sol_pass");
			
			sol_num = CryptoGenerator.decryptRSA(session, sol_num);
			sol_pass = CryptoGenerator.decryptRSA(session, sol_pass);
				
			SessionManager.getInstance().loginDuplcationCheck(session.getId(), sol_num);
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("sol_num", sol_num);
			params.put("sol_pass", sol_pass);
			
			ISoldierService service = SoldierServiceImpl.getInstance();
			
			SoldierVO soldierInfo = service.soldierInfo(params);
			if(soldierInfo == null){
				String message;
				try {
					message = URLEncoder.encode("회원이 아닙니다." , "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "/admin/main.do";		
			}else{
				// 인증된 회원
				session.setAttribute("LOGIN_SOLDIERINFO", soldierInfo);
				return "/admin/soldierList.do";
				
			}
		
		}
}
