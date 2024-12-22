package org.bymarium.hotel.models;

import org.bymarium.hotel.constants.AccommodationType;

import java.util.List;

public class Stay extends Accommodation {
  private Float basePrice;

  public Stay(String name, Float rate, String city, String description, AccommodationType type, List<Service> services, Float basePrice) {
    super(name, rate, city, description, type, services);
    this.basePrice = basePrice;
  }

  public Stay(Float basePrice) {
    this.basePrice = basePrice;
  }

  @Override
  public String printAccommodation() {
    String result = "\n********** ALOJAMIENTO **********\n";

    result += "Ciudad: " + getCity() + "\n";
    result += "Tipo de alojamiento: " + getType() + "\n";
    result += "Nombre: " + getName() + "\n";
    result += "Descripción: " + getDescription() + "\n";
    result += "Calificación: " + getRate() + "\n";
    result += "Precio por noche: " + getBasePrice() + "\n";

    result += "\n********** HABITACIONES **********\n";
    int index = 1;
    for (Service service : getServices()) {
      result += "Habitación " + index + ". \n";
      result += service.printService();
      result += "----\n";
      index++;
    }

    return result;
  }

  public Float getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(Float basePrice) {
    this.basePrice = basePrice;
  }
}
