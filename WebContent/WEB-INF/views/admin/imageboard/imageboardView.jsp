<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="img_no" value="${imageBoardInfo.img_no }"></c:set>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 정보</title>
<!-- 이미지 슬라이드 사이즈 조정 -->
<style type="text/css">
.carousel{
	width:200px;
    height:150px;
    margin-left: 200px;
}
.carousel-inner > .item > img{
    width:200px;
    height:150px;
}       
</style>
<script>
$(function(){
	// 섬머노트를 div를 활용한 textarea에 추가.
	// http://summernote.org 활용
    $('#img_content').summernote({
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
});
</script>
</head>
<body>
<form name ="imageboardView" class="form-horizontal" role="form" action="" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="img_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="img_title" name="img_title" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="img_nickname">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="img_nickname" name="img_nickname" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="img_pwd">패스워드:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="img_pwd" name="img_pwd" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="img_mail">메일:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="img_mail" name="img_mail" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="img_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="img_content"></div>
		</div>
	</div>
	<c:if test="${!empty imageBoardInfo.items }">
	<div class="form-group">
		<label class="control-label col-sm-2" for="img_content">첨부파일:</label>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
			</ol>
	
			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox" style="height: 200px;">	
			<c:forEach items="${imageBoardInfo.items }" var="fileItemInfo" varStatus="stat">
				<c:if test="${stat.first }">
					<div class ="item active">
				</c:if>
				<c:if test="${stat.last }">
					<div class ="item">
				</c:if>
					
					<img src="/files/${fileItemInfo.img_save_name}" onclick="javascript:location.href='/user/imageFileDown.do?qa_seq=${fileItemInfo.img_seq }'">
				</div>
			</c:forEach>
		
				
			</div>
			<!-- Left and right controls -->
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
		</div>
	</div>
	</c:if>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button type="button" class="btn btn-success" id ="btn1">글쓰기</button>
			<button type="button" class="btn btn-danger" id = "btn2">삭제</button>
			<button type="button" class="btn btn-info" id = "btn4">목록</button>
			<button type="submit" class="btn btn-default" style="float: right" >수정</button>
		</div>
	</div>
</form>
</body>
<script type ="text/javascript">

	$(function(){
		
		$('#img_title').val('${imageBoardInfo.img_title}');
		
		$('#img_nickname').val('${imageBoardInfo.img_nickname}');
		
		$('#img_pwd').val('${imageBoardInfo.img_pwd}');
		
		$('#img_mail').val('${imageBoardInfo.img_mail}');
		
		$('#img_content').summernote('code','${imageBoardInfo.img_content}');
		
		
		
		// 글쓰기
		$('#btn1').click(function(){
			$(location).attr('href', '/admin/imageboardForm.do');
		});
		
		//삭제
		$('#btn2').click(function(){
			var flag = true;
			if(eval('${!empty LOGIN_SOLDIERINFO}')){ // 로그인 되어져야하고
				
					$(location).attr('href', '/admin/imageboardDelete.do?img_no=${imageBoardInfo.img_no}');		
				
			}else{
				BootstrapDialog.show({
				       title : '알림',
				       message : '안되용 ㅎㅎ'
				    });
				return false;
			}

		});
			
		
		//목록
		$('#btn4').click(function(){
			
			$(location).attr('href', '/admin/imageboardList.do');
		});
		
		
		// 수정
		$('form[name=imageboardView]').submit(function(){

			if(eval('${!empty LOGIN_SOLDIERINFO}')){
				
					
					/* if(!$('#bo_title').val().validationTITLE()){
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
					
					var img_content = $('#img_content').summernote('code');
					$(this).append('<input type="hidden" name ="img_no" value="${img_no}"/>');
					$(this).append('<input type ="hidden" name="img_content" value="'+img_content+'"/>');
					$(this).append('<input type ="hidden" name="img_ip" value="${pageContext.request.remoteAddr}"/>');
					$(this).attr('action', '/admin/imageboardUpdate.do');
					
					return true;
				
			}else{
				BootstrapDialog.show({
				       title : '알림',
				       message : '안되용 ㅎㅎ'
				    });
				return false;
			}
			
		});
		
	});
</script>
</html>