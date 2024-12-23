package org.bymarium.hotel.controllers.booking;

import org.bymarium.hotel.controllers.interfaces.IController;
import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.services.booking.CreateBooking;

public class CreateBookingController implements IController {
  private final CreateBooking createBooking;

  public CreateBookingController(CreateBooking createBooking) {
    this.createBooking = createBooking;
  }

  @Override
  public void execute() {
    Booking booking = createBooking.execute();
    System.out.println("\033[1;32m☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆\033[0m");
    System.out.println("\033[1;32m☆  ¡RESERVA AGREGADA CON ÉXITO!   ☆\033[0m");
    System.out.println("\033[1;32m☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆\033[0m");
    System.out.println(booking.printBooking());
  }
}