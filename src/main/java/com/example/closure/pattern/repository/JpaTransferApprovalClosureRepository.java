package com.example.closure.pattern.repository;

import com.example.closure.pattern.closuretransfer.ClosureBaseRepository;
import com.example.closure.pattern.entity.TransferApprovalClosure;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTransferApprovalClosureRepository extends ClosureBaseRepository<TransferApprovalClosure> {
}
