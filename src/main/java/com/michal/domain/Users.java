package com.michal.domain;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Mike on 2017-07-07.
 */
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {

    @XmlElement(name="user")
    private List<User> users;

    public Users() {
    }

    public Users(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
