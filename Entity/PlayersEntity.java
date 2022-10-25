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
    public String phone;
    public String email;
    public String fullname;
    public String password;
    public boolean gender;//0 -->Female  // 1 -->Male
    public PlayerStrategy strategy;//1--> // Gym 2--> App // 3-->Personal
    public float weight;
    public float height;
    public int age;
}
