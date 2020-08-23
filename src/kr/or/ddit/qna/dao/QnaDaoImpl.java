package kr.or.ddit.qna.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.QnaBoardVO;

public class QnaDaoImpl implements IQnaDao {
	
	private static IQnaDao dao;
	private SqlMapClient smc;
	
	public QnaDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IQnaDao getInstance(){
		if(dao==null){
			dao = new QnaDaoImpl();
		}
		return dao;
	}

	@Override
	public List<QnaBoardVO> qnaList(Map<String, String> params) throws Exception {
		return smc.queryForList("qna.qnaList", params);
	}

	@Override
	public QnaBoardVO qnaInfo(Map<String, String> params) throws Exception {
		return (QnaBoardVO) smc.queryForObject("qna.qnaBoardInfo", params);
	}
	
	@Override
	public String insertQnaBoardInfo(QnaBoardVO qnaBoardInfo) throws Exception {
		return (String) smc.insert("qna.insertQnaBoardInfo", qnaBoardInfo);
	}
	@Override
	public void deleteQnaBoard(Map<String, String> params) throws Exception {
		smc.update("qna.deleteQnaBoard", params);
		
	}

	@Override
	public void updateQnaBoard(QnaBoardVO qnaBoardInfo) throws Exception {
		smc.update("qna.updateQnaBoard", qnaBoardInfo);
		
	}

	@Override
	public String insertQnaBoardReplyInfo(QnaBoardVO qnaBoardInfo) throws Exception {

		String qa_no="";
		
		try{
			smc.startTransaction();
			
			String qa_seq;
			
			// 내부모가 루트글인지 그냥 댓글인지에 따라 처리가 달라짐
			if("0".intern() == qnaBoardInfo.getQa_seq().intern()){ // 부모가 루트일때
				qa_seq = (String) smc.queryForObject("qna.incrementSeq", qnaBoardInfo);
			}else{// 부모가 댓글일때
				smc.update("qna.updateSeq", qnaBoardInfo); 
				
				qa_seq = String.valueOf(Integer.parseInt(qnaBoardInfo.getQa_seq())+1);
			}
			qnaBoardInfo.setQa_seq(qa_seq);
			
			String qa_depth = String.valueOf(Integer.parseInt(qnaBoardInfo.getQa_depth())+1);
			qnaBoardInfo.setQa_depth(qa_depth);
			
			qa_no = (String)smc.insert("qna.insertQnaBoardReply", qnaBoardInfo);
			smc.commitTransaction();
		}finally{
			smc.endTransaction();
		}
		
		return qa_no;
	}

	@Override
	public String totalCount(Map<String, String> params) throws Exception {
		return (String)smc.queryForObject("qna.totalCount", params);
	}
	
	@Override
	public void updateQnaReplyInfo(QnaBoardVO qnaBoardInfo) throws Exception {
			smc.update("qna.updateQnaReply");
	}
}
