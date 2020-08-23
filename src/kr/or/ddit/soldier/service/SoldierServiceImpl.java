package kr.or.ddit.soldier.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.soldier.dao.ISoldierDao;
import kr.or.ddit.soldier.dao.SoldierDaoImpl;
import kr.or.ddit.vo.SoldierVO;

public class SoldierServiceImpl implements ISoldierService {
	private static ISoldierService service;
	private ISoldierDao dao;

	public static ISoldierService getInstance() {
		if (service == null) {
			service = new SoldierServiceImpl();
		}
		return service;
	}

	private SoldierServiceImpl() {
		dao = SoldierDaoImpl.getInstance();
	}

	@Override
	public SoldierVO soldierInfo(Map<String, String> params) {
		SoldierVO soldierInfo = null;		
		try {
			soldierInfo = dao.soldierInfo(params);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return soldierInfo;
	}

	@Override
	public List<SoldierVO> soldierList(Map<String, String> params) {
		List<SoldierVO> soldierList = null;
		try{
			soldierList = dao.soldierList(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return soldierList;
	}

	@Override
	public void deleteSoldierInfo(Map<String, String> params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSoldierInfo(SoldierVO soldierInfo) {
		try{
			dao.updateSoldierInfo(soldierInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void insertSoldier(SoldierVO soldierInfo) {		
		try{
			dao.insertSoldier(soldierInfo);
		}catch(Exception e){
			e.printStackTrace();
		}		
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
	public String soldierNum() {
		String solnum = null;
			try {
				solnum = dao.soldierNum();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return solnum;
	}
	

}
