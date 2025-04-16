
package com.medicalappointments.medicalappointmentsmanager.dtos.request;

import com.medicalappointments.medicalappointmentsmanager.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PatientRequest {
    
    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Insert a valid name")
    private String name;
    
    @NotBlank(message = "Lastname is required")
    @Size(min = 3, message = "Insert a valid lastname")
    private String lastname;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Insert a valid email")
    private String email;
    
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "The password requires a minimum of 6 characters")
    private String password;
    
    @NotEmpty(message = "Gender is required")
    private Gender gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
       
}
