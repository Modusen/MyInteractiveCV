package com.example.myinteractivecv.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@ToString
public class User {
    private Long id;
    private String email;
    private String password;
    private String doubleCheckPassword;

    private String firstName;
    private String lastName;
    private String specialization;
    private String city;
    private LocalDate birthDate;

//    @OneToMany(mappedBy = userId)
    private List<Education> educationList;
    private String aboutMe;
    private Image image;

//    @Enumerated(EnumType.STRING)
    private Role role;
}
