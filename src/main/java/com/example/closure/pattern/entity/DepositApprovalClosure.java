package com.example.closure.pattern.entity;

import com.example.closure.pattern.closure.Closure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class DepositApprovalClosure implements Closure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ancestor;

    private Long descendant;

    private Integer depth;
}
