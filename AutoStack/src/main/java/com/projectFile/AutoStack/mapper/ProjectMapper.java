package com.projectFile.AutoStack.mapper;


import com.projectFile.AutoStack.Dto.Project.ProjectResponse;
import com.projectFile.AutoStack.Dto.Project.ProjectSummeryResponse;
import com.projectFile.AutoStack.Entity.Project;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);
    List<ProjectSummeryResponse> toListProjectSummeryResponse(List<Project> project);

}
