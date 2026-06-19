package com.projectFile.AutoStack.Entity;


import com.projectFile.AutoStack.Entity.Enum.ProjectRoles;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@Data
@Table(name="ProjectMember")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectMember {            //join table used to connect 2 things

    @OneToMany
    Project project;
    @OneToMany
    User user;
    @Enumerated(EnumType.STRING)
    ProjectRoles roles;

    Long invitedBy;

    Instant invitedAt;
}
