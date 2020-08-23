package kr.or.ddit.freeboard.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.FreeBoardFileItemVO;
import kr.or.ddit.vo.FreeBoardVO;

public interface IFreeBoardDao {
	public List<FreeBoardVO> freeboardList(Map<String,String> params) throws Exception;
	public String totalCount(Map<String, String> params) throws Exception;
	public FreeBoardVO freeboardInfo(Map<String, String> params) throws Exception;
	public void updateFreeboard(FreeBoardVO freeboardInfo) throws Exception;
	public void deleteFreeBoard(String bo_no) throws Exception;
	public String insertFreeBoardInfo(FreeBoardVO freeboardInfo) throws Exception;
	public String insertFreeBoardReplyInfo(FreeBoardVO freeboardInfo) throws Exception;
	public void updateHitFreeboard(String bo_no) throws Exception;

}
