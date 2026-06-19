package com.projectFile.AutoStack.Entity;


import com.projectFile.AutoStack.Entity.Enum.PreviewStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Data
@Table(name="Preview")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Preview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Project project;
    @NotNull
    String nameSpace;
    String podName;
    String previewUrl;
    PreviewStatus Status;
    Instant startedAt;
    Instant terminatedAt;
    @CreationTimestamp
    Instant cratedAt;


}
