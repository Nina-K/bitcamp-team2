package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.CurriculumDao;
import bitcamp.java89.ems.server.vo.Curriculum;

public class CurriculumAddController implements Command {
  private CurriculumDao curriculumDao; 

  public CurriculumAddController() {
    curriculumDao = CurriculumDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (curriculumDao.exsitCode(paramMap.get("code")))  {
      out.println("강좌코드가 중복되어 등록을 취소합니다.");
      return;
    }

    Curriculum curriculum = new Curriculum();
    curriculum.setCurriculumName(paramMap.get("name"));
    curriculum.setCurriculumCode(paramMap.get("code"));
    curriculum.setIntroduce(paramMap.get("introduce"));
    curriculum.setLevelTest(paramMap.get("test").toLowerCase().equals("y"));
    curriculum.setLimit(Integer.parseInt(paramMap.get("limit")));

    curriculumDao.insert(curriculum);
    out.println("등록하였습니다.");
  }
}
