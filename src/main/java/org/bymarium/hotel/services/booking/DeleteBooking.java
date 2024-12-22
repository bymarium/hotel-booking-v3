package org.bymarium.hotel.services.booking;

import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.repositories.BookingRepository;
import org.bymarium.hotel.services.interfaces.ICommand;

public class DeleteBooking implements ICommand<Booking> {
  private final BookingRepository bookingRepository;
  private final SearchBooking searchBooking;

  public DeleteBooking(BookingRepository bookingRepository, SearchBooking searchBooking) {
    this.bookingRepository = bookingRepository;
    this.searchBooking = searchBooking;
  }

  @Override
  public Booking execute() {
    Booking booking = searchBooking.execute();
    bookingRepository.removeBooking(booking);
    return booking;
  }
}