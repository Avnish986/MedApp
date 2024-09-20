package com.test2.patient;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    String name;
    List<String> appointments;

    public Patient(String name) {
        this.name = name;
        this.appointments = new ArrayList<>();
    }

    public void bookAppointment(String appointment) {
        appointments.add(appointment);
    }

    public void cancelAppointment(String appointment) {
        appointments.remove(appointment);
    }

    public List<String> getAppointmentList() {
        return appointments;
    }
}
