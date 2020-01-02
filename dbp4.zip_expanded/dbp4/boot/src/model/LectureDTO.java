package model;

public class LectureDTO {

		int LectureID;
		int userID;
		String lectureName;
		String professorName;
		int lectureYear;
		String semesterDivide;
		String lectureDivide;
		String Title;
		String Content;
		String hasAnnounceMent;
		String hasDebate;
		String hasProject;
		String totalScore;
		int likeCount;
		
		
		public int getLectureID() {
			return LectureID;
		}
		public void setLectureID(int lectureID) {
			LectureID = lectureID;
		}
		public int getUserID() {
			return userID;
		}
		public void setUserID(int userID) {
			this.userID = userID;
		}
		public String getLectureName() {
			return lectureName;
		}
		public void setLectureName(String lectureName) {
			this.lectureName = lectureName;
		}
		public String getProfessorName() {
			return professorName;
		}
		public void setProfessorName(String professorName) {
			this.professorName = professorName;
		}
		public int getLectureYear() {
			return lectureYear;
		}
		public void setLectureYear(int lectureYear) {
			this.lectureYear = lectureYear;
		}
		public String getSemesterDivide() {
			return semesterDivide;
		}
		public void setSemesterDivide(String semesterDivide) {
			this.semesterDivide = semesterDivide;
		}
		public String getLectureDivide() {
			return lectureDivide;
		}
		public void setLectureDivide(String lectureDivide) {
			this.lectureDivide = lectureDivide;
		}
		public String getTitle() {
			return Title;
		}
		public void setTitle(String title) {
			this.Title = title;
		}
		public String getContent() {
			return Content;
		}
		public void setContent(String content) {
			this.Content = content;
		}
		public String getHasAnnounceMent() {
			return hasAnnounceMent;
		}
		public void setHasAnnounceMent(String hasAnnounceMent) {
			this.hasAnnounceMent = hasAnnounceMent;
		}
		public String getHasDebate() {
			return hasDebate;
		}
		public void setHasDebate(String hasDebate) {
			this.hasDebate = hasDebate;
		}
		public String getHasProject() {
			return hasProject;
		}
		public void setHasProject(String hasProject) {
			this.hasProject = hasProject;
		}
		public String getTotalScore() {
			return totalScore;
		}
		public void setTotalScore(String totalScore) {
			this.totalScore = totalScore;
		}
		public int getLikeCount() {
			return likeCount;
		}
		public void setLikeCount(int likeCount) {
			this.likeCount = likeCount;
		}
		
		
		public LectureDTO(String lectureName, String professorName, int lectureYear, String semesterDivide,
				String lectureDivide, String title, String content, String hasAnnounceMent, String hasDebate, String hasProject,
				String totalScore) {
			super();
			this.lectureName = lectureName;
			this.professorName = professorName;
			this.lectureYear = lectureYear;
			this.semesterDivide = semesterDivide;
			this.lectureDivide = lectureDivide;
			Title = title;
			Content = content;
			this.hasAnnounceMent = hasAnnounceMent;
			this.hasDebate = hasDebate;
			this.hasProject = hasProject;
			this.totalScore = totalScore;
		}
		public LectureDTO(int lectureID, int userID, String lectureName, String professorName, int lectureYear,
				String semesterDivide, String lectureDivide, String title, String content, String hasAnnounceMent,
				String hasDebate, String hasProject, String totalScore, int likeCount) {
			super();
			this.LectureID = lectureID;
			this.userID = userID;
			this.lectureName = lectureName;
			this.professorName = professorName;
			this.lectureYear = lectureYear;
			this.semesterDivide = semesterDivide;
			this.lectureDivide = lectureDivide;
			Title = title;
			Content = content;
			this.hasAnnounceMent = hasAnnounceMent;
			this.hasDebate = hasDebate;
			this.hasProject = hasProject;
			this.totalScore = totalScore;
			this.likeCount = likeCount;
		}
		
		
		

		
		
	
}
