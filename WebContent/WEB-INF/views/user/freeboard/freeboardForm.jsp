<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 등록</title>

<script>
$(function(){
	$('#btn3').on('click', function() {
		$(location).attr('href', '/freeboardList.do');
	});
	$('#btn4').on('click', function() {
		$(location).attr('href', '/freeboard/freeboardReplyForm.do');
	});
	// 섬머노트를 div를 활용한 textarea에 추가.
	// http://summernote.org 활용
    $('#bo_content').summernote({
    		lang: 'ko-KR',
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
 
	$('form[name=freeBoardForm]').submit(function(){

	var bo_content = $('#bo_content').summernote('code');

	$(this).append('<input type ="hidden" name="bo_content" value="'+bo_content+'"/>');
	$(this).append('<input type ="hidden" name="bo_writer" value="${LOGIN_SOLDIERINFO.sol_num}"/>');
	$(this).append('<input type ="hidden" name="bo_ip" value="${pageContext.request.remoteAddr}"/>');
	$(this).attr('action', '/freeboard/insertfreeboard.do' );
	
	});
	return true;
});
</script>
</head>
<body>
<form  name="freeBoardForm" class="form-horizontal" role="form" action="/freeboard/insertfreeboard.do" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="bo_title" name="bo_title" placeholder="제목 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_nickname">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="bo_nickname" name="bo_nickname" placeholder="대화명 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_pwd">패스워드:</label>
		<div class="col-sm-10"> 
			<input type="password" class="form-control" id="bo_pwd" name="bo_pwd" placeholder="패스워드 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_mail">메일:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="bo_mail" name="bo_mail" placeholder="메일주소 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="bo_content"></div>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="file01">첨부파일1:</label>
		<div class="col-sm-10">
			 <input type="file" class="filestyle" id="files" name="files" data-buttonName="btn-primary">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="file02">첨부파일2:</label>
		<div class="col-sm-10">
			 <input type="file" class="filestyle" id="files" name="files" data-buttonName="btn-primary">
		</div>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button id="btn1" type="submit" class="btn btn-info" style="float: right">등록</button>
			<button id="btn2" type="reset" class="btn btn-danger" style="float: right">취소</button>
			<button id="btn3" type="button" class="btn btn-primary" style="float: right">목록</button>
			<button id="btn4" type="button" class="btn btn-primary" style="float: right">답글</button>
		</div>
	</div>
</form>
</body>
</html>