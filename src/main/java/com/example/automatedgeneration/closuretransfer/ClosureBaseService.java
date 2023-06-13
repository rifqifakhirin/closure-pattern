package com.example.automatedgeneration.closuretransfer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface ClosureBaseService<T extends NodeBase, U extends ClosureBase> {

    Integer INITIAL_DEPTH = 0;
    Integer RANGE_DEPTH = 1;

    ClosureBaseRepository<U> getRepository();

    default public List<U> addClosure(T entity, U closureObject) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        List<U> closureList = new ArrayList<>();

//        Class<?> thisClass = getClass();
//        Type genericSuperclass = thisClass.getGenericSuperclass();
//        ParameterizedType parameterizedGenericSuperclass = (ParameterizedType) genericSuperclass;
//        Type[] typeArgs = parameterizedGenericSuperclass.getActualTypeArguments();
//        Class<U> closure = (Class<U>) typeArgs[0];
////
//        Class<?> thisClass = Class.forName("uClass");
//        Constructor<?> constructorClass = thisClass.getConstructor(new U());


//        U closureObject = closure.getConstructor().newInstance();
        closureObject.setAncestor(entity.getId());
        closureObject.setDescendant(entity.getId());
        closureObject.setDepth(INITIAL_DEPTH);

        closureList.add(closureObject);

        if (Objects.nonNull(entity.getParentId())) {
            List<U> existingClosureList = this.findByDescendant(entity.getParentId());

            existingClosureList.forEach(closures -> {
                closureObject.setAncestor(closures.getAncestor());
                closureObject.setDepth(closures.getDepth() + RANGE_DEPTH);
                closureList.add(closureObject);
            });
        }

        return saveAll(closureList);
    }

    default List<U> findByDescendant(Long descendant) {
        return getRepository().findAll();
    }

    default List<U> saveAll(Iterable<U> entities) {
        return getRepository().saveAll(entities);
    }
}
