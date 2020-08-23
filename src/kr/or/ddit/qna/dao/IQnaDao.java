package kr.or.ddit.qna.dao;

import java.util.List;
import java.util.Map;
import kr.or.ddit.vo.QnaBoardVO;

public interface IQnaDao {
	public List<QnaBoardVO> qnaList(Map<String, String> params) throws Exception;
	public QnaBoardVO qnaInfo(Map<String, String> params) throws Exception;
	public void deleteQnaBoard(Map<String, String> params) throws Exception;
	public void updateQnaBoard(QnaBoardVO qnaBoardInfo) throws Exception;
	public String insertQnaBoardReplyInfo(QnaBoardVO qnaBoardInfo) throws Exception;
	public String totalCount(Map<String, String> params) throws Exception;
	public String insertQnaBoardInfo(QnaBoardVO qnaBoardInfo) throws Exception;
	public void updateQnaReplyInfo(QnaBoardVO qnaBoardInfo) throws Exception;	
}
