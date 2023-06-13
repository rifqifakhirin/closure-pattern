package com.example.automatedgeneration.entity;

import com.example.automatedgeneration.closure.Node;
import com.example.automatedgeneration.closures.Nodes;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepositApproval extends Nodes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long parentId;

    private String name;

    private Long roleId;

    private Boolean isExecutor;
}
