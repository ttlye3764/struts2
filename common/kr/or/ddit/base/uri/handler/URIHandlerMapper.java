package kr.or.ddit.base.uri.handler;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

//프로퍼티스 파일 내 데이터(클라이언트 요청시 서블릿 패스 키 = 해당 요청을 처리하는 커맨드 컨트롤러의 패키지명.클래스명)
//Map에 저장 후 반환
public class URIHandlerMapper {
	private static Map<String, String> actionMap = new HashMap<String, String>();
	static{
		ResourceBundle bundle = ResourceBundle.getBundle("kr.or.ddit.base.uri.mapper.reqeustURIMapper");
		Enumeration<String> keys = bundle.getKeys();
		while(keys.hasMoreElements()){
			String key = keys.nextElement();
			String value = bundle.getString(key);
			actionMap.put(key, value);
		}
	}
	
	public static Map<String, String> getActionMap(){
		return actionMap;
	}

}
