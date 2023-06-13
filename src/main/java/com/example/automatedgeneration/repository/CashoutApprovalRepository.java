package com.example.automatedgeneration.repository;

import com.example.automatedgeneration.entity.CashoutApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashoutApprovalRepository extends JpaRepository<CashoutApproval, Long> {
}
