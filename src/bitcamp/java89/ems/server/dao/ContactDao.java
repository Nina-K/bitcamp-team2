/* ObjectInputStream와 ObjectOutputStream는 객체형태(ArrayList)를 입출력할 수 있다.
 * list에 있는 내용을 통째로 Input해서, Output으로 담은 것 전체를 출력해주는 것
 * list = (ArrayList<Contact>)in.readObject();
   => readObject가 Contact 형태의 ArrayList이다(타입캐스팅). 이걸 list에 담아라
 * out.writeObject(list); - 통째로 출력
 * */

package bitcamp.java89.ems.server.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bitcamp.java89.ems.server.vo.Contact;

public class ContactDao {
  static ContactDao obj;
  
  private String filename = "contact-v1.8.data";
  private ArrayList<Contact> list;

  private ContactDao() {
    this.load();
  }
  
  public static ContactDao getInstance() {
    if (obj == null) {
      obj = new ContactDao();
    }
    return obj;
  }

  @SuppressWarnings("unchecked")
  private void load() {
    try (
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.filename));) {

        list = (ArrayList<Contact>)in.readObject();
        
        } catch (EOFException e) {

        } catch (Exception e) {
          e.printStackTrace();
          System.out.println("데이터 로딩 중 오류 발생!");
          list = new ArrayList<>();
          }
    }
  

  synchronized public void save() throws Exception {
    try (
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.filename));) {
 
      out.writeObject(list); //list를 통째로 출력해버린 것
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public ArrayList<Contact> getList() { //전체를 리턴함
    return this.list;
    }
  
  public ArrayList<Contact> getListByName(String name) { //이름으로 목록을 찾음 / doView 역할
    ArrayList<Contact> results = new ArrayList<>();
    for (Contact contact : list) {
      if (contact.getName().equals(name)) {
        results.add(contact);
      }
    }
    return results;
  }
  
  synchronized public void insert(Contact contact) { //doAdd 역할
    list.add(contact);
    try {this.save();} catch (Exception e) {} //무조건 save한다. 에러 나도 무시
  }
  
  synchronized public void update(Contact contact) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getEmail().equals(contact.getEmail())) {
        list.set(i, contact);
        try {this.save();} catch (Exception e) {} //무조건 save한다. 에러 나도 무시
        return;
      }
    }
  }
  
  synchronized public void delete(String email) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getEmail().equals(email)) {
        list.remove(i);
        try {this.save();} catch (Exception e) {} //무조건 save한다. 에러 나도 무시
        break;
      }
     } 
   } 
  
  public boolean existEmail(String email) { 
    for (Contact contact : list) {
      if (contact.getEmail().toLowerCase().equals(email.toLowerCase())) {
        return true;
      }
    }
    return false;
}
  
  
  
}
    
