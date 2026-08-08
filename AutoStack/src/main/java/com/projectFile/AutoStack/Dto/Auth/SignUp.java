package com.projectFile.AutoStack.Dto.Auth;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.boot.context.properties.bind.DefaultValue;

public record SignUp (
     @JsonInclude(JsonInclude.Include.NON_NULL) String name,
       @Email String email,
       @Min(4) @Max(70) String password
       ) {

}
