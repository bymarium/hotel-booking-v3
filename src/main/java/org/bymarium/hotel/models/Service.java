package org.bymarium.hotel.models;

public class Service {
  private String name;
  private String description;

  public Service(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Service() {
  }

  public String printService() {
    return "Nombre: " + name + "\n" +
      "Descripción: " + description + "\n";
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }
}