package kr.or.ddit.fileitem.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.DataFileItemVO;

public interface IDataFileItemDao {
	public void insertDataFileItem(List<DataFileItemVO> datafileItemList) throws Exception;
	public DataFileItemVO DatafileItemInfo(Map<String, String> params) throws Exception;
}
