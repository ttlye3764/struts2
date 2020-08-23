package kr.or.ddit.nfileitem.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.NoticeFileItemVO;

public interface INFileItemDao {
	public void insertFileItem(List<NoticeFileItemVO> fileItemList) throws Exception;
	public NoticeFileItemVO fileItemInfo(Map<String, String> params) throws Exception;

}
