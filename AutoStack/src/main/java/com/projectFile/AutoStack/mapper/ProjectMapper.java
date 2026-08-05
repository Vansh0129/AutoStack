package com.projectFile.AutoStack.mapper;


import com.projectFile.AutoStack.Dto.Auth.UserProfileResponse;
import com.projectFile.AutoStack.Dto.Project.ProjectResponse;
import com.projectFile.AutoStack.Dto.Project.ProjectSummeryResponse;
import com.projectFile.AutoStack.Entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);
    @Mapping(target = "id",source = "project.id")
    @Mapping(target = "name",source = "project.name")
    ProjectResponse toProjectResponse(Project project, UserProfileResponse owner);

    List<ProjectSummeryResponse> toListProjectSummeryResponse(List<Project> project);

}
