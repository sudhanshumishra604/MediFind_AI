package com.sudhanshu.medifind.entity;

import jakarta.persistence.*;                         // Entity represents database table
                                                      // It only represent data.
import lombok.*;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String specialization;

    private String qualification;

    private Integer experience;

    private String hospital;

    private String city;

    private String state;

    private Double consultationFee;

    private Double rating;

    @Column(length = 1000)
    private String about;

    private Boolean available;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
