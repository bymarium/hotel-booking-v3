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

      int stayDurationDays = endDate.getDayOfMonth() - startDate.getDayOfMonth();
      int startDay = startDate.getDayOfMonth();
      int endDay = endDate.getDayOfMonth();
      int lastFiveDaysStart = endDate.withDayOfMonth(endDate.lengthOfMonth()).getDayOfMonth() - 4;

      float totalPrice = detailsStay.getTotalPrice() * stayDurationDays;

      applyLastFiveDaysIncrement(startDay, lastFiveDaysStart, endDay, detailsStay, totalPrice);
      applyMidMonthIncrement(startDay, endDay, detailsStay, totalPrice);
      applyEarlyMonthDiscount(startDay, endDay, detailsStay, totalPrice);

      totalPrice += detailsStay.getIncrement();
      totalPrice -= detailsStay.getDiscount();

      detailsStay.setTotalPrice(totalPrice);
      booking.setDetails(detailsStay);
    }
    return booking;
  }

  private void applyEarlyMonthDiscount(int startDay, int endDay, DetailsStay detailsStay, float totalPrice) {
    if (isWithinRange(startDay, 5, 10) && isWithinRange(endDay, 5, 10)) {
      detailsStay.setDiscount(totalPrice * 0.08f);
    }
  }

  private void applyMidMonthIncrement(int startDay, int endDay, DetailsStay detailsStay, float totalPrice) {
    if (isWithinRange(startDay, 10, 15) && isWithinRange(endDay, 10, 15)) {
      detailsStay.setIncrement(totalPrice * 0.10f);
    }
  }

  private void applyLastFiveDaysIncrement(int startDay, int lastFiveDaysStart, int endDay, DetailsStay detailsStay, float totalPrice) {
    if (startDay >= lastFiveDaysStart || endDay >= lastFiveDaysStart) {
      detailsStay.setIncrement(totalPrice * 0.15f);
    }
  }

  private boolean isWithinRange(int day, int start, int end) {
    return day >= start && day <= end;
  }
}
