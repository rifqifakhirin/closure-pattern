package com.example.closure.pattern.repository;

import com.example.closure.pattern.entity.TransferApprovalClosure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferApprovaClosurelRepository extends JpaRepository<TransferApprovalClosure, Long> {
}
