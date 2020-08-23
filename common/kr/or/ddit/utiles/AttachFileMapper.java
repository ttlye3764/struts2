package kr.or.ddit.utiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.DataFileItemVO;
import kr.or.ddit.vo.FreeBoardFileItemVO;
import kr.or.ddit.vo.ImageFileItemVO;
import kr.or.ddit.vo.QnaFileItemVO;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;

public class AttachFileMapper {
	public static List<QnaFileItemVO> mapper(FileItem[] items, String qa_no) {
		List<QnaFileItemVO> QnaFileItemList = new ArrayList<QnaFileItemVO>();
		if (items != null) {
			QnaFileItemVO QnaFileItemInfo = null;
			for (FileItem item : items) {
				QnaFileItemInfo = new QnaFileItemVO();
				QnaFileItemInfo.setQa_bo_no(qa_no);

				// 파일명 취득
				// 브라우저별 d:\\temp\\image\\a.png
				// or a.png
				// a.png 반환
				String fileName = FilenameUtils.getName(item.getName());
				QnaFileItemInfo.setQa_name(fileName);

				// 파일 실제 저장소 : D:\\temp\\files
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

				QnaFileItemInfo.setQa_save_name(saveFileName);

				QnaFileItemInfo.setQa_conteqa_type(item.getContentType());
				QnaFileItemInfo.setQa_size(String.valueOf(item.getSize()));

				QnaFileItemList.add(QnaFileItemInfo);

				saveFile(saveFileName, item);
			}
		}
		return QnaFileItemList;
	}
	
	public static List<FreeBoardFileItemVO> mapper3(FileItem[] items,
			
			String bo_no){
		
			List<FreeBoardFileItemVO> FreeBoardFileItemList = new ArrayList<FreeBoardFileItemVO>();
			if(items != null){
			FreeBoardFileItemVO FreeBoardFileItemInfo = null;
			for(FileItem item : items){
				FreeBoardFileItemInfo = new FreeBoardFileItemVO();
				FreeBoardFileItemInfo.setBo_bo_no(bo_no);
			
			// 파일명 취득
			// 브라우저별 d:\\temp\\image\\a.png
			//		or a.png
			// a.png 반환
			String fileName = FilenameUtils.getName(item.getName());
			FreeBoardFileItemInfo.setBo_name(fileName);
			
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
			
			FreeBoardFileItemInfo.setBo_save_name(saveFileName);
			
			FreeBoardFileItemInfo.setBo_content_type(item.getContentType());
			FreeBoardFileItemInfo.setBo_size(String.valueOf(item.getSize()));
			
			FreeBoardFileItemList.add(FreeBoardFileItemInfo);
			
			saveFile(saveFileName, item);
			}
		}
		return FreeBoardFileItemList;
	}

	public static List<DataFileItemVO> mapper1(FileItem[] items, String db_no) {
		List<DataFileItemVO> DataFileItemList = new ArrayList<DataFileItemVO>();
		if (items != null) {
			DataFileItemVO DataFileItemInfo = null;
			for (FileItem item : items) {
				DataFileItemInfo = new DataFileItemVO();
				DataFileItemInfo.setDb_bo_no(db_no);

				// 파일명 취득
				// 브라우저별 d:\\temp\\image\\a.png
				// or a.png
				// a.png 반환
				String fileName = FilenameUtils.getName(item.getName());
				DataFileItemInfo.setDb_name(fileName);

				// 파일 실제 저장소 : D:\\temp\\files
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

				DataFileItemInfo.setDb_save_name(saveFileName);

				DataFileItemInfo.setDb_content_type(item.getContentType());
				DataFileItemInfo.setDb_size(String.valueOf(item.getSize()));

				DataFileItemList.add(DataFileItemInfo);

				saveFile(saveFileName, item);
			}
		}
		return DataFileItemList;
	}

	private static void saveFile(String saveFileName, FileItem item) {
		
		File saveFile = new File(GlobalConstant.FILE_PATH, saveFileName);

		try {
			item.write(saveFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static List<ImageFileItemVO> mapperImage(FileItem[] items, String img_no) {
		List<ImageFileItemVO> imageFileItemList = new ArrayList<ImageFileItemVO>();
		if (items != null) {
			ImageFileItemVO imageFileItemInfo = null;
			for (FileItem item : items) {
				imageFileItemInfo = new ImageFileItemVO();
				imageFileItemInfo.setImg_bo_no(img_no);

				// 파일명 취득
				// 브라우저별 d:\\temp\\image\\a.png
				// or a.png
				// a.png 반환
				String fileName = FilenameUtils.getName(item.getName());
				imageFileItemInfo.setImg_name(fileName);

				// 파일 실제 저장소 : D:\\temp\\files
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

				imageFileItemInfo.setImg_save_name(saveFileName);

				imageFileItemInfo.setImg_content_type(item.getContentType());
				imageFileItemInfo.setImg_size(String.valueOf(item.getSize()));

				imageFileItemList.add(imageFileItemInfo);

				saveFile(saveFileName, item);
			}
		}
		return imageFileItemList;
	}
}
