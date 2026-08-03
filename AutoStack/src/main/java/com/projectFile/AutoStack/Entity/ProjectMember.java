package com.projectFile.AutoStack.Entity;


import com.projectFile.AutoStack.Entity.Enum.ProjectRoles;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@Data
@Table(name="ProjectMember")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMember {            //join table used to connect 2 things
/*Here Primary key applied on to 2 things so It is embedded ID's /composite.*/

    @EmbeddedId
    ProjectMemberId id;

//    Way of managing the Many-Many Mapping. 1:12:00
//    so instead of creating new col ,we can map id with entity in same table

    @ManyToOne      //many ProjectMember to one project
    @MapsId("projectId")
    Project project;

    @ManyToOne      //many ProjectMember to one project
    @MapsId("userId")
    User user;

    @Enumerated(EnumType.STRING)
    ProjectRoles role;

    Instant invitedAt;

    Instant acceptedAt;
}
