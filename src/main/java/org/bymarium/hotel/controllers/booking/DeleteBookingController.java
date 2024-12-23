package org.bymarium.hotel.controllers.booking;

import org.bymarium.hotel.controllers.interfaces.IController;
import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.services.booking.DeleteBooking;

public class DeleteBookingController implements IController {
  private final DeleteBooking deleteBooking;

  public DeleteBookingController(DeleteBooking deleteBooking) {
    this.deleteBooking = deleteBooking;
  }

  @Override
  public void execute() {
    Booking booking = deleteBooking.execute();
    System.out.println("\033[1;32m☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆\033[0m");
    System.out.println("\033[1;32m☆  ¡RESERVA ELIMINADA CON ÉXITO!   ☆\033[0m");
    System.out.println("\033[1;32m☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆\033[0m");
    System.out.println(booking.printBooking());
  }
}