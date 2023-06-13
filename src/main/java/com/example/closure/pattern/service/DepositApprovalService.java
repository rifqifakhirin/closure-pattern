package com.example.closure.pattern.service;

import com.example.closure.pattern.closures.HierarchyService;
import com.example.closure.pattern.dto.DepositApprovalRequestDto;
import com.example.closure.pattern.entity.*;
import com.example.closure.pattern.repository.CashoutApprovalRepository;
import com.example.closure.pattern.repository.DepositApprovalClosureRepository;
import com.example.closure.pattern.repository.DepositApprovalRepository;
import com.example.closure.pattern.repository.TransferApprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Service
public class DepositApprovalService {

    @Autowired
    private DepositApprovalRepository depositApprovalRepository;

    @Autowired
    private DepositApprovalClosureRepository depositApprovalClosureRepository;

    @Autowired
    private TransferApprovalRepository transferApprovalRepository;

    @Autowired
    @Qualifier("DepositClosurePatternService")
    private HierarchyService<DepositApproval, DepositApprovalClosure, Long> hierarchyService;


//    @Autowired
//    @Qualifier("CashoutClosurePatternService")
//    private ClosurementPatternService<CashoutApproval, CashoutApprovalClosure, Long> closurementPatternService;

    @Autowired
    private CashoutApprovalRepository cashoutApprovalRepository;

    @Autowired
    @Qualifier("TransferService")
    private TransferApprovalService transferApprovalService;


    //use spesific method
    public DepositApproval addNode(DepositApprovalRequestDto requestDto) {
        DepositApproval depositApproval = DepositApproval.builder()
                .name(requestDto.getName())
                .parentId(null)
                .roleId(requestDto.getRoleId())
                .isExecutor(requestDto.getIsExecutor())
                .build();

        if (Objects.nonNull(requestDto.getParentId())) {
            Optional<DepositApproval> depositApprovalParent = depositApprovalRepository.findById(requestDto.getParentId());
            if (depositApprovalParent.isEmpty()) {
                throw new NoSuchElementException("Node not found");
            }
            depositApproval.setParentId(requestDto.getParentId());
        }

        depositApprovalRepository.save(depositApproval);
        depositApprovalClosureRepository.saveAll(addClosure(depositApproval));
        return depositApproval;
    }

    //use spesific method
    public List<DepositApprovalClosure> addClosure(DepositApproval depositApproval) {
        List<DepositApprovalClosure> depositApprovalClosureList = new ArrayList<>();
        DepositApprovalClosure selfClosure = DepositApprovalClosure.builder()
                .ancestor(depositApproval.getId())
                .descendant(depositApproval.getId())
                .depth(0)
                .build();
        depositApprovalClosureList.add(selfClosure);
        if (Objects.nonNull(depositApproval.getParentId())) {
            List<DepositApprovalClosure> depositApprovalClosures =
                    depositApprovalClosureRepository.findByDescendant(depositApproval.getParentId());
            depositApprovalClosures.forEach(depositApprovalClosure -> {
                        DepositApprovalClosure additionClosure = DepositApprovalClosure.builder()
                                .ancestor(depositApprovalClosure.getAncestor())
                                .descendant(depositApproval.getId())
                                .depth(depositApprovalClosure.getDepth() + 1)
                                .build();
                        depositApprovalClosureList.add(additionClosure);
                    }
            );
        }
        return depositApprovalClosureList;
    }

    //use generic method
    public DepositApproval addNodes(DepositApprovalRequestDto requestDto) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        DepositApproval depositApproval = DepositApproval.builder()
                .name(requestDto.getName())
                .parentId(null)
                .roleId(requestDto.getRoleId())
                .isExecutor(requestDto.getIsExecutor())
                .build();

        if (Objects.nonNull(requestDto.getParentId())) {
            Optional<DepositApproval> depositApprovalParent = depositApprovalRepository.findById(requestDto.getParentId());
            if (depositApprovalParent.isEmpty()) {
                throw new NoSuchElementException("Node not found");
            }
            depositApproval.setParentId(requestDto.getParentId());
        }

        var a = depositApprovalRepository.save(depositApproval);
        hierarchyService.addClosure(a);
        return depositApproval;
    }

    //alternative
    public CashoutApproval addNodess(DepositApprovalRequestDto requestDto) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        CashoutApproval cashoutApproval = CashoutApproval.builder()
                .name(requestDto.getName())
                .parentId(null)
                .roleId(requestDto.getRoleId())
                .isExecutor(requestDto.getIsExecutor())
                .build();

        if (Objects.nonNull(requestDto.getParentId())) {
            Optional<CashoutApproval> cashoutApprovalOptional = cashoutApprovalRepository.findById(requestDto.getParentId());
            if (cashoutApprovalOptional.isEmpty()) {
                throw new NoSuchElementException("Node not found");
            }
            cashoutApproval.setParentId(requestDto.getParentId());
        }

        cashoutApprovalRepository.save(cashoutApproval);

//        ClosurementPatternService<CashoutApproval, CashoutApprovalClosure, Long> patternService = new ClosurementPatternService<>();
//        patternService.addClosure(cashoutApproval);

//        closurementPatternService.addClosure(cashoutApproval);
        return cashoutApproval;
    }

    //alternative latest
    public TransferApproval addNodesss(DepositApprovalRequestDto requestDto) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        TransferApproval cashoutApproval = TransferApproval.builder()
                .name(requestDto.getName())
                .parentId(null)
                .roleId(requestDto.getRoleId())
                .isExecutor(requestDto.getIsExecutor())
                .build();

        if (Objects.nonNull(requestDto.getParentId())) {
            Optional<TransferApproval> cashoutApprovalOptional = transferApprovalRepository.findById(requestDto.getParentId());
            if (cashoutApprovalOptional.isEmpty()) {
                throw new NoSuchElementException("Node not found");
            }
            cashoutApproval.setParentId(requestDto.getParentId());
        }

        transferApprovalRepository.save(cashoutApproval);

//        ClosurementPatternService<CashoutApproval, CashoutApprovalClosure, Long> patternService = new ClosurementPatternService<>();
//        patternService.addClosure(cashoutApproval);

        TransferApprovalClosure transferApprovalClosure = new TransferApprovalClosure();

        transferApprovalService.addClosure(cashoutApproval, transferApprovalClosure);
        return cashoutApproval;
    }

}
