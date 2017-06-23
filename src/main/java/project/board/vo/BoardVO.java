package project.board.vo;

/**

* 1. 패키지명 : project.board.vo

* 2. 타입명 : BoardVO.java

* 3. 작성일 : 2017. 6. 23. 오전 9:32:09

* 4. 작성자 : kim

* 5. 설명 : 게시판 용도


*/
public class BoardVO {
	private String no;
	private String subject;
	private String content;
	private String creatEd;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatEd() {
		return creatEd;
	}
	public void setCreatEd(String creatEd) {
		this.creatEd = creatEd;
	}
	
	
}
