package kr.or.ddit.fileitem.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ImageFileItemVO;


public interface IImageFileItemDao {
	public void insertImageFileItem(List<ImageFileItemVO> imageFileItemList) throws Exception;
	public ImageFileItemVO imageFileItemInfo(Map<String, String> params) throws Exception;
}
