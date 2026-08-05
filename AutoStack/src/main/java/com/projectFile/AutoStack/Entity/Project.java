package com.projectFile.AutoStack.Entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Project",
        indexes = {
                @Index(name="idx_projects_updated_at_desc" ,columnList = "updated_on DESC,deleted_on"),
                @Index(name="idx_projects_deleted_at_updated_at_desc" ,columnList = "deleted_on,updated_on DESC"),
                @Index(name="idx_projects_deleted_at" ,columnList = "deleted_on"),
        }
)
public class Project {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

//    @ManyToOne       //READ: Many (Project) to One User.
//    @JoinColumn(name = "owner_id", nullable = false)     //by default field also have same name only owner_Id
//    User owner;

    Boolean is_public = false;

    @CreationTimestamp
    Instant createdOn;

    @UpdateTimestamp
    Instant updatedOn;

    Instant deletedOn;

}
