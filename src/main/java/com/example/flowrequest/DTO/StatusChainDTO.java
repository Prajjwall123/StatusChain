package com.example.flowrequest.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class StatusChainDTO {

    private Integer id;

    private Integer applicationId;

    private String status;

    private String username;

    private String branch;

    private LocalDateTime dateTime;
}
