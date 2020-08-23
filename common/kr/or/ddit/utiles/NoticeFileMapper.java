package kr.or.ddit.utiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.NoticeFileItemVO;




public class NoticeFileMapper {
	public static List<NoticeFileItemVO> mapper(FileItem[] items,
											String nt_no){
		List<NoticeFileItemVO> NoticeFileItemList = new ArrayList<NoticeFileItemVO>();
		if(items != null){
			NoticeFileItemVO NoticeFileItemInfo = null;
			for(FileItem item : items){
				NoticeFileItemInfo  = new NoticeFileItemVO();
				NoticeFileItemInfo.setNt_bo_no(nt_no);
				
				// 파일명 취득
				// 브라우저별 d:\\temp\\image\\a.png
				//		or a.png
				// a.png 반환
				String fileName = FilenameUtils.getName(item.getName());
				NoticeFileItemInfo.setNt_name(fileName);
				
				//파일 실제 저장소 : D:\\temp\\files
				// 저장용 파일명을 별도로 작성
				// a.png => a
				String baseName = FilenameUtils.getBaseName(fileName);
				// a.png => png
				String extension = FilenameUtils.getExtension(fileName);
				// -----------------유니크한 랜덤값 -------------
				// UUID(Univerally unique Identifier) : 128bit 유일값 생성("-" 포함)
				String genID = UUID.randomUUID().toString().replace("-", "");
				
				// a12341245135135135135871938571923847325.png
				String saveFileName = baseName + genID + "." + extension;
				
				NoticeFileItemInfo.setNt_save_name(saveFileName);
				
				NoticeFileItemInfo.setNt_content_type(item.getContentType());
				NoticeFileItemInfo.setNt_size(String.valueOf(item.getSize()));
				
				NoticeFileItemList.add(NoticeFileItemInfo);
				
				saveFile(saveFileName, item);
			}
		}
		return NoticeFileItemList;
	}

	private static void saveFile(String saveFileName, FileItem item) {
		
		File saveFile = new File(GlobalConstant.FILE_PATH, saveFileName);
		
		try {
			item.write(saveFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
