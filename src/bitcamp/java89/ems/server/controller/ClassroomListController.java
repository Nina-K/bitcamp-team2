package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ClassroomDao;
import bitcamp.java89.ems.server.vo.Classroom;

public class ClassroomListController implements Command {
  private ClassroomDao classroomDao;
  
  public ClassroomListController() {
    classroomDao = ClassroomDao.getInstance();
  }
  
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    ArrayList<Classroom> list = classroomDao.getList();
    for (Classroom classroom : list) {
      out.printf("%s, %d, %d, %s, %s, %s, %s, %s, %s\n",
        classroom.getName(),
        classroom.getFloors(),
        classroom.getMaximumSeating(),
        classroom.getMaximumPeriod(),
        classroom.getTime(),
        classroom.getPassword(),
        ((classroom.isProjector())?"yes":"no"),
        ((classroom.isLocker())?"yes":"no"),
        ((classroom.isConditioner())?"yes":"no"));
    }
  }
}
