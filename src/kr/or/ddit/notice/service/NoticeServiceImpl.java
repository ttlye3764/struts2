package kr.or.ddit.notice.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.nfileitem.dao.INFileItemDao;
import kr.or.ddit.nfileitem.dao.NFileItemDaoImpl;
import kr.or.ddit.notice.dao.INoticeDao;
import kr.or.ddit.notice.dao.NoticeDaoImpl;
import kr.or.ddit.utiles.NoticeFileMapper;
import kr.or.ddit.vo.NoticeBoardVO;
import kr.or.ddit.vo.NoticeFileItemVO;

import org.apache.commons.fileupload.FileItem;

public class NoticeServiceImpl implements INoticeService{
	
	private static INoticeService service;
	
	private INoticeDao dao;
	
	private INFileItemDao fileItemDao = NFileItemDaoImpl.getInstance();
	
	private NoticeServiceImpl() {
		dao = NoticeDaoImpl.getInstance();
	}
	public static INoticeService getInstance(){
		if(service == null){
			service = new NoticeServiceImpl();
		}
		return service;
	}
	

	@Override
	public List<NoticeBoardVO> noticeList(Map<String, String> params) {
		List<NoticeBoardVO> noticeList = null;
		try{
			noticeList = dao.noticeList(params);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return noticeList;
	}

	@Override
	public String insertNoticeboardInfo(NoticeBoardVO noticeInfo,
			FileItem[] items) {
		String nt_no = null;
		try{
			nt_no = dao.insertNoticeboardInfo(noticeInfo, items);
			List<NoticeFileItemVO> noticeFileItemList = NoticeFileMapper.mapper(items, nt_no);
			fileItemDao.insertFileItem(noticeFileItemList);
		}catch (Exception e){
			e.printStackTrace();
		}
		return nt_no;
	}

	@Override
	public NoticeBoardVO noticeInfo(Map<String, String> params) {
		NoticeBoardVO noticeboardInfo = null;
		try{
			noticeboardInfo = dao.noticeInfo(params);
		}catch (Exception e){
			e.printStackTrace();
		}
		return noticeboardInfo;
	}

	@Override
	public void deleteNoticeboard(Map<String, String> params) {
		try{
			dao.deleteNoticeboard(params);
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateNoticeboard(NoticeBoardVO noticeInfo) {
		try{
			dao.updateNoticeboard(noticeInfo);
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount ="";
		try{
			totalCount = dao.totalCount(params);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return totalCount;
	}

}
