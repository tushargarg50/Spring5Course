package com.tg.spring5.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Owner extends Person {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet_id")
    private final Set<Pet> pets;

    public Owner(String firstName, String lastName, Address address, Set<Pet> pets) {
        super(firstName, lastName, address);
        this.pets = pets == null ? new HashSet<>() : pets;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(pets, owner.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pets);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "pets=" + pets +
                "} " + super.toString();
    }
}
