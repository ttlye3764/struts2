<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/imageboard.css">
<head>
<title>Insert title here</title>
</head>
<style>
#imgimg{
   width:200px;
    height:150px;
    }
</style>
<body>
<jsp:include page="imageBoardMenu.jsp"></jsp:include>
<div class="container">
    <div class="well well-sm">
        <strong>Display</strong>
        <div class="btn-group">
        
            <a href="#" id="list" class="btn btn-default btn-sm"><span>
            </span>List</a> <a href="#" id="grid" class="btn btn-default btn-sm"><span></span>Grid</a>
        </div>
    </div>
    <div id="products" class="row list-group">
    <c:if test="${!empty imageBoardList }">
    <c:forEach items="${imageBoardList }"  var="imageBoardInfo">
        	<div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
                <img id ="imgimg" class="group list-group-image" src="/files/${imageBoardInfo.items[0].img_save_name}" alt="사진이 없습니다." />
                <div class="caption" id ="clickDiv">
                    <h4 class="group inner list-group-item-heading">
                        ${imageBoardInfo.img_title }</h4>
                    <p class="group inner list-group-item-text">
                        ${imageBoardInfo.img_content}</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">
                              	작성자 : ${imageBoardInfo.img_writer }</p>
                        </div><br/><br/>
                        <div class="col-xs-12 col-md-6">
                        	<input type="hidden" id="imgNo" value="${imageBoardInfo.img_no}" />
                        	<input type="hidden" id="imgRnum" value="${imageBoardInfo.rnum}" />
                            <a class="btn btn-success" id = "clickBtn" href="/admin/imageboardView.do?img_no=${imageBoardInfo.img_no }&img_rnum=${imageBoardInfo.rnum }">글 보기</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
    </c:if>
       <c:if test="${empty imageBoardList }">
       	게시글이없어여
       </c:if>
    </div>
</div>
<div>
<form action="/admin/imageboardList.do" method="post" class="form-inline pull-right">
		<input id="search_keyword" name="search_keyword" type="text" placeholder="검색어 입력..." class="form-control" />
		<select class="form-control" name="search_keycode" >
			<option>검색조건</option>
			<option value="TOTAL">전체</option>
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
			<option value="NICKNAME">작성자</option>
		</select>
	    <button type="submit" class="btn btn-primary form-control">검색</button>
	    <button type="button" class="btn btn-info form-control" id ="imageBoardForm">게시글 등록</button>
</form>
</div>	<br/><br/>
${pagination.getPagingHtmls()}

</body>
<script type ="text/javascript">
$(function(){
	 $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
	    $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');});
	    
	    $('#imageBoardForm').click(function(){
			if(eval('${!empty LOGIN_SOLDIERINFO}')){
				$(location).attr('href', '/admin/imageboardForm.do');
			}else{
				alert('로그인해주세용');	
			}
		});
})
</script>
</html>