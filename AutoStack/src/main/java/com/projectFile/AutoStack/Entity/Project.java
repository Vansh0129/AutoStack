package com.projectFile.AutoStack.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Data
@Table(name="Project")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotNull
    String name;
    @ManyToMany
    User user;
    @Column(unique = true,nullable = false)
    long ownerId;
    Boolean is_public=false;
    @CreationTimestamp
    Instant cratedAt;
    @UpdateTimestamp
    Instant updatedAt;
    Instant deletedAt;

}
