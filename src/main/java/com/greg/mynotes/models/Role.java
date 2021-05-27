package com.greg.mynotes.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    /**
     * Get role id
     * @return role id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set role id
     * @param id value to set as id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the role name
     * @return role name
     */
    public String getRole() {
        return role;
    }

    /**
     * Set the role name
     * @param role name to set for role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Get a set of users
     * @return set of users
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * Set the set of users
     * @param users new set of users to set
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
