package com.baibhav.seattle.projectboard.service;

import com.baibhav.seattle.projectboard.domain.ProjectTask;
import com.baibhav.seattle.projectboard.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProjectClassService {

    @Autowired
    private ProjectTaskRepository projecttaskrepository;



    public ProjectTask addProjectTasks(ProjectTask projectTask){

        if(projectTask.getStatus()==null || projectTask.getStatus()==" "){
            projectTask.setStatus("TO_DO");
        }
        return projecttaskrepository.save(projectTask);

    }


    public Iterable<ProjectTask> getAllProjectTask(){

       return projecttaskrepository.findAll();

    }


    public void deleteProject( Long id){

        ProjectTask pt= projecttaskrepository.getById(id);

         projecttaskrepository.delete(pt);

    }

    public ProjectTask getsingleProject(Long id){

         return projecttaskrepository.getById(id);

    }

    public void updateProject(ProjectTask projectTask, Long id){

        List<ProjectTask> list = new ArrayList<>();
        for(ProjectTask i:list){

            if(id==projectTask.getId()){
                list.add(projectTask);
            }
        }



    }





}
