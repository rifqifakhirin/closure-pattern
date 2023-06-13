package com.example.closure.pattern.closing;

public interface ClosurePattern {

    void setAncestor(Long ancestor);
    void setDescendant(Long descendant);
    void setDepth(Integer depth);

    default Long getAncestor() {
        return null;
    }
    default Long getDescendant() { return null; }
    default Integer getDepth() { return null; }
}
