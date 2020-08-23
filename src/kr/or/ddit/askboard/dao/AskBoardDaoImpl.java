package kr.or.ddit.askboard.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.AskBoardVO;






import com.ibatis.sqlmap.client.SqlMapClient;




public class AskBoardDaoImpl implements IAskBoardDao{
	
	private static IAskBoardDao dao;
	private SqlMapClient smc;
	
	private AskBoardDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IAskBoardDao getInstance(){
		if(dao == null){
			dao = new AskBoardDaoImpl();
		}
		return dao;
	}
	
	
	
	@Override
	public List<AskBoardVO> askBoardList(Map<String, String> params)
			throws Exception {
		
		return smc.queryForList("askBoard.askBoardList", params);
	}
	
	@Override
	public String totalCount(Map<String, String> params) throws Exception {
		return (String)smc.queryForObject("askBoard.totalCount", params);
	}
	
	@Override
	public AskBoardVO askBoardInfo(Map<String, String> params) throws Exception {
		return (AskBoardVO)smc.queryForObject("askBoard.askBoardInfo", params);
	}
	
	@Override
	public void insertAskBoardInfo(AskBoardVO askBoardInfo) throws Exception {
		smc.insert("askBoard.insertAskBoardInfo", askBoardInfo);
	}
	
	@Override
	public void updateAskBoardInfo(AskBoardVO askBoardInfo) throws Exception {
		smc.update("askBoard.updateAskBoardInfo", askBoardInfo);
		
	}
}
