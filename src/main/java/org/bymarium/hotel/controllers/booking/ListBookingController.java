package org.bymarium.hotel.controllers.booking;

import org.bymarium.hotel.controllers.interfaces.IController;
import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.services.booking.ListBooking;

import java.util.List;

public class ListBookingController implements IController {
  private final ListBooking listBooking;

  public ListBookingController(ListBooking listBooking) {
    this.listBooking = listBooking;
  }

  @Override
  public void execute() {
    List<Booking> bookings = listBooking.execute();
    System.out.println("\033[1;32m☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆\033[0m");
    System.out.println("\033[1;32m☆      ¡LISTADO DE RESERVAS!       ☆\033[0m");
    System.out.println("\033[1;32m☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆\033[0m");
    bookings.forEach(booking -> System.out.println(booking.printBooking()));
  }
}