package com.example.myinteractivecv.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
@Entity
@Table(name = "socials")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Social {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String link;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;
}
