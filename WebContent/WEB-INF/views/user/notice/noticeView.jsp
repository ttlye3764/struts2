<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="nt_no" value="${noticeInfo.nt_no }"></c:set>


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
    $('#nt_content').summernote({
			height: 150,
			codemirror: {
			theme: 'monokai'			
		}
    });

});
</script>
</head>
<body>
<form name ="freeboardView" class="form-horizontal" role="form" action="" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="nt_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" disabled ="disabled" id="nt_title" name="nt_title" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="nt_nickname">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" disabled="disabled" id="nt_nickname" name="nt_nickname" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="nt_pwd">패스워드:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" disabled="disabled" id="nt_pwd" name="nt_pwd" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="nt_mail">메일:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" disabled="disabled" id="nt_mail" name="nt_mail" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="nt_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="nt_content"></div>
		</div>
	</div>
	<c:if test="${!empty noticeInfo.items }">
	<div class="form-group">
		<label class="control-label col-sm-2" for="nt_content">첨부파일:</label>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
			</ol>
	
			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox" style="height: 200px;">
				 <c:forEach items="${noticeInfo.items }" var="fileItemInfo" varStatus="stat">
					<c:if test="${stat.first }">
						<div class ="item active">
					</c:if>
					<c:if test="${stat.last }">
						<div class ="item">
					</c:if>
						<img src="/files/${fileItemInfo.nt_save_name}" onclick="javascript:location.href='/user/notice/noticeFileDown.do?nt_seq=${noticeInfo.nt_seq }'">
					</div>
				</c:forEach> 
					
			<%-- 	<div class ="item active">
					<img src="/files/${file_Info.bo_save_name}" onclick="javascript:location.href='/freeboard/freeboardFileDownload.do?bo_seq=${freeboardInfo.bo_seq }'">
				</div> --%>
				
			</div>
			<!-- Left and right controls -->
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
		</div>
	</div>
	</c:if>>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<!-- <button type="button" class="btn btn-success" id ="btn1">글쓰기</button> -->
			 <!-- <button type="button" class="btn btn-danger" id = "btn2">삭제</button>  -->
			<!-- <button type="button" class="btn btn-primary" id = "btn3">답글</button> -->
			<button type="button" class="btn btn-info" id = "btn4">목록</button>
			<!-- <button type="submit" class="btn btn-default" style="float: right" >수정</button> -->
		</div>
	</div>
</form>
</body>
<script type ="text/javascript">

	$(function(){
		
		$('#nt_title').val('${noticeInfo.nt_title}');
		
		$('#nt_nickname').val('${noticeInfo.nt_nickname}');
		
		$('#nt_pwd').val('${noticeInfo.nt_pwd}');
		
		$('#nt_mail').val('${noticeInfo.nt_mail}');
		
		$('#nt_content').summernote('code','${noticeInfo.nt_content}');
		
		$('#btn1').click(function(){
			
			$(location).attr('href', '/notice/noticeForm.do');
		});
			
		
		
		$('#btn3').click(function(){
			// /ddit/13/main.jsp?contentPage=/13/freeboard/freeboard
			if(eval('${!empty LOGIN_SOLDIERINFO}')){
				// bo_title 한글처리
				var nt_title = encodeURIComponent('${noticeInfo.nt_title}');
				var queryString = '?rnum=${param.rnum}&nt_title='+nt_title;
				var parentInfo = '&nt_group=${noticeInfo.nt_group}&nt_seq=${noticeInfo.nt_seq}&nt_depth=${noticeInfo.nt_depth}';
				$(location).attr('href', '/user/notice/noticeInsertReply.do'+ queryString + parentInfo);	
			}else{
				BootstrapDialog.show({
				       title : '알림',
				       message : '어딜 ㅎㅎ 로그인 안하면 안되용 ㅎㅎ'
				    });
				return false;
			}
		});
		
		$('#btn4').click(function(){
			
			$(location).attr('href', '/user/notice.do');
		});
		
		
		
		$('#btn2').click(function(){
			var flag = true;
			if(eval('${!empty LOGIN_SOLDIERINFO}')){ // 로그인 되어져야하고
				if('${LOGIN_SOLDIERINFO.sol_num}'== '${noticeInfo.nt_writer}'){ // 해당게시글 작성자여야 하고
					$(location).attr('href', '/user/notice/noticeDelete.do?nt_no=${noticeInfo.nt_no}');		
				}else{
					BootstrapDialog.show({
					       title : '알림',
					       message : '안되용 ㅎㅎ'
					    });
					return false;
				}
			}else{
				BootstrapDialog.show({
				       title : '알림',
				       message : '안되용 ㅎㅎ'
				    });
				return false;
			}

		});
		
		
		$('form[name=freeboardView]').submit(function(){

			if(eval('${!empty LOGIN_SOLDIERINFO}')){
				if('${LOGIN_SOLDIERINFO.sol_num}'== '${noticeInfo.nt_writer}'){
					
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
					
					var nt_content = $('#nt_content').summernote('code');
					$(this).append('<input type="hidden" name ="nt_no" value="${nt_no}"/>');
					$(this).append('<input type ="hidden" name="nt_content" value="'+nt_content+'"/>');
					$(this).append('<input type ="hidden" name="nt_ip" value="${pageContext.request.remoteAddr}"/>');
					$(this).attr('action', '/user/notice/noticeUpdate.do');
					
					return true;
					
				}else{
					BootstrapDialog.show({
					       title : '알림',
					       message : '안되용 ㅎㅎ'
					    });
					return false;
				}
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