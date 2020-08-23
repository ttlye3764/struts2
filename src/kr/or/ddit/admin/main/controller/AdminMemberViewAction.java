package kr.or.ddit.admin.main.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class AdminMemberViewAction implements IAction {
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String mem_id = request.getParameter("mem_id");
		//System.out.println(mem_id);
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("mem_id", mem_id);
		IMemberService service = MemberServiceImpl.getInstance();
		MemberVO member = service.memberInfo(params);
		request.setAttribute("memberInfo", member);
		return "/admin/member/memberDetail.tiles";
	}

}
