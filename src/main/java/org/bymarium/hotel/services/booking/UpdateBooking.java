package org.bymarium.hotel.services.booking;

import org.bymarium.hotel.constants.AccommodationType;
import org.bymarium.hotel.models.Accommodation;
import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.models.Room;
import org.bymarium.hotel.services.interfaces.ICommand;
import org.bymarium.hotel.services.room.SelectRoom;

public class UpdateBooking implements ICommand<Booking> {
  private final SearchBooking searchBooking;
  private final SelectRoom selectRoom;

  public UpdateBooking(SearchBooking searchBooking, SelectRoom selectRoom) {
    this.searchBooking = searchBooking;
    this.selectRoom = selectRoom;
  }


  @Override
  public Booking execute() {
    Booking booking = searchBooking.execute();

    Accommodation accommodation = booking.getAccommodation();

    if (accommodation.getType().equals(AccommodationType.HOTEL)) {
      Room oldRoom = selectRoom.execute(accommodation);
      accommodation.getServices().removeIf(room -> room.getId().equals(oldRoom.getId()));
      Room newRoom = selectRoom.execute(accommodation);
      accommodation.getServices().add(newRoom);
    }

    booking.setAccommodation(accommodation);

    return booking;
  }
}