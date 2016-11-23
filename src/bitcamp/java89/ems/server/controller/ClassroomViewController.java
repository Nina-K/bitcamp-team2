package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ClassroomDao;
import bitcamp.java89.ems.server.vo.Classroom;

public class ClassroomViewController implements Command {
  private ClassroomDao classroomDao;
  
  public ClassroomViewController() {
    classroomDao = ClassroomDao.getInstance();
  }
  
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    ArrayList<Classroom> list = classroomDao.getListByName(paramMap.get("name"));
    for (Classroom classroom : list) {
        out.println("-----------------------------");
        out.printf("강의실 이름: %s\n", classroom.getName());
        out.printf("층수: %d\n", classroom.getFloors());
        out.printf("최대수용인원: %d\n", classroom.getMaximumSeating());
        out.printf("최대이용기간: %s\n", classroom.getMaximumPeriod());
        out.printf("이용시간: %s\n", classroom.getTime());
        out.printf("암호: (****)\n");
        out.printf("프로젝터 여부: %b\n", (classroom.isProjector()) ? "Yes" : "No");
        out.printf("사물함 여부: %b\n", (classroom.isLocker()) ? "Yes" : "No");
        out.printf("에어컨 여부: %b\n", (classroom.isConditioner()) ? "Yes" : "No");
    }
   }
  }

