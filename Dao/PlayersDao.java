package com.project.software_project.Dao;

import com.project.software_project.Entity.PlayersEntity;
import com.project.software_project.Reposorty.PlayersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayersDao {


    @Autowired
    private PlayersRepo PlayerReposotry;

    public Boolean  LoginPlayerDao (Integer id, String password)
    {
        Optional <PlayersEntity> PlayerEntity;
        PlayerEntity= Optional.ofNullable(PlayerReposotry.findAllByIdAndPassword(id, password));
        if(PlayerEntity.isPresent()){return Boolean.TRUE;}
        else{return Boolean.FALSE;}
    }
    public void SignUpPlayerDao(PlayersEntity Player)
    {
        this.PlayerReposotry.save(Player);
    }


}
