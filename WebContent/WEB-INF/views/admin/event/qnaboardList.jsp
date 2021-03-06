<%@page import="kr.or.ddit.vo.QnaBoardVO"%>
<%@page import="kr.or.ddit.qna.service.QnaServiceImpl"%>
<%@page import="kr.or.ddit.qna.service.IQnaService"%>
<%@page import="kr.or.ddit.utiles.RolePaginationUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- c:set하면 pageScope에 저장 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 목록</title>

</head>
<body>
<div id="freeboardList_content">
	<div class="panel panel-blue">
    	<div class="panel-heading">게시판 목록</div>
		<table class="table table-bordered table-hover" >
			<thead>
				<tr>
					<th scope="col" width="5%">No</th>
					<th scope="col" width="65%">제목</th>
					<th scope="col" width="10%">작성자</th>
					<th scope="col" width="10%">작성일</th>
					<th scope="col" width="10%">조회수</th>
				</tr>
			</thead>
			<tbody id ="freeboardTBY">
			<c:if test="${empty requestScope.QnaBoardList }">
				<tr align="center">
					<td colspan="5"><font color="red">게시물이 없습니다</font></td>
				</tr>
			</c:if>
			<c:if test="${!empty QnaBoardList}">
			<c:forEach items="${QnaBoardList}" var="qnaBoardInfo">
				<tr>
					<td><input type="hidden" value="${qnaBoardInfo.qa_no}" />${qnaBoardInfo.rnum }</td>
					<td align="left">
						<c:forEach begin="1" end="${qnaBoardInfo.qa_depth }" varStatus="stat">
							&nbsp;&nbsp;&nbsp;
							<c:if test="${stat.last}">
								<i class="fa fa-angle-right"></i>
							</c:if>
						</c:forEach>
						${qnaBoardInfo.qa_title}</td>
					<td>${qnaBoardInfo.qa_nickname }</td>
					<td>${qnaBoardInfo.qa_reg_date }</td>
					<td>${qnaBoardInfo.qa_hit }</td>
				</tr>
				</c:forEach>
				</c:if>
				
			</tbody>
		</table>
	</div>
</div>
${pagination.getPagingHtmls()}
<div>
<form action="/qna/qnaboardList.do" method="post" class="form-inline pull-right">
		<input id="search_keyword" name="search_keyword" type="text" placeholder="검색어 입력..." class="form-control" />
		<select class="form-control" name="search_keycode" >
			<option>검색조건</option>
			<option value="TOTAL">전체</option>
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
			<option value="NICKNAME">작성자</option>
		</select>
	    <button type="submit" class="btn btn-primary form-control">검색</button>
	    <button type="button" class="btn btn-info form-control" id ="qnaBoardForm">게시글 등록</button>
</form>
</div>	
</body>

<script type ="text/javascript">
	$(function(){
		$('#qnaBoardForm').click(function(){
			if(eval('${!empty LOGIN_SOLDIERINFO}')){
				$(location).attr('href', '/qna/qnaboardForm.do');
			}else{
				alert('로그인해주세용');	
			}
		});
		
		$('#freeboardTBY tr').click(function(){
			var qa_no = $(this).find('td:eq(0) input').val();
			var rnum = $(this).find('td:eq(0)').text();
			$(location).attr('href', '/qna/qnaboardView.do?qa_no='+qa_no+'&rnum='+rnum);
		});
	});
</script>


</html>