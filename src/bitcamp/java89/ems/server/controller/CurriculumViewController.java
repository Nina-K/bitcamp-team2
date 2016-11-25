package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.CurriculumDao;
import bitcamp.java89.ems.server.vo.Curriculum;

public class CurriculumViewController implements Command {
  private CurriculumDao curriculumDao; 

  public CurriculumViewController() {
    curriculumDao = CurriculumDao.getInstance();
  }

  @Override
  public void service(HashMap<String, String> paramMap, PrintStream out) {
    ArrayList<Curriculum> list = curriculumDao.getListByName(paramMap.get("name"));

    if (list.size() == 0) {
      out.println("일치하는 정보가 없습니다.");
      return;
    }

    for (Curriculum curriculum : list) {
      out.println("--------------------------------");
      out.printf("개설 강좌명: %s\n", curriculum.getCurriculumName());
      out.printf("강좌 소개: %s\n", curriculum.getIntroduce());
      out.printf("레벨 테스트: %s\n", curriculum.isLevelTest()? "있음":"없음");
      out.printf("인원제한: %d 명\n", curriculum.getLimit());
    }
    out.println("--------------------------------");
  }
}
