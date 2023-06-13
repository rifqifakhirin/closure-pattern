package com.example.automatedgeneration.entity;

import com.example.automatedgeneration.closuretransfer.NodeBase;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class TransferApproval extends NodeBase {

    private String name;

    private Long roleId;

    private Boolean isExecutor;
}
