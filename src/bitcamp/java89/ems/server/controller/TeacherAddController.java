package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.TeacherDao;
import bitcamp.java89.ems.server.vo.Teacher;

public class TeacherAddController implements Command {
  private TeacherDao teacherDao;

  public TeacherAddController() {
    teacherDao = TeacherDao.getInstance(); // --> 파일 load 됨
  }
  
  public void service(HashMap<String, String> paramMap, PrintStream out) {
    if (teacherDao.existName(paramMap.get("name"))) {
      out.println("입력하신 성함의 강사님의 정보가 이미 존재합니다.");
      return;
    }

    Teacher teacher = new Teacher();
    teacher.setName(paramMap.get("name"));
    teacher.setLectureName(paramMap.get("lectureName"));
    teacher.setJobCareer(paramMap.get("jobCareer"));
    teacher.setLectureCareer(paramMap.get("lectureCareer"));
    teacher.setBook(paramMap.get("book"));
    teacher.setSchool(paramMap.get("school"));
    teacher.setAppraisal(paramMap.get("appraisal"));
    teacher.setWebSite(paramMap.get("webSite"));
    teacher.setPrize(paramMap.get("prize"));


    teacherDao.insert(teacher);
    out.println("등록하였습니다.");
  }
  
}
