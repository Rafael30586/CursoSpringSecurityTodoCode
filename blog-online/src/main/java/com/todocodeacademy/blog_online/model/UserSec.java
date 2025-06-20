package com.todocodeacademy.blog_online.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "users")
@Entity
public class UserSec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private boolean enabled;
    private boolean accountNotExpired;
    private boolean accountNotLocked;
    private boolean credentialNotExpired;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="user_roles", joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roleList = new HashSet<>();

    public UserSec() {
    }

    public UserSec(Long id, String username, String password, boolean enabled, boolean accountNotExpired, boolean accountNotLocked, Set<Role> roleList, boolean credentialNotExpired) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountNotExpired = accountNotExpired;
        this.accountNotLocked = accountNotLocked;
        this.roleList = roleList;
        this.credentialNotExpired = credentialNotExpired;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAccountNotExpired() {
        return accountNotExpired;
    }

    public void setAccountNotExpired(boolean accountNotExpired) {
        this.accountNotExpired = accountNotExpired;
    }

    public boolean isAccountNotLocked() {
        return accountNotLocked;
    }

    public void setAccountNotLocked(boolean accountNotLocked) {
        this.accountNotLocked = accountNotLocked;
    }

    public Set<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<Role> roleList) {
        this.roleList = roleList;
    }

    public boolean isCredentialNotExpired() {
        return credentialNotExpired;
    }

    public void setCredentialNotExpired(boolean credentialNotExpired) {
        this.credentialNotExpired = credentialNotExpired;
    }
}
