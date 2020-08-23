package kr.or.ddit.soldier.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.SoldierVO;

public interface ISoldierService {
	public SoldierVO soldierInfo(Map<String, String> params);
	public List<SoldierVO> soldierList(Map<String, String> params);
	public void deleteSoldierInfo(Map<String, String> params);
	public void updateSoldierInfo(SoldierVO soldierInfo);
	public void insertSoldier(SoldierVO soldierInfo);
	public String totalCount(Map<String, String> params);
	public String soldierNum();
}
