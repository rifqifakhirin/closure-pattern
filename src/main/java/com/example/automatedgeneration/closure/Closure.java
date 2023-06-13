package com.example.automatedgeneration.closure;

/**
 * @author raymond on 22/05/23
 */
public interface Closure {
//    Long setAncestor(Long ancestor);
//    Long setDescendant(Long descendant);
//    Long getAncestor();


    default Long setAncestor(Long ancestor) {
        return ancestor;
    }
    default Long setDescendant(Long descendant) { return descendant; }
    default Long getAncestor() {
        return null;
    }
}
