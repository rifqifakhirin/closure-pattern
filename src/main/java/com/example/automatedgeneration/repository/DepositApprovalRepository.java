package com.example.automatedgeneration.repository;

import com.example.automatedgeneration.entity.DepositApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositApprovalRepository extends JpaRepository<DepositApproval, Long> {

}
