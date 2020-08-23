package kr.or.ddit.databoard.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.databoard.dao.DataBoardDaoImpl;
import kr.or.ddit.databoard.dao.IDataBoardDao;
import kr.or.ddit.fileitem.dao.DataFileItemDaoImpl;
import kr.or.ddit.fileitem.dao.IDataFileItemDao;
import kr.or.ddit.utiles.AttachFileMapper;
import kr.or.ddit.vo.DataBoardVO;
import kr.or.ddit.vo.DataFileItemVO;

import org.apache.commons.fileupload.FileItem;

public class DataBoardServiceImpl implements IDataBoardService{
	private static IDataBoardService service;	
	private IDataBoardDao dao;
	private IDataFileItemDao DatafileItemDao = DataFileItemDaoImpl.getInstance();
	
	private DataBoardServiceImpl() {
		dao = DataBoardDaoImpl.getInstance();
	}
	
	public static  IDataBoardService getInstance(){
		if(service ==null){
			service = new DataBoardServiceImpl();
		}
		return service;
	}

	@Override
	public List<DataBoardVO> dataList(Map<String, String> params) {
		List<DataBoardVO> dataList = null;
		try{
			dataList = dao.dataList(params);					
		}catch(Exception e){
			e.printStackTrace();
		}
		return dataList;
	}

	@Override
	public DataBoardVO dataInfo(Map<String, String> params) {
		DataBoardVO dataBoardInfo = null;
		try{
			dataBoardInfo = dao.dataInfo(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return dataBoardInfo;
	}

	@Override
	public void deleteDataBoard(Map<String, String> params) {
		try {
			dao.deleteDataBoard(params);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

	@Override
	public void updateDataBoard(DataBoardVO dataBoardInfo) {
		try{
			dao.updateDataBoard(dataBoardInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public String insertDataBoardReplyInfo(DataBoardVO dataBoardInfo) {
		String db_no =null;
		try{
			db_no = dao.insertDataBoardReplyInfo(dataBoardInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return db_no;
	}

	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount ="";
		try{
			totalCount = dao.totalCount(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return totalCount;
	}

	@Override
	public String insertDataBoardInfo(DataBoardVO dataBoardInfo, FileItem[] items) {
		String db_no = null;
		try{
			db_no = dao.insertDataBoardInfo(dataBoardInfo);
			List<DataFileItemVO> datafileItemList = AttachFileMapper.mapper1(items, db_no);
			DatafileItemDao.insertDataFileItem(datafileItemList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return db_no;
	}

	@Override
	public void adminupdateDataBoard(DataBoardVO dataBoardInfo) {
		try{
			dao.adminupdateDataBoard(dataBoardInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
