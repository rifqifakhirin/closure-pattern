package com.example.closure.pattern.closures;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class HierarchyService<T extends Nodes, U extends Closures, ID> {


    @Autowired
    private ClosuresService<U, ID> closuresService;
//    @Autowired
    private Class<U> closure;

    private static final Integer INITIAL_DEPTH = 0;
    private static final Integer RANGE_DEPTH = 1;


    public List<U> addClosure(T entity) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<U> closureList = new ArrayList<>();
//        Class<U> closure;
        Type type = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        closure = (Class) parameterizedType.getActualTypeArguments()[0];

        U closureObject = closure.newInstance();
        closureObject.setAncestor(entity.getId());
        closureObject.setDescendant(entity.getId());
        closureObject.setDepth(INITIAL_DEPTH);

        closureList.add(closureObject);

        if (Objects.nonNull(entity.getParentId())) {
            List<U> existingClosureList = closuresService.findByDescendant(entity.getParentId());

            existingClosureList.forEach(closures -> {
                closureObject.setAncestor(closures.getAncestor());
                closureObject.setDepth(closures.getDepth() + RANGE_DEPTH);
                closureList.add(closureObject);
            });
        }

        return closureList;
    }
}
