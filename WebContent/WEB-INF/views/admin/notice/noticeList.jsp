<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="noticeList" value="${noticeList}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자유게시판 리스트</title>
<script type="text/javascript">
$(function(){
	$('#noticeForm').click(function(){
		if(eval('${!empty LOGIN_SOLDIERINFO}')){
			$(location).attr('href', '/admin/notice/noticeForm.do');
		}else{
			alert('로그인해주세용');	
		}
	});
	$('#freeboardTBY tr').click(function(){
		var nt_no = $(this).find('td:eq(0)').text();
		var rnum = $(this).find('td:eq(0)').text();
		$(location).attr('href', '/admin/notice/noticeView.do?nt_no='+nt_no+'&rnum='+rnum);
	});
});
	
     $(function(){
      $('.pull-right button:eq(0)').click(function(){
         const search_keycode = $("select[name=search_keycode] option:selected").val();
         const search_keyword = $("#search_keyword").val();
         $('#NTForm').submit();
         
         
         
      });
   });  
</script> 
</head>
<body>
<div class="wrap">
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180">
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<div id="container">
					<div class="title">공지사항</div>
					<table border="0" cellspacing="1" cellpadding="1">
						<thead>
							<tr>
							  <th width="5%">번호</th>
							  <th width="60%">제목</th>
							  <th>작성자</th>
							  <th>작성일</th>
							  <th>조회수</th>
							</tr>
						</thead>
						<tbody id ="freeboardTBY">	
						<c:forEach var="noticeInfo" items="${noticeList }">	
				<tr align="center">
					<td colspan="5"><font color="red"></font></td>
				</tr>		
				<tr>
					<td align="left">
								<i class="fa fa-angle-right"></i>
						${noticeInfo.nt_no}</td>
               		<td>${noticeInfo.nt_title}</td>
               		<td>${noticeInfo.nt_writer}</td>
               		<td>${noticeInfo.nt_reg_date}</td>
               		<td>${noticeInfo.nt_hit}</td>
				</tr>
				</c:forEach>
			</tbody>
					</table>
				<form id="NTForm" action="/admin/notice.do" method="post" class="form-inline pull-right">
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
 					<div style="text-align:right; margin-top: 5px;"> 
 						<input class="btn2" type="submit" value="등록" id="noticeForm"/> 
					</div> 
				</div>
			</td>
		</tr>
	</table>
	${pagination.getPagingHtmls()}
</div>
</body>

</html>