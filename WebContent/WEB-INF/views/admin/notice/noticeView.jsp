<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="nt_no" value="${noticeInfo.nt_no }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 보기</title>
<script>
$(function(){
	// 섬머노트를 div를 활용한 textarea에 추가.
	// http://summernote.org 활용
    $('#nt_content').summernote({
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
});
</script>
</head>
<body>
<div class="wrap">
<form name ="freeboardView" class="form-horizontal" role="form" action="" method="post">
	<table  width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180">
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<div id="container">
					<div class="title">공지사항</div>
					<table border="0" cellspacing="1" cellpadding="1">
						<tr>
						  <th>제목</th>
						  <td>
						  	<c:if test="${noticeInfo.nt_depth.intern() == '0'.intern() }">	  	  
						  	<label class="nt_title" >${noticeInfo.nt_title}</label>
						  </c:if>
						  	<c:if test="${noticeInfoInfo.nt_depth.intern() != '0'.intern() }">	  	  
						  	<label class="nt_title" ><input type ="text" id="nt_title" name="nt_title" value="${noticeInfo.nt_title}"></label>
						  </c:if>
						  </td>
						</tr>
						<tr>
						  <th>작성자</th>
						  <td><label class="nt_writer">${noticeInfo.nt_writer}</label></td>
						</tr>
						<tr>
						  <th>내용</th>
						  <c:if test="${noticeInfo.nt_depth.intern() == '0'.intern() }">	  
						  <td><textarea rows="10" cols="110" class="nt_content" disabled="disabled" style="overflow: auto;">${noticeInfo.nt_content }</textarea> </td>
						</c:if>
						<c:if test="${noticeInfo.nt_depth.intern() != '0'.intern() }">	  
						  <td><textarea rows="10" cols="110" class="nt_content" id="nt_content" style="overflow: auto;">${noticeInfo.nt_content }</textarea> </td>
						</c:if>
						</tr>
						<tr>
						  <th>IP Addr.</th>
						  <td><label class="nt_ip">${noticeInfo.nt_ip}</label></td>
						</tr>
					</table>
					
					<div style="text-align:right">
					 <c:if test="${noticeInfo.nt_depth.intern() == '0'.intern() }">
					 	  <!-- <input class="btn2" type="button" id="btn1" value="답글"/>  -->
					 	  	<input class="btn2" type="submit" id="btn2" value="목록"/>
					 </c:if>
					 <c:if test="${noticeInfo.nt_depth.intern() != '0'.intern() }">	  
						 <button class="btn2" type="button" id="btn1">글쓰기</button> 
						 <button class="btn2" type="button" id="btn2">삭제</button> 
						 <button class="btn2" type="button" id="btn3">목록</button> 
						 <button type="submit" class="btn btn-default" style="float: right" >수정</button>
						</c:if>
					</div>
				</div>
			</td>
		</tr>
	</table>
	</form>
</div>
</body>
<script type ="text/javascript">

	$(function(){
		
		$('#nt_title').val('${noticeInfo.nt_title}');
		
		/* $('#nt_nickname').val('${noticeInfo.nt_nickname}');
		
		$('#nt_pwd').val('${noticeInfo.nt_pwd}');
		
		$('#nt_mail').val('${noticeInfo.nt_mail}'); */
		
		$('#nt_content').summernote('code','${noticeInfo.nt_content}');
		
		$('#btn1').click(function(){
			
			$(location).attr('href', '/admin/notice/noticeForm.do');
		});
			
		
		
		$('#btn3').click(function(){
			// /ddit/13/main.jsp?contentPage=/13/freeboard/freeboard
			if(eval('${!empty LOGIN_SOLDIERINFO}')){
				// bo_title 한글처리
				var nt_title = encodeURIComponent('${noticeInfo.nt_title}');
				var queryString = '?rnum=${param.rnum}&nt_title='+nt_title;
				var parentInfo = '&nt_group=${noticeInfo.nt_group}&nt_seq=${noticeInfo.nt_seq}&nt_depth=${noticeInfo.nt_depth}';
				$(location).attr('href', '/admin/notice/noticeInsertReply.do'+ queryString + parentInfo);	
			}else{
				BootstrapDialog.show({
				       title : '알림',
				       message : '어딜 ㅎㅎ 로그인 안하면 안되용 ㅎㅎ'
				    });
				return false;
			}
		});
		
		$('#btn4').click(function(){
			
			$(location).attr('href', '/admin/notice.do');
		});
		
		
		
		$('#btn2').click(function(){
			var flag = true;
			if(eval('${!empty LOGIN_SOLDIERINFO}')){ // 로그인 되어져야하고
				if('${LOGIN_SOLDIERINFO.sol_num}'== '${noticeInfo.nt_writer}'){ // 해당게시글 작성자여야 하고
					$(location).attr('href', '/admin/notice/noticeDelete.do?nt_no=${noticeInfo.nt_no}');		
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

		});
		
		
		$('form[name=freeboardView]').submit(function(){

			if(eval('${!empty LOGIN_SOLDIERINFO}')){
				if('${LOGIN_SOLDIERINFO.sol_num}'== '${noticeInfo.nt_writer}'){
					
					/* if(!$('#bo_title').val().validationTITLE()){
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
					
					var nt_content = $('#nt_content').summernote('code');
					$(this).append('<input type="hidden" name ="nt_no" value="${nt_no}"/>');
					$(this).append('<input type ="hidden" name="nt_content" value="'+nt_content+'"/>');
					$(this).append('<input type ="hidden" name="nt_ip" value="${pageContext.request.remoteAddr}"/>');
					$(this).attr('action', '/admin/notice/noticeUpdate.do');
					
					return true;
					
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
			
		});
		
	});
</script>
</html>