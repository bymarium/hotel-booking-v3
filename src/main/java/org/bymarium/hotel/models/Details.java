package org.bymarium.hotel.models;
import org.bymarium.hotel.constants.AccommodationType;

import java.time.LocalDate;

public class Details {
    private LocalDate startDate;
    private Integer childrenQuantity;
    private Integer adultsQuantity;

    public Details(
        LocalDate startDate,
        Integer childrenQuantity,
        Integer adultsQuantity
    ) {
        this.startDate = startDate;
        this.childrenQuantity = childrenQuantity;
        this.adultsQuantity = adultsQuantity;
    }

    public Details() {
    }

    public String printDetails() {
        return "============= DETALLES DE LA RESERVA =============\n" +
                "Fecha: " + getStartDate() + "\n" +
                "Niños: " + getChildrenQuantity() + "\n" +
                "Adultos: " + getAdultsQuantity() + "\n";
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
}