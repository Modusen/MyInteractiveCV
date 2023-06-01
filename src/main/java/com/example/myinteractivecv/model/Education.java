package com.example.myinteractivecv.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String universityName;
    private String Speciality;
    private String yearsOfStudy;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

}
