package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ClassroomDao;
import bitcamp.java89.ems.server.vo.Classroom;

public class ClassroomUpdateController implements Command {
  private ClassroomDao classroomDao;
  
  public ClassroomUpdateController() {
    classroomDao = ClassroomDao.getInstance();
  }
  
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (!classroomDao.existName(paramMap.get("name"))) {
      out.println("이름을 찾지 못했습니다.");
      return;
    }
    
      Classroom classroom = new Classroom();
      classroom.setName(paramMap.get("name"));
      classroom.setFloors(Integer.parseInt(paramMap.get("floors")));
      classroom.setMaximumSeating(Integer.parseInt(paramMap.get("maximumSeating")));
      classroom.setMaximumPeriod(paramMap.get("maximumPeriod"));
      classroom.setTime(paramMap.get("time"));
      classroom.setPassword(paramMap.get("password"));
      classroom.setProjector((paramMap.get("projector").equals("y")) ? true : false);
      classroom.setLocker((paramMap.get("locker").equals("y")) ? true : false);
      classroom.setConditioner((paramMap.get("conditioner").equals("y")) ? true : false);
      
      classroomDao.update(classroom);
      out.println("저장하였습니다.");
    }
   }
  

