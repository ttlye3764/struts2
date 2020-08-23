package kr.or.ddit.admin.freeboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.freeboard.service.FreeBoardServiceImpl;
import kr.or.ddit.freeboard.service.IFreeBoardService;
import kr.or.ddit.qna.service.IQnaService;
import kr.or.ddit.qna.service.QnaServiceImpl;
import kr.or.ddit.utiles.RolePaginationUtil;
import kr.or.ddit.vo.FreeBoardVO;
import kr.or.ddit.vo.QnaBoardVO;

public class FreeBoardListAction implements IAction{
	// 프레임웍 : 포워딩 default.
		private boolean redirectFlag = false;
		
		@Override
		public boolean isRedirect() {
			return redirectFlag;
		}

		@Override
		public String process(HttpServletRequest request,HttpServletResponse response) {
			HttpSession session = request.getSession();
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
			
			IFreeBoardService service = FreeBoardServiceImpl.getInstace();
			
			String totalCount = service.totalCount(params);
			
			RolePaginationUtil pagination = new RolePaginationUtil(request,
																	Integer.parseInt(currentPage),
																	Integer.parseInt(totalCount));
			
			
			
			params.put("startCount", String.valueOf(pagination.getStartCount()));
			
			params.put("endCount", String.valueOf(pagination.getEndCount()));
			
			List<FreeBoardVO> freeBoardList = service.freeBoardList(params);
			
			request.setAttribute("freeBoardList", freeBoardList);
			request.setAttribute("pagination", pagination);
			
			return "/admin/freeboard/freeBoardList.tiles";
			
		}

}
