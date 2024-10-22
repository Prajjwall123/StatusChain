package com.example.flowrequest.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "statusChains")
@Getter
@Setter
public class StatusChain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="status",nullable=false)
    private String status;

    @Column(name="username",nullable=false)
    private String username;

    @Column(name="branch",nullable=false)
    private String branch;

    @Column(name="dateTime",nullable=false)
    private LocalDateTime dateTime;

}
