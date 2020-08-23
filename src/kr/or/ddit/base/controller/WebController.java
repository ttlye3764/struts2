package kr.or.ddit.base.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.rmi.server.Dispatcher;
import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.base.uri.adapter.URIHandlerAdapter;

// MVC 패턴 모델2 : 소프트웨어 공학의 소프트웨어 디자인 패턴
// 				 Model(M - service layer, DAO layer, VO, Bean)
//               View(V - jsp),
//				 Controller(C - servlet or filter)로 레이어 별 역할을 구분 분리하고
//                          프론트앤드 컨트롤러(디자인 패턴 활용)한 컨트롤러를 
//                          클라이언트의 요청을 일괄 처리하고, 커맨드 컨트롤러(커맨드 디자인 패턴 활용)를 
//							통해 일괄 취득된 클라이언트의 요청을 실제 처리 하는 서번트 컨트롤러라고도 지칭함.
//							다양한 클라이언트의 요청은 서번트 클래스의 인스턴스화 및 요청 처리를 위해 어댑터를 
//							활용한 비지니스 로직의 진입점으로 사용 및 매퍼를 통한 응답 제어를 수행
public class WebController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 프론트 앤드 컨트롤러 : WebController
		// 						어댑터 - 클라이언트의 해당 요청을 처리할 커맨드 컨트롤러 특정
		//							   * 기준 - 클라이언트의 요청시 서블랫 패스
		
		// 어댑터 : properties 파일 내 서블릿 패스 = 패키지명.커맨드컨트롤러 명 패턴으로 정리된 데이터를 
		//		  활용해 특정 서블릿 패스 요청을 처리할 커맨드 컨트롤러의 동적인 인스턴스화 수행 후 활용
		// http://localhost/user/freeboard/freeboardList.do  					=> kr.or.ddit.user.freeboard.FreeboardListAction implements IAction
		//				   /user/freeboard/freeboardForm.do						=> kr.or.ddit.user.freeboard.FreeboardFormAction implements IAction
		//				   /user/freeboard/freeboardView.do?bo_no=1				=> kr.or.ddit.user.freeboard.FreeboardViewAction implements IAction
		//				   /user/freeboard/insertFreeboard.do					=> kr.or.ddit.user.freeboard.insertFreeboardAction implements IAction
		//				   /user/freeboard/updateFreeboard.do
		//				   /user/freeboard/deleteFreeboard.do
				   
		String servletPath = request.getServletPath(); // .do
		
		IAction action = URIHandlerAdapter.getAction(servletPath);
		
		if(action != null){ 
			String viewName = action.process(request, response);
			if(viewName != null){ // 
				if(action.isRedirect()){ // redirect인지 fowarding인지
					response.sendRedirect(request.getContextPath() + viewName);
				}else{ // 포워드
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
					dispatcher.forward(request, response);
				}
			}
			//viewName이 null인경우 (process 메서드에서 null반환) : ajax 응답 처리시 
			//											  : filedownload 처리시
			//  * 해당 커멘트 컨트롤러의 process() 메서드 내에서 response를 
			//   활용해 응답 컨텐츠(ajax json 데이터, 파일 다운로드 설정) 처리.
		}else{
			//404 응답 처리( 응답 헤더 추가 후 클라이언트 대상 전송 처리 )
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			//web.xml의 error부분 넣어야됨.! (팀과제시)
		}
		
		
	}
	
}
