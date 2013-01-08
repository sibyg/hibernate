package org.sibyg.hibernate.tutorial.builder;

import org.sibyg.hibernate.tutorial.domain.Address;
import org.sibyg.hibernate.tutorial.domain.Person;

import java.util.ArrayList;
import java.util.List;

import static org.sibyg.hibernate.tutorial.util.RandomGenerator.integer;
import static org.sibyg.hibernate.tutorial.util.RandomGenerator.string;


public class AddressBuilder {
    private List<Person> persons = new ArrayList<Person>();
    private Integer houseNumber = integer();
    private Integer flatNumber = integer();
    private String streetName = string();

    public AddressBuilder streetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public AddressBuilder persons(List<Person> persons) {
        this.persons = persons;
        return this;
    }

    public AddressBuilder houseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public AddressBuilder flatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
        return this;
    }

    public static AddressBuilder addressBuilder() {
        return new AddressBuilder();
    }

    public Address build() {
        Address address = new Address(houseNumber, flatNumber, streetName, persons);
        return address;
    }
}
