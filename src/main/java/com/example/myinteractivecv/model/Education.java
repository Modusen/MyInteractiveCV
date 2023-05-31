package com.example.myinteractivecv.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Education {
    private Long id;
    private String universityName;
    private String Speciality;
    private String yearsOfStudy;
    private Long userId;

}
