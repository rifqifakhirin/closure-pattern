package com.example.automatedgeneration.service;

import com.example.automatedgeneration.closuretransfer.ClosureBaseRepository;
import com.example.automatedgeneration.closuretransfer.ClosureBaseService;
import com.example.automatedgeneration.entity.TransferApproval;
import com.example.automatedgeneration.entity.TransferApprovalClosure;
import com.example.automatedgeneration.repository.TransferApprovalClosureRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferApprovalService implements ClosureBaseService<TransferApproval, TransferApprovalClosure> {

    TransferApprovalClosureRepository transferApprovalClosureRepository;

    @Override
    public ClosureBaseRepository<TransferApprovalClosure> getRepository() {
        return transferApprovalClosureRepository;
    }
}
