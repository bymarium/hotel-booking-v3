package org.bymarium.hotel.controllers.booking;

import org.bymarium.hotel.controllers.interfaces.IController;
import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.services.booking.UpdateBooking;

public class UpdateBookingController implements IController {
  private final UpdateBooking updateBooking;

  public UpdateBookingController(UpdateBooking updateBooking) {
    this.updateBooking = updateBooking;
  }

  @Override
  public void execute() {
    Booking booking = updateBooking.execute();
    System.out.println("\033[1;32m☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆\033[0m");
    System.out.println("\033[1;32m☆    ¡RESERVA ACTUALIZADA CON ÉXITO!    ☆\033[0m");
    System.out.println("\033[1;32m☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆\033[0m");
    System.out.println(booking.printBooking());
  }
}