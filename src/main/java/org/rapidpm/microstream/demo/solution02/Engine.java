package org.rapidpm.microstream.demo.solution02;

import java.util.List;

class Engine {
  private List<Cylinder> cylinders;
  private int powerInPS;

  public List<Cylinder> getCylinders() {
    return cylinders;
  }

  public void setCylinders(List<Cylinder> cylinders) {
    this.cylinders = cylinders;
  }

  public int getPowerInPS() {
    return powerInPS;
  }

  public void setPowerInPS(int powerInPS) {
    this.powerInPS = powerInPS;
  }
}
