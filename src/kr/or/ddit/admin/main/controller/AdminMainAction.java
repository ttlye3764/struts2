package kr.or.ddit.admin.main.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.utiles.RolePaginationUtil;
import kr.or.ddit.vo.MemberVO;

public class AdminMainAction implements IAction {
	// 프레임웍 : 포워딩 default.
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		//IMember
		String search_keyword = request.getParameter("search_keyword");
		String search_keycode =  request.getParameter("search_keycode");
		
		String mem_bir = request.getParameter("mem_bir");
		String mem_add1 = request.getParameter("mem_add1");
		String mem_add2 = request.getParameter("mem_add2");
		String mem_hp = request.getParameter("mem_hp");

		String currentPage = request.getParameter("currentPage");
		if (currentPage == null) {
			currentPage = "1";
		}
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("search_keyword", search_keyword);
		map.put("search_keycode", search_keycode);
		map.put("mem_bir",mem_bir);
		map.put("mem_add1",mem_add1);
		map.put("mem_add2",mem_add2);
		map.put("mem_hp",mem_hp);
		
		
		IMemberService service = MemberServiceImpl.getInstance();
		String totalCount = service.totalCount(map);
		
		RolePaginationUtil pagination = new RolePaginationUtil(request, 
				Integer.parseInt(currentPage),
				Integer.parseInt(totalCount));
		
		map.put("startCount", String.valueOf(pagination.getStartCount()));
		map.put("endCount", String.valueOf(pagination.getEndCount()));
	
		List<MemberVO> list = service.adminMemberList(map);
		
		request.setAttribute("adminMemberList", list);
		request.setAttribute("adminPagination", pagination.getPagingHtmls());
		
		return "/admin/member/memberMgr.tiles";
	}

}
