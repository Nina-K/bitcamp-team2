package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ClassroomDao;

public class ClassroomDeleteController implements Command {
  private ClassroomDao classroomDao;
  
  public ClassroomDeleteController() {
    classroomDao = ClassroomDao.getInstance();
  }
  
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (!classroomDao.existName(paramMap.get("name"))) {
      out.println("해당 데이터가 없습니다.");
      return;
    }
    
    classroomDao.delete(paramMap.get("name"));
    out.println("해당 데이터 삭제 완료하였습니다.");
    }
   }
  

