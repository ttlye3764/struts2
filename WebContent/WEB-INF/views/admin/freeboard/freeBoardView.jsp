<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 보기</title>
</head>
<script type="text/javascript">
	$(function() {
		$('#freeboardViewInfo').on('submit', function() {
			const bo_content = $('#bo_content1').val();
			const bo_nickname = $('input[name=bo_writer]').val();
		
			$(this).append('<input type ="hidden" name="bo_content" value="'+bo_content+'"/>');
			$(this).append('<input type ="hidden" name="bo_writer" value="${LOGIN_SOLDIERINFO.sol_num}"/>');
			$(this).append('<input type ="hidden" name="bo_nickname" value="' + bo_nickname + '"/>');
			$(this).append('<input type ="hidden" name="bo_ip" value="${pageContext.request.remoteAddr}"/>');
			$(this).append('<input type ="hidden" name="bo_no" value="${freeboardInfo.bo_no}"/>');
		});
		
		
		$('#btn2').on('click', function() {
			$(location).attr('href', '/admin/DeletefreeBoardView.do?bo_no=${freeboardInfo.bo_no}');
		})
		
		$('#btn3').on('click', function() {
			$(location).attr('href', '/admin/freeBoardList.do');
		})
	})
</script>
<body>
<div class="wrap">
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><jsp:include page="freeBoardMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<div id="container">
					<div class="title">자유게시판</div>
						<table border="0" cellspacing="1" cellpadding="1">
						<form id=freeboardViewInfo action="/admin/UpdatefreeBoardView.do">
							<div class="form-group">
							<tr>
							  <th>제목</th>
							  <td>
							  	<label class="bo_title" >
							  		<input type ="text" id="bo_title" name="bo_title" value="${freeboardInfo.bo_title}">
							  	</label>
							  </td>
							</tr>
							<tr>
							  <th>작성자</th>
							  <td>
								  <label class="bo_writer">
								  	<input type = "text" name = "bo_writer" value="${freeboardInfo.bo_writer}">
								  </label>
							  </td>
							</tr>
							<tr>
							  <th>내용</th>
							  <td>
							  	<textarea rows="10" cols="110" class="bo_content" id="bo_content1" style="overflow: auto;" >
${freeboardInfo.bo_content }
							  	</textarea>
						  	  </td>
							</tr>
							<tr>
							  <th>IP Addr.</th>
							  <td>
							  	<label class="bo_ip">
							  		<input type = "text" name = "bo_ip" value="${freeboardInfo.bo_ip}">
							  	</label></td>
							</tr>
							<tr>
								<th>
									<label class="control-label col-sm-2" for="bo_content">첨부파일:</label>
								</th>
								<td>
									<div id="myCarousel" class="carousel slide" data-ride="carousel" style="width: 500px; height: 300px">
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
									</div>
								<!-- Left and right controls -->
								<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
								<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
								</td>
							</tr>
							</div>
						</table>
						<div style="text-align:right">
							 <button class="btn2" type="submit" id="btn1" >수정</button> 
							<input class="btn2" type="button" id="btn2" value="삭제"/> 
							<input class="btn2" type="button" id="btn3" value="목록"/>
						</div>
							</form>
				</div>
			</td>
		</tr>
	</table>
</div>
</body>
</html>