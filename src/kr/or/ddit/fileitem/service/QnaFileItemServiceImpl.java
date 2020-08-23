package kr.or.ddit.fileitem.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.fileitem.dao.IQnaFileItemDao;
import kr.or.ddit.fileitem.dao.QnaFileItemDaoImpl;
import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.QnaFileItemVO;

public class QnaFileItemServiceImpl implements IQnaFileItemService {
	
	private IQnaFileItemDao dao;
	private static IQnaFileItemService service;
	
	private QnaFileItemServiceImpl() {
		dao = QnaFileItemDaoImpl.getInstance();
	}
	
	public static IQnaFileItemService getInstance(){
		if(service ==null){
			service = new QnaFileItemServiceImpl();
		}
		return service;
	}
	
	@Override
	public void insertQnaFileItem(List<QnaFileItemVO> QnafileItemList) {
		try {
			dao.insertQnaFileItem(QnafileItemList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public QnaFileItemVO QnafileItemInfo(Map<String, String> params) {
		QnaFileItemVO QnaFileItemInfo = null;
		try{
			QnaFileItemInfo = dao.QnafileItemInfo(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return QnaFileItemInfo;
	}
}
