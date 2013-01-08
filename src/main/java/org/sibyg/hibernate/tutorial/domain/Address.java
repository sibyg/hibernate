package org.sibyg.hibernate.tutorial.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
//@Audited
@SequenceGenerator(name = "address_seq", sequenceName = "address_id_seq", allocationSize = 1)
public class Address {
    @Id
    @GeneratedValue(generator = "address_seq", strategy = SEQUENCE)
    private Long id;
    private String streetName;
    private Integer houseNumber;
    private Integer flatNumber;
    @OneToMany(mappedBy = "address")
    private List<Person> persons;

    public Address() { } // for proxies

    public Address(Integer houseNumber, Integer flatNumber, String streetName, List<Person> persons) {
//        this.id = id;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.persons = persons;
    }

    public Long getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}