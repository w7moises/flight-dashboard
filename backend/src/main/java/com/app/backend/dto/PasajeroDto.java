package com.app.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PasajeroDto {

    private Long passengerId;

    @NotBlank(message = "First name is required")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "First name must be alphabetic")
    private String firstName;

    @NotBlank(message = "Second name is required")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Second name must be alphabetic")
    private String secondName;

    @NotBlank(message = "Last name is required")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Last name must be alphabetic")
    private String lastName;

    @NotBlank(message = "Phone number is required")
    @Size(min = 9, max = 9, message = "Phone number must be 9 digits")
    @Pattern(regexp = "^\\d*$", message = "Phone number must be numeric")
    private String phoneNumber;

    @NotBlank(message = "Email address is required")
    @Email
    private String emailAddress;

    @NotBlank(message = "Address is required")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Address must be alphabetic")
    private String city;

    @NotBlank(message = "Country is required")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Country must be alphabetic")
    private String country;

    @NotBlank(message = "Other details are required")
    private String otherDetails;
}
