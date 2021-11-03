package org.rapidpm.microstream.demo;


import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

  private HelloWorld() {
  }

  private static record Wheel(int size) {
  }

  private static record Cylinder(int size) {
  }

  private static class Engine {
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

  public static class Car {
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
  }


  private static class RootNode {
    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
      return cars;
    }
  }


  public static void main(String[] args) {
    RootNode rootNode = new RootNode();

    final EmbeddedStorageManager storageManager = EmbeddedStorage.start(
        rootNode,             // root object
        Paths.get("_data")
    );
    storageManager.setRoot(rootNode);
    storageManager.storeRoot();

    //modify the root node
    rootNode.getCars().add(createCar());

    //get all cars with an Engine with 4 cylinders
    List<Car> result = rootNode.getCars().stream()
        .filter(c -> {
          int size = c.getEngine().getCylinders().size();
          return size == 4;
        })
        .toList();

    System.out.println("result = " + result.size());

    // shutdown storage
    storageManager.close();
//    storageManager.shutdown();
    System.exit(0);
  }

  @NotNull
  private static Car createCar() {
    Car car001 = new Car();
    car001.setWheels(List.of(new Wheel(1),
        new Wheel(1),
        new Wheel(1),
        new Wheel(1)));
    Engine engine = new Engine();
    engine.setCylinders(List.of(new Cylinder(1),
        new Cylinder(1),
        new Cylinder(1),
        new Cylinder(1)));
    engine.setPowerInPS(123);
    car001.setEngine(engine);
    return car001;
  }


}
