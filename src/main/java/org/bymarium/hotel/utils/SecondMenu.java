package org.bymarium.hotel.utils;

import org.bymarium.hotel.controllers.booking.ChangeBookingController;
import org.bymarium.hotel.controllers.booking.UpdateBookingController;
import org.bymarium.hotel.controllers.interfaces.IController;
import org.bymarium.hotel.repositories.AccommodationRepository;
import org.bymarium.hotel.repositories.BookingRepository;
import org.bymarium.hotel.services.accommodation.CreateDayPass;
import org.bymarium.hotel.services.accommodation.CreateStay;
import org.bymarium.hotel.services.accommodation.SearchAccommodation;
import org.bymarium.hotel.services.accommodation.SelectAccommodation;
import org.bymarium.hotel.services.booking.CaculateTotalPrice;
import org.bymarium.hotel.services.booking.ChangeBooking;
import org.bymarium.hotel.services.booking.CreateBooking;
import org.bymarium.hotel.services.booking.DeleteBooking;
import org.bymarium.hotel.services.booking.SearchBooking;
import org.bymarium.hotel.services.booking.UpdateBooking;
import org.bymarium.hotel.services.room.SelectRoom;
import org.bymarium.hotel.utils.interfaces.IMenu;

import java.util.Map;
import java.util.Scanner;

public class SecondMenu implements IMenu<Integer> {
  Validator validator = new Validator(new Scanner(System.in));
  BookingRepository bookingRepository = BookingRepository.getInstance();

  AccommodationRepository accommodationRepository = AccommodationRepository.getInstance();
  SearchAccommodation searchAccommodation = new SearchAccommodation(validator, accommodationRepository);
  SelectAccommodation selectAccommodation = new SelectAccommodation(searchAccommodation, validator);
  SelectRoom selectRoom = new SelectRoom(validator);
  CreateStay createStay = new CreateStay(selectRoom, validator);
  CreateDayPass createDayPass = new CreateDayPass();
  CaculateTotalPrice caculateTotalPrice = new CaculateTotalPrice();

  CreateBooking createBooking = new CreateBooking(selectAccommodation, validator, createStay, createDayPass, bookingRepository, caculateTotalPrice);

  SearchBooking searchBooking = new SearchBooking(bookingRepository, validator);
  UpdateBooking updateBooking = new UpdateBooking(searchBooking, selectRoom);
  DeleteBooking deleteBooking = new DeleteBooking(bookingRepository, searchBooking);
  ChangeBooking changeBooking = new ChangeBooking(deleteBooking, createBooking);

  @Override
  public Integer execute() {
    Map<Integer, IController> controllers = Map.of(
      1, new UpdateBookingController(updateBooking),
      2, new ChangeBookingController(changeBooking)
    );

    Integer option = validator.readInteger(
      """
        
        ==========================================================
        ☆ ☆ ☆ BIENVENIDO A LA MODIFICACIÓN DE UNA RESERVA ☆ ☆ ☆
        ==========================================================
                           ¿QUÉ DESEAS HACER?                   \s
        ──────────────────────────────────────────────────────────
          1. Cambiar habitación(es)
          2. Cambiar alojamiento
          3. Volver al menú principal
        ──────────────────────────────────────────────────────────
        Introduce el número de la opción que deseas realizar:\s"""
    );

    do {
      showFirstMenu(option);
      controllers.get(option).execute();
      option = validator.readInteger(
        """
          
          ==========================================================
          ☆ ☆ ☆ BIENVENIDO A LA MODIFICACIÓN DE UNA RESERVA ☆ ☆ ☆
          ==========================================================
                             ¿QUÉ DESEAS HACER?                   \s
          ──────────────────────────────────────────────────────────
            1. Cambiar habitación(es)
            2. Cambiar alojamiento
            3. Volver al menú principal
          ──────────────────────────────────────────────────────────
          Introduce el número de la opción que deseas realizar:\s"""
      );
    } while (option != 3);

    return option;
  }

  private void showFirstMenu(Integer option) {
    if (option == 3) {
      new FirstMenu().execute();
    }
  }
}
