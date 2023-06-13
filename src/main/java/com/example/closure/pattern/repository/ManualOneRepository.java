package com.example.closure.pattern.repository;

import com.example.closure.pattern.entity.ManualOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManualOneRepository extends JpaRepository<ManualOne, Long> {
}
