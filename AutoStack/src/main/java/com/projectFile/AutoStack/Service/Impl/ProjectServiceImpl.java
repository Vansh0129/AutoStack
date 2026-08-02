package com.projectFile.AutoStack.Service.Impl;

import com.projectFile.AutoStack.Dto.Project.ProjectRequest;
import com.projectFile.AutoStack.Dto.Project.ProjectResponse;
import com.projectFile.AutoStack.Dto.Project.ProjectSummeryResponse;
import com.projectFile.AutoStack.Entity.Project;
import com.projectFile.AutoStack.Entity.User;
import com.projectFile.AutoStack.Repository.ProjectRepo;
import com.projectFile.AutoStack.Repository.UserRepo;
import com.projectFile.AutoStack.Service.ProjectService;
import com.projectFile.AutoStack.mapper.ProjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional

public class ProjectServiceImpl implements ProjectService {
    ProjectRepo projectRepo;
    UserRepo userRepo;
    ProjectMapper projectMapper;

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
//        TODO :check if user is valid and have AI credit to create this?
        User user=userRepo.findById(userId).orElseThrow(()-> new NoSuchElementException(("Invalid user Id :"+userId)));
        Project project=Project.builder()
                .owner(user)
                .name(request.name())
                .is_public(false)
                .build();
       project= projectRepo.save(project);
//    Convert Project to ProjectResponse.
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummeryResponse> getAllProjects(Long userId) {       //also get owned and also shared projects.
        List<Project>  projects=projectRepo.getAllAccessibleProject(userId);
        return projectMapper.toListProjectSummeryResponse(projects);
    }

    @Override
    public ProjectResponse getProjectById(Long projectId, Long userId) {
        Project project=projectRepo.getAllAccessibleProjectById(userId,projectId).orElseThrow(()->new NoSuchElementException("Un-Authorized : Project does not belong to user ! "));
        return projectMapper.toProjectResponse(project);
    }


    @Override
    public ProjectResponse updateProjects(Long projectId, Long userId,ProjectRequest projectRequest) {
        Project project=projectRepo.getAllAccessibleProjectById(userId,projectId).orElseThrow(()->new NoSuchElementException("Un-Authorized : Project does not belong to user ! "));

        project.setName(projectRequest.name());
        project=projectRepo.save(project);
        return projectMapper.toProjectResponse(project);



    }

    @Override
    public ProjectResponse deleteProjects(Long projectId, Long userId) {
        Project project=projectRepo.getAllAccessibleProjectById(userId,projectId).orElseThrow(()->new NoSuchElementException("Un-Authorized : Project does not belong to user ! "));
            project.setDeletedOn(Instant.now());        //soft deleted
//           project= projectRepo.save(project);        transaction auto do this!

//        projectRepo.deleteById(projectId); do not delete directly!
        return projectMapper.toProjectResponse(project);
    }

}

