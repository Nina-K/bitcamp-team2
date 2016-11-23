package bitcamp.java89.ems.server.vo;

import java.io.Serializable;

public class Teacher implements Serializable {

  private static final long serialVersionUID = 1L;
  
  protected String name;
  protected String lectureName;
  protected String jobCareer;
  protected String lectureCareer;
  protected String book;
  protected String school;
  protected String appraisal;
  protected String website;
  protected String prize;


  public Teacher() {}

  public Teacher(String name, String lectureName, String lectureCareer) {
    this.name = name;
    this.lectureName = lectureName;
    this.lectureCareer = lectureCareer;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLectureName() {
    return lectureName;
  }

  public void setLectureName(String lectureName) {
    this.lectureName = lectureName;
  }

  public String getJobCareer() {
    return jobCareer;
  }

  public void setJobCareer(String jobCareer) {
    this.jobCareer = jobCareer;
  }

  public String getLectureCareer() {
    return lectureCareer;
  }

  public void setLectureCareer(String lectureCareer) {
    this.lectureCareer = lectureCareer;
  }

  public String getBook() {
    return book;
  }

  public void setBook(String book) {
    this.book = book;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public String getAppraisal() {
    return appraisal;
  }

  public void setAppraisal(String appraisal) {
    this.appraisal = appraisal;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public String getPrize() {
    return prize;
  }

  public void setPrize(String prize) {
    this.prize = prize;
  }

  @Override
  public String toString() {
    return "Teacher [name=" + name + ", lectureName=" + lectureName + ", jobCareer=" + jobCareer + ", lectureCareer="
        + lectureCareer + ", book=" + book + ", school=" + school + ", appraisal=" + appraisal + ", website=" + website
        + ", prize=" + prize + "]";
  }
  
  
}
