package com.projectFile.AutoStack.Exception.Error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class ResourceNotFoundException extends RuntimeException{
    private String ResourceName;
    private Long ResourceId;

}
