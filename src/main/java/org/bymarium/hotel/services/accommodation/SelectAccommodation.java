package org.bymarium.hotel.services.accommodation;

import org.bymarium.hotel.constants.AccommodationType;
import org.bymarium.hotel.models.Accommodation;
import org.bymarium.hotel.models.Room;
import org.bymarium.hotel.models.Service;
import org.bymarium.hotel.models.Stay;
import org.bymarium.hotel.services.interfaces.ICommand;
import org.bymarium.hotel.utils.Validator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SelectAccommodation implements ICommand<Accommodation> {
  private final Integer MINIMUM_OPTION = 1;
  private final SearchAccommodation searchAccommodation;
  private final Validator validator;
  private List<Accommodation> accommodations;

  public SelectAccommodation(SearchAccommodation searchAccommodation, Validator validator) {
    this.searchAccommodation = searchAccommodation;
    this.validator = validator;
  }

  @Override
  public Accommodation execute() {
    Integer option = validator.readInteger("\n☆ ☆ ☆ LISTADO DE ALOJAMIENTOS ☆ ☆ ☆\n" + getFormattedAccommodation() + "\nIngrese el número de la alojamiento que desea seleccionar: \n");

    if (!isValidAccommodation(option)) {
      System.out.println("\nOpción no válida. Inténtalo nuevamente.");
      return execute();
    }

    return accommodations.get(option - 1);
  }

  private String getFormattedAccommodation() {
    accommodations = searchAccommodation.execute();

    setAccommodationPrice();
    return accommodations.stream().map(accommodation -> "☆ ALOJAMIENTO #" + (accommodations.lastIndexOf(accommodation) + 1) + " ☆" + accommodation.printAccommodation()).collect(Collectors.joining("\n"));
  }

  private boolean isValidAccommodation(Integer option) {
    return option <= accommodations.size() && option >= MINIMUM_OPTION;
  }

  private void setAccommodationPrice() {
    accommodations = accommodations.stream().map((Accommodation accommodation) -> {
      Stay stay = (Stay) accommodation;
      if (stay.getType().equals(AccommodationType.HOTEL)) {
        Room room = getLowestPriceRoom(stay.getServices());
        stay.setBasePrice(room.getPrice());
      }
      return stay;
    }).map(Accommodation.class::cast).toList();
  }

  private Room getLowestPriceRoom(List<Service> rooms) {
    return rooms.stream().map(room -> (Room) room).min(Comparator.comparing(Room::getPrice)).get();
  }
}