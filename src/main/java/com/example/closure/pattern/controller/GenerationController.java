package com.example.closure.pattern.controller;

import com.example.closure.pattern.dto.DepositApprovalRequestDto;
import com.example.closure.pattern.dto.ManualOneRequestDto;
import com.example.closure.pattern.entity.CashoutApproval;
import com.example.closure.pattern.entity.DepositApproval;
import com.example.closure.pattern.entity.ManualOne;
import com.example.closure.pattern.entity.TransferApproval;
import com.example.closure.pattern.service.DepositApprovalService;
import com.example.closure.pattern.service.ManualOneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@Slf4j
@RestController
@RequestMapping("/generation")
@RequiredArgsConstructor
public class GenerationController {

    private final DepositApprovalService depositApprovalService;


    @PostMapping("/deposit-approvals")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<DepositApproval> createManual(
            @RequestBody DepositApprovalRequestDto requestDto) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        DepositApproval depositApproval = depositApprovalService.addNode(requestDto);
        return new ResponseEntity<>(depositApproval, HttpStatus.CREATED);
    }

    @PostMapping("/transfer-approvals")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<TransferApproval> createTransferApproval(
            @RequestBody DepositApprovalRequestDto requestDto) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        TransferApproval depositApproval = depositApprovalService.addNodesss(requestDto);
        return new ResponseEntity<>(depositApproval, HttpStatus.CREATED);
    }
}
