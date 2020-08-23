package kr.or.ddit.soldier.freeboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.freeboard.service.FreeBoardServiceImpl;
import kr.or.ddit.freeboard.service.IFreeBoardService;
import kr.or.ddit.utiles.RolePaginationUtil;
import kr.or.ddit.vo.FreeBoardVO;

public class FreeboardListAction implements IAction{
	// 프레임웍 : 포워딩 default.
		private boolean redirectFlag = false;
		
		@Override
		public boolean isRedirect() {
			return redirectFlag;
		}

		@Override
		public String process(HttpServletRequest request,
				HttpServletResponse response) {
			
			IFreeBoardService service = FreeBoardServiceImpl.getInstace();
			Map<String, String> params = new HashMap<String, String>();
			
			String currentPage = request.getParameter("currentPage");
			if(currentPage == null){
				currentPage = "1";
			}

			String search_keyword = request.getParameter("search_keyword");
			String search_keycode = request.getParameter("search_keycode");

			params.put("search_keyword", search_keyword);
			params.put("search_keycode", search_keycode);
			
			String totalCount = service.totalCount(params);
			RolePaginationUtil pagination = new RolePaginationUtil(request, Integer.parseInt(currentPage),Integer.parseInt(totalCount));
			params.put("startCount", String.valueOf(pagination.getStartCount()));
			params.put("endCount", String.valueOf(pagination.getEndCount()));
		
			List<FreeBoardVO> freeboardList = service.freeBoardList(params); 	

			request.setAttribute("freeBoardList", service.freeBoardList(params));
			request.setAttribute("paginationMenu", pagination.getPagingHtmls());
			
			
			return "/user/freeboard/freeboardList.tiles";
		}
}
