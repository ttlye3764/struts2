package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.StringUtils;



public class EncodingFilter implements Filter{
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		// 클라이언트가 전송하는 쿼리스트링 전송방식
		// 		GET : server.xml <connector URIEncoding="UTF-8"></connector>
		// 		POST : jsp 내 스크립트릿 영역 request.setCharactorEncoding("UTF-8");
		// 클라이언트의 쿼리스트링 전송시 특정 인코딩 처리 요구를 요청 헤더에 포함시킬 수 있다.
		//		자바스크립트 : Accept-Charset : UTF-8 -> 으로 보내면 이걸 취득하는 메소드 .getCharacterEncoding()
		String encodingType = servletRequest.getCharacterEncoding();
		
		//http://commons.apache.org
		// java.lang.String 클래스의 확장 API 라이브러리
		
		// encodingType이 null이거나 ""이면 true
		if(StringUtils.isEmpty(encodingType)){
			encodingType = "UTF-8";
		}
		servletRequest.setCharacterEncoding(encodingType);
		
		chain.doFilter(servletRequest, servletResponse);
		
	}

	
}
