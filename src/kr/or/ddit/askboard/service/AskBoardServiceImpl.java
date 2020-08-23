package kr.or.ddit.askboard.service;

import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.askboard.dao.AskBoardDaoImpl;
import kr.or.ddit.askboard.dao.IAskBoardDao;
import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.AskBoardVO;

public class AskBoardServiceImpl implements IAskBoardService {

	private static IAskBoardService service;

	private IAskBoardDao dao;

	private AskBoardServiceImpl() {
		dao = AskBoardDaoImpl.getInstance();
	}

	public static IAskBoardService getInstace() {
		if (service == null) {
			service = new AskBoardServiceImpl();
		}
		return service;
	}

	@Override
	public List<AskBoardVO> askBoardList(Map<String, String> params) {
		
		List<AskBoardVO> askBoardList = null;
		try{
			askBoardList = dao.askBoardList(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return askBoardList;
	}
	
	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount ="";
		try{
			totalCount = dao.totalCount(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return totalCount;
	}
	
	@Override
	public AskBoardVO askBoardInfo(Map<String, String> params) {
		AskBoardVO askBoardInfo = null;
		try{
			askBoardInfo = dao.askBoardInfo(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return askBoardInfo;
	}
	
	@Override
	public void insertAskBoardInfo(AskBoardVO askBoardInfo) {
		try{
			dao.insertAskBoardInfo(askBoardInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateAskBoardInfo(AskBoardVO askBoardInfo) {
		try{
			dao.updateAskBoardInfo(askBoardInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
