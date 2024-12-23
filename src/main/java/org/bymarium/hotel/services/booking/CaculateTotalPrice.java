package org.bymarium.hotel.services.booking;

import org.bymarium.hotel.constants.AccommodationType;
import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.models.DetailsStay;
import org.bymarium.hotel.services.interfaces.ICommandParameterized;

import java.time.LocalDate;

public class CaculateTotalPrice implements ICommandParameterized<Booking, Booking> {

  @Override
  public Booking execute(Booking booking) {
    if (!booking.getAccommodation().getType().equals(AccommodationType.DAYPASS)) {
      DetailsStay detailsStay = (DetailsStay) booking.getDetails();
      LocalDate startDate = detailsStay.getStartDate();
      LocalDate endDate = detailsStay.getEndDate();

      int betweenDays = endDate.getDayOfMonth() - startDate.getDayOfMonth();

      int startDay = startDate.getDayOfMonth();
      int endDay = endDate.getDayOfMonth();

      int lastDate = endDate.withDayOfMonth(endDate.lengthOfMonth()).getDayOfMonth() - 4;

      float totalPrice = detailsStay.getTotalPrice() * betweenDays;
      float discount = 0.0f;
      float increment = 0.0f;
      if (startDay >= lastDate || endDay >= lastDate) {
        increment = totalPrice * 0.15f;
        detailsStay.setIncrement(increment);
      }

      if ((startDay >= 10 && startDay <= 15) && (endDay >= 10 && endDay <= 15)) {
        increment = totalPrice * 0.10f;
        detailsStay.setIncrement(increment);
      }

      if ((startDay >= 5 && startDay <= 10) && (endDay >= 5 && endDay <= 10)) {
        discount = totalPrice * 0.08f;
        detailsStay.setDiscount(discount);
      }

      totalPrice += increment;
      totalPrice -= discount;
      detailsStay.setTotalPrice(totalPrice);
      booking.setDetails(detailsStay);
    }

    return booking;
  }
}
