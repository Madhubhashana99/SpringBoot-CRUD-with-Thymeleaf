package com.ict.SpringCrud.service;

import com.ict.SpringCrud.Repository.ProjectRepo;
import com.ict.SpringCrud.model.Project;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    public Iterable<Project> getAllProjects(){
        return projectRepo.findAll();
    }

    public void saveProject(Project p){
        projectRepo.save(p);
    }

    public Project getProjectByID(Long id){
        return projectRepo.findById(id).get();
    }

    public void deleteProjectByID(Long id){
        projectRepo.deleteById(id);
    }
}
