package com.example.automatedgeneration.closing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ClosurePatternRepository<U, ID> extends JpaRepository<U, ID> {

    List<U> findByDescendant(Long descendant);
}
