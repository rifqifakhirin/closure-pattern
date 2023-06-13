package com.example.closure.pattern.closure;

/**
 * @author raymond on 22/05/23
 */
public interface Closure {
//    Long setAncestor(Long ancestor);
//    Long setDescendant(Long descendant);
//    Long getAncestor();


    default void setAncestor(Long ancestor) {}
    default void setDescendant(Long descendant) {}
    default Long getAncestor() {
        return null;
    }
}
