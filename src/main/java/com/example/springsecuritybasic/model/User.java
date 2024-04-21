package com.example.springsecuritybasic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users_tbl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(unique = true)
    private String email;
    private String password;

    private boolean isDisabled; //false, true -> disable
    private boolean isAccountLocked; //true if account is locked
    private boolean isAccountExpired; //true if account is expired
    private boolean isCredentialExpired;
    @ManyToMany(fetch = FetchType.EAGER)
    Set<Role> roles;
}
