package org.bymarium.hotel.services.interfaces;

public interface ICommandParameterized <T, R>{
  T execute(R parameter);
}
