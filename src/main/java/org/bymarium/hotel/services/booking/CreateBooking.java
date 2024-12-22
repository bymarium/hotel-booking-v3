package org.bymarium.hotel.services.booking;

import org.bymarium.hotel.constants.AccommodationType;
import org.bymarium.hotel.models.Accommodation;
import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.models.Client;
import org.bymarium.hotel.models.DayPass;
import org.bymarium.hotel.models.Details;
import org.bymarium.hotel.models.DetailsStay;
import org.bymarium.hotel.models.Stay;
import org.bymarium.hotel.repositories.BookingRepository;
import org.bymarium.hotel.services.accommodation.CreateDayPass;
import org.bymarium.hotel.services.accommodation.CreateStay;
import org.bymarium.hotel.services.accommodation.SelectAccommodation;
import org.bymarium.hotel.services.interfaces.ICommand;
import org.bymarium.hotel.utils.Validator;

import java.time.LocalDate;
import java.time.LocalTime;

public class CreateBooking implements ICommand<Booking> {
  private final SelectAccommodation selectAccommodation;
  private final Validator validator;
  private final CreateStay createStay;
  private final CreateDayPass createDayPass;
  private final BookingRepository bookingRepository;

  public CreateBooking(SelectAccommodation selectAccommodation, Validator validator, CreateStay createStay, CreateDayPass createDayPass, BookingRepository bookingRepository) {
    this.selectAccommodation = selectAccommodation;
    this.validator = validator;
    this.createStay = createStay;
    this.createDayPass = createDayPass;
    this.bookingRepository = bookingRepository;
  }

  @Override
  public Booking execute() {
    Accommodation accommodation = selectAccommodation.execute();

    Booking booking;
    if (accommodation.getType().equals(AccommodationType.DAYPASS)) {
      booking = createBookingDayPass(accommodation);
      bookingRepository.addBooking(booking);
      return booking;
    }

    booking = createBookingStay(accommodation);
    bookingRepository.addBooking(booking);
    return booking;
  }

  private Booking createBookingStay(Accommodation accommodation) {
    LocalDate startDate = validator.readLocalDate("Ingrese la fecha de inicio de la reserva (yyyy-MM-dd): ");
    LocalDate endDate = validator.readLocalDate("Ingrese la fecha de fin de la reserva (yyyy-MM-dd): ", startDate);
    int numberOfAdults = validator.readInteger("Ingrese el número de adultos: ");
    int numberOfChildren = validator.readInteger("Ingrese el número de niños: ");

    Stay stay = createStay.execute(accommodation);

    Client client = createClient();
    // TODO: numero de habitaciones y total de precio
    DetailsStay detailsStay = new DetailsStay(startDate, endDate, numberOfAdults, numberOfChildren, 0, 0.0f);

    return new Booking(stay, client, detailsStay);
  }

  private Booking createBookingDayPass(Accommodation accommodation) {
    LocalDate startDate = validator.readLocalDate("Ingrese la fecha de inicio de la reserva (yyyy-MM-dd): ");
    int numberOfAdults = validator.readInteger("Ingrese el número de adultos: ");
    int numberOfChildren = validator.readInteger("Ingrese el número de niños: ");

    DayPass dayPass = createDayPass.execute(accommodation);
    Client client = createClient();
    Details details = new Details(startDate, numberOfChildren, numberOfAdults, 0.0f);

    return new Booking(dayPass, client, details);
  }

  private Client createClient() {
    System.out.println("\n============================================================");
    System.out.println("                DATOS DE LA PERSONA TITULAR                 ");
    System.out.println("============================================================");

    String name = validator.readString("Ingrese el nombre: ");
    String lastName = validator.readString("Ingrese el apellido: ");
    String email = validator.readString("Ingrese el email: ");
    String nationality = validator.readString("Ingrese la nacionalidad: ");
    String phone = validator.readString("Ingrese el número de teléfono: ");
    LocalTime arrivalTime = validator.readLocalTime("Ingrese la hora de llegada (HH:mm): ");

    return new Client(name, lastName, phone, nationality, email, arrivalTime);
  }
}