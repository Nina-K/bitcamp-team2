package bitcamp.java89.ems.server.vo;

import java.io.Serializable;

public class Classroom implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected String name;
  protected int floors;
  protected int maximumSeating;
  protected String maximumPeriod;
  protected String time;
  protected String password;
  protected boolean projector;
  protected boolean locker;
  protected boolean conditioner;

  public Classroom() {}

  public Classroom(String name, int floors, int maximumSeating, String maximumPeriod, String time, String password, boolean projector, boolean locker, boolean conditioner) {
    this.name = name;
    this.floors = floors;
    this.maximumSeating = maximumSeating;
    this.maximumPeriod = maximumPeriod;
    this.time = time;
    this.password = password;
    this.projector = projector;
    this.locker = locker;
    this.conditioner = conditioner;

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getFloors() {
    return floors;
  }

  public void setFloors(int floors) {
    this.floors = floors;
  }

  public int getMaximumSeating() {
    return maximumSeating;
  }

  public void setMaximumSeating(int maximumSeating) {
    this.maximumSeating = maximumSeating;
  }

  public String getMaximumPeriod() {
    return maximumPeriod;
  }

  public void setMaximumPeriod(String string) {
    this.maximumPeriod = string;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isProjector() {
    return projector;
  }

  public void setProjector(boolean projector) {
    this.projector = projector;
  }

  public boolean isLocker() {
    return locker;
  }

  public void setLocker(boolean locker) {
    this.locker = locker;
  }

  public boolean isConditioner() {
    return conditioner;
  }

  public void setConditioner(boolean conditioner) {
    this.conditioner = conditioner;
  }

  @Override
  public String toString() {
    return "Classroom [name=" + name + ", floors=" + floors + ", maximumSeating=" + maximumSeating + ", maximumPeriod="
        + maximumPeriod + ", time=" + time + ", password=" + password + ", projector=" + projector + ", locker="
        + locker + ", conditioner=" + conditioner + "]";
  } //중간중간 데이터를 확인하기 위해서 toString을 Override
 
  
}
