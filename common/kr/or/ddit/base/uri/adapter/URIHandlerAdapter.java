package kr.or.ddit.base.uri.adapter;

import java.util.Map;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.base.uri.handler.URIHandlerMapper;

// 프로퍼티스 파일 내 데이터(클라이언트 요청시 서블릿 패스 키 = 해당 요청을 처리하는 커맨드 컨트롤러의 패키지명.클래스명)
// 활용해 커맨드 컨트롤러를 특정하고 동적으로 인스턴스화 처리 후 반환
public class URIHandlerAdapter {
	public static IAction getAction(String servletPath){
		Map<String, String> actionMap = URIHandlerMapper.getActionMap();
		
		IAction action = null;
		if(actionMap.containsKey(servletPath)){
			try {
				Class targetClass = Class.forName(actionMap.get(servletPath));
				action = (IAction) targetClass.newInstance();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} 
		}
		
		return action;
	}
}
