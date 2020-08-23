<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="insertFreeboardURI" value ="/13/databoard/insertFreeboardInfo.jsp"></c:url>
<c:set var="databoardMainURI" value = "/ddit/13/main.jsp"></c:set>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 등록</title>
<script>
$(function(){
	// 섬머노트를 div를 활용한 textarea에 추가.
	// http://summernote.org 활용
    $('#db_content').summernote({
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
	$('form[name=dataBoardForm]').submit(function(){
		
	/* 	
		if(!$('#bo_title').val().validationTITLE()){
			alertPrint('제목 바르게');
		}
		if(!$('#bo_nickname').val().validatioNICKNAME()){
			alertPrint('닉네임 바르게');
		}
		if(!$('#bo_pwd').val().validatioPWD()){
			alertPrint('비밀번호 똑바로');
		}
		if(!$('#bo_mail').val().validatioMAIL()){
			alertPrint('이메일 똑바로');
		} */
		
		var db_content = $('#db_content').summernote('code');
		 

		$(this).append('<input type ="hidden" name="db_content" value="'+db_content+'"/>');
		$(this).append('<input type ="hidden" name="db_writer" value="${LOGIN_SOLDIERINFO.sol_num}"/>');
		$(this).append('<input type ="hidden" name="db_ip" value="${pageContext.request.remoteAddr}"/>');
		$(this).attr('action', '/data/dataInsertBoardInfo.do');
		
		return true;
	});
    
    $('#dataBoardMain').click(function(){
		$(location).attr('href', '/data/databoardList.do');
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
<form name = "dataBoardForm" class="form-horizontal" role="form" action="" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="db_title" name="db_title" placeholder="제목 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="db_nickname">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="db_nickname" name="db_nickname" placeholder="대화명 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="db_pwd">패스워드:</label>
		<div class="col-sm-10"> 
			<input type="password" class="form-control" id="db_pwd" name="db_pwd" placeholder="패스워드 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="db_mail">메일:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="db_mail" name="db_mail" placeholder="메일주소 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="db_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="db_content"><p>내용을 입력해주세요...</p></div>
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
			<button type="submit" class="btn btn-info" style="float: right" id = "dataBoardRegistBtn">등록</button>
			<button type="button" class="btn btn-danger" style="float: right">취소</button>
			<button type="button" class="btn btn-primary" style="float: right" id="dataBoardMain">목록</button>
		</div>
	</div>
</form>
</body>

</html>