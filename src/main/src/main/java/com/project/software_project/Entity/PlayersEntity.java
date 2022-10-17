package com.project.software_project.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "players")
@Data
public class PlayersEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public Integer phone;
    public String email;
    public String firstname;
    public String lastname;
    public String password;
}
