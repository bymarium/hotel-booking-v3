package org.bymarium.hotel.models;

import org.bymarium.hotel.constants.AccommodationType;

import java.time.LocalDate;

public class Details {
  private LocalDate startDate;
  private Integer childrenQuantity;
  private Integer adultsQuantity;
  private Float totalPrice;

  public Details(LocalDate startDate, Integer childrenQuantity, Integer adultsQuantity, Float totalPrice) {
    this.startDate = startDate;
    this.childrenQuantity = childrenQuantity;
    this.adultsQuantity = adultsQuantity;
    this.totalPrice = totalPrice;
  }

  public Details() {
  }

  public String printDetails() {
    return "============= DETALLES DE LA RESERVA =============\n" +
      "Fecha: " + getStartDate() + "\n" +
      "Niños: " + getChildrenQuantity() + "\n" +
      "Adultos: " + getAdultsQuantity() + "\n" +
      "Precio total: " + getTotalPrice() + "\n";
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public Integer getChildrenQuantity() {
    return childrenQuantity;
  }

  public void setChildrenQuantity(Integer childrenQuantity) {
    this.childrenQuantity = childrenQuantity;
  }

  public Integer getAdultsQuantity() {
    return adultsQuantity;
  }

  public void setAdultsQuantity(Integer adultsQuantity) {
    this.adultsQuantity = adultsQuantity;
  }

  public Float getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Float totalPrice) {
    this.totalPrice = totalPrice;
  }
}