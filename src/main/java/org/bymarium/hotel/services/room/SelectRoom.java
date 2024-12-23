package org.bymarium.hotel.services.room;

import org.bymarium.hotel.models.Accommodation;
import org.bymarium.hotel.models.Room;
import org.bymarium.hotel.services.interfaces.ICommandParameterized;
import org.bymarium.hotel.utils.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class SelectRoom implements ICommandParameterized<Room, Accommodation> {
  private final Validator validator;

  public SelectRoom(Validator validator) {
    this.validator = validator;
  }

  @Override
  public Room execute(Accommodation accommodation) {
    Integer option = validator.readInteger("☆ ☆ ☆ LISTADO DE HABITACIONES ☆ ☆ ☆\n" + getFormattedRooms(accommodation) + "\nIngrese el número de la habitación que desea seleccionar:");

    if (!isValidRoom(option, getRooms(accommodation))) {
      System.out.println("Opción no válida. Inténtalo nuevamente.");
      return execute(accommodation);
    }

    Room room = getRoom(accommodation, option);

    if (isSoldOut(room)) {
      System.out.println("No hay habitaciones disponibles para este hotel.");
      return execute(accommodation);
    }

    decrementStock(room);

    return room;
  }

  private void decrementStock(Room room) {
    room.setStock(room.getStock() - 1);
  }

  private Room getRoom(Accommodation accommodation, Integer option) {
    return getRooms(accommodation).get(option - 1);
  }

  private boolean isSoldOut(Room room) {
    return room.getStock() == 0;
  }

  private List<Room> getRooms(Accommodation accommodation) {
    return accommodation.getServices().stream().filter(Room.class::isInstance).map(Room.class::cast).toList();
  }

  private String getFormattedRooms(Accommodation accommodation) {
    List<Room> rooms = getRooms(accommodation);
  return rooms.stream().map(room -> "☆ HABITACIÓN #" + (rooms.lastIndexOf(room) + 1) + " ☆\n" + room.printRoom()).collect(Collectors.joining("\n"));
  }

  private boolean isValidRoom(Integer option, List<Room> rooms) {
    return option <= rooms.size() && option >= 1;
  }
}