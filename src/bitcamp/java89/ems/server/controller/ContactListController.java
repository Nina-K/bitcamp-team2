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

public class ContactListController implements Command {
  private ContactDao contactDao;

  public ContactListController() {
  
    contactDao = ContactDao.getInstance();
  }

  //한 클래스에 대해서 하나의 명령어만 집중하면 된다.
  //EduAppServer가 호출하게 되어있다.
  //(앞으로도 호출자가 누구인지를 확실히 찾아야한다.) (내가 구현하는 입장인가, 사용하는 입장인가) 
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    ArrayList<Contact> list = contactDao.getList();
    for (Contact contact : list) {
      out.printf("%s, %s, %s, %s\n",
        contact.getName(),
        contact.getPosition(),
        contact.getTel(),
        contact.getEmail());
    }
  }

}
    
