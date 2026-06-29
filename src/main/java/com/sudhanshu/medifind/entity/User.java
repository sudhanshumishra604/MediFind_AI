package com.sudhanshu.medifind.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity                    // Marks this class as  database class..
@Table(name = "users")     // table is created.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder               // -> lambok feature //Builder lets you assign each value to its correct field by name, instead of by position/order.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)   // only two value allowed doctor or patient.
    @Column(nullable = false)
    private Role role;
}
