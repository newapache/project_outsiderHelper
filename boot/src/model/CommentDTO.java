package model;

public class CommentDTO {
	int commentID;
	String content;
	String userID;
	int boardID;
	String writeTime;

	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getBoardID() {
		return boardID;
	}
	public void setBoardID(int boardID) {
		this.boardID = boardID;
	}
	public String getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(String writeTime) {
		this.writeTime = writeTime;
	}
	public CommentDTO(int commentID, String content, String userID, int boardID, String writeTime) {
		super();
		this.commentID = commentID;
		this.content = content;
		this.userID = userID;
		this.boardID = boardID;
		this.writeTime = writeTime;
	}
	public CommentDTO(String content, String userID, int boardID) {
		super();
		this.content = content;
		this.userID = userID;
		this.boardID = boardID;
	}
}
