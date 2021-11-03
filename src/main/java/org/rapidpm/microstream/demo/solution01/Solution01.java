package org.rapidpm.microstream.demo.solution01;

import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Solution01 {

  private Solution01() {
  }

  public static void main(String[] args) {
    RootNode rootNode = new RootNode();

    final EmbeddedStorageManager storageManager = EmbeddedStorage.start(
        rootNode, Paths.get("_data/solution01")
    );
    storageManager.setRoot(rootNode);
    storageManager.storeRoot();

    //modify the root node
    rootNode.getCars().add(createCar());

    //get all cars with an Engine with 4 cylinders
    //this is the Query
//    Predicate<Car> carPredicate = c -> {
//      int size = c.getEngine().getCylinders().size();
//      return size == 4;
//    };
    Predicate<Car> carPredicate = c -> c.amountOfCylinders() == 4;


    List<Car> result = rootNode.getCars().stream()
        .filter(carPredicate)
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
