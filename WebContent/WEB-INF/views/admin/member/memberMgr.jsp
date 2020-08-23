<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원리스트</title>
</head>
  <script type="text/javascript">
		$(function() {
			//체크박스 처리
    		$("#checkAll").click(function(){
        		if($("#checkAll").is(":checked")){
            		$(".checkbox_align").prop("checked", true);
       			 } else {
           		    $(".checkbox_align").prop("checked", false);
        		}
    		});
    		
			
			// 체크 박스 전송
			$('#btnEx').on('click',function(){
				let mem_id = [];
				$('table tr:gt(0)').each(function(i, inputTag){
					if($(this).find('td input[type=checkbox]').prop("checked")){
						 mem_id.push($(this).find('td:eq(1)').text());
					}
				});
				$(location).attr('href','/admin/excel.do?mem_id='+mem_id);
			});			
			
			//연락처
			const memhp = settingDisernNum();
			
			$('select[name=search_hp1]').append(memhp);
			
			//생년월일
			const date = new Date();
			const year = getYearsOptions(date);
			$('#sol_bir1').append(year);
			
			const month = getMonthOptions();
			$('#sol_bir2').append(month);
			
			
			
			//전송할때
			$('form[name=search_form]').submit(function(){
				$('input[name=sol_add1]').val($('select[name=sol_add1]').val());
				$('input[name=sol_add2]').val($('select[name=sol_add2]').val());
				
				$('input[name=sol_tel]').val($('select[name=sol_tel1]').val() + $('input[name=sol_tel2]').val()
						 + $('input[name=sol_tel3]').val());
				$('input[name=sol_bir]').val($('select[name=sol_bir1]').val()+$('select[name=sol_bir2]').val()+$('select[name=sol_bir3]').val());
				return true;		
			});	
			
			//memberDetail로 간다.
			$('.memberList tr .td').on('click',function(){
				const mem_id  =$(this).eq('0').text();
				$(location).attr('href','/admin/memberView.do?mem_id='+mem_id);
			});
			
			const sido = getSido();
		  	$('#sol_add1').append(sido);			
			
		  	$('select[name=blockCount] option[value="' + "${blockCount}" + '"]').attr('selected', true);
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
		
		function submit(){
			var blockCount = $('select[name=blockCount]').val();
			$(location).attr('href','/admin/soldierList.do?blockCount='+blockCount);
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
		
		function clean(){
			$('#sol_add2').empty();
			option = "<option value=''>선택하세요</option>";
			$('#sol_add2').append(option);
		}
    </script>
<body>
<div class="wrap">	
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><jsp:include page="memberMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790">
				<div id="container">
					<div class="title">회원관리</div>
					<form name="searchForm" action ="/admin/soldierList.do" method="POST">
						<table border="0" cellspacing="1" cellpadding="1">
							<tr>
								<th width="120">기본검색</th>
								<td>
									<select style="width: 130px;" name="search_keycode">
											<option selected="ALL">전체</option>
											<option value="NAME">이름</option>
											<option value="ID">아이디</option>
									</select>
								<input name="search_base_keyword" type="text" size="20" /></td>
							</tr>
							<tr>
								<th>거주지</th>
								<td>
									<input type="hidden" name="sol_add">
									<select style="width: 130px;" name="sol_add1" id="sol_add1" onchange="Onchange()">
											<option selected="selected">선택하세요</option>
									</select> 
									<select style="width: 130px;" name="sol_add2" id="sol_add2">
										<option selected="selected">선택하세요</option>
									</select>
								</td>
							</tr>
							<tr>
								<th>연락처</th>
								<td>
									<input type="hidden" name="sol_tel">
									<select style="width: 100px;" name="sol_tel1">
										<option selected="selected">선택하세요</option>
									</select> - 
									<input name="sol_tel2" type="text" id="sol_tel2" size="20" /> - 
									<input name="sol_tel3" type="text" id="sol_tel3" size="20" />
								</td>
							</tr>
							<tr>
								<th>생년월일</th>
								<td>
									<input type="hidden" name="sol_bir">
									<input type="radio" name="sol_calendar" value="양력" checked="checked"/>양력
									<input type="radio" name="sol_calendar" value="음력" />음력 
									<select style="width: 130px;" name="sol_bir1" id="sol_bir1">
										<option selected="selected">년</option>
									</select> 
									<select style="width: 130px;" name="sol_bir2" id="sol_bir2" onchange="selectDay()">
										<option selected="selected">월</option>
									</select> 
									<select style="width: 130px;" name="sol_bir3" id="sol_bir3">
										<option selected="selected">일</option>
									</select>
								</td>
							</tr>
						</table>
						<div style="padding-top: 5px; text-align: right;">
							<input class="btn1" type="reset" value="초기화" onclick="clean()"/>
							<input class="btn1" type="submit" value="검색하기" />
						</div>
						<div style="padding-top: 5px;" id="search_totalMembers">
							<label class="totalmembers"></label>
							<input type="hidden" name="blockCount">
							<select style="width: 50px; float: right;" name="blockCount" onchange="submit()">
								<option value="">10</option>
								<option value="25">25</option>
								<option value="50">50</option>
							</select>
						</div>
					</form>
					<div style="height: 15px;"></div>
					<table border="0" cellspacing="1" cellpadding="1">
						<thead>
							<tr>
								<th width="10%">
								    <input type="checkbox" name="selectTotal" class="checkbox_align"/>&nbsp;선택
								</th>
								<th width="20%">군번</th>
								<th>이름</th>
								<th>생일</th>
								<th>메일</th>
							</tr>
						</thead>	
						<tbody class="memberList">				
							<c:forEach items="${SoldierList}" var="soldierList">
							<tr>
								<td align="center"><input type="hidden" value="${soldierList.sol_num}" />
									<input type="checkbox" name="checkbox"></td>
								<td align="center">									
									${soldierList.sol_num}</td>
								<td>${soldierList.sol_name }</td>
								<td>${soldierList.sol_bir }</td>
								<td>${soldierList.sol_email }</td>
							</tr>
							</c:forEach>						
						</tbody>	
					</table>
					<div align="center">
						<input class="publishingCoupon" type="submit" value="선택회원 메일발송" style="float: left;"/>
						<span class="pagingHtml"></span>
						<input class="btn2" type="button" value="Excel작성" style="float: right;"/>
						<input class="btn2" type="button" value="PDF작성" style="float: right; margin-right: 5px;"/>
					</div>
				</div>
			</td>
		</tr>
	</table>
	${pagination.getPagingHtmls()}
</div>
</body>
</html>