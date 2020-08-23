<%@page import="kr.or.ddit.utiles.CryptoGenerator"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// 요청할 때마다 공개키, 비밀키가 새로 만들어짐                                                                              세션에 계속 갱신
	Map<String, String> publicKeyMap = CryptoGenerator.generatePairKey(session);
	//pageContext.setAttribute("publicKeyMap", publicKeyMap); 한거나 마찬가지?	
%>
<c:set var="publicKeyMap" value ="<%=publicKeyMap %>"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type = "text/javascript" src = "http://code.jquery.com/jquery-latest.js"></script>
<script type = "text/javascript" src ="${pageContext.request.contextPath}/js/common/validation.js "></script>
<script type='text/javascript' src="${pageContext.request.contextPath }/js/common/cookieControl.js"></script>
 <script type ="text/javascript" src ="${pageContext.request.contextPath }/js/crypto/jsbn.js"></script>
 <script type ="text/javascript" src ="${pageContext.request.contextPath }/js/crypto/rsa.js"></script>
 <script type ="text/javascript" src ="${pageContext.request.contextPath }/js/crypto/prng4.js"></script>
 <script type ="text/javascript" src ="${pageContext.request.contextPath }/js/crypto/rng.js"></script>
 <script type = "text/javascript" src ="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9/core.js"></script>
 <script type = "text/javascript" src ="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9/sha256.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css" type="text/css">
<title>회원관리 관리자 로그인</title>
</head>
<script type='text/javascript'>

$(function(){
	
	$('.loginBtn').click(function() {
			 	var sol_num = $('input[name=sol_num]').val();
				/* 	if (!mem_id.validationID()) {
							alert('아이디를 바르게 입력해주세요');
							return false;
						} */
						var sol_pass = $('input[name=sol_pass]').val();
						/* if (!mem_pass.validationPWD()) {
							alert('비밀번호를 바르게 입력해주세요');
							return false;
						} */
						
						 
						var modulus = '${publicKeyMap["publicModulus"]}';
						var exponent = '${publicKeyMap["publicExponent"]}';
						
						var rsaObject = new RSAKey();
						rsaObject.setPublic(modulus,exponent);
						
						//평문을 암호문으로 바꾸기
						var encryptID = rsaObject.encrypt($('input[name=sol_num]').val());
						var encryptPWD = rsaObject.encrypt($('input[name=sol_pass]').val());
						
						
						var $frm = $('<form action="/admin/logincheck.do" method="post"></form>');
						var $inputID = $('<input type="hidden" value="' +encryptID+ '" name="sol_num" />');
						var $inputPWD = $('<input type="hidden" value="' +encryptPWD+ '" name="sol_pass" />');
						
						$frm.append($inputID);
						$frm.append($inputPWD);
						$(document.body).append($frm);
						
						$frm.submit();
					});
	
});
</script>
<body>
	<table width="770" border="0" align="center" cellpadding="0"
		cellspacing="0" style="margin: 90px;">
		<tr>
			<td height="150" align="center"><img
				src="${pageContext.request.contextPath }/image/p_login.gif" /></td>
		</tr>
		<tr>
			<td height="174"
				style="background: url(${pageContext.request.contextPath }/image/login_bg.jpg); border: 1px solid #e3e3e3;">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="260" height="110" align="center"
							style="border-right: 1px dotted #736357;"><img
							src="${pageContext.request.contextPath }/image/logo.jpg" /></td>
						<td>
							<table border="0" align="center" cellpadding="5" cellspacing="0">
								<tr>
									<td><b>아이디</b></td>
									<td><input type="text" name="sol_num" class="box"
										tabindex="3" height="18" /></td>
									<td rowspan="2"><img src="${pageContext.request.contextPath }/image/login.gif" class="loginBtn" /></td>
								</tr>
								<tr>
									<td><b>패스워드</b></td>
									<td><input type="password" name="sol_pass" class="box"
										tabindex="3" height="18" /></td>
								</tr>
								<tr>
									<td colspan="2">
										아이디 저장 : <input type="checkbox" name="saveID" />
									</td>
								</tr>
								<tr>
									<td colspan="3" align="right"><a href="">회원가입을 원하세요??</a></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
