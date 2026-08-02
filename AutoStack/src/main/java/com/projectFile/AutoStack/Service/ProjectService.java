package com.projectFile.AutoStack.Service;

import com.projectFile.AutoStack.Dto.Project.ProjectRequest;
import com.projectFile.AutoStack.Dto.Project.ProjectResponse;
import com.projectFile.AutoStack.Dto.Project.ProjectSummeryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    List<ProjectSummeryResponse> getAllProjects(Long userId);

    ProjectResponse getProjectById(Long projectId, Long userId);

    ProjectResponse createProject(ProjectRequest request, Long userId);

    ProjectResponse updateProjects(Long projectId, Long userId,ProjectRequest projectRequest );

    ProjectResponse deleteProjects(Long projectId, Long userId);
}
