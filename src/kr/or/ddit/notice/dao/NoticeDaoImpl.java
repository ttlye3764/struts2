package kr.or.ddit.notice.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.NoticeBoardVO;

import org.apache.commons.fileupload.FileItem;

import com.ibatis.sqlmap.client.SqlMapClient;

public class NoticeDaoImpl implements INoticeDao{
	
	private SqlMapClient smc;
	
	private static INoticeDao dao;
	
	private NoticeDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static INoticeDao getInstance(){
		if(dao == null) {
			dao = new NoticeDaoImpl();
		}
		return dao;
	}

	@Override
	public List<NoticeBoardVO> noticeList(Map<String, String> params)
			throws Exception {
		return smc.queryForList("notice.NoticeBoardList", params);
	}

	@Override
	public String insertNoticeboardInfo(NoticeBoardVO noticeInfo,
			FileItem[] items) throws Exception {
		return (String) smc.insert("notice.insertNoticeBoardInfo", noticeInfo);
	}

	@Override
	public NoticeBoardVO noticeInfo(Map<String, String> params)
			throws Exception {
		return (NoticeBoardVO) smc.queryForObject("notice.NoticeBoardInfo", params);
	}

	@Override
	public void deleteNoticeboard(Map<String, String> params) throws Exception {
		smc.update("notice.deleteNoticeBoard", params);
		
	}

	@Override
	public void updateNoticeboard(NoticeBoardVO noticeInfo) throws Exception {
		smc.update("notice.updateNoticeBoard", noticeInfo);
		
	}

	@Override
	public String totalCount(Map<String, String> params) throws Exception {
		return (String)smc.queryForObject("notice.totalCount", params);
	}

}
