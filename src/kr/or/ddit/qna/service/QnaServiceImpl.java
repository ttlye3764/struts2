package kr.or.ddit.qna.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.fileitem.dao.IQnaFileItemDao;
import kr.or.ddit.fileitem.dao.QnaFileItemDaoImpl;
import kr.or.ddit.qna.dao.IQnaDao;
import kr.or.ddit.qna.dao.QnaDaoImpl;
import kr.or.ddit.utiles.AttachFileMapper;
import kr.or.ddit.vo.QnaBoardVO;
import kr.or.ddit.vo.QnaFileItemVO;

import org.apache.commons.fileupload.FileItem;

public class QnaServiceImpl implements IQnaService {
	
	private static IQnaService service;
	private IQnaDao dao;
	private IQnaFileItemDao QnafileItemDao = QnaFileItemDaoImpl.getInstance();
	private QnaServiceImpl() {
		dao = QnaDaoImpl.getInstance();
	}
	
	public static IQnaService getInstance(){
		if(service ==null){
			service = new QnaServiceImpl();
		}
		return service;
	}
		
	@Override
	public List<QnaBoardVO> qnaList(Map<String, String> params) {
		List<QnaBoardVO> qnaList = null;
		try{
			qnaList = dao.qnaList(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return qnaList;
	}

	@Override
	public String insertQnaBoardInfo(QnaBoardVO qnaBoardInfo, FileItem[] items) {
		String qa_no =null;
		try{
			qa_no = dao.insertQnaBoardInfo(qnaBoardInfo);
			List<QnaFileItemVO> qnafileItemList = AttachFileMapper.mapper(items, qa_no);
			QnafileItemDao.insertQnaFileItem(qnafileItemList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return qa_no;
	}
	
	@Override
	public QnaBoardVO qnaInfo(Map<String, String> params) {
		QnaBoardVO qnaBoardInfo =null;
		try{
			qnaBoardInfo = dao.qnaInfo(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return qnaBoardInfo;
	}

	@Override
	public void deleteQnaBoard(Map<String, String> params) {
		try {
			dao.deleteQnaBoard(params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateQnaBoard(QnaBoardVO qnaBoardInfo) {
		try{
			dao.updateQnaBoard(qnaBoardInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public String insertQnaBoardReplyInfo(QnaBoardVO qnaBoardInfo,  FileItem[] items) {
		String qa_no =null;
		try{
			qa_no = dao.insertQnaBoardReplyInfo(qnaBoardInfo);
			List<QnaFileItemVO> qnafileItemList = AttachFileMapper.mapper(items, qa_no);
			QnafileItemDao.insertQnaFileItem(qnafileItemList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return qa_no;
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
	public void updateQnaReplyInfo(QnaBoardVO qnaBoardInfo) {
		try {
			dao.updateQnaReplyInfo(qnaBoardInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
