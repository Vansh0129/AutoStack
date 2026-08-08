package com.projectFile.AutoStack.Controller;


import com.projectFile.AutoStack.Dto.Project.ProjectRequest;
import com.projectFile.AutoStack.Dto.Project.ProjectResponse;
import com.projectFile.AutoStack.Dto.Project.ProjectSummeryResponse;
import com.projectFile.AutoStack.Security.ContextUtil;
import com.projectFile.AutoStack.Service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final ContextUtil contextUtil;

    @GetMapping
    public ResponseEntity<List<ProjectSummeryResponse>> getAllUserProjects() {
        Long userId = contextUtil.getId();
        List<ProjectSummeryResponse> response = projectService.getAllProjects(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectsById(@PathVariable Long id){
        Long userId = contextUtil.getId();
        ProjectResponse response=projectService.getProjectById(id,userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest projectRequest){
        Long userId = contextUtil.getId();
        ProjectResponse response=projectService.createProject(projectRequest,userId);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProjects(@PathVariable Long id,@RequestBody ProjectRequest projectRequest ){
        Long userId = contextUtil.getId();
        ProjectResponse response=projectService.updateProjects(id,userId,projectRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ProjectResponse> deleteProjects(@PathVariable Long id){
        Long userId = contextUtil.getId();
        ProjectResponse response=projectService.deleteProjects(id,userId);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);


    }



}
