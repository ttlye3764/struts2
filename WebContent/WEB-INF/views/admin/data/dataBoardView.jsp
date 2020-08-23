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
			<td width="180"><jsp:include page="dataBoardMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<div id="container">
					<div class="title">자료실</div>
					<table border="0" cellspacing="1" cellpadding="1">
						<tr>
						  <th>제목</th>
						  <td>						  	 	  
						  	<label class="bo_title" ><input type ="text" id="db_title" name="db_title" value="${dataBoardInfo.db_title}"></label>						 
						  </td>
						</tr>
						<tr>
						  <th>작성자</th>
						  <td><label class="bo_writer">${dataBoardInfo.db_writer}</label></td>
						</tr>
						<tr>
						  <th>내용</th>						 
						  <td><textarea rows="10" cols="110" class="bo_content" id="db_content" style="overflow: auto;">${dataBoardInfo.db_content }</textarea> </td>
						</tr>
						<tr>
						  <th>IP Addr.</th>
						  <td><label class="bo_ip">${dataBoardInfo.db_ip}</label></td>
						</tr>
					</table>
					
					<div style="text-align:right">					
						 <button class="btn2" type="button" id="btn3">수정</button> 
						<input class="btn2" type="button" id="btn4" value="삭제"/> 
						<input class="btn2" type="submit" id="btn5" value="목록"/>					
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
			var db_title = encodeURIComponent('${dataBoardInfo.db_title}');
			var queryString = '?rnum=${param.rnum}&db_title='+db_title;
			var parentInfo = '&db_group=${dataBoardInfo.db_group}&db_seq=${dataBoardInfo.db_seq}&db_depth=${dataBoardInfo.db_depth}';
			$(location).attr('href', '/admin/dataBoardReplyForm.do'+ queryString + parentInfo);	
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
				
				var db_content = $('#db_content').val();
				var db_title = $('#db_title').val();
				var db_no = $('${param.db_no}');
				
				 var $frm = $('<form action="/admin/dataUpdateReply.do" method="post"></form>');
			     var $inputCONTENT = $('<input type ="hidden" name="db_content" value="'+db_content+'"/>');
			     var $inputWRITER = $('<input type ="hidden" name="db_writer" value="${LOGIN_SOLDIERINFO.sol_num}"/>');
			     var $inputIP = $('<input type ="hidden" name="db_ip" value="${pageContext.request.remoteAddr}"/>');
			     var $inputTITLE = $('<input type ="hidden" name="db_title" value="'+db_title+'"/>');
			     var $inputQANO = $('<input type ="hidden" name="db_no" value="${param.db_no}"/>');
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
		
		$(location).attr('href', '/admin/dataBoardList.do');
	});
	
	$('#btn4').click(function(){
		var db_no = "${dataBoardInfo.db_no}";
		$(location).attr('href', '/admin/dataBoardDelete.do?db_no='+db_no);
	})
	
	
	$('#btn5').click(function(){
		
		$(location).attr('href', '/admin/dataBoardList.do');
	});
})
</script>
</html>