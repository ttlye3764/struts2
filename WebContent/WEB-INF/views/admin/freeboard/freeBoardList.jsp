<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자유게시판 리스트</title>
<script type="text/javascript">
$(function() {
	$('#freeboardTBY tr').click(function(){
		var bo_no = $(this).find('td:eq(0) input').val();
		alert(bo_no);
		var rnum = $(this).find('td:eq(0)').text();
		$(location).attr('href', '/admin/freeBoardView.do?bo_no='+bo_no+'&rnum='+rnum);
	});
	
})
</script>
</head>
<body>
<div class="wrap">
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><jsp:include page="freeBoardMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<div id="container">
					<div class="title">자유게시판</div>
					<table name= "freeboardTBY" border="0" cellspacing="1" cellpadding="1">
						<thead>
							<tr>
							  <th width="5%">번호</th>
							  <th width="60%">제목</th>
							  <th>작성자</th>
							  <th>작성일</th>
							</tr>
						</thead>
						<tbody id ="freeboardTBY">
									<c:if test="${empty requestScope.freeBoardList }">
				<tr align="center">
					<td colspan="5"><font color="red">게시물이 없습니다</font></td>
				</tr>
			</c:if>
			<c:if test="${!empty freeBoardList}">
			<c:forEach items="${freeBoardList}" var="freeBoardInfo">
				<tr>
					<td><input type="hidden" value="${freeBoardInfo.bo_no}" />${freeBoardInfo.rnum }</td>
					<td align="left">
						<c:forEach begin="1" end="${freeBoardInfo.bo_depth }" varStatus="stat">
							&nbsp;&nbsp;&nbsp;
							<c:if test="${stat.last}">
							└>
								<i class="fa fa-angle-right"></i>
							</c:if>
						</c:forEach>
						${freeBoardInfo.bo_title}</td>
					<td>${freeBoardInfo.bo_nickname }</td>
					<td>${freeBoardInfo.bo_reg_date }</td>
					<td>${freeBoardInfo.bo_hit }</td>
				</tr>
				</c:forEach>
				</c:if>
						
						</tbody>
					</table>
					<form action="/admin/freeBoardList.do" method="post" class="form-inline pull-right">
					<div style="text-align:right;">
						<select name="search_keycode" style="width:100px;">
							<option selected="selected" value="TITLE">제목</option>
							<option value="CONTENT">내용</option>
							<option value="NICKNAME">작성자</option>
						</select> 
						<input  name="search_keyword" type="text" id="uname" size="20" /> 
						<input class="btn1" type="submit" value="검색"/>
					</div>
					</form>	
<!-- 					<div style="text-align:right; margin-top: 5px;"> -->
<!-- 						<input class="btn2" type="submit" value="등록"/> -->
<!-- 					</div> -->
				</div>
			</td>
		</tr>
	</table>
		${pagination.getPagingHtmls()}
</div>
</body>
</html>