package org.bymarium.hotel.repositories;

import org.bymarium.hotel.constants.AccommodationType;
import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.models.Client;
import org.bymarium.hotel.models.DayPass;
import org.bymarium.hotel.models.Details;
import org.bymarium.hotel.models.DetailsStay;
import org.bymarium.hotel.models.Room;
import org.bymarium.hotel.models.Service;
import org.bymarium.hotel.models.Stay;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class BookingRepository {
  private static BookingRepository instance;
  private List<Booking> bookings;

  private BookingRepository() {
    initialize();
  }

  public static BookingRepository getInstance() {
    if (instance == null) {
      instance = new BookingRepository();
    }

    return instance;
  }

  public List<Booking> getBookings() {
    return bookings;
  }

  public void addBooking(Booking booking) {
    bookings.add(booking);
  }

  public void removeBooking(Booking booking) {
    bookings.remove(booking);
  }

  private void initialize() {
    bookings = Arrays.asList(
      new Booking(
        new Stay(
          "Hotel del Parque",
          4.7f,
          "Medellín",
          "Hotel moderno cerca del Parque Lleras",
          AccommodationType.HOTEL,
          Arrays.asList(
            new Room("Suite", "Suite lujosa con vista a la ciudad, incluye minibar, cama king, baño privado y Wi-Fi de alta velocidad.",8, "Suite", 250.0f),
            new Room("Doble", "Habitación doble con decoración moderna, dos camas individuales, escritorio y aire acondicionado.",10, "Doble", 180.0f)
          ),
          250.0f
        ),
        new Client("Juan", "Perez", "123456789", "Pereira", "juan.perez@gmail.com", LocalTime.of(10, 30)),
        new DetailsStay(LocalDate.of(2024, 12, 28), LocalDate.of(2024, 12, 28), 2, 1, 2, 250.0f)
      ),
      new Booking(
        new Stay(
          "Hotel Campestre",
          4.2f,
          "Pereira",
          "Hermoso hotel campestre rodeado de naturaleza",
          AccommodationType.APARTMENT,
          Arrays.asList(
            new Room("Familiar", "Habitación espaciosa con dos camas dobles y zona de juegos.",6, "Familiar", 300.0f),
            new Room("Individual", "Habitación individual económica con cama sencilla, Wi-Fi y baño privado.", 6, "Individual", 120.0f)
          ),
          300.0f
        ),
        new Client("Juan", "Perez", "123456789", "Pereira", "juan.perez@gmail.com", LocalTime.of(12, 45)),
        new DetailsStay(LocalDate.of(2025, 1, 3), LocalDate.of(2025, 1, 10), 1, 3, 3, 400.0f)
      ),
      new Booking(
        new Stay(
          "Hostal de la Montaña",
          4.5f,
          "Manizales",
          "Hostal acogedor con vistas panorámicas a las montañas",
          AccommodationType.FARM,
          Arrays.asList(
            new Room("Deluxe", "Habitación exclusiva con jacuzzi, cama king, minibar, balcón privado y desayuno incluido.", 3, "Deluxe", 400.0f),
            new Room("Suite", "Suite lujosa con vista a la ciudad, incluye minibar, cama king, baño privado y Wi-Fi de alta velocidad.", 8, "Suite", 250.0f)
          ),
          400.0f
        ),
        new Client("Maria", "Gomez", "987654321", "Manizales", "maria.gomez@gmail.com", LocalTime.of(14, 15)),
        new DetailsStay(LocalDate.of(2024, 12, 28), LocalDate.of(2024, 12, 30), 3, 2, 5, 300.0f)
      ),
      new Booking(
        new DayPass(
          "Hostal de la Montaña",
          4.5f,
          "Manizales",
          "Hostal acogedor con vistas panorámicas a las montañas. Ideal para disfrutar de un Día de Sol.",
          AccommodationType.DAYPASS,
          Arrays.asList(
            new Service("Piscina", "Acceso a piscina climatizada con vista panorámica."),
            new Service("Almuerzo Buffet", "Incluye almuerzo tipo buffet con opciones locales e internacionales."),
            new Service("Zona de Juegos", "Acceso a la zona de juegos para niños y adultos."),
            new Service("Spa", "Incluye 1 sesión de spa de 30 minutos.")
          ),
          120.0f
        ),
        new Client("Maria", "Gomez", "987654321", "Manizales", "maria.gomez@gmail.com", LocalTime.of(9, 0)),
        new Details(LocalDate.of(2024, 12, 30), 0, 1, 120.0f)
      )
    );
  }
}