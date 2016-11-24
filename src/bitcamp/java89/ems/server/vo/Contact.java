package bitcamp.java89.ems.server.vo;

import java.io.Serializable;

public class Contact implements Serializable {
  private static final long serialVersionUID = 1L;

  protected String name;
  protected String position;
  protected String tel;
  protected String email;
  
  public Contact() {
    super(); //수퍼는 무조건 붙여야하지만, 내가 놓지 않으면 컴파일러가 자동으로 붙인다.
  }

  public Contact(String name, String position, String tel, String email) {
    this.name = name;
    this.position = position;
    this.tel = tel;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Contact [name=" + name + ", position=" + position + ", tel=" + tel + ", email=" + email + "]";
  }
}
