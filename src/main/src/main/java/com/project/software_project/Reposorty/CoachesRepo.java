package com.project.software_project.Reposorty;

import com.project.software_project.Entity.CoachesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoachesRepo extends JpaRepository<CoachesEntity,Integer>
{
    public CoachesEntity findAllByIdAndPassword(Integer id, String password) ;
}
