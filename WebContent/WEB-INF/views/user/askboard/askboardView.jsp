<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



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
    $('#bo_content').summernote({
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
    $('bo_content').summernote('disable');
});
</script>
</head>
<body>
<form name ="freeboardView" class="form-horizontal" role="form" action="" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="qa_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" disabled="disabled" class="form-control" id="ask_title" name="ask_title" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="ask_nickname">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" disabled="disabled class="form-control" id="ask_nickname" name="ask_nickname" >
		</div>
	</div>
	<!-- <div class="form-group">
		<label class="control-label col-sm-2" for="ask_pwd">패스워드:</label>
		<div class="col-sm-10"> 
			<input type="text" disabled="disabled class="form-control" id="ask_pwd" name="ask_pwd" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="ask_mail">메일:</label>
		<div class="col-sm-10"> 
			<input type="text" disabled="disabled class="form-control" id="ask_mail" name="ask_mail" >
		</div>
	</div> -->
	<div class="form-group">
		<label class="control-label col-sm-2" for="ask_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="ask_content"></div>
		</div>
	</div>

	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button type="button" class="btn btn-info" id = "btn1">목록</button>
		</div>
	</div>
</form>
</body>
<script type ="text/javascript">

	$(function(){
		
		$('#ask_title').val('${askBoardInfo.ask_title}');
		
		$('#ask_nickname').val('${askBoardInfo.ask_nickname}');
		/* 
		$('#ask_pwd').val('${askBoardInfo.ask_pwd}');
		
		$('#ask_mail').val('${askBoardInfo.ask_mail}');
		 */
		$('#ask_content').summernote('code','${askBoardInfo.ask_content}');
		$('#ask_content').summernote('disable');
		$('#btn1').click(function(){
			$(location).attr('href', '/user/askboardList.do');
		});
	});
</script>
</html>