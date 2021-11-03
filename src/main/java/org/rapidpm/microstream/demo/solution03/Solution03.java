package org.rapidpm.microstream.demo.solution03;

import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Paths;
import java.util.List;

public class Solution03 {
  private Solution03() {
  }

  public static void main(String[] args) {
    RootNode rootNode = new RootNode();

    final EmbeddedStorageManager storageManager = EmbeddedStorage.start(
        rootNode, Paths.get("_data/solution03")
    );
    storageManager.setRoot(rootNode);
    storageManager.storeRoot();

    //modify the root node
    Car car = createCar();
    rootNode.addCar(car);
    //get all cars with an Engine with 4 cylinders
    //this is the Query
    int sum = rootNode.sumOfCarsWithAmountOfCylinders(4);

    System.out.println("result = " + sum);
    // shutdown storage
    storageManager.close();
//    storageManager.shutdown();
    System.exit(0);
  }

  @NotNull
  private static Car createCar() {
    Car car001 = new Car();
    car001.addWheels(List.of(new Wheel(1),
        new Wheel(1),
        new Wheel(1),
        new Wheel(1)));
    Engine engine = new Engine();
    engine.addCylinders(List.of(new Cylinder(1, 1),
        new Cylinder(2, 1),
        new Cylinder(3, 1),
        new Cylinder(4, 1)));
    engine.setPowerInPS(123);
    car001.setEngine(engine);
    return car001;
  }

}
