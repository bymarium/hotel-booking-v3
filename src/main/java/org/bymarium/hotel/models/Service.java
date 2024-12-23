package org.bymarium.hotel.models;

import java.util.UUID;

public class Service {
  private String name;
  private String description;
  private String id;

  public Service(String name, String description) {
    this.name = name;
    this.description = description;
    this.id = UUID.randomUUID().toString();
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

  public String getId() {
    return id;
  }
}