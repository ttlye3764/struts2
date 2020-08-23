<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	#over {
		overflow: auto;
	}
</style>
<meta charset="UTF-8">
<title>자유게시글 목록</title>
<script type="text/javascript">
   $(function() {
      $('#insertfreeboard').on('click', function() {
         if(eval('${!empty LOGIN_SOLDIERINFO}')){
            $(location).attr('href', '/freeboard/freeboardForm.do');
         }else{
            alert('로그인이 필요합니다.');   
         }
      })
      
      $('#freeboardTBY tr').click(function(){
			var bo_no = $(this).find('td:eq(0) input').val();
			alert(bo_no);
			var rnum = $(this).find('td:eq(0)').text();
			$(location).attr('href', '/freeboard/freeboardView.do?bo_no='+bo_no+'&rnum='+rnum);
		});
   })
</script>
</head>
<body>
<div id="freeboardList_content">
   <div class="panel panel-blue">
       <div class="panel-heading">게시판 목록</div>
      <table id="over" class="table table-bordered table-hover">
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
            <c:if test="${empty freeBoardList }">
				<tr align="center">
					<td colspan="5"><font color="red">게시물이 없습니다</font></td>
				</tr>
			</c:if>
            <c:if test="${!empty freeBoardList }">
			<c:forEach items="${freeBoardList }" var="freeBoardInfo">
				<tr>
					
					<td><input type="hidden" value="${freeBoardInfo.bo_no}" />${freeBoardInfo.rnum }</td>
					<td align="left">
						<c:forEach begin="1" end="${freeBoardInfo.bo_depth }" varStatus="stat">
							&nbsp;&nbsp;&nbsp;
							<c:if test="${stat.last}">
								<i class="fa fa-angle-right"></i>
							</c:if>
						</c:forEach>
		               		${freeBoardInfo.bo_title}</td>
		               <td>${freeBoardInfo.bo_writer}</td>
		               <td>${freeBoardInfo.bo_reg_date}</td>
		               <td>${freeBoardInfo.bo_hit}</td>
		            </tr>
				</c:forEach>
				</c:if>
         </tbody>
      </table>
      ${paginationMenu }
      
   </div>
</div>
<div >
<form action="/freeboardList.do" method="post" class="form-inline pull-right">
      <input id="search_keyword" name = "search_keyword" type="text" placeholder="검색어 입력..." class="form-control" />
      <select class="form-control" name="search_keycode" >
         <option>검색조건</option>
         <option value="TOTAL">전체</option>
         <option value="TITLE">제목</option>
         <option value="CONTENT">내용</option>
         <option value="WRITER">작성자</option>
      </select>
       <button type="submit" class="btn btn-primary form-control">검색</button>
       <button id="insertfreeboard" type="button" class="btn btn-info form-control">게시글 등록</button>
</form>
</div>   
</body>
</html>