package model;

public class LikeDTO {
	String userID;
	int boardID;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getEvaluationID() {
		return boardID;
	}

	public void setEvaluationID(int evaluationID) {
		this.boardID = evaluationID;
	}

	
	public LikeDTO(String userID, int evaluationID) {
		this.userID = userID;
		this.boardID = evaluationID;

	}

}
