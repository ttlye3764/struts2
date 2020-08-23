package kr.or.ddit.soldier.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.SoldierVO;

import com.ibatis.sqlmap.client.SqlMapClient;

public class SoldierDaoImpl implements ISoldierDao{
	private static ISoldierDao dao;	
	private SqlMapClient smc;

	public static ISoldierDao getInstance(){
		if(dao == null){
			dao = new SoldierDaoImpl();
		}
		return dao;
	}
	
	public SoldierDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}	
	

	@Override
	public SoldierVO soldierInfo(Map<String, String> params) throws Exception {
		return (SoldierVO) smc.queryForObject("soldier.soldierInfo", params);
	}

	@Override
	public List<SoldierVO> soldierList(Map<String, String> params) throws Exception {
		return smc.queryForList("soldier.soldierList",params);
	}

	@Override
	public void deleteSoldierInfo(Map<String, String> params) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSoldierInfo(SoldierVO soldierInfo) throws Exception {
		smc.update("soldier.updateSoldierInfo", soldierInfo);		
	}

	@Override
	public void insertSoldier(SoldierVO soldierInfo) throws Exception {		
		smc.insert("soldier.insertSoldier", soldierInfo);		
	}

	@Override
	public String totalCount(Map<String, String> params) throws Exception {
		return (String)smc.queryForObject("soldier.totalCount", params);
	}

	@Override
	public String soldierNum() throws Exception {		
		return (String) smc.queryForObject("soldier.soldierNum");
	}

}
