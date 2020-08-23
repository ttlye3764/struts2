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
   
    $('#btn1').on('click', function() {
		$(location).attr('href', '/freeboard/deletefreeboard.do?bo_no=${freeboardInfo.bo_no}');
	})
    $('#btn2').on('click', function() {
    	if(eval('${!empty LOGIN_SOLDIERINFO}')){
			// bo_title 한글처리
			var bo_title = encodeURIComponent('${freeboardInfo.bo_title}');
			var queryString = '?rnum=${param.rnum}&bo_title='+bo_title;
			var parentInfo = '&bo_group=${freeboardInfo.bo_group}&bo_seq=${freeboardInfo.bo_seq}&bo_depth=${freeboardInfo.bo_depth}';
			$(location).attr('href', '/freeboard/freeboardReplyForm.do'+ queryString + parentInfo);	
		}else{
			BootstrapDialog.show({
			       title : '알림',
			       message : '어딜 ㅎㅎ 로그인 안하면 안되용 ㅎㅎ'
			    });
			return false;
		}

	})
    $('#btn3').on('click', function() {
 
		$(location).attr('href', '/freeboardList.do');
	})
	
	
	$('#bo_content').summernote('code','${freeboardInfo.bo_content}');
	
	$('#btn4').on('click', function() {
		var bo_content = $('#bo_content').summernote('code');
		
		$(this).append('<input type ="hidden" name="bo_content" value="'+bo_content+'"/>');
		$(this).append('<input type ="hidden" name="bo_writer" value="${LOGIN_SOLDIERINFO.sol_num}"/>');
		$(this).append('<input type ="hidden" name="bo_ip" value="${pageContext.request.remoteAddr}"/>');
		$(this).attr('action', '/freeboard/updatefreeboard.do' );
	});
});
</script>
</head>
<body>											 
<form class="form-horizontal" role="form" action="/freeboard/updatefreeboard.do?bo_no=${freeboardInfo.bo_no} " method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="bo_title" name="bo_title" value="${freeboardInfo.bo_title }">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_nickname">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="bo_nickname" name="bo_nickname" value="${freeboardInfo.bo_nickname }" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_pwd">패스워드:</label>
		<div class="col-sm-10"> 
			<input type="password" class="form-control" id="bo_pwd" name="bo_pwd"  value="${freeboardInfo.bo_pwd }">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_mail">메일:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="bo_mail" name="bo_mail" value="${freeboardInfo.bo_mail }" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_content" value="${freeboardInfo.bo_content  }">내용:</label>
		<div class="col-sm-10"> 
			<div id="bo_content"><p></p></div>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_content">첨부파일:</label>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox" style="height: 200px;">
				 <c:forEach items="${freeboardInfo.items }" var="fileItemInfo" varStatus="stat">
					<c:if test="${stat.first }">
						<div class ="item active">
					</c:if>
					<c:if test="${stat.last }">
						<div class ="item">
					</c:if>
						<img src="/files/${fileItemInfo.bo_save_name}" onclick="javascript:location.href='/freeboard/freeboardFileDownload.do?bo_seq=${freeboardInfo.bo_seq }'">
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
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button id="btn1" type="button" class="btn btn-danger">삭제</button>
			<button id="btn2" type="button" class="btn btn-primary">답글</button>
			<button id="btn3" type="button" class="btn btn-info">목록</button>
			<button id="btn4" type="submit" class="btn btn-default" style="float: right">수정</button>
		</div>
	</div>
</form>

</body>

	
</html>