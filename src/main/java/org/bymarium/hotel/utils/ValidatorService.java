package org.bymarium.hotel.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ValidatorService {
  private final Scanner scanner;

  public ValidatorService(Scanner scanner) {
    this.scanner = scanner;
  }

  public String readString(String message) {
    System.out.println(message);
    return scanner.nextLine();
  }

  public Integer readInt(String message) {
    int input;
    try {
      System.out.println(message);
      input = Integer.parseInt(scanner.nextLine());
      return input;
    } catch (NumberFormatException e) {
      System.err.println("Entrada inválida. Por favor ingrese un número entero.");
      return readInt(message);
    }
  }

  public LocalDate readLocalDate(String message) {
    LocalDate date;
    try {
      System.out.println(message);
      date = LocalDate.parse(scanner.nextLine());
      return date;
    } catch (Exception e) {
      System.err.println("Fecha inválida. El formato debe ser: yyyy-MM-dd");
      return readLocalDate(message);
    }
  }

  public LocalTime readLocalTime(String message) {
    LocalTime time;
    try {
      System.out.println(message);
      time = LocalTime.parse(scanner.nextLine());
      return time;
    } catch (Exception e) {
      System.err.println("Hora inválida. El formato debe ser: HH:mm");
      return readLocalTime(message);
    }
  }
}