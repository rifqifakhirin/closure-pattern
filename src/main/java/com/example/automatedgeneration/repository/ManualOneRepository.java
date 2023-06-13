package com.example.automatedgeneration.repository;

import com.example.automatedgeneration.entity.ManualOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManualOneRepository extends JpaRepository<ManualOne, Long> {
}
