package kr.or.ddit.fileitem.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.fileitem.dao.DataFileItemDaoImpl;
import kr.or.ddit.fileitem.dao.IDataFileItemDao;
import kr.or.ddit.vo.DataFileItemVO;
import kr.or.ddit.vo.QnaFileItemVO;

public class DataFileItemServiceImpl implements IDataFileItemService{
	private IDataFileItemDao dao;
	private static IDataFileItemService service;
	
	private DataFileItemServiceImpl() {
		dao = DataFileItemDaoImpl.getInstance();
	}
	
	public static IDataFileItemService getInstance(){
		if(service ==null){
			service = new DataFileItemServiceImpl();
		}
		return service;
	}

	@Override
	public void insertDataFileItem(List<DataFileItemVO> DatafileItemList) {
		try {
			dao.insertDataFileItem(DatafileItemList);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

	@Override
	public DataFileItemVO DatafileItemInfo(Map<String, String> params) {
		DataFileItemVO DataFileItemInfo = null;
		try{
			DataFileItemInfo = dao.DatafileItemInfo(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return DataFileItemInfo;
	}
}
