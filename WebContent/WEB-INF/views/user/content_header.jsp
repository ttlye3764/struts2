<%@ page language="JAVA" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="page-title-breadcrumb">
	<ol class="breadcrumb">
		<!-- 자유 게시판-->
		<c:if test="${contentPage eq 'freeBoardList'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/freeboardList.do">자유 게시판</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">목록</li>
		</c:if>
		<c:if test="${contentPage eq 'freeBoardForm'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/freeboardList.do">자유 게시판</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">글 쓰기</li>
		</c:if>
		<c:if test="${contentPage eq 'updateFreeBoard'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/freeboardList.do">자유 게시판</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">글 수정</li>
		</c:if>
		<c:if test="${contentPage eq 'freeBoardView'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/freeboardList.do">자유 게시판</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">세부 글 정보</li>
		</c:if>
		<c:if test="${contentPage eq 'freeBoardReplyForm'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/freeboardList.do">자유 게시판</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">댓글 쓰기</li>
		</c:if>
		<c:if test="${contentPage eq 'updatefreeBoardReply'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/freeboardList.do">자유 게시판</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">댓글 수정</li>
		</c:if>
		<c:if test="${contentPage eq 'freeBoardReplyView'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/freeboardList.do">자유 게시판</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">세부 댓글 정보</li>
		</c:if>
		
		<!-- 공지사항 -->
		<c:if test="${contentPage eq 'noticeBoardList'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/notice.do">공지사항</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">목록</li>
		</c:if>
		<c:if test="${contentPage eq 'noticeBoardForm'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/notice.do">공지사항</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">글 쓰기</li>
		</c:if>
		<c:if test="${contentPage eq 'updateNoticeBoard'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/notice.do">공지사항</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">글 수정</li>
		</c:if>
		<c:if test="${contentPage eq 'noticeBoardView'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/notice.do">공지사항</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">세부 글 정보</li>
		</c:if>
		<c:if test="${contentPage eq 'noticeBoardReplyForm'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/notice.do">공지사항</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">댓글 쓰기</li>
		</c:if>
		<c:if test="${contentPage eq 'updatefreeBoardReply'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/notice.do">공지사항</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">댓글 수정</li>
		</c:if>
		<c:if test="${contentPage eq 'noticeBoardReplyView'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/notice.do">공지사항</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">세부 댓글 정보</li>
		</c:if>
		
		<!-- 이미지 게시판 -->
		<c:if test="${contentPage eq 'imageBoardList'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/imageboardList.do">이미지 게시판</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">목록</li>
		</c:if>
		<c:if test="${contentPage eq 'imageBoardForm'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/imageboardList.do">이미지 게시판</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">글 쓰기</li>
		</c:if>
		<c:if test="${contentPage eq 'updateImageBoard'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/imageboardList.do">이미지 게시판</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">글 수정</li>
		</c:if>
		<c:if test="${contentPage eq 'imageBoardView'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/imageboardList.do">이미지 게시판</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">세부 글 정보</li>
		</c:if>
		
		<!-- q&a 게시판 -->
		<c:if test="${contentPage eq 'qnaBoardList'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/qna/qnaboardList.do">Q&A</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">목록</li>
		</c:if>
		<c:if test="${contentPage eq 'qnaBoardForm'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/qna/qnaboardList.do">Q&A</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">글 쓰기</li>
		</c:if>
		<c:if test="${contentPage eq 'updateQnaBoard'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/qna/qnaboardList.do">Q&A</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">글 수정</li>
		</c:if>
		<c:if test="${contentPage eq 'qnaBoardView'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/qna/qnaboardList.do">Q&A</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">세부 글 정보</li>
		</c:if>
		<c:if test="${contentPage eq 'qnaBoardReplyForm'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/qna/qnaboardList.do">Q&A</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">댓글 쓰기</li>
		</c:if>
		<c:if test="${contentPage eq 'updatefreeBoardReply'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/qna/qnaboardList.do">Q&A</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">댓글 수정</li>
		</c:if>
		<c:if test="${contentPage eq 'noticeBoardReplyView'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/qna/qnaboardList.do">Q&A</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">세부 댓글 정보</li>
		</c:if>
		
		<!-- 자료실 -->
		<c:if test="${contentPage eq 'dataBoardList'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/data/databoardList.do">자료실</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">목록</li>
		</c:if>
		<c:if test="${contentPage eq 'dataBoardForm'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/data/databoardList.do">자료실</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">글 쓰기</li>
		</c:if>
		<c:if test="${contentPage eq 'updateDataBoard'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/data/databoardList.do">자료실</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">글 수정</li>
		</c:if>
		<c:if test="${contentPage eq 'dataBoardView'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/data/databoardList.do">자료실</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">세부 글 정보</li>
		</c:if>
		<c:if test="${contentPage eq 'dataBoardReplyForm'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/data/databoardList.do">자료실</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">댓글 쓰기</li>
		</c:if>
		<c:if test="${contentPage eq 'updateDataBoardReply'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/data/databoardList.do">자료실</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">댓글 수정</li>
		</c:if>
		<c:if test="${contentPage eq 'dataBoardReplyView'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/data/databoardList.do">자료실</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">세부 댓글 정보</li>
		</c:if>
		
		<!-- 자주하는 질문 -->
		<c:if test="${contentPage eq 'askBoardList'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/askboardList.do">자주하는 질문</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">목록</li>
		</c:if>
		<c:if test="${contentPage eq 'askBoardForm'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/askboardList.do">자주하는 질문</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">글 쓰기</li>
		</c:if>
		<c:if test="${contentPage eq 'updateAskBoard'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/askboardList.do">자주하는 질문</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">글 수정</li>
		</c:if>
		<c:if test="${contentPage eq 'askBoardView'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/askboardList.do">자주하는 질문</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">세부 글 정보</li>
		</c:if>
		<c:if test="${contentPage eq 'dataBoardReplyForm'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/askboardList.do">자주하는 질문</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">댓글 쓰기</li>
		</c:if>
		<c:if test="${contentPage eq 'updateAskBoardReply'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/askboardList.do">자주하는 질문</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">댓글 수정</li>
		</c:if>
		<c:if test="${contentPage eq 'askBoardReplyView'}">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="/user/askboardList.do">자주하는 질문</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active">세부 댓글 정보</li>
		</c:if>
	</ol>
	<div class="clearfix"></div>
</div>
</body>
</html>