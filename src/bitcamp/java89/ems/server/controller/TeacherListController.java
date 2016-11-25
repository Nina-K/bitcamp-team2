package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.TeacherDao;
import bitcamp.java89.ems.server.vo.Teacher;

public class TeacherListController implements Command {
  public void service(HashMap<String, String> paramMap, PrintStream out) {
    try {
      TeacherDao teacherDao = TeacherDao.getInstance();
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
    } catch (Exception e) {
      out.println("작업 중 오류가 발생했습니다.");
    }
  }

}
