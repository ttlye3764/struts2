package kr.or.ddit.fileitem.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.QnaFileItemVO;

public interface IQnaFileItemDao {
	public void insertQnaFileItem(List<QnaFileItemVO> qnafileItemList) throws Exception;
	public QnaFileItemVO QnafileItemInfo(Map<String, String> params) throws Exception;
}
