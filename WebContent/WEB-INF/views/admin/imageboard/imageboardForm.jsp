<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 등록</title>
<script>
$(function(){
	// 섬머노트를 div를 활용한 textarea에 추가.
	// http://summernote.org 활용
    $('#img_content').summernote({
//     		lang: 'ko-KR',
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
    // 포커스 처리
    // $('#bo_content').summernote( {focus: true} );
    // 값 취득
    // $('#bo_content').summernote('code');
    // 값 추가
    // $('#bo_content').summernote('code', '<font color="red">추가글</font>');
    // 에디터 제거
    // $('#bo_content').summernote('destroy');
    
	/* BootstrapDialog.show({
	    title: '알럿창',
	    message: '알럿창으로 활용하세요!'
	});
	
	BootstrapDialog.show({
        message: '컨펌 다이얼로그로 활용하세요!',
        buttons: [{
            label: 'Button 1'
        }, {
            label: 'Button 2',
            cssClass: 'btn-primary',
            action: function(){
                alert('Hi Orange!');
            }
        }, {
            icon: 'glyphicon glyphicon-ban-circle',
            label: 'Button 3',
            cssClass: 'btn-warning'
        }, {
            label: 'Close',
            action: function(dialogItself){
                dialogItself.close();
            }
        }]
    }); */
	$('form[name=imageBoardForm]').submit(function(){
		
		var img_content = $('#img_content').summernote('code');
		 

		$(this).append('<input type ="hidden" name="img_content" value="'+img_content+'"/>');
		$(this).append('<input type ="hidden" name="img_writer" value="${LOGIN_SOLDIERINFO.sol_num}"/>');
		$(this).append('<input type ="hidden" name="img_ip" value="${pageContext.request.remoteAddr}"/>');
		$(this).attr('action', '/admin/imageInsertBoardInfo.do');
		
		return true;
	});
    
    $('#imageBoardMain').click(function(){
		$(location).attr('href', '/admin/imageboardList.do');
    });
});

function alertPrint(msg){
	BootstrapDialog.show({
		title: '알림',
		message : msg
	});
	return false;
}
</script>
</head>
<body>
<form name="imageBoardForm" class="form-horizontal" role="form" action="" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label class="control-label col-sm-2" for="img_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="img_title" name="img_title" placeholder="제목 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="img_nickname">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="img_nickname" name="img_nickname" placeholder="대화명 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="img_pwd">패스워드:</label>
		<div class="col-sm-10"> 
			<input type="password" class="form-control" id="img_pwd" name="img_pwd" placeholder="패스워드 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="img_mail">메일:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="img_mail" name="img_mail" placeholder="메일주소 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="img_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="img_content"><p>내용을 입력해주세요...</p></div>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="file01">첨부파일1:</label>
		<div class="col-sm-10">
			 <input type="file" class="filestyle" id="file01" name="files" data-buttonName="btn-primary">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="file02">첨부파일2:</label>
		<div class="col-sm-10">
			 <input type="file" class="filestyle" id="file02" name="files" data-buttonName="btn-primary">
		</div>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-info" style="float: right" >등록</button>
			<button type="button" class="btn btn-primary" style="float: right" id="imageBoardMain">취소</button>
		</div>
	</div>
</form>
</body>

</html>