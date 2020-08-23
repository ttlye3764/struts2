package kr.or.ddit.freeboardfileitem.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.freeboardfileitem.dao.FreeBoardFileItemDaoImpl;
import kr.or.ddit.freeboardfileitem.dao.IFreeBoardFileItemDao;
import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.FreeBoardFileItemVO;

public class FreeBoardFileItemServiceImpl implements IFreeBoardFileItemService {
	
	private IFreeBoardFileItemDao dao;
	private static IFreeBoardFileItemService service;
	
	private FreeBoardFileItemServiceImpl() {
		dao = FreeBoardFileItemDaoImpl.getInstance();
	}
	
	public static IFreeBoardFileItemService getInstance(){
		if(service ==null){
			service = new FreeBoardFileItemServiceImpl();
		}
		return service;
	}

	@Override
	public void insertfreeboardFileItem(List<FreeBoardFileItemVO> fileItemList) {
		try {
			dao.insertfreeboardFileItem(fileItemList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public FreeBoardFileItemVO freeboardfileItemInfo(Map<String, String> params) {
		FreeBoardFileItemVO fileItemInfo = null;
		try{
			fileItemInfo = dao.freeboardfileItemInfo(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return fileItemInfo;
	}
}
