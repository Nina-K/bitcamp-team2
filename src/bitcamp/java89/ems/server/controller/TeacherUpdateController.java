package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.TeacherDao;
import bitcamp.java89.ems.server.vo.Teacher;

public class TeacherUpdateController implements Command {
  private TeacherDao teacherDao;

  public TeacherUpdateController() {
    teacherDao = TeacherDao.getInstance(); // --> 파일 load 됨
  }
  
  public void service(HashMap<String, String> paramMap, PrintStream out) {
    if (!teacherDao.existName(paramMap.get("name"))) {
      out.println("입력하신 성함의 강사님 정보을 찾지 못했습니다.");
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
    teacher.setWebsite(paramMap.get("website"));
    teacher.setPrize(paramMap.get("prize"));
    
    teacherDao.update(teacher);
    out.println("변경 하였습니다.");
  }
  
}
