package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.CurriculumDao;
import bitcamp.java89.ems.server.vo.Curriculum;

public class CurriculumListController implements Command {
  private CurriculumDao curriculumDao; 

  public CurriculumListController() {
    curriculumDao = CurriculumDao.getInstance();
  }
  
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    ArrayList<Curriculum> list = curriculumDao.getList(); 
    for (Curriculum curriculum : list) {
      out.printf("%s, %s, %s, %s, %d 명\n",
          curriculum.getCurriculumName(),
          curriculum.getCurriculumCode(),
          curriculum.getIntroduce(),
          curriculum.isLevelTest()? "있음":"없음",
          curriculum.getLimit());
    }
  }
}
