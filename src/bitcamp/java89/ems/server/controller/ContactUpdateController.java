package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ContactDao;
import bitcamp.java89.ems.server.vo.Contact;

public class ContactUpdateController implements Command {

  public void service(HashMap<String, String> paramMap, PrintStream out) {
    try {
      ContactDao contactDao = ContactDao.getInstance();

      if (!contactDao.existEmail(paramMap.get("email"))) {
        out.println("이메일을 찾지 못했습니다.");
        return;
      }

      Contact contact = new Contact();
      contact.setEmail(paramMap.get("email"));
      contact.setName(paramMap.get("name"));
      contact.setPosition(paramMap.get("position"));
      contact.setTel(paramMap.get("tel"));


      contactDao.update(contact);
      out.println("변경 하였습니다.");

    } catch (Exception e) {
      out.println("작업 중 오류가 발생했습니다.");
      e.printStackTrace();
    }
  }
}