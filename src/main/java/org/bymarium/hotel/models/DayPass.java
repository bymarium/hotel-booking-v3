package org.bymarium.hotel.models;

import org.bymarium.hotel.constants.AccommodationType;

import java.util.List;

public class DayPass extends Accommodation {
  private Float personPrice;

  public DayPass(String name, Float rate, String city, String description, AccommodationType type, List<Service> services, Float personPrice) {
    super(name, rate, city, description, type, services);
    this.personPrice = personPrice;
  }

  public DayPass(Float personPrice) {
    this.personPrice = personPrice;
  }

  @Override
  public String printAccommodation() {
    String result = "\n********** ALOJAMIENTO **********\n";

    result += "Ciudad: " + getCity() + "\n";
    result += "Tipo de alojamiento: Dia de Sol\n";
    result += "Nombre: " + getName() + "\n";
    result += "Descripción: " + getDescription() + "\n";
    result += "Calificación: " + getRate() + "\n";
    result += "Precio por persona: " + getPersonPrice() + "\n";

    result += "\n********** ACTIVIDADES **********\n";
    int index = 1;
    for (Service service : getServices()) {
      result += "Actividad " + index + ". \n";
      result += service.printService();
      result += "----\n";
      index++;
    }

    return result;
  }

  public Float getPersonPrice() {
    return personPrice;
  }
}
