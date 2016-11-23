package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.TeacherDao;

public class TeacherDeleteController implements Command {
  private TeacherDao teacherDao;

  public TeacherDeleteController() {
    teacherDao = TeacherDao.getInstance(); // --> 파일 load 됨
  }
  
  public void service(HashMap<String, String> paramMap, PrintStream out) {
    if (!teacherDao.existName(paramMap.get("name"))) {
      out.println("입력하신 성함의 강사님 정보를 찾지 못했습니다.");
      return;
    }
    
    
    teacherDao.delete(paramMap.get("name"));
    out.println("해당 데이터를 삭제했습니다.");
  }
  
}
