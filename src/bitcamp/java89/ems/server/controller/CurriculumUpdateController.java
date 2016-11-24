package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.CurriculumDao;
import bitcamp.java89.ems.server.vo.Curriculum;

public class CurriculumUpdateController implements Command {
  private CurriculumDao curriculumDao; 

  public CurriculumUpdateController() {
    curriculumDao = CurriculumDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (!curriculumDao.exsitCode(paramMap.get("code")))  {
      out.println("일치하는 정보가 없습니다.");
      return;
    }

    Curriculum curriculum = new Curriculum();
    curriculum.setCurriculumName(paramMap.get("name"));
    curriculum.setCurriculumCode(paramMap.get("code"));
    curriculum.setIntroduce(paramMap.get("introduce"));
    curriculum.setLevelTest(paramMap.get("test").toLowerCase().equals("y")? true : false);
    curriculum.setLimit(Integer.parseInt(paramMap.get("limit")));

    curriculumDao.update(curriculum);
    out.println("수정하였습니다.");
  }
}
