package com.example.XindusProject.Modal;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    @Column(unique = true)
    String name;

    @Column(unique = true)
    String email;

    @Column(unique = true)
    String mobile;

    String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Wishlist wishlist;

    String roles;
}
