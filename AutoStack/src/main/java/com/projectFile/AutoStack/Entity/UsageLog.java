package com.projectFile.AutoStack.Entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Data
@Table(name="Project")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsageLog {     //help to manage usage and the quata
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
//    @ManyToOne
//    User user;
//    @ManyToOne
//    Project project;
    String action;
    Integer tokensUsed;
    Integer durationMs;
    String metaData;  //Json of {model_Used,prompt_Used}
    @CreationTimestamp
    Instant created_at;
}
