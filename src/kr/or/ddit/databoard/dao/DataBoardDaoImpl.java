package kr.or.ddit.databoard.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.DataBoardVO;

import com.ibatis.sqlmap.client.SqlMapClient;

public class DataBoardDaoImpl implements IDataBoardDao {
	private SqlMapClient smc;
	private static IDataBoardDao dao;

	private DataBoardDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}

	public static IDataBoardDao getInstance() {
		if (dao == null) {
			dao = new DataBoardDaoImpl();
		}
		return dao;
	}

	@Override
	public List<DataBoardVO> dataList(Map<String, String> params)
			throws Exception {
		return smc.queryForList("data.dataList", params);
	}

	@Override
	public DataBoardVO dataInfo(Map<String, String> params) throws Exception {
		return (DataBoardVO) smc.queryForObject("data.dataBoardInfo", params);
	}

	@Override
	public void deleteDataBoard(Map<String, String> params) throws Exception {
		smc.update("data.deleteDataBoard", params);
	}

	@Override
	public void updateDataBoard(DataBoardVO dataBoardInfo) throws Exception {
		smc.update("data.updateDataBoard", dataBoardInfo);
	}

	@Override
	public String insertDataBoardReplyInfo(DataBoardVO dataBoardInfo)
			throws Exception {
		String db_no = "";

		try {
			smc.startTransaction();

			String db_seq;

			// 내부모가 루트글인지 그냥 댓글인지에 따라 처리가 달라짐
			if ("0".intern() == dataBoardInfo.getDb_seq().intern()) { // 부모가 루트일때
				db_seq = (String) smc.queryForObject("data.incrementSeq",
						dataBoardInfo);
			} else {// 부모가 댓글일때
				smc.update("data.updateSeq", dataBoardInfo);

				db_seq = String.valueOf(Integer.parseInt(dataBoardInfo
						.getDb_seq()) + 1);
			}
			dataBoardInfo.setDb_seq(db_seq);

			String qa_depth = String.valueOf(Integer.parseInt(dataBoardInfo
					.getDb_depth()) + 1);
			dataBoardInfo.setDb_depth(qa_depth);

			db_no = (String) smc.insert("data.insertDataBoardReply", dataBoardInfo);
			smc.commitTransaction();
		} finally {
			smc.endTransaction();
		}

		return db_no;
	}

	@Override
	public String totalCount(Map<String, String> params) throws Exception {
		return (String)smc.queryForObject("data.totalCount", params);
	}

	@Override
	public String insertDataBoardInfo(DataBoardVO dataBoardInfo)
			throws Exception {
		return (String) smc.insert("data.insertDataBoardInfo", dataBoardInfo);
	}

	@Override
	public void adminupdateDataBoard(DataBoardVO dataBoardInfo)
			throws Exception {
		smc.update("data.adminupdateDataBoard", dataBoardInfo);
	}

}
