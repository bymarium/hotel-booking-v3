package org.bymarium.hotel.repositories;

import org.bymarium.hotel.constants.AccommodationType;
import org.bymarium.hotel.models.Accommodation;
import org.bymarium.hotel.models.DayPass;
import org.bymarium.hotel.models.Room;
import org.bymarium.hotel.models.Service;
import org.bymarium.hotel.models.Stay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccommodationRepository {
  private static AccommodationRepository instance;
  private List<Accommodation> accommodations;

  private AccommodationRepository() {
    initialize();
  }

  public static AccommodationRepository getInstance() {
    if (instance == null) {
      instance = new AccommodationRepository();
    }

    return instance;
  }

  public List<Accommodation> getAccommodations() {
    return accommodations;
  }

  private void initialize() {
    accommodations = new ArrayList<>();
    accommodations.add(
      new Stay("Hotel del Parque", 4.7f, "Medellín", "Hotel moderno cerca del Parque Lleras", AccommodationType.HOTEL, Arrays.asList(
        new Room("Suite", "Suite lujosa con vista a la ciudad, incluye minibar, cama king, baño privado, y Wi-Fi de alta velocidad.", 8, "Suite", 250.0f),
        new Room("Doble", "Habitación doble con decoración moderna, dos camas individuales, escritorio y aire acondicionado.", 10, "Doble", 180.0f),
        new Room("Individual", "Habitación individual ideal para viajeros, cama sencilla, escritorio y conexión Wi-Fi gratuita.", 5, "Individual", 120.0f),
        new Room("Familiar", "Habitación espaciosa para familias, incluye dos camas dobles, zona de juegos y TV por cable.", 6, "Familiar", 300.0f),
        new Room("Deluxe", "Habitación exclusiva con jacuzzi, cama king, minibar, balcón privado y desayuno incluido.", 3, "Deluxe", 400.0f)),
        250.0f)
      );
    accommodations.add(
      new Stay("Casa Colonial", 4.3f, "Cartagena", "Alojamiento colonial en el centro histórico", AccommodationType.HOTEL, Arrays.asList(
        new Room("Familiar", "Habitación ideal para familias, con sala de estar, dos camas dobles y minibar.", 7, "Familiar", 220.0f),
        new Room("Doble", "Habitación doble con balcón al patio colonial, aire acondicionado y desayuno incluido.", 8, "Doble", 170.0f),
        new Room("Individual", "Habitación individual económica con cama sencilla, ventilador y Wi-Fi gratuito.", 6, "Individual", 130.0f),
        new Room("Suite", "Suite con terraza privada y vista al mar, incluye cama king y sala de estar.", 4, "Suite", 350.0f),
        new Room("Deluxe", "Habitación deluxe con detalles de lujo, jacuzzi privado, balcón con vista al mar y minibar.", 2, "Deluxe", 450.0f)),
        220.0f)
      );
    accommodations.add(
      new Stay("Hotel Caribe", 4.6f, "Barranquilla", "Hotel tradicional cerca del Malecón del Río", AccommodationType.HOTEL, Arrays.asList(
        new Room("Suite", "Suite con vista al río, cama king, minibar, sala de estar y Wi-Fi de alta velocidad.", 5, "Suite", 300.0f),
        new Room("Doble", "Habitación doble moderna, aire acondicionado, dos camas individuales y TV por cable.", 8, "Doble", 180.0f),
        new Room("Individual", "Habitación individual económica con conexión Wi-Fi gratuita y baño privado.", 6, "Individual", 100.0f),
        new Room("Familiar", "Habitación para familias, con dos camas dobles, sala de estar y desayuno buffet.", 4, "Familiar", 250.0f),
        new Room("Deluxe", "Habitación de lujo con jacuzzi, balcón privado y minibar.", 3, "Deluxe", 400.0f)),
        200.0f)
    );
    accommodations.add(
      new Stay("Hotel El Refugio", 4.2f, "Bogotá", "Hotel acogedor en el corazón de la capital", AccommodationType.HOTEL, Arrays.asList(
        new Room("Suite", "Suite con vista a la ciudad, cama king, jacuzzi y sala de estar.", 6, "Suite", 280.0f),
        new Room("Doble", "Habitación doble con decoración moderna, dos camas individuales y escritorio.", 9, "Doble", 160.0f),
        new Room("Individual", "Habitación económica con cama sencilla, Wi-Fi y baño privado.", 7, "Individual", 100.0f),
        new Room("Familiar", "Habitación espaciosa con dos camas dobles y zona de estar.", 5, "Familiar", 230.0f),
        new Room("Deluxe", "Habitación de lujo con minibar, balcón privado y desayuno incluido.", 3, "Deluxe", 370.0f)),
        240.0f)
      );
    accommodations.add(
      new Stay("Hotel Sierra", 4.8f, "Santa Marta", "Hotel boutique cerca del Parque Tayrona", AccommodationType.HOTEL, Arrays.asList(
        new Room("Suite", "Suite con terraza privada, cama king, jacuzzi y minibar.", 4, "Suite", 320.0f),
        new Room("Doble", "Habitación doble con balcón y vista a la sierra, incluye aire acondicionado.", 8, "Doble", 200.0f),
        new Room("Individual", "Habitación individual económica, cama sencilla y Wi-Fi.", 5, "Individual", 120.0f),
        new Room("Familiar", "Habitación para familias, dos camas dobles y área de juegos.", 6, "Familiar", 280.0f),
        new Room("Deluxe", "Habitación exclusiva con vista panorámica, minibar y desayuno buffet.", 2, "Deluxe", 450.0f)),
        300.0f)
      );
    accommodations.add(
      new Stay("Finca El Paraíso", 4.8f, "Santa Marta", "Hermosa finca cafetera rodeada de montañas y paisajes espectaculares", AccommodationType.FARM, Arrays.asList(
        new Room("Suite", "Suite con jacuzzi privado y terraza con vista al cafetal, incluye desayuno típico", 4, "Suite", 300.0f),
        new Room("Familiar", "Habitación amplia con dos camas dobles y balcón al jardín, incluye hamaca", 6, "Familiar", 250.0f),
        new Room("Individual", "Habitación sencilla con cama individual y baño privado, incluye conexión Wi-Fi", 5, "Individual", 120.0f),
        new Room("Doble", "Habitación doble con decoración rústica, incluye balcón con vista al paisaje cafetero", 8, "Doble", 180.0f),
        new Room("Deluxe", "Habitación de lujo con piscina privada y chimenea, incluye minibar y vistas panorámicas", 2, "Deluxe", 450.0f)),
        250.0f)
      );
    accommodations.add(
      new Stay("Finca Los Alpes", 4.7f, "Pereira", "Finca tradicional con acceso a senderos ecológicos y cascadas", AccommodationType.FARM, Arrays.asList(
        new Room("Suite", "Suite con jacuzzi y sala de estar, incluye desayuno y tour por la finca", 3, "Suite", 320.0f),
        new Room("Familiar", "Habitación para familias con capacidad para 5 personas, incluye área de juegos", 5, "Familiar", 260.0f),
        new Room("Individual", "Habitación económica para viajeros, incluye cama sencilla y baño privado", 6, "Individual", 100.0f),
        new Room("Doble", "Habitación doble con balcón y vista a los paisajes montañosos", 7, "Doble", 200.0f),
        new Room("Deluxe", "Habitación de lujo con chimenea y terraza privada, incluye cena romántica", 2, "Deluxe", 500.0f)),
        270.0f)
      );
    accommodations.add(
      new Stay("Finca Las Palmas", 4.5f, "Pereira", "Finca rústica con ambiente acogedor y cercanía a parques naturales", AccommodationType.FARM, Arrays.asList(
        new Room("Suite", "Suite amplia con jacuzzi y terraza privada, incluye desayuno típico y minibar", 3, "Suite", 310.0f),
        new Room("Familiar", "Habitación ideal para familias grandes, incluye sala de estar y cocina equipada", 4, "Familiar", 240.0f),
        new Room("Individual", "Habitación sencilla con cama individual, ventilador y vistas al jardín", 5, "Individual", 110.0f),
        new Room("Doble", "Habitación doble con balcón y hamaca, incluye desayuno incluido", 8, "Doble", 190.0f),
        new Room("Deluxe", "Habitación premium con piscina privada y terraza con vista panorámica", 2, "Deluxe", 450.0f)),
        240.0f)
      );
    accommodations.add(
      new Stay("Finca El Bosque", 4.6f, "Medellín", "Finca ecológica rodeada de bosques tropicales y actividades de aventura", AccommodationType.FARM, Arrays.asList(
        new Room("Suite", "Suite con jacuzzi y terraza, incluye acceso a senderos ecológicos y actividades de aventura", 3, "Suite", 300.0f),
        new Room("Familiar", "Habitación espaciosa con dos camas dobles y área para niños, incluye desayuno", 5, "Familiar", 260.0f),
        new Room("Individual", "Habitación cómoda para viajeros solitarios, incluye cama sencilla y baño privado", 4, "Individual", 100.0f),
        new Room("Doble", "Habitación doble con balcón y hamaca, incluye vista a la naturaleza", 6, "Doble", 180.0f),
        new Room("Deluxe", "Habitación exclusiva con terraza privada y cena romántica incluida", 1, "Deluxe", 450.0f)),
        260.0f)
      );
    accommodations.add(
      new Stay("Finca La Esperanza", 4.9f, "Guatapé", "Finca moderna con vistas al embalse y múltiples actividades recreativas", AccommodationType.FARM, Arrays.asList(
        new Room("Familiar", "Habitación amplia con dos camas dobles, balcón y zona de juegos infantiles", 6, "Familiar", 300.0f),
        new Room("Individual", "Habitación sencilla con baño privado y conexión Wi-Fi", 5, "Individual", 150.0f),
        new Room("Doble", "Habitación doble con decoración moderna y vistas al embalse", 7, "Doble", 200.0f),
        new Room("Deluxe", "Habitación premium con piscina privada y terraza panorámica", 2, "Deluxe", 500.0f)),
        300.0f)
      );
    accommodations.add(
      new Stay("Apartamento Central Park", 4.8f, "Medellín", "Moderno apartamento en el centro de la ciudad con acceso a servicios premium", AccommodationType.APARTMENT, Arrays.asList(
        new Room("Suite", "Suite con vistas a la ciudad, incluye cocina completamente equipada y balcón", 2, "Suite", 400.0f),
        new Room("Familiar", "Apartamento con dos habitaciones, sala y comedor, ideal para familias", 5, "Familiar", 300.0f),
        new Room("Individual", "Apartamento estudio con cama individual, cocina y baño privado", 4, "Individual", 200.0f),
        new Room("Doble", "Habitación doble con decoración moderna, incluye Wi-Fi y televisión inteligente", 6, "Doble", 250.0f),
        new Room("Deluxe", "Apartamento premium con terraza y jacuzzi privado, incluye servicio de limpieza diario", 2, "Deluxe", 600.0f)),
        350.0f)
      );
    accommodations.add(
      new Stay("Apartamento Skyline", 4.7f, "Bogotá", "Apartamento de lujo con vistas panorámicas y acceso a zonas exclusivas", AccommodationType.APARTMENT, Arrays.asList(
        new Room("Suite", "Suite de lujo con jacuzzi y sala de estar, incluye vistas al horizonte", 2, "Suite", 450.0f),
        new Room("Familiar", "Apartamento con tres habitaciones, cocina equipada y zona de juegos", 6, "Familiar", 350.0f),
        new Room("Individual", "Apartamento tipo estudio con baño privado y cocina pequeña", 3, "Individual", 180.0f),
        new Room("Doble", "Habitación doble con cama king size, incluye decoración minimalista y balcón", 4, "Doble", 280.0f),
        new Room("Deluxe", "Apartamento exclusivo con terraza privada, chimenea y minibar", 2, "Deluxe", 650.0f)),
        380.0f)
      );
    accommodations.add(
      new Stay("Apartamento Costa Azul", 4.9f, "Cartagena", "Apartamento frente al mar con acceso directo a la playa y piscina", AccommodationType.APARTMENT, Arrays.asList(
        new Room("Suite", "Suite con vista al mar, incluye jacuzzi y balcón privado", 2, "Suite", 500.0f),
        new Room("Familiar", "Apartamento de dos habitaciones, ideal para familias, con cocina y sala de estar", 5, "Familiar", 400.0f),
        new Room("Individual", "Estudio con cama individual, vista al mar y acceso a la piscina", 3, "Individual", 220.0f),
        new Room("Doble", "Habitación doble con cama queen size, incluye decoración náutica", 4, "Doble", 300.0f),
        new Room("Deluxe", "Apartamento premium con terraza panorámica y jacuzzi frente al mar", 2, "Deluxe", 700.0f)),
        450.0f)
      );
    accommodations.add(
      new Stay("Apartamento Loft 72", 4.6f, "Cali", "Apartamento estilo loft en el centro de la ciudad, ideal para viajes de negocios", AccommodationType.APARTMENT, Arrays.asList(
        new Room("Suite", "Suite con cocina equipada y área de trabajo, incluye vistas a la ciudad", 2, "Suite", 350.0f),
        new Room("Familiar", "Apartamento con dos habitaciones, ideal para familias, con sala de TV", 5, "Familiar", 280.0f),
        new Room("Individual", "Apartamento tipo estudio con cocina pequeña y baño privado", 3, "Individual", 170.0f),
        new Room("Doble", "Habitación doble con decoración moderna y balcón", 4, "Doble", 220.0f),
        new Room("Deluxe", "Apartamento exclusivo con terraza y jacuzzi privado, incluye desayuno incluido", 2, "Deluxe", 550.0f)),
        300.0f)
      );
    accommodations.add(
      new Stay("Apartamento Brisa Marina", 4.8f, "Medellin", "Apartamento moderno con vista al mar y acceso a áreas sociales", AccommodationType.APARTMENT, Arrays.asList(
        new Room("Suite", "Suite frente al mar con cocina completa y balcón privado", 2, "Suite", 450.0f),
        new Room("Familiar", "Apartamento amplio con tres habitaciones y sala de estar", 6, "Familiar", 380.0f),
        new Room("Individual", "Apartamento tipo estudio con baño privado y aire acondicionado", 4, "Individual", 200.0f),
        new Room("Doble", "Habitación doble con cama king size, incluye Wi-Fi y Smart TV", 5, "Doble", 260.0f),
        new Room("Deluxe", "Apartamento de lujo con terraza y piscina privada, incluye vistas panorámicas", 2, "Deluxe", 600.0f)),
        400.0f)
      );
    accommodations.add(
      new DayPass("Hotel Tropical Sunset", 4.5f, "Cartagena", "Disfruta de un día en la playa con acceso a piscina, restaurante y actividades acuáticas", AccommodationType.DAYPASS, Arrays.asList(
        new Service("Piscina", "Piscina infinita con vista al mar y servicio de bar"),
        new Service("Restaurante", "Buffet con especialidades caribeñas y opciones internacionales"),
        new Service("Actividades", "Kayak, paddle board y clases de baile en la playa")),
        300.0f)
      );
    accommodations.add(
      new DayPass("Resort Montaña Serena", 4.7f, "Guatapé", "Día de relajación en un resort ecológico con acceso a spa, senderos naturales y gastronomía local", AccommodationType.DAYPASS, Arrays.asList(
        new Service("Spa", "Circuito de aguas termales y masajes relajantes"),
        new Service("Senderos", "Caminatas guiadas por bosques y miradores naturales"),
        new Service("Restaurante", "Platos preparados con ingredientes locales y frescos")),
        250.0f)
      );
    accommodations.add(
      new DayPass("Club Náutico Bahía Azul", 4.6f, "Santa Marta", "Un día exclusivo con acceso a deportes náuticos, piscina y playa privada", AccommodationType.DAYPASS, Arrays.asList(
        new Service("Deportes Náuticos", "Snorkel, jetski y paseos en lancha por la bahía"),
        new Service("Piscina", "Piscina semiolímpica con servicio de coctelería"),
        new Service("Playa", "Zona privada con cabañas y atención personalizada")),
        350.0f)
      );
    accommodations.add(
      new DayPass("Finca Paraíso Tropical", 4.9f, "San Andrés", "Escápate a un paraíso tropical con actividades para toda la familia", AccommodationType.DAYPASS, Arrays.asList(
        new Service("Piscina", "Zona de piscinas con toboganes y área infantil"),
        new Service("Zoológico", "Interacción con animales locales y exóticos"),
        new Service("Restaurante", "Buffet familiar con platos locales e internacionales")),
        200.0f)
      );
    accommodations.add(
      new DayPass("Centro Recreativo Sol y Luna", 4.3f, "Cali", "Un día lleno de diversión con acceso a parques acuáticos, zonas deportivas y entretenimiento para todas las edades", AccommodationType.DAYPASS, Arrays.asList(
        new Service("Parque Acuático", "Toboganes, ríos lentos y piscinas temáticas"),
        new Service("Zonas Deportivas", "Canchas de fútbol, baloncesto y vóleibol"),
        new Service("Entretenimiento", "Show en vivo, música y actividades para niños")),
        180.0f)
    );
  }
}