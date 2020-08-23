package kr.or.ddit.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class IPCheckFilter implements Filter {
	
	private static Map<String, String> ipMap;
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		ipMap = new HashMap<String, String>();
		
		ipMap.put("127.0.0.1", "A");
		ipMap.put("0:0:0:0:0:0:0:0:1", "A");
		ipMap.put("192.168.206.12", "A");
		ipMap.put("192.168.206.45", "A");
		ipMap.put("localhost", "A");
		
		for(int i = 0; i< 40 ;i++){
			if(i!=12){
				ipMap.put("192.168.206."+i, "F");
			}
		}
	}	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		
		String clientIP = servletrequest.getRemoteAddr();
		boolean flag = true;
		if(StringUtils.isNotEmpty(clientIP) && ipMap.containsKey(clientIP)){
			if("A".intern() == ipMap.get(clientIP).intern()){
				chain.doFilter(servletrequest, servletResponse);
			}else{
				flag = false;
			}
		}else{
			flag = false;
		}
		if(!flag){
			HttpServletResponse response = (HttpServletResponse)servletResponse;
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out  = response.getWriter();
			
			out.println("<html>");
				out.println("<body>");
					out.println("<font color='red'>꺼져</font>");
				out.println("<body>");
			out.println("</html>");
		}
	}


}
