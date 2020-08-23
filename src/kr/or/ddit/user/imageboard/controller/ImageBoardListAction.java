package kr.or.ddit.user.imageboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.askboard.service.AskBoardServiceImpl;
import kr.or.ddit.askboard.service.IAskBoardService;
import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.imageboard.service.IImageBoardService;
import kr.or.ddit.imageboard.service.ImageBoardServiceImpl;
import kr.or.ddit.utiles.RolePaginationUtil;
import kr.or.ddit.vo.AskBoardVO;
import kr.or.ddit.vo.ImageBoardVO;

public class ImageBoardListAction implements IAction{

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
				
				IImageBoardService service = ImageBoardServiceImpl.getInstance();
				
				String totalCount = service.totalCount(params);
				
				RolePaginationUtil pagination = new RolePaginationUtil(request,
																		Integer.parseInt(currentPage),
																		Integer.parseInt(totalCount));
				
				
				
				params.put("startCount", String.valueOf(pagination.getStartCount()));
				
				params.put("endCount", String.valueOf(pagination.getEndCount()));
				
				List<ImageBoardVO> imageBoardList = service.imageBoardList(params);
				
				request.setAttribute("imageBoardList", imageBoardList);
				
				session.setAttribute("contentPage","imageBoardList");
				
				request.setAttribute("pagination", pagination);
				
				return "/user/imageboard/imageboardList.tiles";
			}
}
