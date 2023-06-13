//package com.example.automatedgeneration.service;
//
//import com.example.automatedgeneration.closuretransfer.ClosureBase;
//import com.example.automatedgeneration.entity.TransferApprovalClosure;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;
//import java.util.Objects;
//import java.util.function.Supplier;
//
//public class TrialService<T extends ClosureBase> {
//
//    private Class<T> closureClass;
//
//    public String checkObject() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        TypeGeneric<T> tTypeGeneric = new TypeGeneric<>(T::new);
//        tTypeGeneric.setType();
//
//        T type = tTypeGeneric.getType();
//
//        return "ok";
//    }
//}
//
//class TypeGeneric<T> {
//
//    private final Supplier<? extends T> constructor;
//    private T type;
//
//    TypeGeneric(Supplier<? extends T> tClass) throws NoSuchMethodException {
//        this.constructor = Objects.requireNonNull(tClass);
//    }
//
//    public void setType() throws InvocationTargetException, InstantiationException, IllegalAccessException {
//        type = constructor.get();
//    }
//
//    public T getType() {
//        return type;
//    }
//}
