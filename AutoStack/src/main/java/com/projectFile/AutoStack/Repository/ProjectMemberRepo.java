package com.projectFile.AutoStack.Repository;

import com.projectFile.AutoStack.Entity.ProjectMember;
import com.projectFile.AutoStack.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProjectMemberRepo extends JpaRepository<ProjectMember,Long> {
    List<ProjectMember> findAllByIdProjectId( Long projectId);

    @Query("""
            SELECT m from ProjectMember m
            WHERE m.user.id=:memberId
            AND m.project.id=:projectId
            """)
    Optional<ProjectMember> findByIdProjectIdAndMemberId(@Param("projectId") Long projectId, @Param("memberId") Long memberId);

    @Query("""
            SELECT m from ProjectMember m
            WHERE m.user=:user
            AND m.acceptedAt Is Null
            """)
    List<ProjectMember> findAllPendingRequest(@Param("user")User user);

    @Query("""
            SELECT m from ProjectMember m
            WHERE m.user=:user
            AND m.acceptedAt Is Null
            AND m.project.id =:projectId
            """)
    Optional<ProjectMember> ResponseToPendingReq(@Param("user")User user,@Param("projectId") Long projectId);
}
