package com.example.closure.pattern.closuretransfer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ClosureBaseRepository<U extends ClosureBase>
        extends JpaRepository<U, Long> {

//    @Query("Select u from #{#entityName} u where u.descendant = ?1")
//    List<U> findByDescendant(Long descendant);
}
