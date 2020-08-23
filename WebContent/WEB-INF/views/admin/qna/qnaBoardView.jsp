<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 보기</title>
</head>
<body>
<div class="wrap">
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><jsp:include page="qnaBoardMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<div id="container">
					<div class="title">Q&A</div>
					<table border="0" cellspacing="1" cellpadding="1">
						<tr>
						  <th>제목</th>
						  <td>
						  	<c:if test="${qnaBoardInfo.qa_depth.intern() == '0'.intern() }">	  	  
						  	<label class="bo_title" >${qnaBoardInfo.qa_title}</label>
						  </c:if>
						  	<c:if test="${qnaBoardInfo.qa_depth.intern() != '0'.intern() }">	  	  
						  	<label class="bo_title" ><input type ="text" id="qa_title" name="qa_title" value="${qnaBoardInfo.qa_title}"></label>
						  </c:if>
						  </td>
						</tr>
						<tr>
						  <th>작성자</th>
						  <td><label class="bo_writer">${qnaBoardInfo.qa_writer}</label></td>
						</tr>
						<tr>
						  <th>내용</th>
						  <c:if test="${qnaBoardInfo.qa_depth.intern() == '0'.intern() }">	  
						  <td><textarea rows="10" cols="110" class="bo_content" disabled="disabled" style="overflow: auto;">${qnaBoardInfo.qa_content }</textarea> </td>
						</c:if>
						<c:if test="${qnaBoardInfo.qa_depth.intern() != '0'.intern() }">	  
						  <td><textarea rows="10" cols="110" class="bo_content" id="qa_content" style="overflow: auto;">${qnaBoardInfo.qa_content }</textarea> </td>
						</c:if>
						</tr>
						<tr>
						  <th>IP Addr.</th>
						  <td><label class="bo_ip">${qnaBoardInfo.qa_ip}</label></td>
						</tr>
					</table>
					<div class="form-group">
		<label class="control-label col-sm-2" for="qa_content">첨부파일:</label>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
			</ol>
	
			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox" style="height: 200px;">
			
			<c:forEach items="${qnaBoardInfo.items }" var="fileItemInfo" varStatus="stat">
				<c:if test="${stat.first }">
					<div class ="item active">
				</c:if>
				<c:if test="${stat.last }">
					<div class ="item">
				</c:if>
					
					<img src="/files/${fileItemInfo.qa_save_name}" onclick="javascript:location.href='/qna/qnaFileDown.do?qa_seq=${fileItemInfo.qa_seq }'">
				</div>
			</c:forEach>
		
				
			</div>
			<!-- Left and right controls -->
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
		</div>
					
					<div style="text-align:right">
					 <c:if test="${qnaBoardInfo.qa_depth.intern() == '0'.intern() }">
					 	  <input class="btn2" type="button" id="btn1" value="답글"/> 
					 	  	<input class="btn2" type="submit" id="btn2" value="목록"/>
					 </c:if>
					 <c:if test="${qnaBoardInfo.qa_depth.intern() != '0'.intern() }">	  
						 <button class="btn2" type="button" id="btn3">수정</button> 
						<input class="btn2" type="button" id="btn4" value="삭제"/> 
						<input class="btn2" type="submit" id="btn5" value="목록"/>
						</c:if>
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
		// /ddit/13/main.jsp?contentPage=/13/freeboard/freeboard
		if(eval('${!empty LOGIN_SOLDIERINFO}')){
			// bo_title 한글처리
			var qa_title = encodeURIComponent('${qnaBoardInfo.qa_title}');
			var queryString = '?rnum=${param.rnum}&qa_title='+qa_title;
			var parentInfo = '&qa_group=${qnaBoardInfo.qa_group}&qa_seq=${qnaBoardInfo.qa_seq}&qa_depth=${qnaBoardInfo.qa_depth}';
			$(location).attr('href', '/admin/qnaBoardReplyForm.do'+ queryString + parentInfo);	
		}else{
			BootstrapDialog.show({
			       title : '알림',
			       message : '어딜 ㅎㅎ 로그인 안하면 안되용 ㅎㅎ'
			    });
			return false;
		}
	});
	
	$('#btn3').click(function(){
		
		var flag = true;
		if(eval('${!empty LOGIN_SOLDIERINFO}')){ // 로그인 되어져야하고
			if('${LOGIN_SOLDIERINFO.sol_num}'== '100'){ // 해당게시글 작성자여야 하고
				
				var qa_content = $('#qa_content').val();
				var qa_title = $('#qa_title').val();
				var qa_no = $('${param.qa_no}');
				
				 var $frm = $('<form action="/admin/qnaUpdateReply.do" method="post"></form>');
			     var $inputCONTENT = $('<input type ="hidden" name="qa_content" value="'+qa_content+'"/>');
			     var $inputWRITER = $('<input type ="hidden" name="qa_writer" value="${LOGIN_SOLDIERINFO.sol_num}"/>');
			     var $inputIP = $('<input type ="hidden" name="qa_ip" value="${pageContext.request.remoteAddr}"/>');
			     var $inputTITLE = $('<input type ="hidden" name="qa_title" value="'+qa_title+'"/>');
			     var $inputQANO = $('<input type ="hidden" name="qa_no" value="${param.qa_no}"/>');
			     $frm.append($inputCONTENT);
			     $frm.append($inputWRITER);
			     $frm.append($inputQANO);
			     $frm.append($inputTITLE);
			     $frm.append($inputIP);
			     
			     
			     
			     $(document.body).append($frm);
			     $frm.submit();	
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
	
			
	    	/* 	
	    		if(!$('#bo_title').val().validationTITLE()){
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
	    		
	    		return true;
	    	});
	
	$('#btn2').click(function(){
		
		$(location).attr('href', '/admin/qnaBoardList.do');
	});
	
	
	$('#btn4').click(function(){
		
		$(location).attr('href', '/admin/qnaBoardList.do');
	});
})
</script>
</html>