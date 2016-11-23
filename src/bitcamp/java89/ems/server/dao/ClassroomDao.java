/* ObjectInputStream와 ObjectOutputStream는 객체형태(ArrayList)를 입출력할 수 있다.
 * list에 있는 내용을 통째로 Input해서, Output으로 담은 것 전체를 출력해주는 것
 * list = (ArrayList<Classroom>)in.readObject();
   => readObject가 Classroom 형태의 ArrayList이다(타입캐스팅). 이걸 list에 담아라
 * out.writeObject(list); - 통째로 출력
 * */

package bitcamp.java89.ems.server.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bitcamp.java89.ems.server.vo.Classroom;

public class ClassroomDao {
  static ClassroomDao obj;

  private String filename = "classroom-v1.7.data";
  private ArrayList<Classroom> list;

  public ClassroomDao() {
    this.load();
  }

  public static ClassroomDao getInstance() {
    if (obj == null) {
      obj = new ClassroomDao();
    }
    return obj;
  }

  @SuppressWarnings("unchecked")
  private void load() {
    FileInputStream in0 = null;
    ObjectInputStream in = null;

    try {
      in0 = new FileInputStream(this.filename);
      in = new ObjectInputStream(in0);

    list = (ArrayList<Classroom>)in.readObject();
    // readObject가 Classroom 형태의 ArrayList이다(타입캐스팅). 이걸 list에 담아라

    } catch (EOFException e) {

    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류 발생!");
      list = new ArrayList<>();
    } finally {
      try {
        in.close();
        in0.close();
      } catch (Exception e) {

      }
    }
  }

  public void save() throws Exception {

    FileOutputStream out0 = new FileOutputStream(this.filename);
    ObjectOutputStream out = new ObjectOutputStream(out0);

    out.writeObject(list); //list를 통째로 출력해버린 것

    out.close();
    out0.close();
  }

  public ArrayList<Classroom> getList() {
    return this.list;
    }
  
  public ArrayList<Classroom> getListByName(String name) { // doView 역할
    ArrayList<Classroom> results = new ArrayList<>();
    for (Classroom classroom : list) {
      if (classroom.getName().equals(name)) {
        results.add(classroom);
      }
    }
    return results;
  }
  
  
  synchronized public void insert(Classroom classroom) { // doAdd
    list.add(classroom);
    try {this.save();} catch (Exception e) {}
    }
  
  synchronized public void delete(String name) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getName().equals(name)) {
        list.remove(i);
        try {this.save();} catch (Exception e) {}
        break;
        }
      }
    }

    //update?name=강의실301&floors=4&maximumSeating=400&maximumPeriod=4&time=08:00~14:00&password=4000&projector=n&locker=y&conditioner=y
  synchronized public void update(Classroom classroom) {
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getName().equals(classroom.getName())) {
          list.set(i, classroom);
          try {this.save();} catch (Exception e) {}
          return;
        }
      } 
    }
  
    public boolean existName(String name) { 
      for (Classroom classroom : list) {
        if (classroom.getName().toLowerCase().equals(name.toLowerCase())) {
          return true;
        }
      }
      return false;
  }
}
