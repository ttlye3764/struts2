<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
.fieldName {text-align: center; background-color: #f4f4f4;}
.tLine {background-color: #d2d2d2; height: 1px;}
.btnGroup { text-align: right; }
td {text-align: left; }
</style>
<body>
<form name="joinForm" method="post">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr><td class="tLine" colspan="2"></td></tr>
	<tr>
		<td class="fieldName" width="100px" height="25">군번</td>
		<td>			
			<input type="hidden" name="sol_num" value="">
			<input type="text" size="2" value="${year}" disabled="disabled"> - 
			<input type="text" size="13" value="${gunnum}" disabled="disabled">&nbsp;&nbsp;<a href="/user/selectSolNum.do">[군번 발급]</a>			
			<input type="hidden" name="sol_num1" value="${year}">
			<input type="hidden" name="sol_num2" value="${gunnum}">	
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	<tr>
		<td class="fieldName" width="100px" height="25">주특기번호</td>
		<td>			
			<input type="hidden" name="sol_skillnum" value="">
			<input type="text" name="sol_skillnum1" size="7" value="">  - 
			<input type="text" name="sol_skillnum2" size="8" value="">	
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	<tr>
		<td class="fieldName" width="100px" height="25px">계급</td>
		<td>
			<input type="hidden" name="sol_rank"/>
			<select name="sol_rank1">
				<option value="병장">병장</option>
				<option value="상병">상병</option>
				<option value="일병">일병</option>								        	
				<option value="이등병">이등병</option>						        					        					        	
			</select>
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	<tr>
		<td class="fieldName" width="100px" height="25">성 명</td>
		<td>
			<input type="text" name="sol_name" value=""/>
		</td>
	</tr>	
	<tr><td class="tLine" colspan="2"></td></tr>
	<tr>
		<td class="fieldName" width="100px" height="25">총기번호</td>
		<td>
			<input type="text" name="sol_gunnum" value=""/>
		</td>
	</tr>	
	<tr><td class="tLine" colspan="2"></td></tr>
	<tr>
		<td class="fieldName" width="100px" height="25">입대일자</td>
		<td>
				<input type="hidden" name="sol_start" />
				<input type="text" name="sol_start1" size="4" value="" />년
				<input type="text" name="sol_start2" size="2" value="" />월
				<input type="text" name="sol_start3" size="2" value="" />일
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	<tr>
		<td class="fieldName" width="100px" height="25">전역일자</td>
		<td>
				<input type="hidden" name="sol_end" />
				<input type="text" name="sol_end1" size="4" value="" />년
				<input type="text" name="sol_end2" size="2" value="" />월
				<input type="text" name="sol_end3" size="2" value="" />일
		</td>
	</tr>	
	<tr><td class="tLine" colspan="2"></td></tr>
	<tr>
		<td class="fieldName" width="100px" height="25">생년월일</td>
		<td>
			<input type="radio" name="sol_calendar" value="양력" checked="checked"/>양력
			<input type="radio" name="sol_calendar" value="음력" />음력 
			
			<select style="width: 70px;" name="sol_bir1" id="sol_bir1">
				<option selected="selected">년도</option>
			</select> 
			<select style="width: 70px;" name="sol_bir2" id="sol_bir2" onchange="selectDay()">
				<option selected="selected">월</option>
			</select> 
			<select style="width: 70px;" name="sol_bir3" id="sol_bir3">	
				<option selected="selected">일</option>			
			</select>
		</td>
	</tr>	
	<tr><td class="tLine" colspan="2"></td></tr>
	<tr>
		<td class="fieldName" width="100px" height="25">비밀번호</td>
		<td>
			<input type="text" name="sol_pass" value="" /> 8 ~ 20 자리 영문자 및 숫자 사용
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">비밀번호확인</td>
		<td>
			<input type="text" name="sol_pass_confirm" value="" /> 8 ~ 20 자리 영문자 및 숫자 사용
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0">	
	<tr>
		<td class="fieldName" width="100px" height="25">휴대전화번호</td>
		<td>
			<input type="hidden" name="sol_tel"/>
			<select name="sol_tel1">
				<option value="010">010</option>
				<option value="016">016</option>				        	
				<option value="017">017</option>				        	
				<option value="019">019</option>				        	
			</select>	-
			<input type="text" name="sol_tel2" size="4" value="" /> - 
			<input type="text" name="sol_tel3" size="4" value="" />
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">이메일</td>
		<td>
			<input type="hidden" name="sol_mail" />
			<input type="text" name="sol_mail1" value="" /> @
			<select name="sol_mail2">
				<option value="naver.com">naver.com</option>
				<option value="daum.net">daum.net</option>
				<option value="hanmail.net">hanmail.net</option>
				<option value="nate.com">nate.com</option>
				<option value="gmail.com">gmail.com</option>				
			</select>
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
		
	<tr>
		<td class="fieldName" width="100px" height="25">주소</td>
		<td>			
			<select id="sol_add1" name="sol_add1" onchange="Onchange()">
				<option value="" selected="selected">선택하세요</option>
			</select>
			<select id="sol_add2" name="sol_add2">
				<option value="" selected="selected">선택하세요</option>
			</select>
		</td>
	</tr>	
	<tr><td class="tLine" colspan="2"></td></tr>
	<tr>
		<td class="fieldName" width="100px" height="25">키</td>
		<td>
			<input type="text" name="sol_height" size="7" value=""/> cm			
		</td>		
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	<tr>
		<td class="fieldName" width="100px" height="25">몸무게</td>
		<td>
			<input type="text" name="sol_weight" size="7" value=""/> kg
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	<tr>
		<td class="fieldName" width="100px" height="25">취미</td>
		<td>
			<input type="text" name="sol_hobby" value=""/>
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	<tr>
		<td class="fieldName" width="100px" height="25">특기</td>
		<td>
			<input type="text" name="sol_ability" value=""/>
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr><td colspan="2" height="20"></td></tr>
	
	<tr>
		<td class="btnGroup" colspan="2" >
			<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="btn1" type="submit">가입하기</button>
			<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="btn2" type="reset">취소</button>
			<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="btn3" type="button">목록</button>
		</td>
	</tr>
</table>
</form>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/validation.js"></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/js/common/commons.js'></script>
<script type="text/javascript">
$(function(){
	$('form[name=joinForm]').submit(function(){
		$(this).attr('action', '/user/insertMember.do');		
		
// 		if($('input[name=sol_pass]').val() != $('input[name=sol_pass_confirm]').val()){
// 			alert('비밀번호를 확인해주세요.');
// 			return false;
// 		}
		
		return true;
	});
	
	$('#btn3').click(function(){
		$(location).attr('href', '/user/main.do');
	});
	
	const sido = getSido();
  	$('#sol_add1').append(sido);
  	
  	const date = new Date();
	const year = getYearsOptions(date);
	$('#sol_bir1').append(year);
	
	const month = getMonthOptions();
	$('#sol_bir2').append(month);
});

function selectDay() {
	var date = new Date();
	var selectYear = $('select[name=sol_bir1]').val();
	var selectMonth = $('select[name=sol_bir2]').val()-1;
	
	date.setFullYear(selectYear);
 	date.setMonth(selectMonth);
 	
 	var days = getLastDate(date);
 	$('#sol_bir3').empty(); 	
 	var option ='<option value="">일</option>';
 	for(var i=1; i<=days; i++){
 		if(i<10){
 			option +=  '<option value="0'+i+'">0'+i+'일'+'</option>';
 		}else{
 			option +=  '<option value="'+i+'">'+i+'일'+'</option>';
 		}
 	}
 	console.log(days);
	$('#sol_bir3').append(option);
}

function Onchange() {
	$('#sol_add2').empty();
	
	var gugun2 = $('select[name = sol_add1]').val();
	const gugun = getGugun(gugun2);
		
	for(var i = 1; i < gugun.length; i++) {
		option = "<option value='" + gugun[i] + "'>" + gugun[i] + "</option>";
		$('#sol_add2').append(option);
	}
};
</script>
</html>
