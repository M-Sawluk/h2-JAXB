package com.michal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mike on 2017-07-01.
 */
@Entity
@Data

public class User {

    @Id @GeneratedValue
    private long id;
    private String name;
    @ManyToMany
    private List<Address> address;

}
