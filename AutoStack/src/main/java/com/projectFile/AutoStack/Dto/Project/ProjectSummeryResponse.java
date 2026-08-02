package com.projectFile.AutoStack.Dto.Project;

import java.time.Instant;

public record ProjectSummeryResponse (
        Long id,
        String name,
        Instant createdAt,
        Boolean is_public,
        Instant updatedAt
){

}
