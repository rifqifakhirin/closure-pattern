//package com.example.automatedgeneration.closing;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.InvocationTargetException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Component
//public class ClosurementPatternService<T extends NodePattern, U extends ClosurePattern, ID> {
//
//    private ClosurePatternRepository<U, ID> closurePatternRepository;
//
//    private Class<U> closure;
//
//    private static final Integer INITIAL_DEPTH = 0;
//    private static final Integer RANGE_DEPTH = 1;
//
//    @Autowired
//    public ClosurementPatternService(ClosurePatternRepository<U, ID> closurePatternRepository, Class<U> closure) {
//        this.closurePatternRepository = closurePatternRepository;
//        this.closure = closure;
//    }
//
//    public ClosurementPatternService() {};
//
//    public List<U> addClosure(T entity) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        List<U> closureList = new ArrayList<>();
////        Class<U> closure;
////        Type type = getClass().getGenericSuperclass();
////        ParameterizedType parameterizedType = (ParameterizedType) type;
////        closure = (Class) parameterizedType.getActualTypeArguments()[0];
//
//        U closureObject = closure.getConstructor().newInstance();
//        closureObject.setAncestor(entity.getId());
//        closureObject.setDescendant(entity.getId());
//        closureObject.setDepth(INITIAL_DEPTH);
//
//        closureList.add(closureObject);
//
//        if (Objects.nonNull(entity.getParentId())) {
//            List<U> existingClosureList = closurePatternRepository.findByDescendant(entity.getParentId());
//
//            existingClosureList.forEach(closures -> {
//                closureObject.setAncestor(closures.getAncestor());
//                closureObject.setDepth(closures.getDepth() + RANGE_DEPTH);
//                closureList.add(closureObject);
//            });
//        }
//
//        return closureList;
//    }
//
//
//}
