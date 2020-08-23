<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자유게시판 리스트</title>
</head>
<body>
<div class="wrap">
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><jsp:include page="dataBoardMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<div id="container">
					<div class="title">자료실</div>
					<table border="0" cellspacing="1" cellpadding="1">
						<thead>
							<tr>
							  <th width="5%">번호</th>
							  <th width="60%">제목</th>
							  <th>작성자</th>
							  <th>작성일</th>
							</tr>
						</thead>
						<tbody id ="freeboardTBY">
			<c:if test="${empty requestScope.DataBoardList }">
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
				<form action="/admin/dataBoardList.do" method="post" class="form-inline pull-right">
					<div style="text-align:right;">
						<select name="search_keycode" style="width:100px;">
							<option>검색조건</option>
							<option value="TOTAL">전체</option>
							<option value="TITLE">제목</option>
							<option value="CONTENT">내용</option>
							<option value="NICKNAME">작성자</option>
						</select> 
						<input id="search_keyword" name="search_keyword" type="text" placeholder="검색어 입력..." /> 
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

<script type ="text/javascript">
	$(function(){
		$('#dataBoardForm').click(function(){
			if(eval('${!empty LOGIN_SOLDIERINFO}')){
				$(location).attr('href', '/data/databoardForm.do');
			}else{
				alert('로그인해주세용');	
			}
		});
		
		$('#freeboardTBY tr').click(function(){
			var db_no = $(this).find('td:eq(0) input').val();
			var rnum = $(this).find('td:eq(0)').text();
			
			$(location).attr('href', '/admin/dataBoardView.do?db_no='+db_no+'&rnum='+rnum);					
		});
	});
</script>
</html>