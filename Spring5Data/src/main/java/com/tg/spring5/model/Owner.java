package com.tg.spring5.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner extends Person {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private final Set<Pet> pets;

    public Owner() {
        super(null, null, null);
        pets = Collections.emptySet();
    }

    public Owner(String firstName, String lastName, Address address) {
        super(firstName, lastName, address);
        this.pets = new HashSet<>();
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        pet.setOwner(this);
        pets.add(pet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Owner owner = (Owner) o;
        return Objects.equals(pets, owner.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pets);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "pets=" + pets +
                "} " + super.toString();
    }
}
