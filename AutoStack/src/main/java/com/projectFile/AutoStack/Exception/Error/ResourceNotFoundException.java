package com.projectFile.AutoStack.Exception.Error;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class ResourceNotFoundException extends RuntimeException{
    private String ResourceName;
    private Long ResourceId;

}
