package com.essohpee.userContacts.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@Entity
public class UserContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "You must enter you name")
    private String name;

    @NotEmpty(message = "You must enter you email")
    @Email
    private String email;

    @NotBlank(message = "You must enter you phoneNumber")
    private String phoneNumber;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past
    @NotNull(message = "You must enter your date of birth")
    private LocalDate birthDate;

    private LocalDateTime registrationDate;

    public UserContact(String name, String email,
                       String phoneNumber, LocalDate birthDate,
                       LocalDateTime registrationDate) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
    }

    public UserContact() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    @PrePersist
    public void assignRegistrationDate() {
        registrationDate = LocalDateTime.now();
    }
}
