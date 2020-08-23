package kr.or.ddit.freeboardfileitem.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.FreeBoardFileItemVO;

public interface IFreeBoardFileItemDao {
	public void insertfreeboardFileItem(List<FreeBoardFileItemVO> fileItemList) throws Exception ;
	public FreeBoardFileItemVO freeboardfileItemInfo(Map<String, String> params) throws Exception;
}
