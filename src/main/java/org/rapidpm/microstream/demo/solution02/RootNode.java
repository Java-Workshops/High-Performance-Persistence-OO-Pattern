package org.rapidpm.microstream.demo.solution02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RootNode {
  private final List<Car> cars = new ArrayList<>();

  //NOT Immutable !!
  public List<Car> getCars() {
    return cars;
  }

  private Map<Integer, List<Car>> queryForAmountOfCylinders = new HashMap<>();

  public void addCar(Car c) {
    getCars().add(c);
    int amount = c.getEngine().getCylinders().size();
    queryForAmountOfCylinders.computeIfPresent(amount, (integer, cars) -> {
      cars.add(c);
      return cars;
    });

    queryForAmountOfCylinders.computeIfAbsent(amount, integer -> {
      List<Car> holder = new ArrayList<>();
      holder.add(c);
      return holder;
    });
  }

  public void removeCar(Car c) {
    getCars().remove(c);
    int amount = c.getEngine().getCylinders().size();
    queryForAmountOfCylinders.computeIfPresent(amount, (integer, cars) -> {
      cars.remove(c);
      return cars;
    });
  }

  //Query
  public int sumOfCarsWithAmountOfCylinders(int i) {
    return listOfCarsWithAmountOfCylinders(i).size();
  }

  public List<Car> listOfCarsWithAmountOfCylinders(int i) {
    return queryForAmountOfCylinders.getOrDefault(i, List.of());
  }
}
