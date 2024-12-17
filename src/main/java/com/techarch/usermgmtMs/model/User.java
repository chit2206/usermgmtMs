package com.techarch.usermgmtMs.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @Column(unique=true,nullable = false,length=50)
    private String username;
    @Column(unique=true, nullable = false,length=100)
    private String email;
    private String  password_hash;
    @Column(unique=true,length=15)
    private String phone_number;
    @Column (nullable = false)
    private Boolean two_factor_enabled;
    @Column (nullable = false,length=20)
    private String kyc_status="pending";
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate created_at;
    @UpdateTimestamp
    private LocalDate updated_at;


}
