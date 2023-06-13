package com.example.closure.pattern.closures;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClosuresService<U extends Closures, ID> {

    private ClosuresRepository<U, ID> repository;

    public Closures save(U entity) { return repository.save(entity); }

    public Optional<U> findById(ID id) {
        return repository.findById(id);
    }

    public List<U> findByDescendant(Long descendant) {
        return repository.findByDescendant(descendant);
    }
}
