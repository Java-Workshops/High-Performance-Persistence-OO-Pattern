package org.rapidpm.microstream.demo.solution03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {
  private Engine engine;
  private List<Wheel> wheels = new ArrayList<>();
  private int amountOfWheels;

  public Engine getEngine() {
    return engine;
  }

  public void setEngine(Engine engine) {
    this.engine = engine;
  }

  public List<Wheel> getWheels() {
    return Collections.unmodifiableList(wheels);
  }

  public void addWheel(Wheel wheel) {
    wheels.add(wheel);
    amountOfWheels = wheels.size();
  }

  public void addWheels(List<Wheel> wheelList) {
    wheels.addAll(wheelList);
    amountOfWheels = wheels.size();
  }

  //prepare for Queries
  public int amountOfCylinders() {
    return getEngine().getAmountCylinders();
  }

  public int getAmountOfWheels() {
    return amountOfWheels;
  }
}
