package com.baibhav.seattle.projectboard.web;

import com.baibhav.seattle.projectboard.domain.ProjectTask;
import com.baibhav.seattle.projectboard.service.ProjectClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value="/projectboard")
@CrossOrigin
public class ProjectClassController {


    @Autowired
    private ProjectClassService projectclasservice;

    @GetMapping (value="/getall")
    public Iterable<ProjectTask> getAllUsers(){

        return projectclasservice.getAllProjectTask();

    }

    @PostMapping(value="/addProject")
    public ResponseEntity<?> addProjectBoard(@RequestBody ProjectTask projectTask){

        ProjectTask project= projectclasservice.addProjectTasks(projectTask);
        return new ResponseEntity<ProjectTask>(project, HttpStatus.CREATED);
    }
//    @DeleteMapping(value="/deleteProject")
//
//    public ResponseEntity<?> deleteProjectById(@PathVariable Long id ){
//
//        ProjectTask project= projectclasservice.deleteProject(id);
//        return new ResponseEntity<ProjectTask>(project, HttpStatus.CREATED);
//    }

    @GetMapping(value="/getById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id ){

        ProjectTask project= projectclasservice.getsingleProject(id);
        return new ResponseEntity<ProjectTask>(project, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/delete/{id}")
    public void deleteById(@PathVariable Long id ){

         projectclasservice.deleteProject(id);

    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateProject(ProjectTask projectTask, Long id){


         projectclasservice.updateProject(projectTask, id);


    }


}
