package kr.or.ddit.freeboard.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.taglibs.standard.lang.jstl.test.beans.Factory;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.freeboard.service.FreeBoardServiceImpl;
import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.FreeBoardFileItemVO;
import kr.or.ddit.vo.FreeBoardVO;

public class FreeBoardDaoImpl implements IFreeBoardDao {
	private SqlMapClient smc;
	private static IFreeBoardDao instance;
	
	private FreeBoardDaoImpl(){
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IFreeBoardDao getInstance(){
		if(instance==null){
			instance = new FreeBoardDaoImpl();
		}
		return instance;
	}
	
	@Override
	public List<FreeBoardVO> freeboardList(Map<String, String> params)
			throws Exception {
		System.out.println("dao: "+params);
		return smc.queryForList("freeboard.freeboardList",params);
	}


	@Override
	public String totalCount(Map<String, String> params) throws Exception {
		return (String) smc.queryForObject("freeboard.totalCount",params);
	}

	@Override
	public String insertFreeBoardInfo(FreeBoardVO freeboardInfo) throws Exception {
		return (String) smc.insert("freeboard.insertFreeboardInfo",freeboardInfo);
		
	}

	@Override
	public FreeBoardVO freeboardInfo(Map<String, String> params)
			throws Exception {
		return (FreeBoardVO) smc.queryForObject("freeboard.freeboardInfo",params);
	}

	@Override
	public void updateFreeboard(FreeBoardVO freeboardInfo) throws Exception {
		smc.update("freeboard.updateFreeboard",freeboardInfo);
	}

	@Override
	public void deleteFreeBoard(String bo_no) throws Exception {
		smc.delete("freeboard.deleteFreeBoard",bo_no);
		
	}

	@Override
	public String insertFreeBoardReplyInfo(FreeBoardVO freeboardInfo)
			throws Exception {
		String bo_no="";
		try{
		smc.startTransaction();
			String bo_seq;
			// 내부모가 루트글인지 그냥 댓글인지에 따라 처리가 달라짐
			if("0".intern() == freeboardInfo.getBo_seq().intern()){ // 부모가 루트일때
				bo_seq = (String) smc.queryForObject("freeboard.incrementSeq", freeboardInfo);
			}else{// 부모가 댓글일때
				smc.update("freeboard.updateSeq", freeboardInfo); 
				
				bo_seq = String.valueOf(Integer.parseInt(freeboardInfo.getBo_seq())+1);
			}
			freeboardInfo.setBo_seq(bo_seq);
			
			String bo_depth = String.valueOf(Integer.parseInt(freeboardInfo.getBo_depth())+1);
			freeboardInfo.setBo_depth(bo_depth);
			
			bo_no = (String)smc.insert("freeboard.insertFreeBoardReplyInfo", freeboardInfo);
			smc.commitTransaction();
		}finally{
			smc.endTransaction();
		}
		
		return bo_no;
			
	}

	@Override
	public void updateHitFreeboard(String bo_no) throws Exception {
		smc.update("freeboard.updateHitFreeboard",bo_no);
	}

}	
