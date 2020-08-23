<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="db_no" value="${dataBoardInfo.db_no }"></c:set>


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
});
</script>
</head>
<body>
<form name ="freeboardView" class="form-horizontal" role="form" action="" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="db_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="db_title" name="db_title" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="db_nickname">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="db_nickname" name="db_nickname" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="db_pwd">패스워드:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="db_pwd" name="db_pwd" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="db_mail">메일:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="db_mail" name="db_mail" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="db_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="db_content"></div>
		</div>
	</div>
	<c:if test="${!empty dataBoardInfo.items }">
	<div class="form-group">
		<label class="control-label col-sm-2" for="db_content">첨부파일:</label>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
			</ol>
	
			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox" style="height: 200px;">
			
			<c:forEach items="${dataBoardInfo.items }" var="fileItemInfo" varStatus="stat">
				<c:if test="${stat.first }">
					<div class ="item active">
				</c:if>
				<c:if test="${stat.last }">
					<div class ="item">
				</c:if>
					
					<img src="/files/${fileItemInfo.db_save_name}" onclick="javascript:location.href='/data/dataFileDownload.do?db_seq=${dataBoardInfo.db_seq }'">
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
			<button type="button" class="btn btn-primary" id = "btn3">답글</button>
			<button type="button" class="btn btn-info" id = "btn4">목록</button>
			<button type="submit" class="btn btn-default" style="float: right" >수정</button>
		</div>
	</div>
</form>
</body>
<script type ="text/javascript">

	$(function(){
		
		$('#db_title').val('${dataBoardInfo.db_title}');
		
		$('#db_nickname').val('${dataBoardInfo.db_nickname}');
		
		$('#db_pwd').val('${dataBoardInfo.db_pwd}');
		
		$('#db_mail').val('${dataBoardInfo.db_mail}');
		
		$('#db_content').summernote('code','${dataBoardInfo.db_content}');
		
		$('#btn1').click(function(){
			
			$(location).attr('href', '/data/databoardForm.do');
		});
			
		
		
		$('#btn3').click(function(){
			// /ddit/13/main.jsp?contentPage=/13/freeboard/freeboard
			if(eval('${!empty LOGIN_SOLDIERINFO}')){
				// bo_title 한글처리
				var db_title = encodeURIComponent('${dataBoardInfo.db_title}');
				var queryString = '?rnum=${param.rnum}&db_title='+db_title;
				var parentInfo = '&db_group=${dataBoardInfo.db_group}&db_seq=${dataBoardInfo.db_seq}&db_depth=${dataBoardInfo.db_depth}';
				$(location).attr('href', '/data/dataReplyForm.do'+ queryString + parentInfo);	
			}else{
				BootstrapDialog.show({
				       title : '알림',
				       message : '어딜 ㅎㅎ 로그인 안하면 안되용 ㅎㅎ'
				    });
				return false;
			}
		});
		
		$('#btn4').click(function(){
			
			$(location).attr('href', '/data/databoardList.do');
		});
		
		
		
		$('#btn2').click(function(){
			var flag = true;
			if(eval('${!empty LOGIN_SOLDIERINFO}')){ // 로그인 되어져야하고
				if('${LOGIN_SOLDIERINFO.sol_num}'== '${dataBoardInfo.db_writer}'){ // 해당게시글 작성자여야 하고
					$(location).attr('href', '/data/databoardDelete.do?db_no=${dataBoardInfo.db_no}');		
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
				if('${LOGIN_SOLDIERINFO.sol_num}'== '${dataBoardInfo.db_writer}'){
					
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
					
					var db_content = $('#db_content').summernote('code');
					$(this).append('<input type="hidden" name ="db_no" value="${db_no}"/>');
					$(this).append('<input type ="hidden" name="db_content" value="'+db_content+'"/>');
					$(this).append('<input type ="hidden" name="db_ip" value="${pageContext.request.remoteAddr}"/>');
					$(this).attr('action', '/data/dataUpdate.do');
					
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