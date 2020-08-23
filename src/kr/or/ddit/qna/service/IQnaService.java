package kr.or.ddit.qna.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.QnaBoardVO;

public interface IQnaService {
	public List<QnaBoardVO> qnaList(Map<String, String> params);
	public QnaBoardVO qnaInfo(Map<String, String> params);
	public void deleteQnaBoard(Map<String, String> params);
	public void updateQnaBoard(QnaBoardVO qnaBoardInfo);
	public String insertQnaBoardReplyInfo(QnaBoardVO qnaBoardInfo,  FileItem[] items);
	public String totalCount(Map<String, String> params);
	public String insertQnaBoardInfo(QnaBoardVO qnaBoardInfo,  FileItem[] items);
	public void updateQnaReplyInfo(QnaBoardVO qnaBoardInfo);	
}
