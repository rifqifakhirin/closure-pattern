package com.example.closure.pattern.closure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author raymond on 22/05/23
 */
@NoRepositoryBean
public interface JpaClosureRepository<T, ID> extends JpaRepository<T, ID> {

  public List<T> findByDescendant(Long descendant);
}
