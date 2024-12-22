package org.bymarium.hotel.models;

import java.time.LocalTime;

public class Client {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String nationality;
    private String email;
    private LocalTime arrivalTime;

    public Client(
        String firstName,
        String lastName,
        String phoneNumber,
        String nationality,
        String email,
        LocalTime arrivalTime
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
        this.email = email;
        this.arrivalTime = arrivalTime;
    }

    public Client() {
    }

    public String printClient() {
    return "============= DETALLES DEL CLIENTE =============\n" +
                "Nombre: " + getFirstName() + " " + getLastName() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Nacionalidad: " + getNationality() + "\n" +
                "Teléfono: " + getPhoneNumber() + "\n" +
                "Tiempo de llegada: " + getArrivalTime() + "\n";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}