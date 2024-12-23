package org.bymarium.hotel.controllers.booking;

import org.bymarium.hotel.controllers.interfaces.IController;
import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.services.booking.ChangeBooking;

public class ChangeBookingController implements IController {
  private final ChangeBooking changeBooking;

  public ChangeBookingController(ChangeBooking changeBooking) {
    this.changeBooking = changeBooking;
  }

  @Override
  public void execute() {
    Booking booking = changeBooking.execute();
    System.out.println("\033[1;32m☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆\033[0m");
    System.out.println("\033[1;32m☆  ¡RESERVA AGREGADA CON ÉXITO!   ☆\033[0m");
    System.out.println("\033[1;32m☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆\033[0m");
    System.out.println(booking.printBooking());
  }
}