package com.project.software_project.Reposorty;

import com.project.software_project.Entity.AdminsEntity;
import org.apache.el.parser.JJTELParserState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminsRepo extends JpaRepository<AdminsEntity , Integer> {
    public AdminsEntity findAllByIdAndPassword(Integer id, String password);
}
