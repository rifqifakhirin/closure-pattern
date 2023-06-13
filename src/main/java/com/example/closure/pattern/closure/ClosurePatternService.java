package com.example.closure.pattern.closure;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * return new ClosurePatternService<DepositClosure, Deposit, Long>()
 *
 * @param <T> Entity Ancestor
 * @param <V> Entity Descendant
 * @param <ID> ID of Descendant
 *
 * @author raymond on 22/05/23
 */
public class ClosurePatternService<T extends Node, V extends Closure, ID> {

//  private Class<V> descendantClass;

//  @Autowired
  JpaClosureRepository<V, ID> jpaClosureRepository;

  public ClosurePatternService() {

  }

  public List<V> createClosure(T entity, V closure) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    List<V> closureList = new ArrayList<>();

    closure.setAncestor(entity.getId());
    closure.setDescendant(entity.getId());

    List<V> ancestorList = jpaClosureRepository.findByDescendant(entity.getParentId());
    ancestorList.forEach(x -> {
      closure.setAncestor(x.getAncestor());
      closure.setDescendant(entity.getId());
    });

    closureList.add(closure);
    return closureList;
  }
}
