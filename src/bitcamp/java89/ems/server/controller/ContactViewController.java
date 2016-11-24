/* ObjectInputStream와 ObjectOutputStream는 객체형태(ArrayList)를 입출력할 수 있다.
 * list에 있는 내용을 통째로 Input해서, Output으로 담은 것 전체를 출력해주는 것
 * list = (ArrayList<Contact>)in.readObject();
   => readObject가 Contact 형태의 ArrayList이다(타입캐스팅). 이걸 list에 담아라
 * out.writeObject(list); - 통째로 출력
 * */

package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ContactDao;
import bitcamp.java89.ems.server.vo.Contact;

public class ContactViewController implements Command {
  private ContactDao contactDao;

  public ContactViewController() {
    contactDao = ContactDao.getInstance();
  }
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    
      ArrayList<Contact> list = contactDao.getListByName(paramMap.get("name"));
      for (Contact contact : list) {
          out.println("-----------------------------");
          out.printf("이름: %s\n", contact.getName());
          out.printf("직위: %s\n", contact.getPosition());
          out.printf("전화: %s\n", contact.getTel());
          out.printf("이메일: %s\n", contact.getEmail());
        }
      }
  }