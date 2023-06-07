package com.ict.SpringCrud.controller;

import com.ict.SpringCrud.model.Project;
import com.ict.SpringCrud.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/view")
    public String viewPage(Model mod){
        Iterable<Project> projList = projectService.getAllProjects();
        mod.addAttribute("projectList",projList);
        return "project_home";
    }

    @RequestMapping("/new")
    public String showNewProject(Model mod){
        Project proj = new Project();
        mod.addAttribute("newProject",proj);

        return "new_project";
    }

    @RequestMapping(value = "/save",method= RequestMethod.POST)
    public String saveProject(@ModelAttribute("newProject") Project proj){
        projectService.saveProject(proj);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProjectPage(@PathVariable(name="id") Long id){
        ModelAndView mav = new ModelAndView("edit_project");
        Project proj = projectService.getProjectByID(id);
        mav.addObject("editproject",proj);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteCourse(@PathVariable(name="id")Long id){
        projectService.deleteProjectByID(id);
        return "redirect:/";
    }
}
