package model;
import java.sql.Date;
public class AnonymousDTO {
   private int aboardID;
   private String category;
   private String title;
   private String content;
   private int userID;
   private String writeTime;
   private int readCount;
   
   public int getAboardID() {
      return aboardID;
   }
   public void setAboardID(int aboardID) {
      this.aboardID = aboardID;
   }
   public String getCategory() {
      return category;
   }
   public void setCategory(String category) {
      this.category = category;
   }
   public String getWriteTime() {
      return writeTime;
   }
   public void setWriteTime(String writeTime) {
      this.writeTime = writeTime;
   }
   public int getUserID() {
      return userID;
   }
   public void setUserID(int userID) {
      this.userID = userID;
   }
   
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
   }
   
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public int getReadCount() {
      return readCount;
   }
   public void setReadCount(int readCount) {
      this.readCount = readCount;
   }
   public AnonymousDTO() {}
   public AnonymousDTO(String category, String title, String content) {
      super();
      this.category = category;
      this.title = title;
      this.content = content;
      
   }
   public AnonymousDTO(int aboardID)
   {
      super();
      this.aboardID = aboardID;
   }
   public AnonymousDTO(int aboardID, String category, String title, String content, int userID, String writeTime) {
      super();
      this.aboardID = aboardID;
      this.category = category;
      this.title = title;
      this.content = content;
      this.userID = userID;
      this.writeTime = writeTime;
   }
   // 조회수 추가
   public AnonymousDTO(int aboardID, String category, String title, String content, int userID, String writeTime, int readCount) {
      super();
      this.aboardID = aboardID;
      this.category = category;
      this.title = title;
      this.content = content;
      this.userID = userID;
      this.writeTime = writeTime;
      this.readCount = readCount;
   }
   
   
}