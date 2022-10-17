package com.project.software_project.Dao;

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

    public boolean LoginCoachDao(Integer id, String password)
    {
        Optional<CoachesEntity> CouchEntity;
        CouchEntity= Optional.ofNullable(CouchReposotry.findAllByIdAndPassword(id, password));
        if(CouchEntity.isPresent()){return Boolean.TRUE;}
        else{return Boolean.FALSE;}
    }


    public void SignUpCoachDao(CoachesEntity Coach)
    {
        this.CouchReposotry.save(Coach);
    }
}
