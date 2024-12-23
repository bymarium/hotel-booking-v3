package org.bymarium.hotel.models;

import java.time.LocalDate;

public class DetailsStay extends Details {
  private LocalDate endDate;
  private Integer roomsQuantity;
  private Float discount;
  private Float increment;

  public DetailsStay(
    LocalDate startDate,
    LocalDate endDate,
    Integer adultsQuantity,
    Integer childrenQuantity,
    Integer roomsQuantity,
    Float totalPrice
  ) {
    super(startDate, childrenQuantity, adultsQuantity, totalPrice);
    this.endDate = endDate;
    this.roomsQuantity = roomsQuantity;
    this.discount = 0.0f;
    this.increment = 0.0f;
  }

  public DetailsStay(LocalDate endDate, Integer roomsQuantity) {
    this.endDate = endDate;
    this.roomsQuantity = roomsQuantity;
  }

  public String printDetails() {
    return "============= DETALLES DE LA RESERVA =============\n" +
      "Fecha de inicio: " + getStartDate() + "\n" +
      "Fecha de fin: " + getEndDate() + "\n" +
      "Niños: " + getChildrenQuantity() + "\n" +
      "Adultos: " + getAdultsQuantity() + "\n" +
      "Habitaciones: " + getRoomsQuantity() + "\n" +
      "Descuento: " + getDiscount() + "\n" +
      "Incremento: " + getIncrement() + "\n" +
      "Precio total: " + getTotalPrice() + "\n";
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public Integer getRoomsQuantity() {
    return roomsQuantity;
  }

  public void setRoomsQuantity(Integer roomsQuantity) {
    this.roomsQuantity = roomsQuantity;
  }

  public Float getDiscount() {
    return discount;
  }

  public void setDiscount(Float discount) {
    this.discount = discount;
  }

  public Float getIncrement() {
    return increment;
  }

  public void setIncrement(Float increment) {
    this.increment = increment;
  }
}