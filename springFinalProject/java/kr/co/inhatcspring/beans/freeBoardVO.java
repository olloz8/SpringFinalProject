package kr.co.inhatcspring.beans;

/**
 * 자유게시판 게시물 정보를 담는 클래스입니다.
 */
public class freeBoardVO {
	
	// 게시물 고유 번호
	int boardID;
	// 게시물 작성자
	String userId;
	// 게시물 제목
	String title;
	// 게시물 내용
	String boardContent;
	// 작성일자
	String nowDate;
	// 게시물 카테고리
	String boardCategory;
	
	public int getBoardID() {
		return boardID;
	}
	public void setBoardID(int boardID) {
		this.boardID = boardID;
	}
	public String getBoardCategory() {
		return boardCategory;
	}
	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getNowDate() {
		return nowDate;
	}
	public void setNowDate(String nowDate) {
		this.nowDate = nowDate;
	}
	
	
	
	
}
