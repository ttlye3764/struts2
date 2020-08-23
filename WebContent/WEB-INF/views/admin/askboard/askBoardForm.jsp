<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 수정</title>
</head>
<body>
<div class="wrap">
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><jsp:include page="askBoardMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<div id="container">
					<div class="title">자주 묻는 질문</div>
					<table border="0" cellspacing="1" cellpadding="1">
						<tr>
						  <th>제목</th>
						  <td><input type="text" class="ask_title"></td>
						</tr>
						<tr>
						  <th>작성자</th>
						  <td><input type="text" class="ask_writer"></td>
						</tr>
						<tr>
						  <th>내용</th>
						  <td><textarea rows="10" cols="110" class="ask_content" style="overflow: auto;"></textarea> </td>
						</tr>
						<tr>
						  <th>IP Addr.</th>
						  <td><input type="text" class="ask_ip" value="${pageContext.request.remoteAddr}"></td>
						</tr>
					</table>
					<table border="0" cellspacing="0" cellpadding="0">
					  <tr></tr>
					</table>
					<div style="text-align:right">
						<button class="btn2" type="submit" id = "btn1">등록</button> 
						<button class="btn2" type="button" id = "btn2">취소</button> 
					</div>
				</div>
			</td>
		</tr>
	</table>
</div>	
</body>
<script type ="text/javascript">
	$(function(){
		$('#btn1').click(function(){
			var aa = '?ask_title='+$('.ask_title').val() + '&ask_writer=${LOGIN_SOLDIERINFO.sol_num}'+'&ask_content='+$('.ask_content').val()+'&ask_ip=${pageContext.request.remoteAddr}';
			$(location).attr('href','/admin/insertAskBoardInfo.do'+aa);
		});
		$('#btn2').click(function(){
			$(loaction).attr('href', '/admin/askBoardList.do');
		});
	});
</script>
</html>