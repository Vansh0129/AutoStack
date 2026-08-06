package com.projectFile.AutoStack.Dto.Project;

import java.time.Instant;

public record ProjectSummeryResponse (
        Long id,
        String name,
        Instant createdAt,
        Boolean isPublic,
        Instant updatedAt
){

}
