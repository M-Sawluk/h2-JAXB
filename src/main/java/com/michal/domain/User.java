package com.michal.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Mike on 2017-07-01.
 */
@Entity
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(Address.class)
public class User {

    @Id @GeneratedValue
    private long id;
    private String name;

    @JsonManagedReference
    @ManyToMany
    private List<Address> address;

    public User() {
    }

    public User(String name, List<Address> address) {
        this.name = name;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}
