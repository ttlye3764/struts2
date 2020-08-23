package kr.or.ddit.imageboard.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ImageBoardVO;


public interface IImageBoardDao {
	public List<ImageBoardVO> imageBoardList(Map<String, String> params) throws Exception;
	public ImageBoardVO imageBoardInfo(Map<String, String> params) throws Exception;
	public void deleteImageBoard(Map<String, String> params) throws Exception;
	public void updateImageBoard(ImageBoardVO imageBoardInfo) throws Exception;
	public String insertImageBoardReplyInfo(ImageBoardVO imageBoardInfo) throws Exception;
	public String totalCount(Map<String, String> params) throws Exception;
	public String insertImageBoardInfo(ImageBoardVO ImageBoardInfo) throws Exception;
	public void updateImageReplyInfo(ImageBoardVO ImageBoardInfo) throws Exception;	
}
