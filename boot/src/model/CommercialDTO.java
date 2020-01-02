package model;

public class CommercialDTO {
   
   int CBoardId;
   int userId;
   String commercialName;
   String commercialCategory;
   String hasWifi;
   String hasSingleTable;
   String hasSocket; //has enough sockets
   String congestion;
   String grade;
   String price;
   String content;
   int likeCount;
   
   public int getCBoardId() {
      return CBoardId;
   }
   public void setCBoardId(int cBoardId) {
      CBoardId = cBoardId;
   }
   public int getUserId() {
      return userId;
   }
   public void setUserId(int userId) {
      this.userId = userId;
   }
   public String getCommercialName() {
      return commercialName;
   }
   public void setCommercialName(String commercialName) {
      this.commercialName = commercialName;
   }
   public String getCommercialCategory() {
      return commercialCategory;
   }
   public void setCommercialCategory(String commercialCategory) {
      this.commercialCategory = commercialCategory;
   }
   public String getHasWifi() {
      return hasWifi;
   }
   public void setHasWifi(String hasWifi) {
      this.hasWifi = hasWifi;
   }
   public String getHasSingleTable() {
      return hasSingleTable;
   }
   public void setHasSingleTable(String hasSingleTable) {
      this.hasSingleTable = hasSingleTable;
   }
   public String getHasSocket() {
      return hasSocket;
   }
   public void setHasSocket(String hasSocket) {
      this.hasSocket = hasSocket;
   }
   public String getCongestion() {
      return congestion;
   }
   public void setCongestion(String congestion) {
      this.congestion = congestion;
   }
   public String getPrice() {
      return price;
   }
   public void setPrice(String price) {
      this.price = price;
   }
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
   }
   public int getLikeCount() {
      return likeCount;
   }
   public void setLikeCount(int likeCount) {
      this.likeCount = likeCount;
   }
   public String getGrade() {
      return grade;
   }
   public void setGrade(String grade) {
      this.grade = grade;
   }
   
   public CommercialDTO(String commercialName, String commercialCategory, 
         String hasWifi, String hasSingleTable, String hasSocket, 
         String congestion, String price, String grade, 
         String content) {
      super();
      this.commercialName = commercialName;
      this.commercialCategory = commercialCategory;
      this.hasWifi = hasWifi;
      this.hasSingleTable = hasSingleTable;
      this.hasSocket = hasSocket;
      this.congestion = congestion;
      this.price = price;
      this.grade = grade;
      this.content = content;
   }
   public CommercialDTO(int cBoardId, int userId, String commercialName, String commercialCategory, 
         String hasWifi, String hasSingleTable, String hasSocket, 
         String congestion, String price, String grade, 
         String content, int likeCount) {
      super();
      CBoardId = cBoardId;
      this.userId = userId;
      this.commercialName = commercialName;
      this.commercialCategory = commercialCategory;
      this.hasWifi = hasWifi;
      this.hasSingleTable = hasSingleTable;
      this.hasSocket = hasSocket;
      this.congestion = congestion;
      this.price = price;
      this.grade = grade;
      this.content = content;
      this.likeCount = likeCount;
      
   }
   
}