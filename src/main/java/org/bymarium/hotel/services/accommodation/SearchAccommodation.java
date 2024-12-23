package org.bymarium.hotel.services.accommodation;

import org.bymarium.hotel.constants.AccommodationType;
import org.bymarium.hotel.models.Accommodation;
import org.bymarium.hotel.repositories.AccommodationRepository;
import org.bymarium.hotel.services.interfaces.ICommand;
import org.bymarium.hotel.utils.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchAccommodation implements ICommand<List<Accommodation>> {
  private final Validator validator;
  private final AccommodationRepository accommodationRepository;
  private final List<String> cities = Arrays.asList("Medellín", "Cartagena", "Barranquilla", "Bogotá", "Santa Marta", "Pereira", "Guatapé", "Cali");
  private final List<String> types = Stream.of(AccommodationType.values()).map(AccommodationType::getSpanishName).toList();

  public SearchAccommodation(Validator validator, AccommodationRepository accommodationRepository) {
    this.validator = validator;
    this.accommodationRepository = accommodationRepository;
  }

  @Override
  public List<Accommodation> execute() {
    Integer optionCity = validator.readInteger("\nIngrese la ciudad: \n" + getFormattedCity());
    String city = cities.get(optionCity - 1);

    Integer optionType = validator.readInteger("\nIngrese el tipo de alojamiento: \n" + getFormattedType());
    AccommodationType type = AccommodationType.values()[optionType - 1];

    return getAccommodationsByCityAndType(city, type);
  }

  private List<Accommodation> getAccommodationsByCityAndType(String city, AccommodationType type) {
    return accommodationRepository.getAccommodations().stream().filter(accommodation -> accommodation.getCity().equals(city) && accommodation.getType().equals(type)).toList();
  }

  private String getFormattedCity() {
    return this.cities.stream().map(city -> (cities.lastIndexOf(city) + 1) + ". " + city).collect(Collectors.joining("\n"));
  }

  private String getFormattedType() {
    return this.types.stream().map(type -> (types.lastIndexOf(type) + 1) + ". " + type).collect(Collectors.joining("\n"));
  }
}