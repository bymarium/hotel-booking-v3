package org.bymarium.hotel.services.interfaces;

public interface ICommand<T> {
  T execute();
}
