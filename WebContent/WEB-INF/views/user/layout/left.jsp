<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
	/* $(function(){
		$('#QnaBtn').click(function(){
			$(location).attr('href','/qna/qnaboradList.do');
		});
	}); */
</script>
<title>Insert title here</title>
</head>
<body>
<!--BEGIN SIDEBAR MENU-->
<nav id="sidebar" role="navigation" data-step="2"
	data-intro="Template has &lt;b&gt;many navigation styles&lt;/b&gt;"
	data-position="right" class="navbar-default navbar-static-side">
	<div class="sidebar-collapse menu-scroll">
		<ul id="side-menu" class="nav">
			<div class="clearfix"></div>
			<li class="active">
				<a href="/user/notice.do">
					<i class="fa fa-tachometer fa-fw"><div class="icon-bg bg-orange"></div></i>
					<span class="menu-title">공지사항</span>
				</a>
			</li>
			<li>
				<a href="/freeboardList.do">
					<i class="fa fa-desktop fa-fw"><div class="icon-bg bg-pink"></div></i>
					<span class="menu-title">자유게시판</span>
				</a>
			</li>
			<li>
				<a href="/data/databoardList.do">
					<i class="fa fa-send-o fa-fw"><div class="icon-bg bg-green"id="DataBtn"></div></i>
					<span class="menu-title">자료실</span>
				</a>
			</li>
			<li>
				<a href="/qna/qnaboardList.do">
					<i class="fa fa-edit fa-fw"><div class="icon-bg bg-violet" id="QnaBtn"></div></i>
					<span class="menu-title">Q&A게시판</span>
				</a>
			</li>
			<li>
				<a href="/user/askboardList.do">
					<i class="fa fa-th-list fa-fw"><div class="icon-bg bg-blue"></div></i>
					<span class="menu-title">자주하는질문</span>
				</a>
			</li>
			<li>
				<a href="/user/imageboardList.do">
					<i class="fa fa-database fa-fw"><div class="icon-bg bg-red"></div></i>
					<span class="menu-title">이미지 게시판</span>
				</a>
			</li> 
		</ul>
	</div>
</nav>
</body>
</html>