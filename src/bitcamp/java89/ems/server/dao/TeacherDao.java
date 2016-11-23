
package bitcamp.java89.ems.server.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bitcamp.java89.ems.server.vo.Teacher;

public class TeacherDao {
  static TeacherDao obj;
  private ArrayList<Teacher> list;
  private String filename = "teacheructor-v1.7.data";

  
  private TeacherDao() {
    this.load();
  }

  public static TeacherDao getInstance() {
    if (obj == null) {
      obj = new TeacherDao();
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

      list = (ArrayList<Teacher>)in.readObject();

    } catch (EOFException e) {
    } catch (Exception e) {
      System.out.println("강사 데이터 로딩 중 오류 발생!");
      list = new ArrayList<>();
      
    } finally {
      try {
        in.close();
        in0.close();
      } catch (Exception e) {}
    }
  }




  public void save() throws Exception {
    FileOutputStream out0 = new FileOutputStream(this.filename);
    ObjectOutputStream out = new ObjectOutputStream(out0);


    out.writeObject(list);

    out0.close();
    out.close();
  }


  public void insert(Teacher teacher) {
    list.add(teacher);
    try {this.save();} catch (Exception e) {}
  }


  public boolean existName(String name) {
    for (Teacher teacher : list) {
      if (teacher.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }


  public ArrayList<Teacher> getList() {
    return this.list;
  }
  
  
  
  public ArrayList<Teacher> getListByName(String name) {
    ArrayList<Teacher> results = new ArrayList<>();
    
    for (Teacher teacher : list) {
      if (teacher.getName().equals(name)) {
        results.add(teacher);
      }
    }
    
    return results;
  }
  


  public void delete(String name) { //이름을 넘겨 받음.
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getName().equals(name)) {
        list.remove(i);
        try {this.save();} catch (Exception e) {}
        return;
      }
    }
  }




  public void update(Teacher teacher) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getName().equals(teacher.getName())) {
        list.set(i, teacher);
        try {this.save();} catch (Exception e) {}
        return;
      }
    }
  }
  
}
