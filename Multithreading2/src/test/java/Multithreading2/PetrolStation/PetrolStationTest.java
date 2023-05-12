package Multithreading2.PetrolStation;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hillel.Multithreading2.PetrolStation.PetrolStation;
import org.junit.jupiter.api.Test;

public class PetrolStationTest {
  @Test
  public void testCreateOrderDecreasesAvailableAmountOfFuel() {
    PetrolStation petrolStation = new PetrolStation(100, 2);
    petrolStation.createOrder("John", 10);
    assertEquals(90, petrolStation.getAvailableAmountOfFuel());
  }

  @Test
  void doRefuel_whenPetrolRequestIsSmall_shouldNotThrowException() {
    PetrolStation petrolStation = new PetrolStation(100, 2);

    assertDoesNotThrow(() -> petrolStation.doRefuel(50, "John"));
  }

  @Test
  void startService_whenPetrolRequestIsSmall_shouldFillUpTheCar() {
    PetrolStation petrolStation = new PetrolStation(100, 2);

    petrolStation.startService(50, "John");

    assertEquals(50, petrolStation.getAvailableAmountOfFuel());
    assertEquals(50, petrolStation.getAmountOfFuelAtCistern());
  }

  @Test
  void startService_whenPetrolRequestIsTooBig_shouldPrintErrorMessage() {
    PetrolStation petrolStation = new PetrolStation(100, 2);

    petrolStation.startService(150, "John");

    assertEquals(100, petrolStation.getAvailableAmountOfFuel());
    assertEquals(100, petrolStation.getAmountOfFuelAtCistern());
  }


  @Test
  void checkAvailabilityOfDispensers_whenNotAllDispensersAreBusy_shouldNotWait() {
    PetrolStation petrolStation = new PetrolStation(100, 2);

    petrolStation.doRefuel(50, "John");

    long startTime = System.currentTimeMillis();
    petrolStation.checkAvailabilityOfDispensers();
    long endTime = System.currentTimeMillis();

    assertTrue(endTime - startTime < 3000);
    assertEquals(2, petrolStation.getNumberOfBusyDispensers().get());
  }

  @Test
  void isAllBusy_whenNotAllDispensersAreBusy_shouldReturnFalse() {
    PetrolStation petrolStation = new PetrolStation(100, 2);
    petrolStation.doRefuel(50, "John");

    assertFalse(petrolStation.isAllBusy());
  }
}
