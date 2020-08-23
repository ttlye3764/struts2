package kr.or.ddit.nfileitem.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.nfileitem.dao.INFileItemDao;
import kr.or.ddit.nfileitem.dao.NFileItemDaoImpl;
import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.NoticeFileItemVO;

public class NFileItemServiceImpl implements INFileItemService{
	
	private INFileItemDao dao;
	private static INFileItemService service;
	
	private NFileItemServiceImpl(){
		dao = NFileItemDaoImpl.getInstance();
	}
	
	public static INFileItemService getInstance(){
		if(service == null){
		}
		return service;
	}

	@Override
	public void insertFileItem(List<NoticeFileItemVO> fileItemList) {
		try {
			dao.insertFileItem(fileItemList);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public NoticeFileItemVO fileItemInfo(Map<String, String> params) {
		NoticeFileItemVO fileItemInfo = null;
		try{
			fileItemInfo = dao.fileItemInfo(params);
		}catch (Exception e){
			e.printStackTrace();
		}
		return fileItemInfo;
	}
}
