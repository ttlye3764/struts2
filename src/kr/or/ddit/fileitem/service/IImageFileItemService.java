package kr.or.ddit.fileitem.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ImageFileItemVO;

public interface IImageFileItemService {
	public void insertImageFileItem(List<ImageFileItemVO> imageFileItemList);
	public ImageFileItemVO imageFileItemInfo(Map<String, String> params);
}
