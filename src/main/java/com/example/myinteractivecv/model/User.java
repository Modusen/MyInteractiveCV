package com.example.myinteractivecv.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private String confirmPassword;

    private String firstName;
    private String lastName;
    private String specialization;
    private String city;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    @OneToOne
    @JoinColumn(name = "image")
    private Image image;
//    @OneToMany(mappedBy = "userId")
//    private List<Education> educationList;
//    @OneToMany(mappedBy = "userId")
//    private List<Social> socialsList;

    private String aboutMe;

    @Enumerated(EnumType.STRING)
    private Role role;
}
