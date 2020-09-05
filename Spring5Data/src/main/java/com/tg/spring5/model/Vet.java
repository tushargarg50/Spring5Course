package com.tg.spring5.model;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Vet extends Person {

    private final Set<Speciality> specialities;

    public Vet(String firstName, String lastName, Address address, Set<Speciality> specialities) {
        super(firstName, lastName, address);
        this.specialities = (specialities != null) ? specialities : new HashSet<>();
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vet vet = (Vet) o;
        return Objects.equals(specialities, vet.specialities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), specialities);
    }

    @Override
    public String toString() {
        return "Vet{" +
                "specialities=" + specialities +
                "} " + super.toString();
    }
}
