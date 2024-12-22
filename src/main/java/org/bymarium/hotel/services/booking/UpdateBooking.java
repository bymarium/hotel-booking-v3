package org.bymarium.hotel.services.booking;

import org.bymarium.hotel.constants.AccommodationType;
import org.bymarium.hotel.models.Accommodation;
import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.models.Room;
import org.bymarium.hotel.services.interfaces.ICommand;
import org.bymarium.hotel.services.room.SelectRoom;
import org.bymarium.hotel.utils.Validator;

public class UpdateBooking implements ICommand<Booking> {
  private final Validator validator;
  private final SearchBooking searchBooking;
  private final SelectRoom selectRoom;

  public UpdateBooking(Validator validator, SearchBooking searchBooking, SelectRoom selectRoom) {
    this.validator = validator;
    this.searchBooking = searchBooking;
    this.selectRoom = selectRoom;
  }


  @Override
  public Booking execute() {
    Booking booking = searchBooking.execute();

    Accommodation accommodation = booking.getAccommodation();

    if (accommodation.getType().equals(AccommodationType.HOTEL)) {
      Room oldRoom = selectRoom.execute(accommodation);
      accommodation.getServices().remove(oldRoom);
      Room newRoom = selectRoom.execute(accommodation);
      accommodation.getServices().add(newRoom);
    }

    booking.setAccommodation(accommodation);

    return booking;
  }
}