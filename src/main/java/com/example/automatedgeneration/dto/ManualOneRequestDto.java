package com.example.automatedgeneration.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ManualOneRequestDto {

    private BigDecimal price;

    private String name;

    private LocalDateTime createdAt;

    private Long iso;

}