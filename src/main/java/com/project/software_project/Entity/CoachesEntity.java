package com.project.software_project.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "coaches")
@Data
public class CoachesEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    public Integer phone;
    public String email;
    public String firstname;
    public String lastname;
    public String password;

}
