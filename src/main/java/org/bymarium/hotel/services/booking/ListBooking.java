package org.bymarium.hotel.services.booking;

import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.repositories.BookingRepository;
import org.bymarium.hotel.services.interfaces.ICommand;

import java.util.List;

public class ListBooking implements ICommand<List<Booking>> {
  private final BookingRepository bookingRepository;

  public ListBooking(BookingRepository bookingRepository) {
    this.bookingRepository = bookingRepository;
  }

  @Override
  public List<Booking> execute() {
    return bookingRepository.getBookings();
  }
}
