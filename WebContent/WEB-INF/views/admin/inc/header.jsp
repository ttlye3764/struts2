<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css" type="text/css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css">


<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/commons.js"></script>
<title>회원관리 관리자</title>
</head>
<body>
	<div class="wrap">
		<div id="header">
			<div class="top_bn">
				<ul>
					<li><a href="#"><img src="${pageContext.request.contextPath }/image/admin_t.jpg" /></a></li>
					<li><a href="#"><img src="${pageContext.request.contextPath }/image/admin_f.jpg" /></a></li>
					<li><a href="#"><img src="${pageContext.request.contextPath }/image/admin_homelink.jpg" /></a></li>
					<li><a href="#"><img src="${pageContext.request.contextPath }/image/admin_logout.jpg" /></a></li>
				</ul>
			</div>
			<div class="logo">
				<img src="${pageContext.request.contextPath }/image/logo.jpg" />
			</div>
			<div class="gnb">
				<ul>
					<li><a href="/admin/soldier.do">병사관리</a></li>
					<li><a href="/admin/notice.do">공지사항</a></li>
					<li><a href="/admin/freeBoardList.do">자유게시판</a></li>
					<li><a href="/admin/dataBoardList.do">자료실</a></li>
					<li><a href="/admin/qnaBoardList.do">Q&A</a></li>
					<li><a href="/admin/imageboardList.do">이미지 게시판</a></li>
					<li><a href="/admin/askBoardList.do">자주 묻는 질문</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script src="${pageContext.request.contextPath}/script/jquery-1.8.3.js"></script>
<script src="${pageContext.request.contextPath}/script/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/script/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/script/bootstrap-hover-dropdown.js"></script>
<script src="${pageContext.request.contextPath}/script/html5shiv.js"></script>
<script src="${pageContext.request.contextPath}/script/respond.min.js"></script>
<script src="${pageContext.request.contextPath}/script/jquery.metisMenu.js"></script>
<script src="${pageContext.request.contextPath}/script/jquery.slimscroll.js"></script>
<script src="${pageContext.request.contextPath}/script/jquery.cookie.js"></script>
<script src="${pageContext.request.contextPath}/script/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/script/custom.min.js"></script>
<script src="${pageContext.request.contextPath}/script/jquery.news-ticker.js"></script>
<script src="${pageContext.request.contextPath}/script/jquery.menu.js"></script>
<script src="${pageContext.request.contextPath}/script/pace.min.js"></script>
<script src="${pageContext.request.contextPath}/script/holder.js"></script>
<script src="${pageContext.request.contextPath}/script/responsive-tabs.js"></script>
<script src="${pageContext.request.contextPath}/script/zabuto_calendar.min.js"></script>
<!-- summernote 에디터 js 파일 시작 -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.7.1/summernote.js"></script>
<!-- summernote 에디터 js 파일 끝 -->
<!-- 부트스트랩 다이얼로그 js 파일 시작 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<!-- 부트스트랩 다이얼로그 js 파일 끝 -->

<script type ="text/javascript" src ="${pageContext.request.contextPath}/js/common/validation.js"></script>
 <script type ="text/javascript" src ="${pageContext.request.contextPath }/js/crypto/jsbn.js"></script>
 <script type ="text/javascript" src ="${pageContext.request.contextPath }/js/crypto/rsa.js"></script>
 <script type ="text/javascript" src ="${pageContext.request.contextPath }/js/crypto/prng4.js"></script>
 <script type ="text/javascript" src ="${pageContext.request.contextPath }/js/crypto/rng.js"></script>
<script type = "text/javascript" src ="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9/core.js"></script>
<script type = "text/javascript" src ="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9/sha256.js"></script>
</html>