package com.example.automatedgeneration.repository;

import com.example.automatedgeneration.entity.TransferApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferApprovalRepository extends JpaRepository<TransferApproval, Long> {
}
