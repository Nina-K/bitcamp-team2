package bitcamp.java89.ems.server.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bitcamp.java89.ems.server.vo.Curriculum;

public class CurriculumDao {
  static CurriculumDao obj; 

  private String fileName = "Curriculum-v1.8.data";
  private ArrayList<Curriculum> list;

  public static CurriculumDao getInstance() {
    if (obj == null) {
      obj = new CurriculumDao(); 
    }
    return obj; 
  }

  private CurriculumDao() { 
    this.load(); 
  }

  @SuppressWarnings("unchecked")
  private void load() {
    FileInputStream in0 = null;
    ObjectInputStream in = null;
    try {
      in0 = new FileInputStream(this.fileName);
      in = new ObjectInputStream(in0);
      list = (ArrayList<Curriculum>)in.readObject();
    } catch (EOFException e) {
    } catch (Exception e) {
      System.out.println("강좌정보 로딩 중 오류 발생!");
      list = new ArrayList<Curriculum>(); 
    } finally {
      try {
        in.close();
        in0.close();
      } catch (Exception e) {}
    }
  }

  synchronized public void save() throws Exception {
    FileOutputStream out0 = new FileOutputStream(this.fileName);
    ObjectOutputStream out = new ObjectOutputStream(out0);

    out.writeObject(list);

    out.close();
    out0.close();
  }

  public ArrayList<Curriculum> getList() {
    return this.list; 
  }

  public ArrayList<Curriculum> getListByName (String name) {
    ArrayList<Curriculum> results = new ArrayList<>();
    for (Curriculum curriculm : list) {
      if (curriculm.getCurriculumName().equals(name)) {
        results.add(curriculm); 
      }
    }
    return results; 
  }

  synchronized public void insert(Curriculum curriculm) {
    list.add(curriculm);
    System.out.println("CurriculumLog: inserted"); // 
    try {
      this.save();
      System.out.println("CurriculumLog: save");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  synchronized public void update(Curriculum curriculm) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getCurriculumCode().equals(curriculm.getCurriculumCode())) {
        list.set(i, curriculm); 
        System.out.println("CurriculumLog: updated");
        try {
          this.save();
          System.out.println("CurriculumLog: save");
        } catch (Exception e) {}
        return; 
      }
    }
  }

  synchronized public void delete(String code) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getCurriculumCode().equals(code)) {
        list.remove(i);
        System.out.println("CurriculumLog: deleted");
        try {
          this.save();
          System.out.println("CurriculumLog: save");  
        } catch (Exception e) {}
        return;
      }
    }
  }

  public boolean exsitCode(String code) {
    for (Curriculum curriculm : list) {
      if (curriculm.getCurriculumCode().toLowerCase().equals(code.toLowerCase())) {
        return true;
      }
    }
    return false;
  }
}
