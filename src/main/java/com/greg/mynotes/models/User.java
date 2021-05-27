package com.greg.mynotes.models;

/**
 *
 * Created by Gregory Roberts on 5/27/21
 *
 */

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private boolean enabled;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    /**
     * Get user id
     * @return user id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set user id
     * @param id user id to be set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get user email
     * @return user email
     */
    public String getEmail() {
        return email;
    }

    /**
     * set user email
     * @param email new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get user pass
     * @return user pass
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set user pass
     * @param password value to set as password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get user first name
     * @return user first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set user first name
     * @param firstName value to set first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get user last name
     * @return user last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set user last name
     * @param lastName value to set for last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get enabled status from user as boolean
     * @return boolean specifying if user is enabled or not
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Set enabled status of user
     * @param enabled Value to set enabled status to
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Get the user roles as a set
     * @return Set for user roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Set the user roles with a set
     * @param roles Set of user roles
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
