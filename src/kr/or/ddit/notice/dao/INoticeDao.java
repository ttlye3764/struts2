package kr.or.ddit.notice.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.NoticeBoardVO;

import org.apache.commons.fileupload.FileItem;

public interface INoticeDao {
	public List<NoticeBoardVO> noticeList(Map<String, String> params) throws Exception;
	public String insertNoticeboardInfo(NoticeBoardVO noticeInfo, FileItem[] items) throws Exception;
	public NoticeBoardVO noticeInfo(Map<String, String> params) throws Exception;
	public void deleteNoticeboard(Map<String, String> params) throws Exception;
	public void updateNoticeboard(NoticeBoardVO noticeInfo) throws Exception;
	public String totalCount(Map<String, String> params) throws Exception;

}
