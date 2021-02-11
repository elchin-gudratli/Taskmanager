package com.taskmanager.taskmanager.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taskmanager.taskmanager.entity.Role;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

public class UserRequest {
    private String name;

    private String surname;

    @NotBlank(message="true")
    private String username;

    private String password;

    private String email;

    private Set<String> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
