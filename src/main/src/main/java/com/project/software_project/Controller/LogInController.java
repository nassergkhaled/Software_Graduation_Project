package com.project.software_project.Controller;

import com.project.software_project.Dao.AdminsDao;
import com.project.software_project.Dao.CoachesDao;
import com.project.software_project.Dao.PlayersDao;
import com.project.software_project.Dto.LogInBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogInController {

    @Autowired
    private PlayersDao PlayerDao;
    @Autowired
    private CoachesDao CoachDao;
    @Autowired
    private AdminsDao AdminDao;


    @PostMapping("/login")

    public String LogIn(@RequestBody LogInBody Body)
    {
        if(PlayerDao.LoginPlayerDao(Body.getId(),Body.getPassword()))
        {
            return "Success 'Player'";
        }
        else if (CoachDao.LoginCoachDao(Body.getId(),Body.getPassword()))
        {
            return "Success 'Coach'";
        }
        else if (AdminDao.LoginAdminDao(Body.getId(),Body.getPassword()))
        {
            return "Success 'Admin'";
        }
        else {return "Failed";}
    }
}
