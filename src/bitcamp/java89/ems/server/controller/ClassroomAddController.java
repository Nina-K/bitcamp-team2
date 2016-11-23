package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ClassroomDao;
import bitcamp.java89.ems.server.vo.Classroom;

public class ClassroomAddController implements Command {
  private ClassroomDao classroomDao;
  
  public ClassroomAddController() {
    classroomDao = ClassroomDao.getInstance();
  }
  
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (classroomDao.existName(paramMap.get("name"))) {
      out.println("같은 강의실이 존재합니다. 등록을 취소합니다.");
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

    classroomDao.insert(classroom);
    out.println("등록하였습니다.");
    }
  }

