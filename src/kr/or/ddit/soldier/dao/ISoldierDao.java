package kr.or.ddit.soldier.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.SoldierVO;

public interface ISoldierDao {
	public SoldierVO soldierInfo(Map<String, String> params) throws Exception;
	public List<SoldierVO> soldierList(Map<String, String> params)throws Exception;
	public void deleteSoldierInfo(Map<String, String> params)throws Exception;
	public void updateSoldierInfo(SoldierVO soldierInfo)throws Exception;
	public void insertSoldier(SoldierVO soldierInfo)throws Exception;
	public String totalCount(Map<String, String> params)throws Exception;
	public String soldierNum()throws Exception;
}
