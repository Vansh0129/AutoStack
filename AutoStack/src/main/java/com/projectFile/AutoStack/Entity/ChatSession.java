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
@Table(name="ChatSession")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

//    @ManyToOne
//    Project project;
//    @ManyToOne
//    User user;
    @NotNull
    String title;
    @CreationTimestamp
    Instant cratedAt;
    @UpdateTimestamp
    Instant updatedAt;
    Instant deletedAt;

}
