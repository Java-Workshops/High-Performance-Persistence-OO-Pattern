package org.rapidpm.microstream.demo.solution02;

import java.util.List;

public class Car {
  private Engine engine;
  private List<Wheel> wheels;

  public Engine getEngine() {
    return engine;
  }

  public void setEngine(Engine engine) {
    this.engine = engine;
  }

  public List<Wheel> getWheels() {
    return wheels;
  }

  public void setWheels(List<Wheel> wheels) {
    this.wheels = wheels;
  }

  //prepare for Queries
  public int amountOfCylinders() {
    return getEngine().getCylinders().size();
  }


}
