package com.ict.SpringCrud.Repository;


import com.ict.SpringCrud.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepo extends CrudRepository<Project,Long> {
}
