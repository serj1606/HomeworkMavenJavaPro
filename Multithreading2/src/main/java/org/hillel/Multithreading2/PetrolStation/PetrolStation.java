package org.hillel.Multithreading2.PetrolStation;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.Getter;

@Getter
public class PetrolStation implements GasStation {
  volatile int amountOfFuelAtCistern;
  volatile int availableAmountOfFuel;

  private final int numberOfDispensers;
  private final AtomicInteger numberOfBusyDispensers = new AtomicInteger(0);

  public PetrolStation(int amountOfFuel, int numberOfDispensers) {
    amountOfFuelAtCistern = amountOfFuel;
    availableAmountOfFuel = amountOfFuel;

    this.numberOfDispensers = numberOfDispensers;
  }

  @Override
  public void doRefuel(int petrolRequest, String name) {
    new Thread(() -> startService(petrolRequest, name)).start();
  }

  public void startService(int petrolRequest, String name) {
    checkAvailabilityOfDispensers();

    try {
      createOrder(name, petrolRequest);
    } catch (TooBigOrderException e) {
      System.out.println(e.getMessage());
      leavePetrolStation();
      return;
    }

    fillUpTheCar(petrolRequest);

    System.out.println(name + " has got " + petrolRequest + ", amount of fuel at cistern left: " +
        amountOfFuelAtCistern);
    leavePetrolStation();
  }

  public synchronized void checkAvailabilityOfDispensers() {
    if (isAllBusy()) {
      try {
        wait();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    numberOfBusyDispensers.incrementAndGet();
  }

  public boolean isAllBusy() {
    return numberOfBusyDispensers.get() >= numberOfDispensers;
  }

  public void createOrder(String name, int petrolRequest) throws TooBigOrderException {
    System.out.println(name + " ordered " + petrolRequest + " liters");

    if (petrolRequest > availableAmountOfFuel) {
      throw new TooBigOrderException(name + "\'s order is too big");
    }

    decreaseAvailableAmountOfFuel(petrolRequest);
  }

  private void fillUpTheCar(int petrolRequest) {
    try {
      Thread.sleep((long) (Math.random() * 10000 + 3000));
      decreaseAmountOfFuelAtCistern(petrolRequest);
    } catch (InterruptedException e) {
      leavePetrolStation();
      throw new RuntimeException(e);
    }
  }

  synchronized void decreaseAmountOfFuelAtCistern(int petrolRequest) {
    amountOfFuelAtCistern -= petrolRequest;
  }

  synchronized void decreaseAvailableAmountOfFuel(int petrolRequest) {
    availableAmountOfFuel -= petrolRequest;
  }

  synchronized void leavePetrolStation() {
    numberOfBusyDispensers.decrementAndGet();
    notify();
  }
}
