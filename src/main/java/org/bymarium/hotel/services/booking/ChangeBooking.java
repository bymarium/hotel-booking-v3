package org.bymarium.hotel.services.booking;

import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.services.interfaces.ICommand;

public class ChangeBooking implements ICommand<Booking> {
  private final DeleteBooking deleteBooking;
  private final CreateBooking createBooking;

  public ChangeBooking(DeleteBooking deleteBooking, CreateBooking createBooking) {
    this.deleteBooking = deleteBooking;
    this.createBooking = createBooking;
  }

  @Override
  public Booking execute() {
    deleteBooking.execute();
    return createBooking.execute();
  }
}
