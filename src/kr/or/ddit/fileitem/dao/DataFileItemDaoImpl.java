package kr.or.ddit.fileitem.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.DataFileItemVO;
import kr.or.ddit.vo.QnaFileItemVO;

import com.ibatis.sqlmap.client.SqlMapClient;

public class DataFileItemDaoImpl implements IDataFileItemDao{
	private SqlMapClient smc;
	
	private static IDataFileItemDao dao;
	
	private DataFileItemDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IDataFileItemDao getInstance(){
		if(dao == null){
			dao = new DataFileItemDaoImpl();
		}
		return dao;
	}

	@Override
	public void insertDataFileItem(List<DataFileItemVO> datafileItemList)
			throws Exception {
		try{
			// iBatis 트랜잭션
			//	commit : startTransaction() : 쿼리 질의(전체 성공)
			//			 -> commitTransaction()
			//			 -> smc.endTransaction();
			// Rollback : satrtTransaction() : 쿼리 질의(일부 성공 후 에러)
			//			 -> endTransaction();
			smc.startTransaction();
			
			for(DataFileItemVO datafileItemInfo : datafileItemList){
				smc.insert("dataFileItem.insertDataFileItem", datafileItemInfo);
			}
			smc.commitTransaction();
		}finally{
			smc.endTransaction();
		}
		
	}

	@Override
	public DataFileItemVO DatafileItemInfo(Map<String, String> params)
			throws Exception {
		return (DataFileItemVO) smc.queryForObject("dataFileItem.dataFileItemInfo", params);
	}
}
