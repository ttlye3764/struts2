package kr.or.ddit.admin.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.base.action.controller.IAction;

public class MainAction implements IAction {
	// 프레임웍 : 포워딩 default.
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		// - Model(service layer 접근)
		// 	 request 저장영역(Scope) 대상 View(포워딩 처리)에 전달될 
		//   데이터를 저장(request.setAttribute(키, 값)) 후 포워딩.
		//   View(jsp, title[jsp들로 구성])는 EL 취득 활용(응답 컨텐츠 작성)
		// - ajax 엔진 대상 데이터(json, xml, ...) 를 직접 response에 저장후 클라이언트 대상 전송(반환값이 null)
		// - 직접 파일 다운로드 설정(반환값이 null)
		
		// IFreeboardService service = IFreeboardServiceImpl.getInstance();
		// List<FreeboardVO> freeboardList = service.freeboardList(params);
		// request.setAttribute("freeboardList", freeboardList);
		// => 포워드 => freeboardList.jsp : ${freeboardList}
//		return "/WEB-INF/views/user/main.jsp";
		return "/WEB-INF/views/admin/index.jsp";
		//return "/user/freeboard/freeboardList.tiles";
	}

}
