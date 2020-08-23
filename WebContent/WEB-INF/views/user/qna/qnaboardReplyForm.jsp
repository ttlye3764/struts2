<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:url var = "mainURI" value="/13/main.jsp"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 댓글등록</title>
<script>
$(function(){
	// 섬머노트를 div를 활용한 textarea에 추가.
	// http://summernote.org 활용
    $('#qa_content').summernote({
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
    
    $('form[name=freeboardReplyForm]').submit(function(){
		
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
    		
    		var qa_content = $('#qa_content').summernote('code');
    		
    		$(this).append('<input type ="hidden" name="qa_content" value="'+qa_content+'"/>');
    		$(this).append('<input type ="hidden" name="qa_writer" value="${LOGIN_SOLDIERINFO.sol_num}"/>');
    		$(this).append('<input type ="hidden" name="qa_ip" value="${pageContext.request.remoteAddr}"/>');
    		$(this).append('<input type ="hidden" name="qa_group" value="${qa_group}"/>');
    		$(this).append('<input type ="hidden" name="qa_seq" value="${qa_seq}"/>');
    		$(this).append('<input type ="hidden" name="qa_depth" value="${qa_depth}"/>');
    		$(this).attr('action', '/qna/qnaInsertReply.do');
    		
    		return true;
    	});
    
    $('#btn1').click(function(){
    	$(location).attr('href', '${mainURI}');
    });
});
function alertPrint(msg){
	BootstrapDialog.show({
		title : '알림',
		message : msg
	});
	return false;
}
</script>
</head>
<body>
<div class="row">
	 <div class="col-sm-3">
		 <label class="col-sm-2 control-label">No :</label>
  		 <p class="form-control-static">${param.rnum }</p>
	 </div>
	 <div class="col-sm-8">
	 	<label class="col-sm-2 control-label">제목 :</label>
    	<p class="form-control-static">${qa_title} </p>
	 </div>
	 <div class="col-sm-1">
	 	<p class="text-right text-danger bg-danger">${LOGIN_SOLDIERINFO.sol_name }의 댓글</p>
	 </div>
</div>
<hr />
<form class="form-horizontal" role="form" action="" method="post" name ="freeboardReplyForm">
	<div class="form-group">
		<label class="control-label col-sm-2" for="qa_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="qa_title" name="qa_title" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="qa_nickname">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="qa_nickname" name="qa_nickname" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="qa_pwd">패스워드:</label>
		<div class="col-sm-10"> 
			<input type="password" class="form-control" id="qa_pwd" name="qa_pwd" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="qa_mail">메일:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="qa_mail" name="qa_mail" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="qa_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="qa_content"><p></p></div>
		</div>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-success" style="float: right;">댓글등록</button>
			<button type="button" class="btn btn-danger" id ="btn2">취소</button>
			<button type="button" class="btn btn-info" id = "btn3">목록</button>
		</div>
	</div>
</form>
</body>
</html>