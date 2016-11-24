package bitcamp.java89.ems.server;

import java.net.ServerSocket;
import java.util.HashMap;

import bitcamp.java89.ems.server.controller.ClassroomAddController;
import bitcamp.java89.ems.server.controller.ClassroomDeleteController;
import bitcamp.java89.ems.server.controller.ClassroomListController;
import bitcamp.java89.ems.server.controller.ClassroomUpdateController;
import bitcamp.java89.ems.server.controller.ClassroomViewController;
//import bitcamp.java89.ems.server.controller.ContactAddController;
//import bitcamp.java89.ems.server.controller.ContactDeleteController;
//import bitcamp.java89.ems.server.controller.ContactListController;
//import bitcamp.java89.ems.server.controller.ContactUpdateController;
//import bitcamp.java89.ems.server.controller.ContactViewController;
import bitcamp.java89.ems.server.controller.TeacherAddController;
import bitcamp.java89.ems.server.controller.TeacherDeleteController;
import bitcamp.java89.ems.server.controller.TeacherListController;
import bitcamp.java89.ems.server.controller.TeacherUpdateController;
import bitcamp.java89.ems.server.controller.TeacherViewController;


public class EduAppServer {
  HashMap<String, Command> commandMap = new HashMap<>();
  //클라이언트 요청을 처리할 Command 구현체들을 보관한다.

  public EduAppServer() {
//    commandMap.put("contact/list", new ContactListController());
//    commandMap.put("contact/view", new ContactViewController());
//    commandMap.put("contact/add", new ContactAddController());
//    commandMap.put("contact/delete", new ContactDeleteController());
//    commandMap.put("contact/update", new ContactUpdateController());

    commandMap.put("teacher/list", new TeacherListController());
    commandMap.put("teacher/view", new TeacherViewController());
    commandMap.put("teacher/add", new TeacherAddController());
    commandMap.put("teacher/update", new TeacherUpdateController());
    commandMap.put("teacher/delete", new TeacherDeleteController());

    commandMap.put("classroom/list", new ClassroomListController());
    commandMap.put("classroom/view", new ClassroomViewController());
    commandMap.put("classroom/add", new ClassroomAddController());
    commandMap.put("classroom/delete", new ClassroomDeleteController());
    commandMap.put("classroom/update", new ClassroomUpdateController());
  }
  //contact/add?name=1&position=2&tel=3&email=4
  //teacher/add?name=1&lectureName=2&jobCareer=3&lectureCareer=5&book=4&school=66&appraisal=5&website=7&prize=3


  private void service() throws Exception {
    ServerSocket ss = new ServerSocket(8888);
    System.out.println("서버 실행 중....");

    while (true) {
      new RequestThread(ss.accept(), commandMap).start();
    }
  }

  public static void main(String[] args) throws Exception {
    EduAppServer eduServer = new EduAppServer();
    eduServer.service();
  }
}
