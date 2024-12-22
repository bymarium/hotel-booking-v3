package org.bymarium.hotel.services.booking;

import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.repositories.BookingRepository;
import org.bymarium.hotel.services.interfaces.ICommand;
import org.bymarium.hotel.utils.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class SearchBooking implements ICommand<Booking> {
  private final Integer MINIMUM_OPTION = 1;
  private final BookingRepository bookingRepository;
  private final Validator validator;
  private List<Booking> bookings;

  public SearchBooking(BookingRepository bookingRepository, Validator validator) {
    this.bookingRepository = bookingRepository;
    this.validator = validator;
  }

  @Override
  public Booking execute() {
    String email = validator.readString("\nIngrese el email para buscar la reserva: ");

    bookings = getBookingsByEmail(email);

    Integer option = validator.readInteger("Ingrese el número de la reserva que desea seleccionar: \n" + getFormattedBooking());

    if (!isValidBooking(option)) {
      System.out.println("Opción no válida. Inténtalo nuevamente.");
      return execute();
    }

    return bookings.get(option - 1);
  }

  private List<Booking> getBookingsByEmail(String email) {
    return bookingRepository.getBookings().stream().filter(booking -> booking.getClient().getEmail().equals(email)).toList();
  }

  private String getFormattedBooking() {
    return this.bookings.stream().map(booking -> (bookings.lastIndexOf(booking) + 1) + ". " + booking).collect(Collectors.joining("\n"));
  }

  private boolean isValidBooking(Integer option) {
    return option > bookings.size() || option < MINIMUM_OPTION;
  }
}