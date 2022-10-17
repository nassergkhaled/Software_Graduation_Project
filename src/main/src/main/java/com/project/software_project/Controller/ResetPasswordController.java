package com.project.software_project.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResetPasswordController
{
@GetMapping(path = "/HI")
public String Nasser()
{
    return "HI t";
}
}

