package kr.or.ddit.fileitem.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.QnaFileItemVO;

public interface IQnaFileItemService {
	public void insertQnaFileItem(List<QnaFileItemVO> QnafileItemList);
	public QnaFileItemVO QnafileItemInfo(Map<String, String> params);
}
