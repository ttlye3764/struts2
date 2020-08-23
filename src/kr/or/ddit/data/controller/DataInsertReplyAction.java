package kr.or.ddit.data.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.databoard.service.DataBoardServiceImpl;
import kr.or.ddit.databoard.service.IDataBoardService;
import kr.or.ddit.vo.DataBoardVO;

import org.apache.commons.beanutils.BeanUtils;

public class DataInsertReplyAction implements IAction{
private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		DataBoardVO dataBoardInfo = new DataBoardVO();

		// BeanUtils.populate(freeboardInfo, request.getParameterMap());
		try {
			BeanUtils.populate(dataBoardInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		IDataBoardService service = DataBoardServiceImpl.getInstance();
		
		service.insertDataBoardReplyInfo(dataBoardInfo);

		return "/data/databoardList.do";
	
	}
}
