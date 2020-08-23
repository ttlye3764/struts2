package kr.or.ddit.nfileitem.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.NoticeFileItemVO;

public interface INFileItemService {
	public void insertFileItem(List<NoticeFileItemVO> fileItemList);
	public NoticeFileItemVO fileItemInfo(Map<String, String> params);

}
