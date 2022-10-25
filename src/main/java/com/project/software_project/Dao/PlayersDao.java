package com.project.software_project.Dao;

import com.project.software_project.Dto.LogInBody;
import com.project.software_project.Dto.ResetPasswordBody;
import com.project.software_project.Dto.UpdatePasswordBody;
import com.project.software_project.Entity.PlayersEntity;
import com.project.software_project.Reposorty.PlayersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayersDao {


    @Autowired
    private PlayersRepo PlayerRepository;

    public Boolean  LoginPlayerDao (String email, String password)
    {
        try {
            Optional <PlayersEntity> PlayerEntity;
            PlayerEntity= Optional.ofNullable(PlayerRepository.findAllByEmailAndPassword(email, password));
            if(PlayerEntity.isPresent()){return Boolean.TRUE;}
            else{return Boolean.FALSE;}
        }
        catch (Exception  e)
        {
            return Boolean.FALSE;
        }


    }
    public String SignUpPlayerDao(PlayersEntity Player)
    {
        try {
            if(this.PlayerRepository.existsByEmail(Player.getEmail())){return "Email Is Already In Use";}
            else if (this.PlayerRepository.existsByPhone(Player.getPhone())) {return "This Phone Number Is Already in Use ";}
            this.PlayerRepository.save(Player);
            return " Success";
        }
        catch (Exception  e)
        {
            System.out.println(e.toString());
            return "Failed";
        }

    }


    public String UpdatePassword(UpdatePasswordBody body) {
        try {
            Optional<PlayersEntity> PlayerEntity;
            PlayerEntity= Optional.ofNullable(PlayerRepository.findAllByEmailAndPassword(body.getEmail(), body.getOld()));
            PlayerEntity.get().setPassword(body.getPassword());
            this.PlayerRepository.save(PlayerEntity.get());
            return "Success";
        }
        catch (Exception  e)
        {
            return "Failed";
        }

    }

    public String ResetPassword(ResetPasswordBody resetPasswordBody) {
        try{
            Optional<PlayersEntity> PlayerEntity;
            PlayerEntity= Optional.ofNullable(this.PlayerRepository.findAllById(resetPasswordBody.getId()));
            PlayerEntity.get().setPassword(resetPasswordBody.getNewPassword());
            this.PlayerRepository.save(PlayerEntity.get());
            return "Success";
        }
        catch (Exception e)
        {
            return "Failed";
        }
    }
}
