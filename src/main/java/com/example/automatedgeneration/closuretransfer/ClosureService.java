//package com.example.automatedgeneration.closure_transfer;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.io.Serializable;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Service
//@Transactional
//public abstract class ClosureService<T extends NodeBase, U extends ClosureBase,ID extends Serializable>
//        implements ClosureBaseService<U, ID>{
//
//    private ClosureBaseRepository<U, ID> closureBaseRepository;
//
//    private static final Integer INITIAL_DEPTH = 0;
//    private static final Integer RANGE_DEPTH = 1;
//
//    @Autowired
//    public ClosureService(ClosureBaseRepository<U, ID> closureBaseRepository) {
//        this.closureBaseRepository = closureBaseRepository;
//    }
//
//    public List<U> addClosure(T entity) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        List<U> closureList = new ArrayList<>();
//        Class<U> closure = null;
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
//            List<U> existingClosureList = this.findByDescendant(entity.getParentId());
//
//            existingClosureList.forEach(closures -> {
//                closureObject.setAncestor(closures.getAncestor());
//                closureObject.setDepth(closures.getDepth() + RANGE_DEPTH);
//                closureList.add(closureObject);
//            });
//        }
//
//        this.saveAll(closureList);
//
//        return closureList;
//    }
//
//    @Override
//    public U save(U entity) {
//        return (U) closureBaseRepository.save(entity);
//    }
//
//    @Override
//    public List<U> findByDescendant(Long descendant) {
//        return closureBaseRepository.findByDescendant(descendant);
//    }
//
//    @Override
//    public List<U> saveAll(Iterable<U> entities) {
//        return closureBaseRepository.saveAll(entities);
//    }
//
//}
