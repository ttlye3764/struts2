package kr.or.ddit.askboard.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AskBoardVO;

public interface IAskBoardDao {
	public List<AskBoardVO> askBoardList(Map<String, String> params) throws Exception;
	public String totalCount(Map<String, String> params) throws Exception;
	public AskBoardVO askBoardInfo(Map<String, String> params) throws Exception;
	public void insertAskBoardInfo(AskBoardVO askBoardInfo) throws Exception;
	public void updateAskBoardInfo(AskBoardVO askBoardInfo) throws Exception;
}
