<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<div class="row">
	 <div class="col-sm-3">
		 <label class="col-sm-2 control-label">No :</label>
  		 <p class="form-control-static">${param.rnum }</p>
	 </div>
	 <div class="col-sm-8">
	 	<label class="col-sm-2 control-label">제목 :</label>
    	<p class="form-control-static">${db_title} </p>
	 </div>
	 <div class="col-sm-1">
	 	<p class="text-right text-danger bg-danger">${LOGIN_SOLDIERINFO.sol_name }의 댓글</p>
	 </div>
</div>

					<table border="0" cellspacing="1" cellpadding="1">		
						<tr>
						  <th>제목</th>
						  <td><input type="text" id="db_title" name="db_title"></td>
						</tr>
						<tr>
						  <th>작성자</th>
						  <td><label class="bo_writer"><input type="text" id="db_title" name="db_writer" value="${LOGIN_SOLDIERINFO.sol_num}"></label></td>
						</tr>
						<tr>
						  <th>내용</th>
						  <td><textarea rows="10" cols="110" class="bo_content" style="overflow: auto;" id="db_content"></textarea> </td>
						</tr>
						<tr>
						  <th>IP Addr.</th>
						  <td><label class="bo_ip">${pageContext.request.remoteAddr}</label></td>
						</tr>
					</table>
					<div style="text-align:right">
						<button class="btn2" type="button" id="btn1" >등록</button>
						<button class="btn2" type="button" id="btn2" >목록</button>
					</div>
				</div>
			</td>
		</tr>
	</table>
	
	
</div>
</body>
<script type ="text/javascript">
$(function(){
	
	
	$('#btn2').click(function(){
		
		$(location).attr('href', '/admin/dataBoardList.do');
	});
	
	$('btn1').click(function(){
		
	});
	
$('#btn1').click(function(){
	
	var db_content = $('#db_content').val();
	var db_title = $('#db_title').val();
	
	 var $frm = $('<form action="/admin/dataInsertReply.do" method="post"></form>');
     var $inputCONTENT = $('<input type ="hidden" name="db_content" value="'+db_content+'"/>');
     var $inputWRITER = $('<input type ="hidden" name="db_writer" value="${LOGIN_SOLDIERINFO.sol_num}"/>');
     var $inputIP = $('<input type ="hidden" name="db_ip" value="${pageContext.request.remoteAddr}"/>');
     var $inputGROUP = $('<input type ="hidden" name="db_group" value="${db_group}"/>');
     var $inputSEQ = $('<input type ="hidden" name="db_seq" value="${db_seq}"/>');
     var $inputDEPTH = $('<input type ="hidden" name="db_depth" value="${db_depth}"/>');
     var $inputTITLE = $('<input type ="hidden" name="db_title" value="'+db_title+'"/>');
     
     $frm.append($inputCONTENT);
     $frm.append($inputWRITER);
     $frm.append($inputSEQ);
     $frm.append($inputDEPTH);
     $frm.append($inputTITLE);
     $frm.append($inputGROUP);
     
     
     
     $(document.body).append($frm);
     $frm.submit();
		
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
})
</script>
</html>