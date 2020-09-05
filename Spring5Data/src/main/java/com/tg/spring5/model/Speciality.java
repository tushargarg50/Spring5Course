package com.tg.spring5.model;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Speciality extends BaseEntity {

    private final String specialityName;
    private final String description;

    public Speciality(String specialityName, String description) {
        this.specialityName = specialityName;
        this.description = description;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public String getDescription() {
        return description;
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
