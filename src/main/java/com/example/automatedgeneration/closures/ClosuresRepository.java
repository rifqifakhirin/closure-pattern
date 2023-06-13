package com.example.automatedgeneration.closures;

import com.example.automatedgeneration.closures.Closures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ClosuresRepository<U extends Closures, ID> extends JpaRepository<U, ID> {

    List<U> findByDescendant(Object obj);
}
