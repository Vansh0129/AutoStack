package com.projectFile.AutoStack.mapper;

import com.projectFile.AutoStack.Dto.Member.InvitationResponse;
import com.projectFile.AutoStack.Dto.Member.MemberResponse;
import com.projectFile.AutoStack.Entity.ProjectMember;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {
    MemberResponse toMemberResponse(ProjectMember projectMember);



    @Mapping(source = "id.userId",target = "userId")
    @Mapping(source = "user.name",target = "name")
    @Mapping(source = "user.avtarUrl",target = "avtarUrl")
    @Mapping(source = "user.email",target = "email")
    MemberResponse toMemberResponseFromMember(ProjectMember owner);

    @Mapping(source = "project.id",target = "projectId")
    @Mapping(source = "project.name",target = "projectName")
    @Mapping(source = "project.createdOn",target = "createdOn")
    @Mapping(source = "project.updatedOn",target = "updatedOn")
    InvitationResponse toInvitationResponseFromProjectMember(ProjectMember list);
}
