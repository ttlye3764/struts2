package kr.or.ddit.fileitem.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.fileitem.dao.IImageFileItemDao;
import kr.or.ddit.fileitem.dao.ImageFileItemDaoImpl;
import kr.or.ddit.vo.ImageFileItemVO;
import kr.or.ddit.vo.QnaFileItemVO;

public class ImageFileItemServiceImpl implements IImageFileItemService{

	private static IImageFileItemService service;
	
	private IImageFileItemDao dao;
	
	private ImageFileItemServiceImpl() {
		dao = ImageFileItemDaoImpl.getinstance();
	}
	
	public static IImageFileItemService getInstance(){
		if(service == null){
			service = new ImageFileItemServiceImpl();
		}
		return service;
	}
	
	
	@Override
	public void insertImageFileItem(List<ImageFileItemVO> imageFileItemList) {
		try {
			dao.insertImageFileItem(imageFileItemList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ImageFileItemVO imageFileItemInfo(Map<String, String> params) {
		ImageFileItemVO imageFileItemInfo = null;
		try{
			imageFileItemInfo = dao.imageFileItemInfo(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return imageFileItemInfo;
	}
}
