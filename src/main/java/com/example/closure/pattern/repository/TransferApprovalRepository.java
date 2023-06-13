package com.example.closure.pattern.repository;

import com.example.closure.pattern.entity.TransferApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferApprovalRepository extends JpaRepository<TransferApproval, Long> {
}
