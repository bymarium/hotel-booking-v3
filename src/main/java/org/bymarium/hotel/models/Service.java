package org.bymarium.hotel.models;

public class Service {
  private String name;
  private String description;
  private Integer quantity;

  public Service(String name, String description, Integer quantity) {
    this.name = name;
    this.description = description;
    this.quantity = quantity;
  }

  public Service(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Service() {
  }

  public String printService() {
    return "Nombre: " + name + "\n" +
      "Descripción: " + description + "\n" +
      "Cantidad: " + quantity + "\n";
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Integer getQuantity() {
    return quantity;
  }
}