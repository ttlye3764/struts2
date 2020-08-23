package kr.or.ddit.admin.soldier.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.qna.service.IQnaService;
import kr.or.ddit.qna.service.QnaServiceImpl;
import kr.or.ddit.soldier.service.ISoldierService;
import kr.or.ddit.soldier.service.SoldierServiceImpl;
import kr.or.ddit.utiles.RolePaginationUtil;
import kr.or.ddit.vo.SoldierVO;

public class SoldierListAction implements IAction {
	
		private boolean redirectFlag = false;
		
		@Override
		public boolean isRedirect() {
			return redirectFlag;
		}

		@Override
		public String process(HttpServletRequest request,
				HttpServletResponse response) {
			
			String currentPage = request.getParameter("currentPage");
			if(currentPage==null){
				currentPage = "1";
			}
			
			// freeboardList.jsp
			//		리다이렉트 요청 -> (request[search_keyword, search_keycode], response)main.jsp
			//					c:import 포워드 ( request[search_keyword, search_keycode], response) freeboardList.jsp
			
			String search_keyword = request.getParameter("search_keyword");
			String search_keycode = request.getParameter("search_keycode");

			Map<String, String> params = new HashMap<String, String>();
			
			params.put("search_keyword", search_keyword);
			params.put("search_keycode", search_keycode);
			
			ISoldierService service = SoldierServiceImpl.getInstance();
			
			String totalCount = service.totalCount(params);
			
			String blockCount = request.getParameter("blockCount");
			
			System.out.println(blockCount);
			
			if(blockCount==null){
				blockCount = "10";
			}else if(blockCount.equals("")){
				blockCount = "10";
			}
			
			System.out.println(blockCount);
			
			RolePaginationUtil pagination = new RolePaginationUtil(request,
																	Integer.parseInt(currentPage),
																	Integer.parseInt(totalCount),
																	Integer.parseInt(blockCount));
			
			
			
			params.put("startCount", String.valueOf(pagination.getStartCount()));
			
			params.put("endCount", String.valueOf(pagination.getEndCount()));
			
			List<SoldierVO> SoldierList = service.soldierList(params); 
			
			request.setAttribute("SoldierList", SoldierList);
			request.setAttribute("pagination", pagination);
			request.setAttribute("blockCount", blockCount);
			
			return "/admin/member/memberMgr.tiles";
		}
}
