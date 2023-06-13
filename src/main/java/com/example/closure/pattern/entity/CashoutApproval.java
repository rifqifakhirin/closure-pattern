package com.example.closure.pattern.entity;

import com.example.closure.pattern.closing.NodePattern;
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
public class CashoutApproval implements NodePattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long parentId;

    private String name;

    private Long roleId;

    private Boolean isExecutor;

}
