package com.example.closure.pattern.repository;

import com.example.closure.pattern.entity.DepositApprovalClosure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositApprovalClosureRepository extends JpaRepository<DepositApprovalClosure, Long> {

    List<DepositApprovalClosure> findByDescendant(Long id);

}
