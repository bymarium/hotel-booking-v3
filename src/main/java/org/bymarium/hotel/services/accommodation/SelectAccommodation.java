package org.bymarium.hotel.services.accommodation;

import org.bymarium.hotel.models.Accommodation;
import org.bymarium.hotel.services.interfaces.ICommand;
import org.bymarium.hotel.utils.Validator;

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
    Integer option = validator.readInteger("Ingrese el número de la alojamiento que desea seleccionar: \n" + getFormattedAccommodation());

    if (!isValidAccommodation(option)) {
      System.out.println("Opción no válida. Inténtalo nuevamente.");
      return execute();
    }

    return accommodations.get(option - 1);
  }

  private String getFormattedAccommodation() {
    accommodations = searchAccommodation.execute();

    return accommodations.stream().map(accommodation -> (accommodations.lastIndexOf(accommodation) + 1) + ". " + accommodation.getName()).collect(Collectors.joining("\n"));
  }

  private boolean isValidAccommodation(Integer option) {
    return option > accommodations.size() || option < MINIMUM_OPTION;
  }
}