package kr.or.ddit.nfileitem.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.NoticeFileItemVO;

import com.ibatis.sqlmap.client.SqlMapClient;

public class NFileItemDaoImpl implements INFileItemDao{
	private SqlMapClient smc;
	private static INFileItemDao dao;
	private NFileItemDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
		
	}
		public static INFileItemDao getInstance() {
			if(dao == null) {
				dao = (INFileItemDao) new NFileItemDaoImpl();
				} 
				return dao;
			}
		@Override
		public void insertFileItem(List<NoticeFileItemVO> fileItemList) throws Exception {
			try {
				smc.startTransaction();
				
				for(NoticeFileItemVO fileItemInfo : fileItemList) {
					smc.insert("noticeFileItem.insertNoticeFileItem", fileItemInfo);
				}
				smc.commitTransaction();
			}finally{
				smc.endTransaction();
			}
			
		}
		@Override
		public NoticeFileItemVO fileItemInfo(Map<String, String> params) throws Exception {
			return (NoticeFileItemVO) smc.queryForObject("noticeFileItem.NoticeFileItemInfo",params);
		}
			
	}
		

