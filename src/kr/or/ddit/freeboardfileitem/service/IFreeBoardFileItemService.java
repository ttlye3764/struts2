package kr.or.ddit.freeboardfileitem.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FreeBoardFileItemVO;

public interface IFreeBoardFileItemService {
	
	
	
	public void insertfreeboardFileItem(List<FreeBoardFileItemVO> fileItemList) ;
	public FreeBoardFileItemVO freeboardfileItemInfo(Map<String, String> params);
	
}
