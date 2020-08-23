<%@page import="kr.or.ddit.vo.DataBoardVO"%>
<%@page import="kr.or.ddit.databoard.service.DataBoardServiceImpl"%>
<%@page import="kr.or.ddit.databoard.service.IDataBoardService"%>
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
<title>자료실 목록</title>

</head>
<body>
<div id="databoardList_content">
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
			<tbody id ="databoardTBY">
			<c:if test="${empty DataBoardList}">
				<tr align="center">
					<td colspan="5"><font color="red">게시물이 없습니다</font></td>
				</tr>
			</c:if>
			<c:if test="${!empty DataBoardList}">
			<c:forEach items="${DataBoardList}" var="dataBoardInfo">
				<tr>
					<td><input type="hidden" value="${dataBoardInfo.db_no}" />${dataBoardInfo.rnum }</td>
					<td align="left">
						<c:forEach begin="1" end="${dataBoardInfo.db_depth }" varStatus="stat">
							&nbsp;&nbsp;&nbsp;
							<c:if test="${stat.last}">
								<i class="fa fa-angle-right"></i>
							</c:if>
						</c:forEach>
						${dataBoardInfo.db_title}</td>
					<td>${dataBoardInfo.db_nickname }</td>
					<td>${dataBoardInfo.db_reg_date }</td>
					<td>${dataBoardInfo.db_hit }</td>
				</tr>
				</c:forEach>
				</c:if>
				
			</tbody>
		</table>
	</div>
</div>
${pagination.getPagingHtmls()}
<div>
<form action="/data/databoardList.do" method="post" class="form-inline pull-right">
		<input id="search_keyword" name="search_keyword" type="text" placeholder="검색어 입력..." class="form-control" />
		<select class="form-control" name="search_keycode" >
			<option>검색조건</option>
			<option value="TOTAL">전체</option>
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
			<option value="NICKNAME">작성자</option>
		</select>
	    <button type="submit" class="btn btn-primary form-control">검색</button>
	    <button type="button" class="btn btn-info form-control" id ="dataBoardForm">게시글 등록</button>
</form>
</div>	
</body>

<script type ="text/javascript">
	$(function(){
		$('#dataBoardForm').click(function(){
			if(eval('${!empty LOGIN_SOLDIERINFO}')){
				$(location).attr('href', '/data/databoardForm.do');
			}else{
				alert('로그인해주세요');	
			}
		});
		
		$('#databoardTBY tr').click(function(){
			var bo_no = $(this).find('td:eq(0) input').val();
			var rnum = $(this).find('td:eq(0)').text();
			$(location).attr('href', '/data/databoardView.do?bo_no='+bo_no+'&rnum='+rnum);
		});
	});
</script>


</html>