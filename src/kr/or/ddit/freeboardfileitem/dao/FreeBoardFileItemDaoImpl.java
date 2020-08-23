package kr.or.ddit.freeboardfileitem.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.FreeBoardFileItemVO;

public class FreeBoardFileItemDaoImpl implements IFreeBoardFileItemDao {
	
	private SqlMapClient smc;
		
	private static IFreeBoardFileItemDao dao;
		
	private FreeBoardFileItemDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IFreeBoardFileItemDao getInstance(){
		if(dao == null){
			dao = new FreeBoardFileItemDaoImpl();
		}
		return dao;
	}

	
	@Override
	public void insertfreeboardFileItem(List<FreeBoardFileItemVO> fileItemList)
			throws Exception {
		try{
			smc.startTransaction();
			
			for(FreeBoardFileItemVO fileItemInfo : fileItemList){
				smc.insert("freeboardfileItem.insertfreeboardFileItem", fileItemInfo);
			}
			smc.commitTransaction();
		}finally{
			smc.endTransaction();
		}
		
	}

	@Override
	public FreeBoardFileItemVO freeboardfileItemInfo(Map<String, String> params)
			throws Exception {
		return (FreeBoardFileItemVO) smc.queryForObject("freeboardfileItem.freeboardfileItemInfo", params);
	}
	
}
