package com.tg.spring5.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity {

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "specialities")
    private final Set<Vet> vets;
    @Column
    private String specialityName;
    @Column
    private String description;

    public Speciality() {
        vets = new HashSet<>();
    }

    public Speciality(String specialityName, String description) {
        this.specialityName = specialityName;
        this.description = description;
        vets = new HashSet<>();
    }

    public Set<Vet> getVets() {
        return vets;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public String getDescription() {
        return description;
    }

    protected void addVet(Vet vet) {
        vets.add(vet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speciality that = (Speciality) o;
        return Objects.equals(specialityName, that.specialityName) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialityName, description);
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "specialityName='" + specialityName + '\'' +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }
}
