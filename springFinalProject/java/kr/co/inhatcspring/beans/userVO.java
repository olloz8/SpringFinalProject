package kr.co.inhatcspring.beans;

public class userVO {
	
    private String userId;		//유저 아이디
    private String userName;	//유저 이름
    private String password;	//유저 비밀번호
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
