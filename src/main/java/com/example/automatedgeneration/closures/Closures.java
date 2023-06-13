package com.example.automatedgeneration.closures;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@SuperBuilder
@MappedSuperclass
public abstract class Closures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ancestor;

    private Long descendant;

    private Integer depth;
}
