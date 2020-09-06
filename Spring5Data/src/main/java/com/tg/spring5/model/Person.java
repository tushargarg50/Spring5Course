package com.tg.spring5.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import java.util.Objects;

@MappedSuperclass
public class Person extends BaseEntity {

    @Column
    private final String firstName;
    @Column
    private final String lastName;
    @OneToOne
    private final Address address;

    public Person(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                "} " + super.toString();
    }
}
