package com.test2.doctor;

import java.util.HashMap;
import java.util.Map;

public class Doctor {
    private String name;
    private Speciality speciality;
    private Map<String, Boolean> availability;

    public Doctor(String name, Speciality speciality) {
        this.name = name;
        this.speciality = speciality;
        this.availability = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Map<String, Boolean> getAvailability() {
        return availability;
    }

    public void setAvailability(String slot) {
        availability.put(slot, true);
    }

    public Boolean isAvailable(String slot) {
        return availability.getOrDefault(slot, false);
    }

    public void bookSlot(String slot) {
        availability.put(slot, false);
    }

    public void cancelSlot(String slot) {
        availability.put(slot, true);
    }
}
