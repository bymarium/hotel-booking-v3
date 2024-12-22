package org.bymarium.hotel.services.accommodation;

import org.bymarium.hotel.models.Accommodation;
import org.bymarium.hotel.models.DayPass;
import org.bymarium.hotel.services.interfaces.ICommandParameterized;

public class CreateDayPass implements ICommandParameterized<DayPass, Accommodation> {
  @Override
  public DayPass execute(Accommodation accommodation) {
    DayPass dayPass = null;
    if (accommodation instanceof DayPass) {
      dayPass = new DayPass(accommodation.getName(), accommodation.getRate(), accommodation.getCity(), accommodation.getDescription(), accommodation.getType(), accommodation.getServices(), 0.0f);
    }

    return dayPass;
  }
}
