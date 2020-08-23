package kr.or.ddit.askboard.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AskBoardVO;


public interface IAskBoardService {
	public List<AskBoardVO> askBoardList(Map<String, String> params);
	public String totalCount(Map<String, String> params);
	public AskBoardVO askBoardInfo(Map<String, String> params);
	public void insertAskBoardInfo(AskBoardVO askBoardInfo);
	public void updateAskBoardInfo(AskBoardVO askBoardInfo);
}
