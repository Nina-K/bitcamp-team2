package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.TeacherDao;
import bitcamp.java89.ems.server.vo.Teacher;

public class TeacherAddController implements Command {
  
  public void service(HashMap<String, String> paramMap, PrintStream out) {
    try {
      TeacherDao teacherDao = TeacherDao.getInstance();
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
      teacher.setWebsite(paramMap.get("website"));
      teacher.setPrize(paramMap.get("prize"));
  
  
      teacherDao.insert(teacher);
      out.println("등록하였습니다.");
    } catch (Exception e) {
      out.println("작업 중 오류가 발생했습니다.");
    }
  }
  
}
