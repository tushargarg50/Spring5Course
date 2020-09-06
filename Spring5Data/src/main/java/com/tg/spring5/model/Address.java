package com.tg.spring5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Addresses")
public class Address extends BaseEntity {

    @Column
    private String address;
    @Column
    private String city;
    @Column
    private String state;

    public Address() {
    }

    public Address(String address, String city, String state) {
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(address, address1.address) &&
                Objects.equals(city, address1.city) &&
                Objects.equals(state, address1.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, city, state);
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                "} " + super.toString();
    }
}
