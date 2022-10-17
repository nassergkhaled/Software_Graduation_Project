package com.project.software_project.Reposorty;

import com.project.software_project.Entity.PlayersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayersRepo extends JpaRepository<PlayersEntity,Integer> {

    public PlayersEntity findAllByIdAndPassword(Integer id,String password);
    //insert is done in the dao directly using save () from jpa



}
