package kr.or.ddit.freeboard.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.FreeBoardVO;
import kr.or.ddit.vo.QnaBoardVO;

public interface IFreeBoardService {
	public List<FreeBoardVO> freeBoardList(Map<String,String> params);
	public FreeBoardVO freeboardInfo(Map<String, String> params);
	public void updateFreeboard(FreeBoardVO freeboardInfo);
	public void deleteFreeBoard(String bo_no);
	public String totalCount(Map<String, String> params);
	public String insertFreeboardInfo(FreeBoardVO freeboardInfo, FileItem[] items);
	public String insertFreeBoardReplyInfo(FreeBoardVO freeboardInfo);
	public void updateHitFreeboard(String bo_no);


}
