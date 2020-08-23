package kr.or.ddit.fileitem.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.QnaFileItemVO;

import com.ibatis.sqlmap.client.SqlMapClient;

public class QnaFileItemDaoImpl implements IQnaFileItemDao{
	
	private SqlMapClient smc;
	
	private static IQnaFileItemDao dao;
	
	private QnaFileItemDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IQnaFileItemDao getInstance(){
		if(dao == null){
			dao = new QnaFileItemDaoImpl();
		}
		return dao;
	}
	
	@Override
	public void insertQnaFileItem(List<QnaFileItemVO> qnafileItemList) throws Exception {
		try{
			// iBatis 트랜잭션
			//	commit : startTransaction() : 쿼리 질의(전체 성공)
			//			 -> commitTransaction()
			//			 -> smc.endTransaction();
			// Rollback : satrtTransaction() : 쿼리 질의(일부 성공 후 에러)
			//			 -> endTransaction();
			smc.startTransaction();
			
			for(QnaFileItemVO qnafileItemInfo : qnafileItemList){
				smc.insert("qnaFileItem.insertQnaFileItem", qnafileItemInfo);
			}
			smc.commitTransaction();
		}finally{
			smc.endTransaction();
		}
		
	}
	@Override
	public QnaFileItemVO QnafileItemInfo(Map<String, String> params) throws Exception {
		return (QnaFileItemVO) smc.queryForObject("qnaFileItem.qnaFileItemInfo", params);
	}
}
