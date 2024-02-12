package com.UserApp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Schema(description = "User DTO Model Class ")
public class UserDto {

    private Long id;

    @Schema(description = "User First Name ")
    @NotEmpty(message = "First Name cannot be empty")
    private String firstName;
    @Schema(description = "User Last Name ")
    @NotEmpty(message = "Last Name cannot be empty")
    private String lastName;
    @Schema(description = "User email address ")
    @NotEmpty(message = "First Name cannot be empty")
    @Email(message="Not a Valid E-mail")
    private String email;
}
