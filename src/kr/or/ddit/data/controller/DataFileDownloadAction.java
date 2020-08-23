package kr.or.ddit.data.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.fileitem.service.DataFileItemServiceImpl;
import kr.or.ddit.fileitem.service.IDataFileItemService;
import kr.or.ddit.utiles.FileDownloadView;
import kr.or.ddit.vo.DataFileItemVO;

public class DataFileDownloadAction implements IAction{
private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String db_seq = request.getParameter("db_seq");
	    
    	Map<String, String> params = new HashMap<String, String>();
    	
    	params.put("db_seq", db_seq);
    
    	IDataFileItemService service = DataFileItemServiceImpl.getInstance();
    	DataFileItemVO fileItemInfo = service.DatafileItemInfo(params);
    	
    	PrintWriter out = response.getWriter();
		
		out = request.pushBody();
    	FileDownloadView.fileDownload(pageContext, fileItemInfo.getFile_name(), fileItemInfo.getFile_save_name());
		return "";
	
	}
}
