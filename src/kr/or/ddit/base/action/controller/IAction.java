package kr.or.ddit.base.action.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 전체 커맨드 컨트롤러 클래스가 공통 implements 하는 인터페이스
public interface IAction {
	// 클라이언트의 해당 요청의 응답 제어
	// true : 리다이렉트 응답 제어
	// false : 포워딩 응답 제어
	public boolean isRedirect();
	
	// 비지니스 로직 수행의 접점 : Model layer(Service Layer)
	// 반환값 : View(jsp의 경로와 이름, tiles의 레이아웃 definition)
	public String process(HttpServletRequest request,
							HttpServletResponse response);
}
