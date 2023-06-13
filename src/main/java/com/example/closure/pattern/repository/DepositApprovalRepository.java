package com.example.closure.pattern.repository;

import com.example.closure.pattern.entity.DepositApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositApprovalRepository extends JpaRepository<DepositApproval, Long> {

}
