<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="noticeList" value="${noticeList}"></c:set>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
<script type="text/javascript" scr="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(function(){
	$('#noticeForm').click(function(){
		if(eval('${!empty LOGIN_SOLDIERINFO}')){
			$(location).attr('href', '/user/notice/noticeForm.do');
		}else{
			alert('로그인해주세용');	
		}
	});
	$('#freeboardTBY tr').click(function(){
		var nt_no = $(this).find('td:eq(0)').text();
		var rnum = $(this).find('td:eq(0)').text();
		$(location).attr('href', '/user/notice/noticeView.do?nt_no='+nt_no+'&rnum='+rnum);
	});
});
	
     $(function(){
      $('.pull-right button:eq(0)').click(function(){
         const search_keycode = $("select[name=search_keycode] option:selected").val();
         const search_keyword = $("#search_keyword").val();
         $('#NTForm').submit();
         
         
         
      });
   });  
</script> 
<style>
   .center{
         text-align : center;}
</style>
</head>
<body>

<div id="noticeList_content">
   <div class="panel panel-blue">
       <div class="panel-heading">게시판 목록</div>
      <table class="table table-bordered table-hover">
         <thead>
            <tr>
               <th scope="col" width="5%">No</th>
               <th scope="col" width="65%">제목</th>
               <th scope="col" width="10%">작성자</th>
               <th scope="col" width="10%">작성일</th>
               <th scope="col" width="10%">조회수</th>
            </tr>
         </thead>
         <tbody id ="freeboardTBY">
            <c:forEach var="noticeInfo" items="${noticeList }">
            <tr>
               <td>${noticeInfo.nt_no}</td>
               <td>${noticeInfo.nt_title}</td>
               <td>${noticeInfo.nt_writer}</td>
               <td>${noticeInfo.nt_reg_date}</td>
               <td>${noticeInfo.nt_hit}</td>
            </tr>
            </c:forEach>
         </tbody>
      </table>
   </div>
</div>
${pagination.getPagingHtmls() }
<div >
<form id="NTForm" action="/user/notice.do" method="post" class="form-inline pull-right">
      <input id="search_keyword" name="search_keyword"  type="text" placeholder="검색어 입력..." class="form-control" />
      <select class="form-control" name="search_keycode" >
         <option>검색조건</option>
         <option value="TOTAL">전체</option>
         <option value="TITLE">제목</option>
         <option value="CONTENT">내용</option>
         <option value="WRITER">작성자</option>
      </select>
       <button type="button" id="search" class="btn btn-primary form-control"  >검색</button>
      <!--  <button type="button" class="btn btn-info form-control" id="noticeForm">게시글 등록</button>  -->
</form>
</div>   
</body>

</html>