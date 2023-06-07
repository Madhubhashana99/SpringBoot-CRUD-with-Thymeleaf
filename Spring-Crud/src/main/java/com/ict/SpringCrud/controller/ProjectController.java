package com.ict.SpringCrud.controller;

import com.ict.SpringCrud.model.Project;
import com.ict.SpringCrud.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/")
    public String viewPage(Model mod){
        Iterable<Project> projList = projectService.getAllProjects();
        mod.addAttribute("projectList",projList);
        return "project_home";
    }
}
