package kr.or.ddit.notice.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.NoticeBoardVO;

public interface INoticeService {
	public List<NoticeBoardVO> noticeList(Map<String, String> params);
	public String insertNoticeboardInfo(NoticeBoardVO noticeInfo, FileItem[] items);
	public NoticeBoardVO noticeInfo(Map<String, String> params);
	public void deleteNoticeboard(Map<String, String> params);
	public void updateNoticeboard(NoticeBoardVO noticeInfo);
	public String totalCount(Map<String, String> params);
	

}
