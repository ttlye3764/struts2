<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 댓글등록</title>
<script>
$(function(){
	// 섬머노트를 div를 활용한 textarea에 추가.
	// http://summernote.org 활용
    $('#bo_content').summernote({
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
    
    $('#btn3').on('click', function() {
    	$(location).attr('href', '/freeboardList.do');
	});

    
    var bo_group = ${param.bo_group};
	var bo_seq = ${param.bo_seq};
	var bo_depth = ${param.bo_depth};
	
	$('form[name=freeBoardForm]').submit(function(){

		var bo_content = $('#bo_content').summernote('code');
		alert(bo_content);

		$(this).append('<input type ="hidden" name="bo_content" value="'+bo_content+'"/>');
		$(this).append('<input type ="hidden" name="bo_writer" value="${LOGIN_SOLDIERINFO.sol_num}"/>');
		$(this).append('<input type ="hidden" name="bo_ip" value="${pageContext.request.remoteAddr}"/>');
		$(this).append('<input type ="hidden" name="bo_group" value="'+bo_group+'"/>');
		$(this).append('<input type ="hidden" name="bo_seq" value="'+bo_seq+'"/>');
		$(this).append('<input type ="hidden" name="bo_depth" value="'+bo_depth+'"/>');
		$(this).attr('action', '/freeboard/insertfreeboardReplyForm.do');
		
		return true;
		});
});
</script>
</head>
<body>
<div class="row">
	 <div class="col-sm-3">
		 <label class="col-sm-2 control-label">No :</label>
  		 <p class="form-control-static">${param.rnum}</p>
	 </div>
	 <div class="col-sm-8">
	 	<label class="col-sm-2 control-label">제목 :</label>
    	<p class="form-control-static">${param.bo_title }</p>
	 </div>
	 <div class="col-sm-1">
	 	<p class="text-right text-danger bg-danger">${LOGIN_SOLDIERINFO.sol_name }의 댓글</p>
	 </div>
</div>
<hr />
<form name="freeBoardForm" class="form-horizontal" role="form" action="" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="bo_title" name="bo_title" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_nickname">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="bo_nickname" name="bo_nickname" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_pwd">패스워드:</label>
		<div class="col-sm-10"> 
			<input type="password" class="form-control" id="bo_pwd" name="bo_pwd" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_mail">메일:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="bo_mail" name="bo_mail" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="bo_content"><p></p></div>
		</div>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button id="btn1" type="submit" class="btn btn-success" style="float: right;">답글등록</button>
			<button id="btn2" type="reset" class="btn btn-danger">취소</button>
			<button id="btn3" type="button" class="btn btn-info">목록</button>
		</div>
	</div>
</form>
</body>

</html>