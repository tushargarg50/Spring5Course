package com.tg.spring5.model;

import java.time.LocalDate;
import java.util.Objects;

public class Visit extends BaseEntity {

    private final LocalDate visitTime;
    private final Pet bookingFor;
    private final Vet doctor;

    public Visit(LocalDate visitTime, Pet bookingFor, Vet doctor) {
        this.visitTime = visitTime;
        this.bookingFor = bookingFor;
        this.doctor = doctor;
    }

    public LocalDate getVisitTime() {
        return visitTime;
    }

    public Pet getBookingFor() {
        return bookingFor;
    }

    public Vet getDoctor() {
        return doctor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(visitTime, visit.visitTime) &&
                Objects.equals(bookingFor, visit.bookingFor) &&
                Objects.equals(doctor, visit.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitTime, bookingFor, doctor);
    }

    @Override
    public String toString() {
        return "Visit{" +
                "visitTime=" + visitTime +
                ", bookingFor=" + bookingFor +
                ", doctor=" + doctor +
                "} " + super.toString();
    }
}
