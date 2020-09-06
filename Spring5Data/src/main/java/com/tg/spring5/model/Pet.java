package com.tg.spring5.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Pet extends BaseEntity {

    @Column
    @Convert(converter = PetTypeConverter.class)
    private PetType petType;
    @Column
    private String name;
    @Column
    private LocalDate birthDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Pet() {
    }

    public Pet(PetType petType, String name, LocalDate birthDate) {
        this.petType = petType;
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Owner getOwner() {
        return owner;
    }

    protected void setOwner(Owner owner) {
        this.owner = owner;
    }

    public PetType getPetType() {
        return petType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return petType == pet.petType &&
                Objects.equals(name, pet.name) &&
                Objects.equals(birthDate, pet.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petType, name, birthDate);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petType=" + petType +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                "} " + super.toString();
    }
}
