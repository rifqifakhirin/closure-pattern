package com.example.closure.pattern.closure;

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

  private Class<V> descendantClass;
  JpaClosureRepository<V, ID> jpaClosureRepository;

  public ClosurePatternService() {

  }

  public ClosurePatternService(Class<V> descendantClass, JpaClosureRepository<V, ID> jpaClosureRepository) {
    this.descendantClass = descendantClass;
    this.jpaClosureRepository = jpaClosureRepository;
  }

  public List<V> createClosure(T entity) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    List<V> closureList = new ArrayList<>();

    V closure = descendantClass.getConstructor().newInstance();
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
