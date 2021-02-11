package com.taskmanager.taskmanager.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    @ManyToMany(mappedBy = "roles")
    private Set<Users> users;

    public Long getRoleId() {
        return id;
    }

    public void setRoleId(Long roleId) {
        this.id = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }
}