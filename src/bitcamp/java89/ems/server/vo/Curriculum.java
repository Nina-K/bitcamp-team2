package bitcamp.java89.ems.server.vo;

import java.io.Serializable;

public class Curriculum implements Serializable {
  private static final long serialVersionUID = 1L;
  
  String curriculumName;
  String curriculumCode; 
  String introduce;
  boolean levelTest;
  int limit;

  public Curriculum() {}

  public Curriculum(String curriculumName, String introduce, boolean levelTest, int limit) {
    super();
    this.curriculumName = curriculumName;
    this.introduce = introduce;
    this.levelTest = levelTest;
    this.limit = limit;
  }

  public String getCurriculumName() {
    return curriculumName;
  }

  public void setCurriculumName(String curriculumName) {
    this.curriculumName = curriculumName;
  }

  public String getCurriculumCode() {
    return curriculumCode;
  }

  public void setCurriculumCode(String curriculumCode) {
    this.curriculumCode = curriculumCode;
  }
  
  public String getIntroduce() {
    return introduce;
  }

  public void setIntroduce(String introduce) {
    this.introduce = introduce;
  }

  public boolean isLevelTest() {
    return levelTest;
  }

  public void setLevelTest(boolean levelTest) {
    this.levelTest = levelTest;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  @Override
  public String toString() {
    return "Curriculum [curriculumName=" + curriculumName + ", curriculumCode=" + curriculumCode + ", introduce="
        + introduce + ", levelTest=" + levelTest + ", limit=" + limit + "]";
  }
}
