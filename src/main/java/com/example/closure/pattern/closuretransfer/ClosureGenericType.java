package com.example.closure.pattern.closuretransfer;

import java.lang.reflect.InvocationTargetException;

public class ClosureGenericType<U> {

    private Class<U> uClass;

    public ClosureGenericType(Class<U> uClass) {
        this.uClass = uClass;
    }

    public U buildInstance() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return uClass.getDeclaredConstructor().newInstance();
    }
}
