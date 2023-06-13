package com.example.automatedgeneration.entity;

import com.example.automatedgeneration.closure.Closure;
import com.example.automatedgeneration.closures.Closures;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@SuperBuilder
public class DepositApprovalClosure extends Closures {

}
