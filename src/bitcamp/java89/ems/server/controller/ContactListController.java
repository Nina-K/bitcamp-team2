package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ContactDao;
import bitcamp.java89.ems.server.vo.Contact;

public class ContactListController implements Command {


  public void service(HashMap<String, String> paramMap, PrintStream out) {
    try {
      ContactDao contactDao = ContactDao.getInstance();
      ArrayList<Contact> list = contactDao.getList();
      for (Contact contact : list) {
        out.printf("%s,%s,%s,%s\n",
            contact.getName(),
            contact.getPosition(),
            contact.getTel(),
            contact.getEmail());
      }
    } catch (Exception e) {
      out.println("작업 중 오류가 발생했습니다.");
      e.printStackTrace();
    }
  }

}
