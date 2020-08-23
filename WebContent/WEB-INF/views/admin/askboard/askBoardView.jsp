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
			<td width="180"><jsp:include page="askBoardMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<div id="container">
					<div class="title">Q&A</div>
					<table border="0" cellspacing="1" cellpadding="1">
						<tr>
						  <th>제목</th>
						  <td>
						  	<label class="ask_title" ><input type ="text" id="ask_title" name="ask_title" value="${askBoardInfo.ask_title}"></label>
						  </td>
						</tr>
						<tr>
						  <th>작성자</th>
						  <td><label class="ask_writer">${askBoardInfo.ask_writer}</label></td>
						</tr>
						<tr>
						  <th>내용</th>
						  <td><textarea rows="10" cols="110" class="ask_content" id="ask_content" style="overflow: auto;">${askBoardInfo.ask_content }</textarea> </td>
						</tr>
						<tr>
						  <th>IP Addr.</th>
						  <td><label class="ask_ip">${askBoardInfo.ask_ip}</label></td>
						</tr>
					</table>
					
					<div style="text-align:right">
						<button class="btn2" type="button" id="btn1">새 글쓰기</button>
						<button class="btn2" type="submit" id="btn2">수정</button> 
						<button class="btn2" type="button" id="btn3">삭제</button> 
						<button class="btn2" type="button" id="btn4">목록</button>
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
		
		$(location).attr('href', '/admin/askBoardForm.do');
	});
	
	$('#btn2').click(function(){
		var aa = '?ask_title='+$('#ask_title').val() + '&ask_writer=${LOGIN_SOLDIERINFO.sol_num}'+'&ask_content='+$('.ask_content').val()+'&ask_ip=${pageContext.request.remoteAddr}&ask_no=${param.ask_no}';
		$(location).attr('href','/admin/updateAskBoardInfo.do'+aa);
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
	
	
	
	
	$('#btn4').click(function(){
		
		$(location).attr('href', '/admin/askBoardList.do');
	});
})
</script>
</html>