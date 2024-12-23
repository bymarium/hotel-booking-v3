package org.bymarium.hotel.utils;

import org.bymarium.hotel.controllers.booking.CreateBookingController;
import org.bymarium.hotel.controllers.booking.ListBookingController;
import org.bymarium.hotel.controllers.interfaces.IController;
import org.bymarium.hotel.repositories.AccommodationRepository;
import org.bymarium.hotel.repositories.BookingRepository;
import org.bymarium.hotel.services.accommodation.CreateDayPass;
import org.bymarium.hotel.services.accommodation.CreateStay;
import org.bymarium.hotel.services.accommodation.SearchAccommodation;
import org.bymarium.hotel.services.accommodation.SelectAccommodation;
import org.bymarium.hotel.services.booking.CaculateTotalPrice;
import org.bymarium.hotel.services.booking.CreateBooking;
import org.bymarium.hotel.services.booking.ListBooking;
import org.bymarium.hotel.services.room.SelectRoom;
import org.bymarium.hotel.utils.interfaces.IMenu;

import java.util.Map;
import java.util.Scanner;

public class FirstMenu implements IMenu<Integer> {
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
  ListBooking listBooking = new ListBooking(bookingRepository);

  @Override
  public Integer execute() {
    Map<Integer, IController> controllers = Map.of(
      1, new CreateBookingController(createBooking),
      2, new ListBookingController(listBooking)
    );

    Integer option = validator.readInteger(
      """
        ====================================================================
        ☆ ☆ ☆ BIENVENIDO A LA APLICACIÓN DE RESERVA DE ALOJAMIENTOS ☆ ☆ ☆
        ====================================================================
                                 ¿QUÉ DESEAS HACER?                       \s
        ────────────────────────────────────────────────────────────────────
          1. Reservar un alojamiento
          2. Ver reservas
          3. Modificar una reserva
          4. Salir del sistema
        ────────────────────────────────────────────────────────────────────
        Introduce el número de la opción que deseas realizar:\s"""
    );

    do {
      showSecondMenu(option);
      controllers.get(option).execute();
      option = validator.readInteger(
        """
          ====================================================================
          ☆ ☆ ☆ BIENVENIDO A LA APLICACIÓN DE RESERVA DE ALOJAMIENTOS ☆ ☆ ☆
          ====================================================================
                                   ¿QUÉ DESEAS HACER?                       \s
          ────────────────────────────────────────────────────────────────────
            1. Reservar un alojamiento
            2. Ver reservas
            3. Modificar una reserva
            4. Salir del sistema
          ────────────────────────────────────────────────────────────────────
          Introduce el número de la opción que deseas realizar:\s"""
      );
    } while (option != 4);

    return option;
  }

  private void showSecondMenu(Integer option) {
    if (option == 3) {
      new SecondMenu().execute();
    }
  }
}