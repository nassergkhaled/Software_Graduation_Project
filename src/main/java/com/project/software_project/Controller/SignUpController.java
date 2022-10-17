package com.project.software_project.Controller;

import com.project.software_project.Dao.CoachesDao;
import com.project.software_project.Dao.PlayersDao;
import com.project.software_project.Entity.CoachesEntity;
import com.project.software_project.Entity.PlayersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/signup")
public class SignUpController {
    @Autowired
    private PlayersDao PlayerDao;
    @Autowired
    private CoachesDao CoachDao;


    @PostMapping(path = "/player")
    public void SignUp(@RequestBody PlayersEntity Player)
    {
        this.PlayerDao.SignUpPlayerDao(Player);
    }

    @PostMapping(path = "/coach")
    public void SignUp(@RequestBody CoachesEntity Coach)
    {
        this.CoachDao.SignUpCoachDao(Coach);
    }

}
