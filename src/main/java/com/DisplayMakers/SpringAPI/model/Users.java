package com.DisplayMakers.SpringAPI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name = "users_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    String id;
    @Column(name = "login")
    String login;
    @Column(name = "password")
    String password;
    @Column(name = "email")
    String email;
}
