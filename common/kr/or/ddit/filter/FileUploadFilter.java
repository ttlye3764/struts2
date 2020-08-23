package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.utiles.FIleUploadRequestWrapper;

import org.apache.commons.lang3.StringUtils;

public class FileUploadFilter implements Filter {
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		// 클라이언트 요청시 컨텐츠 타입
		//		content type - null
		//					       직접 브라우저의 주소창에 URL 입력 후 요청
		//					   location.href ='URI'
		//					   location.replace('URI')
		//					   <a href = 'URI'>아아아</a>
		
		//					 - apllcation/x-www-form-urlencoded
		//					   <form action='URI'/>
		//					   ajax
		
		//					 - multipart/form-data
		//					   <form action='URI' enctype='multipart/form-data' method='POST'>
		//					   ajax
		
		// 요청한 컨텐츠 타입 획득
		String contentType = servletRequest.getContentType();
		
		// contentType이 null, ''이 아니면 true && contentType에 multipart라는 문자열이 포함되어 있으면 true
		if(StringUtils.isNotEmpty(contentType) && contentType.toLowerCase().contains("multipart")){
			
			FIleUploadRequestWrapper wrapper =
					new FIleUploadRequestWrapper((HttpServletRequest)servletRequest);
			
			chain.doFilter(wrapper, servletResponse);
		}else{
			
			// 스트리밍 요청이 아니면 그냥 보낸다.
			chain.doFilter(servletRequest, servletResponse);
		}
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	

	
}
