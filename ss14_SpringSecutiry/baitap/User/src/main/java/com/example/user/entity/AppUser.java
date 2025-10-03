package com.example.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "app_user")
@Getter
@Setter
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "user_name", length = 36, nullable = false, unique = true)
    private String userName;

    @Column(name = "encryted_password", length = 128, nullable = false)
    private String encrytedPassword;

    @Column(name = "enabled", length = 1, nullable = false)
    private boolean enabled;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private AppRole appRole;


}
