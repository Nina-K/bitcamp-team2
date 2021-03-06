package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.TeacherDao;

public class TeacherDeleteController implements Command {
  public void service(HashMap<String, String> paramMap, PrintStream out) {
    try {
      TeacherDao teacherDao = TeacherDao.getInstance();
      if (!teacherDao.existName(paramMap.get("name"))) {
        out.println("입력하신 성함의 강사님 정보를 찾지 못했습니다.");
        return;
      }
      
      
      teacherDao.delete(paramMap.get("name"));
      out.println("해당 데이터를 삭제했습니다.");
    } catch (Exception e) {
      out.println("작업 중 오류가 발생했습니다.");
    }
  }
  
}
