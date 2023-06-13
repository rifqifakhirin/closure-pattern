package com.example.automatedgeneration.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepositApprovalRequestDto {

    private Long parentId;

    private String name;

    private Long roleId;

    private Boolean isExecutor;
}
