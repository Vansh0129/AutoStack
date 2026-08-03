package com.projectFile.AutoStack.Entity;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data@AllArgsConstructor@NoArgsConstructor
public class ProjectMemberId {
    Long projectId;
    Long userId;
}
