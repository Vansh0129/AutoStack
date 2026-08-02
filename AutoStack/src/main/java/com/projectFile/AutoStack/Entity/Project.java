package com.projectFile.AutoStack.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@Entity
@Table(name="Project")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id     @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    String name;

    @ManyToOne       //READ: Many (Project) to One User.
    @JoinColumn(name = "owner_id",nullable = false)     //by default field also have same name only owner_Id
    User owner;  //One owner can have many Projects.

    Boolean is_public=false;

    @CreationTimestamp
    Instant createdOn;

    @UpdateTimestamp
    Instant updatedOn;

    Instant deletedOn;

}
