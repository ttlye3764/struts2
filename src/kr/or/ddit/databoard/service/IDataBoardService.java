package kr.or.ddit.databoard.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.DataBoardVO;

public interface IDataBoardService {
	public List<DataBoardVO> dataList(Map<String, String> params);
	public DataBoardVO dataInfo(Map<String, String> params);
	public void deleteDataBoard(Map<String, String> params);
	public void updateDataBoard(DataBoardVO dataBoardInfo);
	public String insertDataBoardReplyInfo(DataBoardVO dataBoardInfo);
	public String totalCount(Map<String, String> params);
	public String insertDataBoardInfo(DataBoardVO dataBoardInfo, FileItem[] items);
	public void adminupdateDataBoard(DataBoardVO dataBoardInfo);
}
