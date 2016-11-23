package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.TeacherDao;
import bitcamp.java89.ems.server.vo.Teacher;

public class TeacherListController implements Command {
  private TeacherDao teacherDao;

  public TeacherListController() {
    teacherDao = TeacherDao.getInstance(); // --> 파일 load 됨
  }
  
  public void service(HashMap<String, String> paramMap, PrintStream out) {
    for (Teacher teacher : teacherDao.getList()) {
      out.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
          teacher.getName(),
          teacher.getLectureName(),
          teacher.getJobCareer(),
          teacher.getLectureCareer(),
          teacher.getBook(),
          teacher.getSchool(),
          teacher.getAppraisal(),
          teacher.getWebsite(),
          teacher.getPrize());
    }
  }
  
}
