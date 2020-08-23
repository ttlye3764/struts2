package kr.or.ddit.admin.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.utiles.RolePaginationUtil;
import kr.or.ddit.vo.NoticeBoardVO;

public class NoticeAction implements IAction{
	// 프레임웍 : 포워딩 default
	private boolean redirectFlag = false;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		//HttpSession session = request.getSession();
		INoticeService service = NoticeServiceImpl.getInstance();
		Map<String, String> params = new HashMap<String, String>();
		
		String currentPage = request.getParameter("currentPage");
		if(currentPage == null) {
			currentPage = "1";
		}
		
		String search_keyword  = request.getParameter("search_keyword");
		String search_keycode = request.getParameter("search_keycode");
		
		params.put("search_keyword", search_keyword);
		params.put("search_keycode", search_keycode);
		
		
		String totalCount = service.totalCount(params);
		
		RolePaginationUtil pagination = new RolePaginationUtil(request,
																Integer.parseInt(currentPage),
																Integer.parseInt(totalCount));
		
		params.put("startCount", String.valueOf(pagination.getStartCount()));
		params.put("endCount", String.valueOf(pagination.getEndCount()));
		
		List<NoticeBoardVO> noticeList = service.noticeList(params);
		
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("pagination", pagination);
		
		return "/admin/notice/noticeList.tiles";
	}

}
