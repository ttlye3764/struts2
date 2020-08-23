package kr.or.ddit.utiles;

import javax.servlet.http.HttpServletRequest;

public class RolePaginationUtil {
	private int currentPage; 		// 현재 페이지
	private int totalCount;			// 전체 게시글 수
	private int totalPage;			// 전체 페이지 수
	private int blockCount = 10; 	// 페이지별 출력될 게시글 수
	private int blockPage = 5;		// 페이지네이션 메뉴 수
	private int startPage;			// 페이지네이션 메뉴 시작 페이지 번호
	private int endPage;			// 페이지네이션 메뉴 끝 페이지 번호
	private int startCount;			// 해당 페이지 내 게시글 시작 번호
	private int endCount;			// 해당 페이지 내 게시글 끝번호
	private HttpServletRequest request;
	private StringBuffer pagingHtmls;
	
	public RolePaginationUtil(HttpServletRequest request, int currentPage, int totalCount) {
		this.request = request;
		this.currentPage = currentPage;
		this.totalCount = totalCount;		
		
		pagingHtmls = new StringBuffer();
		
		makePageination();
	}
	
	public RolePaginationUtil(HttpServletRequest request, int currentPage, int totalCount, int blockCount) {
		this.request = request;
		this.currentPage = currentPage;
		this.totalCount = totalCount;	
		this.blockCount = blockCount;
		
		pagingHtmls = new StringBuffer();
		
		makePageination();
	}

	private void makePageination() {
		// 전체 페이지의 수
		this.totalPage = (int)Math.ceil((this.totalCount / (double)this.blockCount));
		
		if(totalPage==0){
			this.totalPage = 1;
		}
		
		//해당 페이지 내 게시글 시작 번호, 끝 번호
		this.startCount = this.totalCount - (this.currentPage -1) * this.blockCount;
		this.endCount = this.startCount - this.blockCount +1;
		if(this.endCount<0){
			this.endCount = 1;
		}
		
		// 페이지 별 페이지네이션 메뉴 시작 페이지 번호, 끝 페이지 번호
		// 이전 |1|2|3|4|5|다음
		// 이전 |6|7|8|9|10|다음
		this.startPage = ((this.currentPage-1)/this.blockPage *this.blockPage) +1;
		this.endPage = this.startPage + this.blockPage-1;
		if(this.endPage > this.totalPage){
			this.endPage = this.totalPage;
		}
		
		this.pagingHtmls.append("<div class='text-center'>");
		this.pagingHtmls.append("<ul class='pagination mtm mbm'>");
		
		String requestURI = request.getRequestURI();

		// 이전|1|2|3|4|5|다음
		// 이전
		if((this.currentPage -1)==0){
			this.pagingHtmls.append("<li class ='disabled'><a href='#'>&laquo</a></li>");
		}else{
			this.pagingHtmls.append("<li><a href='"+ requestURI +"?currentPage="+(this.currentPage - 1)+"'>&laquo</a></li>");
		}
		// 1|2|3|4|5
		for(int i = this.startPage; i<= this.endPage; i++){
			if(this.currentPage ==i){
				this.pagingHtmls.append("<li class='active'><a href='#'>"+i+"</a></li>");
			}else{
				this.pagingHtmls.append("<li><a href='"+ requestURI +"?currentPage="+i +"'>"+ i +"</a></li>");
			}
		}
		// 다음
		if((this.currentPage < this.totalPage)){
			this.pagingHtmls.append("<li><a href='"+ requestURI +"?currentPage="+(this.currentPage + 1)+"'>&raquo</a></li>");
		}else{
			this.pagingHtmls.append("<li class ='disabled'><a href='#'>&raquo</a></li>");
		}
		
		this.pagingHtmls.append("</ul>");
		this.pagingHtmls.append("</div>");
	}

	public int getStartCount() {
		return startCount;
	}

	public int getEndCount() {
		return endCount;
	}

	public String getPagingHtmls() {
		return pagingHtmls.toString();
	}
}
