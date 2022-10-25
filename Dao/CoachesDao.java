package com.project.software_project.Dao;

import com.project.software_project.Dto.LogInBody;
import com.project.software_project.Dto.ResetPasswordBody;
import com.project.software_project.Dto.UpdatePasswordBody;
import com.project.software_project.Entity.CoachesEntity;
import com.project.software_project.Entity.PlayersEntity;
import com.project.software_project.Reposorty.CoachesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoachesDao
{
    @Autowired
    private CoachesRepo CouchReposotry;

    public boolean LoginCoachDao(String email, String password)
    {
        try {
            Optional<CoachesEntity> CouchEntity;
            CouchEntity= Optional.ofNullable(CouchReposotry.findAllByEmailAndPassword(email, password));
            if(CouchEntity.isPresent()){return Boolean.TRUE;}
            else{return Boolean.FALSE;}
        }
        catch (Exception  e)
        {
            return Boolean.FALSE;
        }
    }


    public String SignUpCoachDao(CoachesEntity Coach)
    {
        try {
            if(this.CouchReposotry.existsByEmail(Coach.getEmail())){return "Email Is Already In Use";}
            else if (this.CouchReposotry.existsByPhone(Coach.getPhone())) {return "This Phone Number Is Already in Use ";}
            this.CouchReposotry.save(Coach);
            return " Success";
        }
        catch (Exception  e)
        {
            return "Failed";
        }

    }

    public String ResetPassword(ResetPasswordBody resetPasswordBody) {
        try{
            Optional<CoachesEntity> CoachEntity;
            CoachEntity=Optional.ofNullable(this.CouchReposotry.findById(resetPasswordBody.getId())).get();
            CoachEntity.get().setPassword(resetPasswordBody.getNewPassword());
            this.CouchReposotry.save(CoachEntity.get());
            return "Success";
        }
        catch (Exception e)
        {
            return "Failed";
        }
    }

    public String UpdatePassword(UpdatePasswordBody body) {
        try {
            Optional<CoachesEntity> CoachEntity;
            CoachEntity= Optional.ofNullable(this.CouchReposotry.findAllByEmailAndPassword(body.getEmail(), body.getOld()));
            CoachEntity.get().setPassword(body.getPassword());
            this.CouchReposotry.save(CoachEntity.get());
            return "Success";
        }
        catch (Exception  e)
        {
            return "Failed";
        }
    }
}
