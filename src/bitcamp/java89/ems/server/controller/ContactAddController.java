package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ContactDao;
import bitcamp.java89.ems.server.vo.Contact;

public class ContactAddController implements Command {
  //  public ContactAddController() { //이 생성자는 EduAppServer에서 호출
  //    contactDao = ContactDao.getInstance(); // --> 파일 load 됨
  //  }

  public void service(HashMap<String, String> paramMap, PrintStream out) {
    try {
      ContactDao contactDao = ContactDao.getInstance();

      if (contactDao.existEmail(paramMap.get("email"))) {
        out.println("같은 이메일이 존재합니다. 등록을 취소합니다.");
        return;
      }


      Contact contact = new Contact();
      contact.setName(paramMap.get("name"));
      contact.setPosition(paramMap.get("position"));
      contact.setTel(paramMap.get("tel"));
      contact.setEmail(paramMap.get("email"));


      contactDao.insert(contact);
      out.println("등록하였습니다.");
    } catch (Exception e) {
      out.println("작업 중 오류가 발생하였습니다.");
      e.printStackTrace();
    }
  }

}
