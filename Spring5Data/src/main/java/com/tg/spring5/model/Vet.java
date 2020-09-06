package com.tg.spring5.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "vet_specialities",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialities_id"))
    private final Set<Speciality> specialities;

    public Vet() {
        super(null, null, null);
        specialities = new HashSet<>();
    }

    public Vet(String firstName, String lastName, Address address) {
        super(firstName, lastName, address);
        this.specialities = new HashSet<>();
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void addSpeciality(Speciality speciality) {
        speciality.addVet(this);
        specialities.add(speciality);
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
