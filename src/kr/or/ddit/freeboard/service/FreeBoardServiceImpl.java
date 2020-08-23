package kr.or.ddit.freeboard.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.freeboard.dao.FreeBoardDaoImpl;
import kr.or.ddit.freeboard.dao.IFreeBoardDao;
import kr.or.ddit.freeboardfileitem.dao.FreeBoardFileItemDaoImpl;
import kr.or.ddit.freeboardfileitem.dao.IFreeBoardFileItemDao;
import kr.or.ddit.utiles.AttachFileMapper;
import kr.or.ddit.vo.FreeBoardFileItemVO;
import kr.or.ddit.vo.FreeBoardVO;
import kr.or.ddit.vo.QnaFileItemVO;

public class FreeBoardServiceImpl implements IFreeBoardService {
	private IFreeBoardDao dao;
	private static FreeBoardServiceImpl instance;
	private IFreeBoardFileItemDao FreeBoardfileItemDao = FreeBoardFileItemDaoImpl.getInstance();
	private FreeBoardServiceImpl(){
		dao = FreeBoardDaoImpl.getInstance();
	}
	
	public static IFreeBoardService getInstace(){
		if(instance == null){
			instance = new FreeBoardServiceImpl();
		}
		return instance;
	}
	

	@Override
	public List<FreeBoardVO> freeBoardList(Map<String, String> params) {
		List<FreeBoardVO> list = null;
		try {
			System.out.println("service: "+params);
			list = dao.freeboardList(params);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
/*
	@Override
	public String insertFreeBoardInfo(FreeBoardVO soldierInfo) {
		String chk = null;
		try {
			chk = dao.insertFreeboardInfo(soldierInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public FreeBoardVO freeBoardInfo(Map<String, String> params) {
		FreeBoardVO soldier = null;
		try {
			soldier = dao.freeboardInfo(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soldier;
	}

	@Override
	public void deleteFreeboard(Map<String, String> params) {
		try {
			dao.deleteFreeboard(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateFreeboard(FreeBoardVO freeboardInfo) {
		try {
			dao.updateFreeboard(freeboardInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


*/
	@Override
	public String totalCount(Map<String, String> params) {
		String chk = null;
		try {
			chk = dao.totalCount(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public String insertFreeboardInfo(FreeBoardVO freeboardInfo, FileItem[] items) {
		String bo_no =null;
		try {
			bo_no = dao.insertFreeBoardInfo(freeboardInfo);
			List<FreeBoardFileItemVO> freeboardfileItemList = AttachFileMapper.mapper3(items, bo_no);
			FreeBoardfileItemDao.insertfreeboardFileItem(freeboardfileItemList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo_no;
	}

	@Override
	public FreeBoardVO freeboardInfo(Map<String, String> params) {
		FreeBoardVO vo = null;
		try {
			vo = dao.freeboardInfo(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;	}

	@Override
	public void updateFreeboard(FreeBoardVO freeboardInfo) {
		try {
			dao.updateFreeboard(freeboardInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteFreeBoard(String bo_no) {
		try {
			dao.deleteFreeBoard(bo_no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public String insertFreeBoardReplyInfo(FreeBoardVO freeboardInfo) {
		String chk = null;
		try {
			chk = dao.insertFreeBoardReplyInfo(freeboardInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public void updateHitFreeboard(String bo_no) {
		try {
			dao.updateHitFreeboard(bo_no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
