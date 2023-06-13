package com.example.automatedgeneration.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ManualOneDto {

    private Long id;

    private BigDecimal price;

    private String name;

    private LocalDateTime createdAt;

    private Long iso;

}