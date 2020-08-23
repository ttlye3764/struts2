package kr.or.ddit.imageboard.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.fileitem.dao.IImageFileItemDao;
import kr.or.ddit.fileitem.dao.ImageFileItemDaoImpl;
import kr.or.ddit.imageboard.dao.IImageBoardDao;
import kr.or.ddit.imageboard.dao.ImageBoardDaoImpl;
import kr.or.ddit.utiles.AttachFileMapper;
import kr.or.ddit.vo.ImageBoardVO;
import kr.or.ddit.vo.ImageFileItemVO;
import kr.or.ddit.vo.QnaFileItemVO;

import org.apache.commons.fileupload.FileItem;

public class ImageBoardServiceImpl implements IImageBoardService{
	
	private static IImageBoardService service;
	private IImageBoardDao dao;
	private IImageFileItemDao imageFileItemDao = ImageFileItemDaoImpl.getinstance();
	
	private ImageBoardServiceImpl() {
		dao = ImageBoardDaoImpl.getInstance();
	}
	
	public static IImageBoardService getInstance(){
		if(service ==null){
			service = new ImageBoardServiceImpl();
		}
		return service;
	}

	@Override
	public List<ImageBoardVO> imageBoardList(Map<String, String> params) {
		List<ImageBoardVO> imageBoardList = null;
 		try{
			imageBoardList = dao.imageBoardList(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return imageBoardList;
	}

	@Override
	public ImageBoardVO imageBoardInfo(Map<String, String> params) {
		ImageBoardVO imageBoardInfo = null;
		try{
			imageBoardInfo = dao.imageBoardInfo(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return imageBoardInfo;
	}

	@Override
	public void deleteImageBoard(Map<String, String> params) {
		try{
			dao.deleteImageBoard(params);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void updateImageBoard(ImageBoardVO imageBoardInfo) {
		try{
			dao.updateImageBoard(imageBoardInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public String insertImageBoardReplyInfo(ImageBoardVO imageBoardInfo, FileItem[] items) {
		String img_no =null;
		try{
			img_no = dao.insertImageBoardReplyInfo(imageBoardInfo);
			List<ImageFileItemVO> imageFileItemList = AttachFileMapper.mapperImage(items, img_no);
			imageFileItemDao.insertImageFileItem(imageFileItemList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return img_no;
	}

	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount ="";
		try{
			totalCount = dao.totalCount(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return totalCount;
	}

	@Override
	public String insertImageBoardInfo(ImageBoardVO imageBoardInfo, FileItem[] items) {
		String img_no =null;
		try{
			img_no = dao.insertImageBoardInfo(imageBoardInfo);
			List<ImageFileItemVO> imageFileItemList = AttachFileMapper.mapperImage(items, img_no);
			imageFileItemDao.insertImageFileItem(imageFileItemList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return img_no;
	}

	@Override
	public void updateImageReplyInfo(ImageBoardVO imageBoardInfo) {
		try {
			dao.updateImageReplyInfo(imageBoardInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
