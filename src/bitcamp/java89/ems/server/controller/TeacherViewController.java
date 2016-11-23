package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.TeacherDao;
import bitcamp.java89.ems.server.vo.Teacher;

public class TeacherViewController implements Command {
  private TeacherDao teacherDao;

  public TeacherViewController() {
    teacherDao = TeacherDao.getInstance(); // --> 파일 load 됨
  }
  
  public void service(HashMap<String, String> paramMap, PrintStream out) {
    for (Teacher teacher : teacherDao.getListByName(paramMap.get("name"))) {
      if (teacher.getName().equals(paramMap.get("name"))) {
        out.printf("이름: %s\n", teacher.getName());
        out.printf("담당강의: %s\n", teacher.getLectureName());
        out.printf("회사경력: %s\n", teacher.getJobCareer());
        out.printf("강의경력: %s\n", teacher.getLectureCareer());
        out.printf("저서: %s\n", teacher.getBook());
        out.printf("학력: %s\n", teacher.getSchool());
        out.printf("강의평가: %s\n", teacher.getAppraisal());
        out.printf("웹사이트: %s\n", teacher.getWebSite());
        out.printf("수상내역: %s\n", teacher.getPrize());
      }
    }
  }
  
}
