package org.bymarium.hotel.models;

import org.bymarium.hotel.constants.AccommodationType;

import java.time.LocalDate;

public class DetailsStay extends Details {
    private LocalDate endDate;
    private Integer roomsQuantity;

    public DetailsStay(
        LocalDate startDate,
        LocalDate endDate,
        Integer adultsQuantity,
        Integer childrenQuantity,
        Integer roomsQuantity
    ) {
        super(startDate, childrenQuantity, adultsQuantity);
        this.endDate = endDate;
        this.roomsQuantity = roomsQuantity;
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
          "Habitaciones: " + getRoomsQuantity() + "\n";
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
}