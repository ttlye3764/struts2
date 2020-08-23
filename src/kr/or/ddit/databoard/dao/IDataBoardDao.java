package kr.or.ddit.databoard.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.DataBoardVO;

public interface IDataBoardDao {
	public List<DataBoardVO> dataList(Map<String, String> params) throws Exception;
	public DataBoardVO dataInfo(Map<String, String> params) throws Exception;
	public void deleteDataBoard(Map<String, String> params) throws Exception;
	public void updateDataBoard(DataBoardVO dataBoardInfo) throws Exception;
	public String insertDataBoardReplyInfo(DataBoardVO dataBoardInfo) throws Exception;
	public String totalCount(Map<String, String> params) throws Exception;
	public String insertDataBoardInfo(DataBoardVO dataBoardInfo) throws Exception;
	public void adminupdateDataBoard(DataBoardVO dataBoardInfo) throws Exception;
}
