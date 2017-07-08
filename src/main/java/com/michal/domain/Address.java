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
@XmlRootElement
@XmlSeeAlso(User.class)
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    @Id
    @GeneratedValue
    @XmlElement
    private long id;
    @XmlElement
    private String city;

    @JsonBackReference
    @ManyToMany(mappedBy = "address" , cascade = CascadeType.ALL)
    @XmlTransient
    private List<User> users;

    public Address(String city, List<User> users) {
        this.city = city;
        this.users = users;
    }

    public Address() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
