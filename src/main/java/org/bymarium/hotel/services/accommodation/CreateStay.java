package org.bymarium.hotel.services.accommodation;

import org.bymarium.hotel.constants.AccommodationType;
import org.bymarium.hotel.models.Accommodation;
import org.bymarium.hotel.models.Room;
import org.bymarium.hotel.models.Service;
import org.bymarium.hotel.models.Stay;
import org.bymarium.hotel.services.interfaces.ICommandParameterized;
import org.bymarium.hotel.services.room.SelectRoom;
import org.bymarium.hotel.utils.Validator;

import java.util.ArrayList;
import java.util.List;

public class CreateStay implements ICommandParameterized<Stay, Accommodation> {
  private final SelectRoom selectRoom;
  private final Validator validator;

  public CreateStay(SelectRoom selectRoom, Validator validator) {
    this.selectRoom = selectRoom;
    this.validator = validator;
  }

  @Override
  public Stay execute(Accommodation accommodation) {
    Stay stay = null;
    if (accommodation instanceof Stay) {
      stay = new Stay(accommodation.getName(), accommodation.getRate(), accommodation.getCity(), accommodation.getDescription(), accommodation.getType(), accommodation.getServices(), 0.0f);
    }

    if (accommodation.getType().equals(AccommodationType.HOTEL)) {
      List<Room> rooms = selectRooms(accommodation);
      stay.setServices(rooms.stream().map(Service.class::cast).toList());
    }
    return stay;
  }

  private List<Room> selectRooms(Accommodation accommodation) {
    List<Room> rooms = new ArrayList<>();

    String response = validator.readString("¿Deseas seleccionar más habitaciones? (S/N): ");
    do {
      if (response.equals("S")) {
        Room room = selectRoom.execute(accommodation);
        rooms.add(room);
      }

      response = validator.readString("¿Deseas seleccionar más habitaciones? (S/N): ");
    } while (response.equalsIgnoreCase("S"));

    return rooms;
  }
}
