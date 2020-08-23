package kr.or.ddit.admin.qnaboard.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.fileitem.service.IQnaFileItemService;
import kr.or.ddit.fileitem.service.QnaFileItemServiceImpl;
import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.QnaFileItemVO;

public class QnaFileDownloadAction implements IAction{

	   @Override
	   public boolean isRedirect() {
	      // TODO Auto-generated method stub
	      return false;
	   }

	   @Override
	   public String process(HttpServletRequest request,
	         HttpServletResponse response) {
	      
	      String qa_seq = request.getParameter("qa_seq");
	      
	      Map<String, String>params = new HashMap<String, String>();
	      params.put("qa_seq", qa_seq);
	      
	      IQnaFileItemService service = QnaFileItemServiceImpl.getInstance();
	      QnaFileItemVO fileInfo = service.QnafileItemInfo(params);
	      
	      File downloadFile = new File(GlobalConstant.FILE_PATH, fileInfo.getQa_save_name());
	      
	      if(downloadFile.exists()){
	         String fileName = null;
	         
	         try {
	            fileName = URLEncoder.encode(fileInfo.getQa_name(), "UTF-8");
	         } catch (UnsupportedEncodingException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	         
	         response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
	         response.setContentType("application/octet-stream");
	         response.setContentLength((int)downloadFile.length());
	         
	         byte[] buffer = new byte[(int)downloadFile.length()];
	         
	           BufferedInputStream inputStream = null;
	               
	               try{
	               inputStream = new BufferedInputStream(new FileInputStream(downloadFile));
	               } catch(FileNotFoundException e){
	                  e.printStackTrace();
	               }
	               BufferedOutputStream outputStream = null;
	               
	               try {
	                  outputStream = new BufferedOutputStream(response.getOutputStream());
	               } catch (IOException e) {
	                  e.printStackTrace();
	               }
	               
	               int readCNT = 0;
	               try {
	                  while((readCNT = inputStream.read(buffer)) != -1){
	                     outputStream.write(buffer);
	                  }
	               } catch (IOException | IllegalStateException e) {
	                  e.printStackTrace();
	               }
	               
	               try {
	                  inputStream.close();
	               } catch (IOException  | IllegalStateException e) {
	                  e.printStackTrace();
	               }
	               try {
	                  outputStream.close();
	               } catch (IOException  | IllegalStateException e) {
	                  e.printStackTrace();
	               }
	            }
	            
	      
	      return null;
	   }

}
