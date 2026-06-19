package com.projectFile.AutoStack.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Table(name="Plan")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotNull
    String name;
    @NotNull
    String stripeId;
    @NotNull
    Integer maxProjects;
    @NotNull
    Long maxTokensPerDay;
    @NotNull
    Integer maxPreviews;
    @NotNull
    Boolean unlimitedAi;
//    @NotNull
//    Jsonb features;
    @NotNull
    Boolean active;


}
