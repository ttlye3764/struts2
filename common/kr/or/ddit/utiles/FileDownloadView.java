package kr.or.ddit.utiles;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import kr.or.ddit.global.GlobalConstant;
// 파일 다운로드 처리 jsp 내
// FileDownloadView.fileDownload(pageContext, "a.png")

public class FileDownloadView {
	public static void fileDownload(PageContext pageContext, String realName, String downloadFileName) throws IOException{
		
		// 자바에서는 기본객체를 바로 쓸수 없기대문에 pageContext를 통해서 얻어냄
		HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
		JspWriter out = pageContext.getOut();
		

		File downloadFile = new File(GlobalConstant.FILE_PATH, downloadFileName); // 다운은 경로로 저장해주고
		
		if(downloadFile.exists()){
			realName= URLEncoder.encode(realName, "UTF-8"); // 파일이름은 유저가 지정
			
			response.setHeader("Content-Disposition", "attachment;fileName=" + realName);
			response.setContentType("application/octet-stream");
			response.setContentLength((int)downloadFile.length());
			
			
			byte[] buffer = new byte[(int)downloadFile.length()];
			
			BufferedInputStream inputStream = new BufferedInputStream(
													new FileInputStream(
															downloadFile));
			
			BufferedOutputStream outputStream = new BufferedOutputStream(
													response.getOutputStream());
			
			int readCnt = 0;
			while((readCnt= inputStream.read(buffer))!= -1){
				outputStream.write(buffer);
				
			}
			inputStream.close();
			outputStream.close();
		}
	}
	
}
