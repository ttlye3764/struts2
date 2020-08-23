package kr.or.ddit.imageboard.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.ImageBoardVO;

public class ImageBoardDaoImpl implements IImageBoardDao{
	
	private static IImageBoardDao dao;
	private SqlMapClient smc;
	
	private ImageBoardDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IImageBoardDao getInstance(){
		if(dao == null){
			dao = new ImageBoardDaoImpl();
		}
		return dao;
	}
	

	@Override
	public List<ImageBoardVO> imageBoardList(Map<String, String> params) throws Exception {
		return smc.queryForList("imageBoard.imageBoardList", params);
	}

	@Override
	public ImageBoardVO imageBoardInfo(Map<String, String> params) throws Exception {
		return (ImageBoardVO) smc.queryForObject("imageBoard.imageBoardInfo",params);
	}

	@Override
	public void deleteImageBoard(Map<String, String> params) throws Exception {
		smc.delete("imageBoard.deleteImageBoard", params);
		
	}

	@Override
	public void updateImageBoard(ImageBoardVO imageBoardInfo) throws Exception {
		smc.update("imageBoard.updateImageBoard", imageBoardInfo);
		
	}

	@Override
	public String insertImageBoardReplyInfo(ImageBoardVO imageBoardInfo) throws Exception {

		String img_no="";
		
		try{
			smc.startTransaction();
			
			String img_seq;
			
			// 내부모가 루트글인지 그냥 댓글인지에 따라 처리가 달라짐
			if("0".intern() == imageBoardInfo.getImg_seq().intern()){ // 부모가 루트일때
				img_seq = (String) smc.queryForObject("imageBoard.incrementSeq", imageBoardInfo);
			}else{// 부모가 댓글일때
				smc.update("imageBoard.updateSeq", imageBoardInfo); 
				
				img_seq = String.valueOf(Integer.parseInt(imageBoardInfo.getImg_seq())+1);
			}
			imageBoardInfo.setImg_seq(img_seq);
			
			String img_depth = String.valueOf(Integer.parseInt(imageBoardInfo.getImg_depth())+1);
			imageBoardInfo.setImg_depth(img_depth);
			
			img_no = (String)smc.insert("imageBoard.insertImageBoardReply", imageBoardInfo);
			smc.commitTransaction();
		}finally{
			smc.endTransaction();
		}
		
		return img_no;
	}

	@Override
	public String totalCount(Map<String, String> params) throws Exception {
		return (String)smc.queryForObject("imageBoard.totalCount", params);

	}

	@Override
	public String insertImageBoardInfo(ImageBoardVO ImageBoardInfo) throws Exception {
		return (String)smc.insert("imageBoard.insertImageBoardInfo", ImageBoardInfo);
	}

	@Override
	public void updateImageReplyInfo(ImageBoardVO ImageBoardInfo) throws Exception {
		smc.update("imageBoard.updateImageBoard", ImageBoardInfo);
		
	}

}
