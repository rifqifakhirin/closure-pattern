package com.example.closure.pattern.service;

import com.example.closure.pattern.closuretransfer.ClosureBaseRepository;
import com.example.closure.pattern.closuretransfer.ClosureBaseService;
import com.example.closure.pattern.entity.TransferApproval;
import com.example.closure.pattern.entity.TransferApprovalClosure;
import com.example.closure.pattern.repository.JpaTransferApprovalClosureRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferApprovalService implements ClosureBaseService<TransferApproval, TransferApprovalClosure> {

    JpaTransferApprovalClosureRepository jpaTransferApprovalClosureRepository;

    @Override
    public ClosureBaseRepository<TransferApprovalClosure> getRepository() {
        return jpaTransferApprovalClosureRepository;
    }
}
