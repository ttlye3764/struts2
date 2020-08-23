package kr.or.ddit.imageboard.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ImageBoardVO;

import org.apache.commons.fileupload.FileItem;

public interface IImageBoardService {
	public List<ImageBoardVO> imageBoardList(Map<String, String> params);
	public ImageBoardVO imageBoardInfo(Map<String, String> params);
	public void deleteImageBoard(Map<String, String> params);
	public void updateImageBoard(ImageBoardVO imageBoardInfo);
	public String insertImageBoardReplyInfo(ImageBoardVO imageBoardInfo,  FileItem[] items);
	public String totalCount(Map<String, String> params);
	public String insertImageBoardInfo(ImageBoardVO imageBoardInfo,  FileItem[] items);
	public void updateImageReplyInfo(ImageBoardVO imageBoardInfo);	
}
