package org.rapidpm.microstream.demo.solution02;

import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Paths;
import java.util.List;

public class Solution02 {
  private Solution02() {
  }

  public static void main(String[] args) {
    RootNode rootNode = new RootNode();

    final EmbeddedStorageManager storageManager = EmbeddedStorage.start(
        rootNode, Paths.get("_data/solution02")
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
