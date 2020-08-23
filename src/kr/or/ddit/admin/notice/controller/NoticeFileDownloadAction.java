package kr.or.ddit.admin.notice.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.nfileitem.service.INFileItemService;
import kr.or.ddit.nfileitem.service.NFileItemServiceImpl;
import kr.or.ddit.vo.NoticeFileItemVO;

public class NoticeFileDownloadAction implements IAction{
private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String nt_seq = request.getParameter("nt_seq");
	    
    	Map<String, String> params = new HashMap<String, String>();
    	
    	params.put("nt_seq", nt_seq);
    
    	INFileItemService service = NFileItemServiceImpl.getInstance();
    	NoticeFileItemVO fileItemInfo = service.fileItemInfo(params);
    	
    	/*PrintWriter out = response.getWriter();
		
		out = request.pushBody();
    	FileDownloadView.fileDownload(pageContext, fileItemInfo.getFile_name(), fileItemInfo.getFile_save_name());*/
		return "";
	
	}
}
