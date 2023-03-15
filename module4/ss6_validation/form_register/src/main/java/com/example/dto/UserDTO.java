package com.example.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class UserDTO {
    @NotBlank(message = "{fistName.notBlank}")
    @Length(min = 5)
    @Size(max = 45)
    private String fistName;
    @NotBlank(message = "{lastName.notBlank}")
    @Length(min = 5)
    @Size(max = 45)
    private String lastName;
    @NotBlank(message = "{phoneNumber.notBlank}")
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[\\d]{7}$", message = "{phoneNumber.Pattern}")
    private String phoneNumber;
    @NotBlank(message = "{age.notBlank}")
    @Min(value = 18)
    private String age;
    @NotBlank(message = "{email.notBlank}")
    @Email
    private String email;

    public UserDTO() {
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
