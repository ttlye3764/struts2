package kr.or.ddit.fileitem.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.ImageFileItemVO;
import kr.or.ddit.vo.QnaFileItemVO;

public class ImageFileItemDaoImpl implements IImageFileItemDao{
	
	private static IImageFileItemDao dao;
	
	private SqlMapClient smc;
	
	private ImageFileItemDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IImageFileItemDao getinstance(){
		if(dao ==null){
			dao = new ImageFileItemDaoImpl();
		}
		return dao;
	}

	@Override
	public void insertImageFileItem(List<ImageFileItemVO> imageFileItemList) throws Exception {
		try{
			// iBatis 트랜잭션
			//	commit : startTransaction() : 쿼리 질의(전체 성공)
			//			 -> commitTransaction()
			//			 -> smc.endTransaction();
			// Rollback : satrtTransaction() : 쿼리 질의(일부 성공 후 에러)
			//			 -> endTransaction();
			smc.startTransaction();
			
			for(ImageFileItemVO imageFileItemInfo : imageFileItemList){
				smc.insert("imageFileItem.insertImageFileItem", imageFileItemInfo);
			}
			smc.commitTransaction();
		}finally{
			smc.endTransaction();
		}
		
	}

	@Override
	public ImageFileItemVO imageFileItemInfo(Map<String, String> params) throws Exception {
		return (ImageFileItemVO) smc.queryForObject("imageFileItem.imageFileItemInfo", params);
	}
	
}
