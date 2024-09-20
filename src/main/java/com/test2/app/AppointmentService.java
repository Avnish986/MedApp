package com.test2.app;

import com.test2.doctor.Doctor;
import com.test2.doctor.Speciality;
import com.test2.patient.Patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentService {
    private Map<String, Doctor> doctors;
    private Map<String, Patient> patients;

    public AppointmentService() {
        this.doctors = new HashMap<>();
        this.patients = new HashMap<>();
    }

    public void registerDoctor(String name, Speciality  speciality) {
        doctors.put(name, new Doctor(name, speciality));
        System.out.println("Doctor registered successfully: " + name);
    }

    public void registerPatient(String name) {
        patients.put(name, new Patient(name));
        System.out.println("Patient registered successfully: " + name);
    }

    public void markDoctorAvailable(String doctorName, String slot) {
        Doctor doctor = doctors.get(doctorName);
        if (doctor!= null) {
            doctor.setAvailability(slot);
            System.out.println("Doctor marked as available: " + doctorName + " at " + slot);
        } else {
            System.out.println("Doctor not found: " + doctorName);
        }
    }

    public void showAvailabilityAppointment(Speciality speciality) {
        for (Doctor doctor : doctors.values()) {
            if (doctor.getSpeciality().equals(speciality)) {
                for (Map.Entry<String, Boolean> entry : doctor.getAvailability().entrySet()) {
                    if (entry.getValue()) {
                        System.out.println("Dr." + doctor.getName() + " is available" + " at " + entry.getKey());
                    }
                }
            }
        }
    }

    public void bookAppointment(String doctorName, String patientName, String slot) {
        Doctor doctor = doctors.get(doctorName);
        Patient patient = patients.get(patientName);
        if (doctor != null && patient != null && doctor.isAvailable(slot)) {
            doctor.bookSlot(slot);
            patient.bookAppointment("Dr. " + doctor.getName() + " at " + slot);
            System.out.println("Appointment booked successfully: Dr." + doctorName + " for " + patientName + " at " + slot);
        } else {
            System.out.println("Doctor or patient not found.");
        }
    }

    public void cancelAppointment(String doctorName, String patientName, String slot) {
        Doctor doctor = doctors.get(doctorName);
        Patient patient = patients.get(patientName);
        if (doctor!= null && patient!= null) {
            doctor.cancelSlot(slot);
            patient.cancelAppointment("Dr. " + doctor.getName() + " at " + slot);
            System.out.println("Appointment canceled successfully: Dr." + doctorName + " for " + patientName + " at " + slot);
        } else {
            System.out.println("Doctor or patient not found.");
        }
    }

    public void showAppointmentList(String patientName) {
        Patient patient = patients.get(patientName);
        if (patient != null) {
            List<String> appointments = patient.getAppointmentList();
            if (!appointments.isEmpty()) {
                System.out.println("Appointments for " + patientName + ":");
                for (String appointment : appointments) {
                    System.out.println(appointment);
                }
            } else {
                System.out.println("No appointments found for " + patientName);
            }
        } else {
            System.out.println("Patient not found: " + patientName);
        }
    }
}
