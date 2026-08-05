package com.projectFile.AutoStack.Repository;

import com.projectFile.AutoStack.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepo extends JpaRepository<Project,Long> {

    @Query("""
            SELECT p FROM Project p
            WHERE p.deletedOn IS NULL
            ORDER BY p.updatedOn DESC
            """
    )
    List<Project>  getAllAccessibleProject(@Param("userId")Long id);

    @Query("""
            SELECT p FROM Project p
            WHERE p.id = :projectId
            AND p.deletedOn IS NULL
            ORDER BY p.updatedOn DESC
            """
    )
    Optional<Project> getAllAccessibleProjectById(@Param("userId")Long id,
                                                  @Param("projectId")Long pro_Id);
}
