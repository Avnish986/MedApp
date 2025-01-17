package com.test2;

import com.test2.app.AppointmentService;
import com.test2.doctor.Speciality;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        AppointmentService service = new AppointmentService();
        service.registerDoctor("Dr. Smith", Speciality.CARDIOLOGIST);
        service.markDoctorAvailable("Dr. Smith", "10:00");
        service.registerPatient("John Doe");
        service.bookAppointment("Dr. Smith", "John Doe", "10:00");
        service.showAvailabilityAppointment(Speciality.CARDIOLOGIST);
        service.cancelAppointment("Dr. Smith", "John Doe", "10:00");
        service.showAppointmentList("John Doe");

    }
}