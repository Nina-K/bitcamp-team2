
package bitcamp.java89.ems.server.dao;

import java.util.ArrayList;

import bitcamp.java89.ems.server.vo.Teacher;

public class TeacherDao extends AbstractDao<Teacher> {
  static TeacherDao obj;

  
  public static TeacherDao getInstance() throws Exception {
    if (obj == null) {
      obj = new TeacherDao();
      obj.load();
    }
    return obj;
  }

  private TeacherDao() throws Exception {
    super("teacher-v1.9.data");
  }


  public void insert(Teacher teacher) {
    list.add(teacher);
    try {this.save();

    } catch (Exception e) {}
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
