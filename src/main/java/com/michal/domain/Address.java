package com.michal.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mike on 2017-07-01.
 */
@Entity
@Data
public class Address {
    @Id
    @GeneratedValue
    private long id;
    private String city;
    @ManyToMany(mappedBy = "address" , cascade = CascadeType.ALL)
    private List<User> users;
}
