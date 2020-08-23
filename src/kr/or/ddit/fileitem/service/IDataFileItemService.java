package kr.or.ddit.fileitem.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.DataFileItemVO;

public interface IDataFileItemService {
	public void insertDataFileItem(List<DataFileItemVO> DatafileItemList);
	public DataFileItemVO DatafileItemInfo(Map<String, String> params);
}	
