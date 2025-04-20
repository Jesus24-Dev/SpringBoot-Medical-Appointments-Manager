
package com.medicalappointments.medicalappointmentsmanager.utils;

import com.medicalappointments.medicalappointmentsmanager.enums.Shift;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentUtils {

    public static List<LocalTime> getAvailableHoursByShift(Shift shift) {
        List<LocalTime> hours = new ArrayList<>();
        
        if (shift == Shift.DAY || shift == Shift.MIXED) {
            for (int hour = 8; hour < 12; hour++) {
                hours.add(LocalTime.of(hour, 0));
            }
        }

        if (shift == Shift.NIGHT || shift == Shift.MIXED) {
            for (int hour = 14; hour < 18; hour++) {
                hours.add(LocalTime.of(hour, 0));
            }
        }

        return hours;
    }
}
