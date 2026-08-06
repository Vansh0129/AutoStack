package com.projectFile.AutoStack.Entity;


import com.projectFile.AutoStack.Entity.Enum.MessageRoles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@Data
@Table(name="ChatMessage")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotNull
    MessageRoles roles;
    String content;
    String toolCalls;       //json array of the tool called
    String toolCallingId;
//    @NotNull
    Integer tokenUsed;
//    @CreationTimestamp
    Instant createdAt;
}
