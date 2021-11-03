package org.rapidpm.microstream.demo.solution03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Engine {
  private List<Cylinder> cylinders = new ArrayList<>();
  private int powerInPS;
  private int amountCylinders;

  public List<Cylinder> getCylinders() {
    return Collections.unmodifiableList(cylinders);
  }

  public void addCylinder(Cylinder cylinder) {
    cylinders.add(cylinder);
    amountCylinders = cylinders.size();
  }

  public void addCylinders(List<Cylinder> cylinderList) {
    cylinders.addAll(cylinderList);
    amountCylinders = cylinders.size();
  }

  public void removeCylinder(Cylinder cylinder) {
    cylinders.remove(cylinder);
    amountCylinders = cylinders.size();
  }

  public void removeCylinderAtPosition(int position) {
    cylinders.removeIf(cylinder -> cylinder.position() == position);
    amountCylinders = cylinders.size();
  }

  public int getPowerInPS() {
    return powerInPS;
  }

  public void setPowerInPS(int powerInPS) {
    this.powerInPS = powerInPS;
  }

  public int getAmountCylinders() {
    return amountCylinders;
  }
}
